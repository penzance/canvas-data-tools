package edu.harvard.canvas_data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.DumpInformation;
import edu.harvard.data.client.CombinedDataSetReader;
import edu.harvard.data.client.CombinedTableReader;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetInfoFile;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.DelimitedTableReader;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.canvas.api.CanvasDataArtifact;
import edu.harvard.data.client.canvas.api.CanvasDataFile;
import edu.harvard.data.client.canvas.tables.CanvasTable;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class DataSetUtils {

  private final CanvasTableFactory factory;
  private final FormatLibrary formats;
  private final Configuration config;

  public DataSetUtils(final Configuration config) {
    this.factory = new CanvasTableFactory();
    this.formats = new FormatLibrary();
    this.config = config;
  }

  public Format getFormatFromString(final String format, final Format defaultFormat) {
    Format outputFormat;
    if (format != null) {
      try {
        outputFormat = Format.fromLabel(format);
      } catch(final IllegalArgumentException e) {
        String err = "Format " + format + " not found. Possible formats are:\n";
        for (final Format f : Format.values()) {
          err += "  " + f.getLabel() + "\n";
        }
        throw new RuntimeException(err);
      }
    } else {
      outputFormat = defaultFormat;
    }
    return outputFormat;
  }

  public DataSetReader getReaderFromString(final String input) throws IOException {
    DataSetReader in;
    final TableFormat inputFormat;
    if (input.equals("LATEST")) {
      in = getLatestDataSet(config.getCanvasDataArchiveDirectory());
      inputFormat = formats.getFormat(Format.CanvasDataFlatFiles);
    } else {
      final Path inputPath = Paths.get(input);
      if (!Files.exists(inputPath) || !Files.isDirectory(inputPath)
          || !Files.exists(DataSetInfo.getFileName(inputPath))) {
        throw new RuntimeException("Input directory " + input + " is not a well-formed data set");
      }
      final DataSetInfo inputInfo = DataSetInfo.read(DataSetInfo.getFileName(inputPath));
      inputFormat = formats.getFormat(inputInfo.getFormat());
      in = new FileDataSetReader(inputPath, inputFormat, factory);
    }
    return in;
  }

  public DataSetReader getLatestDataSet(final Path archiveDir) throws IOException {
    final Map<Integer, Path> dumps = new HashMap<Integer, Path>();
    final TableFormat format = new FormatLibrary().getFormat(Format.CanvasDataFlatFiles);
    for (final Path dir : Files.newDirectoryStream(archiveDir)) {
      if (!Files.isDirectory(dir)) {
        continue;
      }
      try {
        final int dumpId = Integer.parseInt(dir.getFileName().toString());
        dumps.put(dumpId, dir);
      } catch (final NumberFormatException e) {
        continue;
      }
    }
    final List<Integer> dumpIds = new ArrayList<Integer>(dumps.keySet());
    Collections.sort(dumpIds);
    Collections.reverse(dumpIds);

    final Map<String, TableReader<? extends DataTable>> tables = new HashMap<String, TableReader<? extends DataTable>>();
    for (final CanvasTable table : CanvasTable.values()) {
      tables.put(table.getSourceName(), getTableReader(table, dumpIds, dumps, format));
    }
    return new CombinedDataSetReader(tables, format);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private TableReader<? extends DataTable> getTableReader(final CanvasTable table,
      final List<Integer> dumpIds, final Map<Integer, Path> dumps, final TableFormat format)
          throws IOException {
    final ArrayList<TableReader<? extends DataTable>> partialReaders = new ArrayList<TableReader<? extends DataTable>>();
    for (final int dumpId : dumpIds) {
      final Path dir = dumps.get(dumpId);
      final Path dumpInfoFile = DumpInformation.getFile(dir);
      if (Files.exists(dumpInfoFile)){
        final DumpInformation info = DumpInformation.read(dumpInfoFile);
        final CanvasDataArtifact artifact = info.getDump().getArtifactsByTable()
            .get(table.getSourceName());
        if (artifact != null) {
          for (final CanvasDataFile file : artifact.getFiles()) {
            final Path dumpFile = dir.resolve(table.getSourceName()).resolve(file.getFilename());
            partialReaders.add(0, new DelimitedTableReader(table.getTableClass(), format, dumpFile));
          }
          if (!artifact.isPartial()) {
            break;
          }
        }
      }
    }
    return new CombinedTableReader(partialReaders, table.getTableClass());
  }

  private List<Path> getDumpsForLatestTable(final CanvasTable table, final Path archiveDir) throws IOException {
    final List<Path> partialDumps = new ArrayList<Path>();
    final Map<Integer, Path> dumps = new HashMap<Integer, Path>();
    //    final TableFormat format = new FormatLibrary().getFormat(Format.CanvasDataFlatFiles);
    for (final Path dir : Files.newDirectoryStream(archiveDir)) {
      if (!Files.isDirectory(dir)) {
        continue;
      }
      try {
        final int dumpId = Integer.parseInt(dir.getFileName().toString());
        dumps.put(dumpId, dir);
      } catch (final NumberFormatException e) {
        continue;
      }
    }
    final List<Integer> dumpIds = new ArrayList<Integer>(dumps.keySet());
    Collections.sort(dumpIds);
    Collections.reverse(dumpIds);

    for (final int dumpId : dumpIds) {
      final Path dir = dumps.get(dumpId);
      final Path dumpInfoFile = DumpInformation.getFile(dir);
      if (Files.exists(dumpInfoFile)){
        final DumpInformation info = DumpInformation.read(dumpInfoFile);
        final CanvasDataArtifact artifact = info.getDump().getArtifactsByTable().get(table.getSourceName());
        if (artifact != null){
          partialDumps.add(dir);
          if (!artifact.isPartial()) {
            break;
          }
        }
      }
    }
    return partialDumps;
  }

  public DataSetInfo getLatestDataSetInfo(final Configuration config) throws IOException {
    final DataSetInfo info = new DataSetInfo();
    for (final CanvasTable table : CanvasTable.values()) {
      final List<Path> dumps = getDumpsForLatestTable(table, config.getCanvasDataArchiveDirectory());
      final DataSetInfoTable tableInfo = new DataSetInfoTable(table.getSourceName());
      info.addTable(table.getSourceName(), tableInfo);
      for (final Path dump : dumps) {
        final DataSetInfo dumpInfo = DataSetInfo.read(DataSetInfo.getFileName(dump));
        for (final DataSetInfoFile fileInfo : dumpInfo.getTable(table.getSourceName()).getFileInfo()) {
          tableInfo.addFileInfo(fileInfo);
        }
      }
    }
    return info;
  }

}
