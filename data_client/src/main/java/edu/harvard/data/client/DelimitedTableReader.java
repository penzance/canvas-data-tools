package edu.harvard.data.client;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class DelimitedTableReader<T extends DataTable> implements TableReader<T> {
  private final TableFormat format;
  private final Path file;
  private DelimitedFileIterator<T> iterator;
  private final Class<T> tableType;
  private final String tableName;

  public DelimitedTableReader(final Class<T> tableType, final TableFormat format, final Path file,
      final String tableName) throws IOException {
    this.format = format;
    this.file = file;
    this.tableType = tableType;
    this.tableName = tableName;
    if (!Files.exists(file) || Files.isDirectory(file)) {
      throw new FileNotFoundException(file.toString());
    }
    reset();
  }

  @Override
  public void reset() throws IOException {
    if (iterator != null) {
      iterator.close();
    }
    this.iterator = new DelimitedFileIterator<T>(tableType, format, file, this);
  }

  @Override
  public Iterator<T> iterator() {
    return iterator;
  }

  @Override
  public void close() throws IOException {
    iterator.close();
  }

  @Override
  public Class<T> getTableType() {
    return tableType;
  }

  @Override
  public long size() throws IOException {
    try (LineNumberReader lineReader = new LineNumberReader(
        new InputStreamReader(getInputStream()))) {
      while (lineReader.ready()) {
        lineReader.skip(Long.MAX_VALUE);
      }
      return lineReader.getLineNumber();
    }
  }

  InputStream getInputStream() throws IOException {
    switch (format.getCompression()) {
    case Gzip:
      return new GZIPInputStream(Files.newInputStream(file));
    case None:
      return Files.newInputStream(file);
    default:
      throw new RuntimeException("Unknown compression format: " + format.getCompression());
    }
  }

  @Override
  public DataSetInfoTable generateTableInfo() throws IOException {
    final DataSetInfoTable tableInfo = new DataSetInfoTable(tableName);
    tableInfo.addFileInfo(new DataSetInfoFile(file.toString(), size()));
    return tableInfo;
  }

}

class DelimitedFileIterator<T extends DataTable> implements Iterator<T>, Closeable {

  private Iterator<CSVRecord> iterator;
  private CSVParser requestParser;
  private final Class<T> table;
  private final TableFormat format;
  private final Path file;
  private int line;
  private final DelimitedTableReader<T> parent;

  public DelimitedFileIterator(final Class<T> table, final TableFormat format, final Path file,
      final DelimitedTableReader<T> parent) throws IOException {
    this.format = format;
    this.table = table;
    this.file = file;
    this.parent = parent;
    if (format.includeHeaders()) {
      iterator.next();
      line = 1;
    } else {
      line = 0;
    }
  }

  private void createIterator() {
    try {
      final InputStream in = parent.getInputStream();
      requestParser = new CSVParser(new InputStreamReader(in, format.getEncoding()),
          format.getCsvFormat());
      iterator = requestParser.iterator();
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean hasNext() {
    if (iterator == null) {
      createIterator();
    }
    return iterator.hasNext();
  }

  @Override
  public T next() {
    if (iterator == null) {
      createIterator();
    }
    final CSVRecord next = iterator.next();
    line++;
    try {
      return table.getConstructor(TableFormat.class, CSVRecord.class).newInstance(format, next);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
        | NoSuchMethodException | SecurityException e) {
      throw new RuntimeException(e);
    } catch (final InvocationTargetException e) {
      Throwable cause = e;
      while (cause instanceof InvocationTargetException) {
        cause = cause.getCause();
      }
      throw new RecordParsingException(file, line, next, cause);
    }
  }

  @Override
  public void close() throws IOException {
    if (requestParser != null) {
      requestParser.close();
    }
  }

}