package edu.harvard.data.client;

import java.io.IOException;
import java.util.Map;

public class CombinedDataSetReader implements DataSetReader {

  private final Map<String, TableReader<? extends DataTable>> readers;
  private final TableFormat format;

  public CombinedDataSetReader(final Map<String, TableReader<? extends DataTable>> readers, final TableFormat format) {
    this.readers = readers;
    this.format = format;
  }

  @Override
  public void close() throws IOException {
    for (final TableReader<? extends DataTable> table : readers.values()) {
      table.close();
    }
  }

  @Override
  public Map<String, TableReader<? extends DataTable>> getTables() {
    return readers;
  }

  @Override
  @SuppressWarnings("unchecked")
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
  public <T extends DataTable> void replaceTable(final String tableName, final TableReader<T> reader) throws IOException {
    final TableReader<T> oldTable = (TableReader<T>) readers.get(tableName);
    if (oldTable != null) {
      oldTable.close();
    }
    readers.put(tableName, reader);
  }

}
