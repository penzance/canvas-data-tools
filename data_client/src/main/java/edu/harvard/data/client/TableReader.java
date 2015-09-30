package edu.harvard.data.client;

import java.io.Closeable;
import java.io.IOException;

public interface TableReader<T extends DataTable> extends Iterable<T>, Closeable {

  void reset() throws IOException;

  Class<T> getTableType();

  long size() throws IOException;

  DataSetInfoTable generateTableInfo() throws IOException;

}
