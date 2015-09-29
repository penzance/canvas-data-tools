package edu.harvard.data.client;

import java.io.IOException;
import java.util.Map;

public class CombinedDataSetReader implements DataSetReader {

  private final Map<String, TableReader<? extends DataTable>> tables;

  public CombinedDataSetReader(final Map<String, TableReader<? extends DataTable>> tables) {
    this.tables = tables;
  }

  @Override
  public void close() throws IOException {
    for (final TableReader<? extends DataTable> table : tables.values()) {
      table.close();
    }
  }

  @Override
  public Map<String, TableReader<? extends DataTable>> getTables() {
    return tables;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends DataTable> TableReader<T> getTable(final String tableName, final Class<T> tableClass) {
    return (TableReader<T>) tables.get(tableName);
  }

}
