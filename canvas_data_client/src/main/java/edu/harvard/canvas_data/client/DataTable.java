package edu.harvard.canvas_data.client;

import java.io.File;
import java.io.IOException;

import edu.harvard.canvas_data.client.tables.CanvasDataTable;

public interface DataTable<T extends CanvasDataTable> extends Iterable<T> {

  void writeCanvasDataFormat(File outputFile, boolean gzip) throws IOException;

  long size();


}
