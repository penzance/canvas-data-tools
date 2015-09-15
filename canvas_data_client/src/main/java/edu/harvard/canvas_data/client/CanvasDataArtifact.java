package edu.harvard.canvas_data.client;

import java.util.List;

public interface CanvasDataArtifact {

  String getTableName();

  /**
   * false if a complete dump, true indicates more files are needed for a
   * complete dataset
   */
  boolean isPartial();

  List<CanvasDataFile> getFiles();

}
