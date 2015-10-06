package edu.harvard.data.client;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class NamedFileTableWriter<T extends DataTable> implements TableWriter<T> {

  private final String defaultFileName;
  Map<String, TableWriter<T>> writers;
  private final String tableName;
  private final Class<T> tableType;
  private final TableFormat format;
  private final Path directory;
  private final DataSetInfoTable existingFiles;

  public NamedFileTableWriter(final Class<T> tableType, final TableFormat format,
      final Path directory, final String tableName, final DataSetInfoTable existingFiles)
          throws IOException {
    this.defaultFileName = tableName;
    this.tableName = tableName;
    this.tableType = tableType;
    this.format = format;
    this.directory = directory;
    this.existingFiles = existingFiles;
    writers = new HashMap<String, TableWriter<T>>();
  }

  @Override
  public void close() throws IOException {
    for (final TableWriter<T> writer : writers.values()) {
      writer.close();
    }
  }

  public void add(final DataTable a, final String file) throws IOException {
    if (!writers.containsKey(file)) {
      final DataSetInfoFile existing = existingFiles.getFileInfo(file, true);
      final long existingLines = existing == null ? 0 : existing.getLines();
      writers.put(file, new DelimitedTableWriter<T>(tableType, format, directory, tableName, file,
          false, existingLines));
    }
    writers.get(file).add(a);
  }

  @Override
  public void add(final DataTable a) throws IOException {
    add(a, defaultFileName);
  }

  @Override
  public DataSetInfoTable getTableInfo() {
    final DataSetInfoTable info = new DataSetInfoTable(tableName);
    for (final TableWriter<T> writer : writers.values()) {
      info.addFileInfo(writer.getTableInfo().getFileInfo());
    }
    return info;
  }

  @Override
  public String getTableName() {
    return tableName;
  }

  @Override
  public void flush() throws IOException {
    for (final TableWriter<T> writer : writers.values()) {
      writer.flush();
    }
  }

}
