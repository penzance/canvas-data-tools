package edu.harvard.canvas_data.client;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import edu.harvard.canvas_data.client.tables.CanvasDataTable;

public interface DataTable<T extends CanvasDataTable> extends Iterable<T>, Closeable {

  void writeCanvasDataFormat(File outputFile, boolean headers, boolean gzip) throws IOException;

  long size();

  void addRecords(DataTable<T> newRecords, Class<T> type);


}
