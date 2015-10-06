package edu.harvard.data.client;

import java.io.Closeable;
import java.io.IOException;

public interface TableWriter<T extends DataTable> extends Closeable {

  void add(DataTable a) throws IOException;

  DataSetInfoTable getTableInfo();

  String getTableName();

  void flush() throws IOException;

}
