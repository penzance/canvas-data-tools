package edu.harvard.data.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CombinedTableReader<T extends DataTable> implements TableReader<T> {

  private final List<TableReader<T>> tables;
  private CombinedTableIterator<T> iterator;
  private final Class<T> tableType;
  private final String tableName;

  public CombinedTableReader(final List<TableReader<T>> tables, final Class<T> tableType, final String tableName) {
    this.tables = tables;
    this.tableType = tableType;
    this.iterator = new CombinedTableIterator<T>(tables);
    this.tableName = tableName;
  }

  @Override
  public Iterator<T> iterator() {
    return iterator;
  }

  @Override
  public void close() throws IOException {
    for (final TableReader<T> table : tables) {
      table.close();
    }
  }

  @Override
  public void reset() throws IOException {
    this.iterator = new CombinedTableIterator<T>(tables);
    for (final TableReader<T> table : tables) {
      table.reset();
    }
  }

  @Override
  public Class<T> getTableType() {
    return tableType;
  }

  @Override
  public long size() throws IOException {
    long size = 0;
    for (final TableReader<T> table : tables) {
      size += table.size();
    }
    return size;
  }

  @Override
  public DataSetInfoTable generateTableInfo() throws IOException {
    final DataSetInfoTable info = new DataSetInfoTable(tableName);
    for (final TableReader<T> tableReader : tables) {
      info.addFileInfo(tableReader.generateTableInfo().getFileInfo());
    }
    return info;
  }

}

class CombinedTableIterator<T extends DataTable> implements Iterator<T> {

  private Iterator<T> currentIterator;
  private final List<Iterator<T>> iteratorQueue;
  private final List<TableReader<T>> tables;

  public CombinedTableIterator(final List<TableReader<T>> tables) {
    iteratorQueue = new ArrayList<Iterator<T>>();
    this.tables = tables;
    if (tables.size() == 0) {
      currentIterator = null;
    } else {
      currentIterator = tables.get(0).iterator();
    }
    for (int i = 1; i < tables.size(); i++) {
      iteratorQueue.add(tables.get(i).iterator());
    }
  }

  @Override
  public boolean hasNext() {
    if (currentIterator == null) {
      return false;
    }
    if (currentIterator.hasNext()) {
      return true;
    }
    if (iteratorQueue.isEmpty()) {
      closeCurrentIterator();
      return false;
    }
    closeCurrentIterator();
    currentIterator = iteratorQueue.remove(0);
    return hasNext();
  }

  private void closeCurrentIterator() {
    for (final TableReader<T> t : tables) {
      if (t.iterator().equals(currentIterator)) {
        try {
          t.close();
        } catch (final IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  @Override
  public T next() {
    return currentIterator.next();
  }

}
