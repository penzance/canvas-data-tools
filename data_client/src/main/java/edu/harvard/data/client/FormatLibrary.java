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
    CanvasDataFlatFiles("canvas"), DecompressedCanvasDataFlatFiles("canvas_expanded");

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
      case "canvas_expanded":
        return DecompressedCanvasDataFlatFiles;
      default:
        return Format.valueOf(label);
      }
    }
  };

  private final Map<Format, TableFormat> formatMap;

  public FormatLibrary() {
    this.formatMap = new HashMap<Format, TableFormat>();
    formatMap.put(Format.CanvasDataFlatFiles, createCanvasDataFlatFileFormat());
    formatMap.put(Format.DecompressedCanvasDataFlatFiles,
        createDecompressedCanvasDataFlatFileFormat());
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

  private static DateTimeFormatter CANVAS_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

}
