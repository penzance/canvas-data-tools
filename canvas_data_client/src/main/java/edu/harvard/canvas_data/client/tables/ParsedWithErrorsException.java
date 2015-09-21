package edu.harvard.canvas_data.client.tables;

import java.io.File;
import java.util.List;

import edu.harvard.canvas_data.client.DataTable;

public class ParsedWithErrorsException extends Exception {

  private static final long serialVersionUID = 1L;

  private final DataTable<?> dataSet;
  private final List<ParseError> errors;
  private final File file;
  private final Class<?> tableType;

  public ParsedWithErrorsException(final DataTable<?> dataSet, final List<ParseError> errors,
      final File file, final Class<?> tableType) {
    this.dataSet = dataSet;
    this.errors = errors;
    this.file = file;
    this.tableType = tableType;
  }

  public DataTable<?> getDataTable() {
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
