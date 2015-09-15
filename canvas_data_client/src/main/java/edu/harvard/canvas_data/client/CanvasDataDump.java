package edu.harvard.canvas_data.client;

import java.util.Date;
import java.util.Map;

public interface CanvasDataDump {

  String getDumpId();

  /**
   * Incrementing counter for each new dump, provides a strict ordering of dumps.
   */
  long getSequence();

  String getAccountId();

  /**
   * The number of files/tables associated with the dump
   */
  int getNumFiles();

  /**
   * indicates whether the dump is completed or not
   */
  boolean isFinished();

  /**
   * timestamp of when the dump will be pruned from the database
   */
  Date getExpires();

  Date getCreatedAt();

  Date getUpdatedAt();

  Map<String, CanvasDataArtifact> getArtifactsByTable();

}
