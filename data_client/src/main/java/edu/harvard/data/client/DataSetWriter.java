package edu.harvard.data.client;

import java.io.Closeable;
import java.io.IOException;

public interface DataSetWriter extends Closeable {
  void pipe(DataSetReader reader) throws IOException;

  <T extends DataTable> TableWriter<T> getTable(String table, Class<T> tableClass) throws IOException;

  <T extends DataTable> void setTableWriter(String tableName, Class<T> tableClass, TableWriter<T> table);

  void flush() throws IOException;
}
