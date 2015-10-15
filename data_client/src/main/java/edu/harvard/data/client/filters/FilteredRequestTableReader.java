package edu.harvard.data.client.filters;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import edu.harvard.data.client.DataSetInfoFile;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.canvas.tables.Requests;

public class FilteredRequestTableReader<T extends Requests> implements TableReader<T> {

  private final TableReader<T> srcReader;
  private final List<FilterCriteria<T>> filters;
  private FilteredIterator<T> iterator;
  private final Class<T> tableType;

  public FilteredRequestTableReader(final Class<T> tableType, final TableReader<T> srcReader,
      final List<FilterCriteria<T>> filters) {
    this.tableType = tableType;
    this.srcReader = srcReader;
    this.filters = filters;
  }

  @Override
  public Iterator<T> iterator() {
    if (iterator == null) {
      iterator = new FilteredIterator<T>(srcReader.iterator(), filters);
    }
    return iterator;
  }

  @Override
  public void close() throws IOException {
    srcReader.close();
  }

  @Override
  public void reset() throws IOException {
    srcReader.reset();
    iterator = null;
  }

  @Override
  public Class<T> getTableType() {
    return tableType;
  }

  @Override
  public long size() throws IOException {
    return iterator.size();
  }

  @Override
  public DataSetInfoTable generateTableInfo() throws IOException {
    final DataSetInfoTable tableInfo = new DataSetInfoTable("requests");
    tableInfo.addFileInfo(new DataSetInfoFile("Filtered data set", iterator.size()));
    return tableInfo;
  }

}

class FilteredIterator<T extends Requests> implements Iterator<T> {

  private final Iterator<T> iterator;
  private final List<FilterCriteria<T>> filters;
  private long size;
  private T next;

  public FilteredIterator(final Iterator<T> iterator, final List<FilterCriteria<T>> filters) {
    this.iterator = iterator;
    this.filters = filters;
    size = 0L;
  }

  public long size() {
    if (iterator.hasNext()) {
      throw new RuntimeException("Don't know filtered data set size until the iterator is empty");
    }
    return size;
  }

  private void advanceToNextValue() {
    while (iterator.hasNext()) {
      final T nextValue = iterator.next();
      boolean match = true;
      for (final FilterCriteria<T> filter : filters) {
        match &= filter.matches(nextValue);
        if (!match) {
          break;
        }
      }
      if (match) {
        next = nextValue;
        return;
      }
    }
  }

  @Override
  public boolean hasNext() {
    if (next == null) {
      advanceToNextValue();
    }
    return next != null;
  }

  @Override
  public T next() {
    if (next == null) {
      advanceToNextValue();
    }
    if (next == null) {
      return null;
    }
    final T nextValue = next;
    next = null;
    size++;
    return nextValue;
  }

}