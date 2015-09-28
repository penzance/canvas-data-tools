package edu.harvard.data.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileDataSetWriter implements DataSetWriter {
  // Assumes that the target directory is empty, and nobody else is writing to it.

  private final Path directory;
  private final Map<String, TableWriter<? extends DataTable>> writers;
  private final TableFactory factory;
  private final TableFormat format;

  public FileDataSetWriter(final Path directory, final TableFormat format, final TableFactory factory) {
    this.directory = directory;
    this.factory = factory;
    this.format = format;
    this.writers = new HashMap<String, TableWriter<? extends DataTable>>();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends DataTable> TableWriter<T> getTable(final String table, final Class<T> tableClass)
      throws IOException {
    if (writers.containsKey(table)) {
      return (TableWriter<T>) writers.get(table);
    }
    final Path tableDir = directory.resolve(table);
    if (!Files.exists(tableDir)) {
      Files.createDirectories(tableDir);
    }
    String filename;
    switch(format.getCompression()) {
    case Gzip:
      filename = table + ".gz";
      break;
    default:
      filename = table;
    }
    final TableWriter<T> writer = (TableWriter<T>) factory.getDelimitedTableWriter(table, format, tableDir.resolve(filename));
    writers.put(table, writer);
    return writer;
  }

  @Override
  public void close() throws IOException {
    for (final TableWriter<? extends DataTable> table : writers.values()) {
      table.close();
    }
  }

  @Override
  public void pipe(final DataSetReader reader) throws IOException {
    final Map<String, TableReader<? extends DataTable>> tables = reader.getTables();
    for (final String tableName : tables.keySet()) {
      final TableReader<? extends DataTable> tableReader = tables.get(tableName);
      final TableWriter<? extends DataTable> writer = getTable(tableName, tableReader.getTableType());
      for (final DataTable row : tables.get(tableName)) {
        writer.add(row);
      }
    }
  }
}
