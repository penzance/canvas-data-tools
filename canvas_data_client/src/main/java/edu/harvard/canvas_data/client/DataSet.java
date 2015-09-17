package edu.harvard.canvas_data.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.csv.CSVPrinter;

import edu.harvard.canvas_data.client.tables.CanvasDataTable;

public class DataSet<T extends CanvasDataTable> {

  private final List<T> records;

  public DataSet(final List<T> records) {
    this.records = records;
  }

  public List<T> getRecords() {
    return records;
  }

  public void writeCanvasDataFormat(final File outputFile, final boolean gzip) throws IOException {
    outputFile.getParentFile().mkdirs();
    Writer out = null;
    try {
      if (gzip) {
        out = new OutputStreamWriter(new GZIPOutputStream(
            new FileOutputStream(outputFile)), CanvasDataTable.CANVAS_DATA_ENCODING);
      } else {
        out = new FileWriter(outputFile);
      }
      try (CSVPrinter printer = new CSVPrinter(out, CanvasDataTable.CANVAS_DATA_FILE_FORMAT)) {
        for (final T record : records) {
          final List<Object> fields = record.getCsvFields();
          printer.printRecord(fields);
        }
      }
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }

}
