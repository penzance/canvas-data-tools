package edu.harvard.data.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.csv.CSVPrinter;

public class DelimitedTableWriter<T extends DataTable> implements TableWriter<T> {

  private static final int DEFAULT_BUFFER_SIZE = 512;
  private final TableFormat format;
  private final List<List<? extends Object>> buffer;
  private final Path file;
  private int bufferSize;

  public DelimitedTableWriter(final Class<T> tableType, final TableFormat format, final Path file)
      throws IOException {
    this.format = format;
    this.buffer = new ArrayList<List<? extends Object>>();
    this.file = file;
    this.bufferSize = DEFAULT_BUFFER_SIZE;
    Files.createDirectories(file.getParent());
    if (format.includeHeaders()) {
      try {
        @SuppressWarnings("unchecked")
        final List<String> headers = (List<String>) tableType.getMethod("getFieldNames")
        .invoke(null);
        buffer.add(headers);
      } catch (NoSuchMethodException | SecurityException | IllegalAccessException
          | IllegalArgumentException | InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void setBufferSize(final int size){
    this.bufferSize = size;
  }

  private OutputStream getOutputStream() throws IOException {
    final StandardOpenOption[] opts = new StandardOpenOption[] {
        StandardOpenOption.CREATE, StandardOpenOption.APPEND
    };
    switch (format.getCompression()) {
    case Gzip:
      return new GZIPOutputStream(Files.newOutputStream(file, opts));
    case None:
      return Files.newOutputStream(file, opts);
    default:
      throw new RuntimeException("Unknown compression: " + format.getCompression());
    }
  }

  private void flushBuffer() throws IOException {
    try (
        OutputStream out = getOutputStream();
        final CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(out), format.getCsvFormat())) {
      for (final List<? extends Object> row : buffer) {
        printer.printRecord(row);
      }
    }
    buffer.clear();
  }

  @Override
  public void close() throws IOException {
    flushBuffer();
  }

  @Override
  public void add(final DataTable a) throws IOException {
    buffer.add(a.getFieldsAsList(format));
    if(buffer.size() > bufferSize) {
      flushBuffer();
    }
  }

}
