package edu.harvard.canvas_data.client.collation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.csv.CSVPrinter;

import edu.harvard.canvas_data.client.DataTable;
import edu.harvard.canvas_data.client.tables.CanvasDataTable;

public class ListDataTable<T extends CanvasDataTable> implements DataTable<T> {

  private final List<T> records;

  public ListDataTable(final List<T> records) {
    this.records = records;
  }

  @Override
  public void writeCanvasDataFormat(final File outputFile, final boolean gzip) throws IOException {
    outputFile.getParentFile().mkdirs();
    Writer out = null;
    try {
      if (gzip) {
        out = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outputFile)),
            CanvasDataTable.CANVAS_DATA_ENCODING);
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

  @Override
  public Iterator<T> iterator() {
    return records.iterator();
  }

  @Override
  public long size() {
    return records.size();
  }

}
