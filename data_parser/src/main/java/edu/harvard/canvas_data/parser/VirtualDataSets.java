package edu.harvard.canvas_data.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.harvard.data.client.CombinedDataSetReader;
import edu.harvard.data.client.CombinedTableReader;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.DelimitedTableReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.canvas.api.CanvasDataArtifact;
import edu.harvard.data.client.canvas.api.CanvasDataFile;
import edu.harvard.data.client.canvas.tables.CanvasTable;

public class VirtualDataSets {

  public static DataSetReader getLatestDataSet(final Path archiveDir) throws IOException {
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
    return new CombinedDataSetReader(tables);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static TableReader<? extends DataTable> getTableReader(final CanvasTable table,
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
}
