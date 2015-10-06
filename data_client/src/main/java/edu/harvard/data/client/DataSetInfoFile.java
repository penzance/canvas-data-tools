package edu.harvard.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSetInfoFile {

  private final String name;
  private long lines;

  public DataSetInfoFile(@JsonProperty("name") final String name,
      @JsonProperty("lines") final long lines) {
    this.name = name;
    this.lines = lines;
  }

  public void setLines(final int lines) {
    this.lines = lines;
  }

  public String getName() {
    return name;
  }

  public long getLines() {
    return lines;
  }

  @Override
  public String toString() {
    return "file:" + name + " records:" + lines + "\n";
  }

}
