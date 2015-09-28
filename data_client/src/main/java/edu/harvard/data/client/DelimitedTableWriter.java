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
  private static final int DEFAULT_MAX_FILE_SIZE = 65536;
  private final TableFormat format;
  private final List<List<? extends Object>> buffer;
  private final Path directory;
  private int bufferSize;
  private int maxFileSize;
  private int currentFileLines;
  private int currentFileIndex;
  private final String tableName;
  private final DataSetInfoTable info;

  public DelimitedTableWriter(final Class<T> tableType, final TableFormat format, final Path directory, final String tableName)
      throws IOException {
    this.format = format;
    this.tableName = tableName;
    this.buffer = new ArrayList<List<? extends Object>>();
    this.currentFileLines = 0;
    this.currentFileIndex = 0;
    this.directory = directory;
    this.bufferSize = DEFAULT_BUFFER_SIZE;
    this.maxFileSize = DEFAULT_MAX_FILE_SIZE;
    this.info = new DataSetInfoTable(tableName);
    Files.createDirectories(directory);
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

  public void setMaxFileSize(final int size){
    this.maxFileSize = size;
  }

  private OutputStream getOutputStream() throws IOException {
    final StandardOpenOption[] opts = new StandardOpenOption[] {
        StandardOpenOption.CREATE, StandardOpenOption.APPEND
    };
    Path file;
    if (currentFileLines + buffer.size() > maxFileSize) {
      info.addFileInfo(new DataSetInfoFile(getCurrentFileName(), currentFileLines));
      currentFileIndex++;
      currentFileLines = 0;
    }
    file = directory.resolve(getCurrentFileName());
    switch (format.getCompression()) {
    case Gzip:
      return new GZIPOutputStream(Files.newOutputStream(file, opts));
    case None:
      return Files.newOutputStream(file, opts);
    default:
      throw new RuntimeException("Unknown compression: " + format.getCompression());
    }
  }

  private String getCurrentFileName() {
    return tableName + "-" + String.format("%03d", currentFileIndex) + format.getExtension();
  }

  private void flushBuffer() throws IOException {
    try (
        OutputStream out = getOutputStream();
        final CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(out), format.getCsvFormat())) {
      for (final List<? extends Object> row : buffer) {
        printer.printRecord(row);
        currentFileLines++;
      }
    }
    buffer.clear();
  }

  @Override
  public void close() throws IOException {
    flushBuffer();
    info.addFileInfo(new DataSetInfoFile(getCurrentFileName(), currentFileLines));
  }

  @Override
  public void add(final DataTable a) throws IOException {
    buffer.add(a.getFieldsAsList(format));
    if(buffer.size() > bufferSize) {
      flushBuffer();
    }
  }

  @Override
  public String getName() {
    return tableName;
  }

  @Override
  public DataSetInfoTable getTableInfo() {
    return info;
  }

}
