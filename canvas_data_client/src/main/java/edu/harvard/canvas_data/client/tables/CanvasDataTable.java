package edu.harvard.canvas_data.client.tables;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.apache.commons.csv.CSVFormat;

public abstract class CanvasDataTable {

  protected static final DateTimeFormatter CANVAS_DATA_TIMESTAMP_FORMAT =
      new DateTimeFormatterBuilder()
      .appendValue(ChronoField.YEAR, 4)
      .appendLiteral("-")
      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
      .appendLiteral("-")
      .appendValue(ChronoField.DAY_OF_MONTH, 2)
      .appendLiteral(" ")
      .appendValue(ChronoField.HOUR_OF_DAY, 2)
      .appendLiteral(":")
      .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
      .appendLiteral(":")
      .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
      .optionalStart()
      .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true)
      .optionalEnd()
      .toFormatter().withZone(ZoneOffset.ofHours(0));

  protected final DateTimeFormatter CANVAS_DATA_ALL_DAY_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static final CSVFormat CANVAS_DATA_FILE_FORMAT =
      CSVFormat.TDF
          .withQuote(null)
          .withNullString("\\N")
          .withRecordSeparator("\n")
          .withIgnoreSurroundingSpaces(false);

  public static final String CANVAS_DATA_ENCODING = "UTF-8";

  public abstract List<Object> getCsvFields();

  protected String formatTimestamp(final ZonedDateTime time) {
    if (time == null) {
      return null;
    }
    String timestamp = time.format(CANVAS_DATA_TIMESTAMP_FORMAT);
    if (timestamp.endsWith(".0")) {
      timestamp = timestamp.substring(0,  timestamp.lastIndexOf("."));
    }
    return timestamp;
  }
}
