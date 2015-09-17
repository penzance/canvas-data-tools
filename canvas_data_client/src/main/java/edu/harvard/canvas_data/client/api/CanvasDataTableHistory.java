package edu.harvard.canvas_data.client.api;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataTableHistory {

  private final String tableName;
  private final List<CanvasDataHistoricalDump> history;

  @JsonCreator
  public CanvasDataTableHistory(@JsonProperty("tableName") final String tableName,
      @JsonProperty("history") final List<CanvasDataHistoricalDump> history) {
    this.tableName = tableName;
    this.history = history;
  }

  public String getTableName() {
    return tableName;
  }

  public List<CanvasDataHistoricalDump> getHistory() {
    return Collections.unmodifiableList(history);
  }

}
