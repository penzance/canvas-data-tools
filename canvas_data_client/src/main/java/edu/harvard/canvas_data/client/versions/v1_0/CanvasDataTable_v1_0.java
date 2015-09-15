package edu.harvard.canvas_data.client.versions.v1_0;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.CanvasDataHistoricalDump;
import edu.harvard.canvas_data.client.CanvasDataTable;

public class CanvasDataTable_v1_0 implements CanvasDataTable {

  private final String tableName;
  private final List<CanvasDataHistoricalDump_v1_0> history;

  @JsonCreator
  public CanvasDataTable_v1_0(@JsonProperty("tableName") final String tableName,
      @JsonProperty("history") final List<CanvasDataHistoricalDump_v1_0> history) {
    this.tableName = tableName;
    this.history = history;
  }

  @Override
  public String getTableName() {
    return tableName;
  }

  @Override
  public List<CanvasDataHistoricalDump> getHistory() {
    return Collections.unmodifiableList(history);
  }

}
