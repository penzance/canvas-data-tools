package edu.harvard.canvas_data.client;

import java.util.List;

public interface CanvasDataHistoricalDump {

  String getDumpId();

  long getSequence();

  boolean isPartial();

  List<CanvasDataFile> getFiles();

}
