package edu.harvard.data.client.canvas.api;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.data.client.DataSetInfoFile;

public class CanvasDataArtifact {
  private final String tableName;
  private final boolean partial;
  private final List<CanvasDataFile> files;

  @JsonCreator
  public CanvasDataArtifact(@JsonProperty("tableName") final String tableName,
      @JsonProperty("partial") final boolean partial,
      @JsonProperty("files") final List<CanvasDataFile> files) {
    this.tableName = tableName;
    this.partial = partial;
    this.files = files;
  }

  public String getTableName() {
    return tableName;
  }

  public boolean isPartial() {
    return partial;
  }

  public List<CanvasDataFile> getFiles() {
    return Collections.unmodifiableList(files);
  }

  public List<DataSetInfoFile> downloadAllFiles(final Path directory)
      throws IOException, UnexpectedApiResponseException {
    final List<DataSetInfoFile> info = new ArrayList<DataSetInfoFile>();
    // Iterate over the files for the table.
    for (final CanvasDataFile dataFile : files) {
      final Path dest = directory.resolve(dataFile.getFilename());
      // Download the file.
      info.add(dataFile.download(dest));
    }
    return info;
  }

  void setRestUtils(final RestUtils rest) {
    if (files != null) {
      for (final CanvasDataFile file : files) {
        file.setRestUtils(rest);
      }
    }
  }

  @Override
  public String toString() {
    return "name:" + tableName +  " partial:" + partial + " files:" + files.size();
  }
}
