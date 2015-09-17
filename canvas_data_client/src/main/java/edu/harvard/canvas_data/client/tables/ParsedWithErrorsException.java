package edu.harvard.canvas_data.client.tables;

import java.io.File;
import java.util.List;

import edu.harvard.canvas_data.client.DataSet;

public class ParsedWithErrorsException extends Exception {

  private static final long serialVersionUID = 1L;

  private final DataSet<?> dataSet;
  private final List<ParseError> errors;
  private final File file;
  private final Class<?> tableType;

  public ParsedWithErrorsException(final DataSet<?> dataSet, final List<ParseError> errors,
      final File file, final Class<?> tableType) {
    this.dataSet = dataSet;
    this.errors = errors;
    this.file = file;
    this.tableType = tableType;
  }

  public DataSet<?> getDataSet() {
    return dataSet;
  }

  public List<ParseError> getErrors() {
    return errors;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public File getFile() {
    return file;
  }

  public Class<?> getTableType() {
    return tableType;
  }

}
