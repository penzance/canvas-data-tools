package edu.harvard.data.client;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;

public class FormatLibrary {
  public enum Format {
    DecompressedCanvasDataFlatFiles("decompressed_canvas"), CanvasDataFlatFiles(
        "canvas"), DecompressedExcel("decompressed_excel"), Excel("excel");

    private String label;

    private Format(final String label) {
      this.label = label;
    }

    public String getLabel() {
      return label;
    }

    public static Format fromLabel(final String label) {
      switch (label) {
      case "canvas":
        return CanvasDataFlatFiles;
      case "decompressed_canvas":
        return DecompressedCanvasDataFlatFiles;
      case "excel":
        return Excel;
      case "decompressed_excel":
        return DecompressedExcel;
      default:
        return Format.valueOf(label);
      }
    }
  };

  private final Map<Format, TableFormat> formatMap;

  public FormatLibrary() {
    this.formatMap = new HashMap<Format, TableFormat>();
    formatMap.put(Format.CanvasDataFlatFiles, createCanvasDataFlatFileFormat());
    formatMap.put(Format.DecompressedCanvasDataFlatFiles, createDecompressedCanvasDataFlatFileFormat());
    formatMap.put(Format.Excel, createExcelFormat());
    formatMap.put(Format.DecompressedExcel, createDecompressedExcelFormat());
  }

  public TableFormat getFormat(final Format format) {
    return formatMap.get(format);
  }

  private static DateTimeFormatter CANVAS_TIMESTAMP_FORMAT = new DateTimeFormatterBuilder()
      .appendValue(ChronoField.YEAR, 4).appendLiteral("-").appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral("-").appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral(" ")
      .appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(":")
      .appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(":")
      .appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalStart()
      .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true).optionalEnd().toFormatter()
      .withZone(ZoneOffset.ofHours(0));

  public static DateTimeFormatter CANVAS_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static final DateTimeFormatter LOCAL_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd Z").withZone(ZoneOffset.ofHours(5));

  private static final CSVFormat CANVAS_CSV_FORMAT = CSVFormat.TDF.withQuote(null)
      .withNullString("\\N").withRecordSeparator("\n").withIgnoreSurroundingSpaces(false);

  private static final String CANVAS_FILE_ENCODING = "UTF-8";

  private TableFormat createCanvasDataFlatFileFormat() {
    final TableFormat canvasFormat = new TableFormat(Format.CanvasDataFlatFiles);
    canvasFormat.setTimestampFormat(CANVAS_TIMESTAMP_FORMAT);
    canvasFormat.setDateFormat(CANVAS_DATE_FORMAT);
    canvasFormat.setIncludeHeaders(false);
    canvasFormat.setEncoding(CANVAS_FILE_ENCODING);
    canvasFormat.setCsvFormat(CANVAS_CSV_FORMAT);
    canvasFormat.setCompression(TableFormat.Compression.Gzip);
    return canvasFormat;
  }

  private TableFormat createDecompressedCanvasDataFlatFileFormat() {
    final TableFormat canvasFormat = new TableFormat(Format.DecompressedCanvasDataFlatFiles);
    canvasFormat.setTimestampFormat(CANVAS_TIMESTAMP_FORMAT);
    canvasFormat.setDateFormat(CANVAS_DATE_FORMAT);
    canvasFormat.setIncludeHeaders(false);
    canvasFormat.setEncoding(CANVAS_FILE_ENCODING);
    canvasFormat.setCsvFormat(CANVAS_CSV_FORMAT);
    canvasFormat.setCompression(TableFormat.Compression.None);
    return canvasFormat;
  }

  private TableFormat createExcelFormat() {
    final TableFormat canvasFormat = new TableFormat(Format.Excel);
    canvasFormat.setTimestampFormat(CANVAS_TIMESTAMP_FORMAT);
    canvasFormat.setDateFormat(CANVAS_DATE_FORMAT);
    canvasFormat.setIncludeHeaders(true);
    canvasFormat.setEncoding(CANVAS_FILE_ENCODING);
    canvasFormat.setCsvFormat(CSVFormat.EXCEL);
    canvasFormat.setCompression(TableFormat.Compression.Gzip);
    return canvasFormat;
  }

  private TableFormat createDecompressedExcelFormat() {
    final TableFormat canvasFormat = new TableFormat(Format.Excel);
    canvasFormat.setTimestampFormat(CANVAS_TIMESTAMP_FORMAT);
    canvasFormat.setDateFormat(CANVAS_DATE_FORMAT);
    canvasFormat.setIncludeHeaders(true);
    canvasFormat.setEncoding(CANVAS_FILE_ENCODING);
    canvasFormat.setCsvFormat(CSVFormat.EXCEL);
    canvasFormat.setCompression(TableFormat.Compression.None);
    return canvasFormat;
  }

}
