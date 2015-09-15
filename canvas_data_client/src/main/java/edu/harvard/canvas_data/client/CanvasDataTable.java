package edu.harvard.canvas_data.client;

import java.util.List;

public interface CanvasDataTable {

  String getTableName();

  List<CanvasDataHistoricalDump> getHistory();

}
