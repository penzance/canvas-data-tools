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

import org.apache.commons.csv.CSVPrinter;

public class DelimitedTableWriter<T extends DataTable> implements TableWriter<T> {

  private static final int DEFAULT_BUFFER_SIZE = 512;
  private static final int DEFAULT_MAX_FILE_SIZE = 65536;
  private final TableFormat format;
  private final List<T> buffer;
  private final Path directory;
  private int bufferSize;
  private int maxFileSize;
  private long currentFileLines;
  private int currentFileIndex;
  private final String tableName;
  private final DataSetInfoTable info;
  private final Class<T> tableType;
  private String fileName;
  private boolean splitFile;

  public DelimitedTableWriter(final Class<T> tableType, final TableFormat format,
      final Path directory, final String tableName) throws IOException {
    this(tableType, format, directory, tableName, tableName, true, 0);
  }

  public DelimitedTableWriter(final Class<T> tableType, final TableFormat format,
      final Path directory, final String tableName, final String fileName, final boolean splitFile,
      final long previousFileLines) throws IOException {
    this.format = format;
    this.tableName = tableName;
    this.tableType = tableType;
    this.fileName = fileName;
    this.splitFile = splitFile;
    this.buffer = new ArrayList<T>();
    this.currentFileLines = previousFileLines;
    this.currentFileIndex = 0;
    this.directory = directory;
    this.bufferSize = DEFAULT_BUFFER_SIZE;
    this.maxFileSize = DEFAULT_MAX_FILE_SIZE;
    this.info = new DataSetInfoTable(tableName);
    Files.createDirectories(directory);
  }

  public void setBufferSize(final int size) {
    this.bufferSize = size;
  }

  public void setMaxFileSize(final int size) {
    this.maxFileSize = size;
  }

  private OutputStream getOutputStream() throws IOException {
    final StandardOpenOption[] opts = new StandardOpenOption[] { StandardOpenOption.CREATE,
        StandardOpenOption.APPEND };
    Path file;
    if (splitFile && (currentFileLines + buffer.size() > maxFileSize)) {
      info.addFileInfo(new DataSetInfoFile(getCurrentFileName(), currentFileLines));
      currentFileIndex++;
      currentFileLines = 0;
    }
    file = directory.resolve(getCurrentFileName());
    return format.getOutputStream(file, opts);
  }

  @SuppressWarnings("unchecked")
  private void writeHeaders(final CSVPrinter printer) throws IOException {
    try {
      final List<String> headers = (List<String>) tableType.getMethod("getFieldNames").invoke(null);
      printer.printRecord(headers);
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  private String getCurrentFileName() {
    final String splitNumber = splitFile ? "-" + String.format("%03d", currentFileIndex) : "";
    return fileName + splitNumber + format.getExtension();
  }

  private void flushBuffer() throws IOException {
    final boolean newFile = !Files.exists(directory.resolve(getCurrentFileName()));
    try (OutputStream out = getOutputStream();
        final CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(out),
            format.getCsvFormat())) {
      if (newFile && format.includeHeaders()) {
        writeHeaders(printer);
      }
      for (final T row : buffer) {
        printer.printRecord(row.getFieldsAsList(format));
      }
    }
    buffer.clear();
  }

  @Override
  public void close() throws IOException {
    flushBuffer();
    info.addFileInfo(new DataSetInfoFile(getCurrentFileName(), currentFileLines));
  }

  @SuppressWarnings("unchecked")
  @Override
  public void add(final DataTable a) throws IOException {
    buffer.add((T) a);
    currentFileLines++;
    if (buffer.size() > bufferSize) {
      flushBuffer();
    }
  }

  @Override
  public String getTableName() {
    return tableName;
  }

  @Override
  public DataSetInfoTable getTableInfo() {
    return info;
  }

  @Override
  public void flush() throws IOException {
    flushBuffer();
  }

}
