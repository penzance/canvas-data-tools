package edu.harvard.data.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public interface DataSetReader extends Closeable {

  Map<String, TableReader<? extends DataTable>> getTables();

  <T extends DataTable> TableReader<T> getTable(String tableName, Class<T> tableClass);

  TableFormat getFormat();

  DataSetInfo generateDataSetInfo() throws IOException;

  <T extends DataTable> void replaceTable(String tableName, TableReader<T> reader) throws IOException;

}
