package edu.harvard.canvas_data.client.tables;

import org.apache.commons.csv.CSVRecord;

public class ParseError {

  private final CSVRecord record;
  private final Throwable error;

  public ParseError(final CSVRecord record, final Throwable error) {
    this.record = record;
    this.error = error;
  }

  public CSVRecord getRecord() {
    return record;
  }

  public Throwable getError() {
    return error;
  }

}
