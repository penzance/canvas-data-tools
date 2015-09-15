package edu.harvard.canvas_data.client.versions.v1_0;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.CanvasDataArtifact;
import edu.harvard.canvas_data.client.CanvasDataFile;
import edu.harvard.canvas_data.client.RestUtils;

public class CanvasDataArtifact_v1_0 implements CanvasDataArtifact {
  private final String tableName;
  private final boolean partial;
  private final List<CanvasDataFile_v1_0> files;

  @JsonCreator
  public CanvasDataArtifact_v1_0(@JsonProperty("tableName") final String tableName,
      @JsonProperty("partial") final boolean partial,
      @JsonProperty("files") final List<CanvasDataFile_v1_0> files) {
    this.tableName = tableName;
    this.partial = partial;
    this.files = files;
  }

  @Override
  public String getTableName() {
    return tableName;
  }

  @Override
  public boolean isPartial() {
    return partial;
  }

  @Override
  public List<CanvasDataFile> getFiles() {
    return Collections.unmodifiableList(files);
  }

  void setRestUtils(final RestUtils rest) {
    if (files != null) {
      for (final CanvasDataFile_v1_0 file : files) {
        file.setRestUtils(rest);
      }
    }
  }
}
