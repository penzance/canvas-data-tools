package edu.harvard.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSetInfoFile {

  private final String name;
  private final int lines;

  public DataSetInfoFile(@JsonProperty("name") final String name,
      @JsonProperty("lines") final int lines) {
    this.name = name;
    this.lines = lines;
  }

  public String getName() {
    return name;
  }

  public int getLines() {
    return lines;
  }

  @Override
  public String toString() {
    return "file:" + name + " records:" + lines + "\n";
  }

}
