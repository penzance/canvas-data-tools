package edu.harvard.data.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public interface DataSetReader extends Closeable {

  Map<String, TableReader<? extends DataTable>> getTables();

  <T extends DataTable> TableReader<T> getTable(String tableName, Class<T> tableClass);

  TableFormat getFormat();

  void generateDataSetInfo() throws IOException;

}
