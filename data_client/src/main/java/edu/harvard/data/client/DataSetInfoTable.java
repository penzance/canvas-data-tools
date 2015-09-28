package edu.harvard.data.client;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSetInfoTable {

  private final String name;
  private final List<DataSetInfoFile> files;

  public DataSetInfoTable(@JsonProperty("name") final String name) {
    this.name = name;
    this.files = new ArrayList<DataSetInfoFile>();
  }

  public void addFileInfo(final List<DataSetInfoFile> fileInfo) {
    this.files.addAll(fileInfo);
  }

  public void addFileInfo(final DataSetInfoFile fileInfo) {
    this.files.add(fileInfo);
  }

  public String getName() {
    return name;
  }

  public List<DataSetInfoFile> getFileInfo() {
    return files;
  }

  @Override
  public String toString() {
    long size = 0;
    for (final DataSetInfoFile file : files) {
      size += file.getLines();
    }
    String str = "table:" + name + " records:" + size + "\n";
    for (final DataSetInfoFile file : files) {
      str += "    " + file;
    }
    return str;
  }
}
