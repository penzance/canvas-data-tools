package edu.harvard.data.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDataSetReader implements DataSetReader {
  private final Map<String, TableReader<? extends DataTable>> readers;
  private final TableFormat format;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public FileDataSetReader(final Path directory, final TableFormat format,
      final TableFactory factory) throws IOException {
    this.readers = new HashMap<String, TableReader<? extends DataTable>>();
    this.format = format;
    if (!Files.exists(directory) || !Files.isDirectory(directory)) {
      throw new FileNotFoundException(directory.toString());
    }
    try (DirectoryStream<Path> listing = Files.newDirectoryStream(directory)) {
      for (final Path child : listing) {
        if (Files.isDirectory(child)) {
          final String tableName = child.getFileName().toString();
          final List<TableReader<? extends DataTable>> tableReaders = new ArrayList<TableReader<? extends DataTable>>();
          try (DirectoryStream<Path> childListing = Files.newDirectoryStream(child)) {
            for (final Path dataFile : childListing) {
              final TableReader<? extends DataTable> table = factory.getDelimitedTableReader(tableName,
                  format, dataFile);
              if (table != null) {
                tableReaders.add(table);
              }
            }
          }
          if (tableReaders.size() != 0) {
            if (tableReaders.size() == 1) {
              readers.put(tableName, tableReaders.get(0));
            } else {
              readers.put(tableName, new CombinedTableReader(tableReaders, tableReaders.get(0).getTableType(), tableName));
            }
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

  @Override
  public TableFormat getFormat() {
    return format;
  }

  @Override
  public DataSetInfo generateDataSetInfo() throws IOException {
    final DataSetInfo info = new DataSetInfo();
    info.setFormat(format.getFormat());
    for (final TableReader<? extends DataTable> reader : readers.values()) {
      final DataSetInfoTable tableInfo = reader.generateTableInfo();
      info.addTable(tableInfo.getName(), tableInfo);
    }
    return info;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends DataTable> void replaceTable(final String tableName, final TableReader<T> reader)
      throws IOException {
    final TableReader<T> oldTable = (TableReader<T>) readers.get(tableName);
    if (oldTable != null) {
      oldTable.close();
    }
    readers.put(tableName, reader);
  }
}
