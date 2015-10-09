package edu.harvard.canvas_data;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.DumpInformation;
import edu.harvard.data.client.CombinedDataSetReader;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetInfoFile;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.canvas.api.CanvasDataArtifact;
import edu.harvard.data.client.canvas.tables.CanvasTable;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class DataSetUtils {

  private static final Logger log = Logger.getLogger("Canvas Data");

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

  @SuppressWarnings("resource")
  public DataSetReader getLatestDataSet(final Path archiveDir) throws IOException {
    final Map<String, TableReader<? extends DataTable>> tables = new HashMap<String, TableReader<? extends DataTable>>();
    final TableFormat format = new FormatLibrary().getFormat(Format.CanvasDataFlatFiles);
    for (final CanvasTable table : CanvasTable.values()) {
      for (final Path dumpDir : getDumpsForLatestTable(table, archiveDir)) {
        final String tableName = table.getSourceName();
        final Class<? extends DataTable> tableClass = table.getTableClass();
        tables.put(tableName, new FileDataSetReader(dumpDir, format, factory).getTable(tableName, tableClass));
      }
    }
    return new CombinedDataSetReader(tables, format);
  }

  private List<Path> getDumpsForLatestTable(final CanvasTable table, final Path archiveDir) throws IOException {
    final List<Path> partialDumps = new ArrayList<Path>();
    final Map<Integer, Path> dumps = new HashMap<Integer, Path>();
    try (DirectoryStream<Path> listing = Files.newDirectoryStream(archiveDir)) {
      for (final Path dir : listing) {
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

  public DataSetInfo getDataSetInfo(final String input) throws IOException {
    if (input.equals("LATEST")) {
      return getLatestDataSetInfo(config);
    } else {
      final Path infoFile = DataSetInfo.getFileName(Paths.get(input));
      if (!Files.exists(infoFile)) {
        log.severe(input + " is not a well-formed data set");
        return null;
      }
      return DataSetInfo.read(infoFile);
    }
  }

}
