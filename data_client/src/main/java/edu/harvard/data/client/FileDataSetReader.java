package edu.harvard.data.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataSetReader implements DataSetReader {
  private final Map<String, TableReader<? extends DataTable>> readers;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public FileDataSetReader(final Path directory, final TableFormat format,
      final TableFactory factory) throws IOException {
    this.readers = new HashMap<String, TableReader<? extends DataTable>>();
    if (!Files.exists(directory) || !Files.isDirectory(directory)) {
      throw new FileNotFoundException(directory.toString());
    }
    for (final Path child : Files.newDirectoryStream(directory)) {
      if (Files.isDirectory(child)) {
        final String tableName = child.getFileName().toString();
        final List<TableReader<? extends DataTable>> tableReaders = new ArrayList<TableReader<? extends DataTable>>();
        for (final Path dataFile : Files.newDirectoryStream(child)) {
          final TableReader<? extends DataTable> table = factory.getDelimitedTableReader(tableName,
              format, dataFile);
          if (table != null) {
            tableReaders.add(table);
          }
        }
        if (tableReaders.size() != 0) {
          if (tableReaders.size() == 1) {
            readers.put(tableName, tableReaders.get(0));
          } else {
            readers.put(tableName, new CombinedTableReader(tableReaders, tableReaders.get(0).getTableType()));
          }
        }
      }
    }
  }

  @Override
  public Map<String, TableReader<? extends DataTable>> getTables() {
    return readers;
  }

  @Override
  public void close() throws IOException {
    for (final TableReader<? extends DataTable> table : readers.values()) {
      table.close();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends DataTable> TableReader<T> getTable(final String tableName, final Class<T> tableClass) {
    return (TableReader<T>) readers.get(tableName);
  }
}
