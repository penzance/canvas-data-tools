package edu.harvard.data.client.canvas.api;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataSchemaTable {

  public enum DataWarehouseType { dimension, fact, both }

  private final DataWarehouseType dwType;
  private final String description;
  private final boolean incremental;
  private final String tableName;
  private final Map<String, String> hints; // "sort_key" : "timestamp" in requests
  private final List<CanvasDataSchemaColumn> columns;
  private final String seeAlso;
  private final String databasePath;  // non-null in requests
  private final String originalTable; // non-null in requests

  @JsonCreator
  public CanvasDataSchemaTable(@JsonProperty("dw_type") final DataWarehouseType dwType,
      @JsonProperty("description") final String description,
      @JsonProperty("columns") final List<CanvasDataSchemaColumn> columns,
      @JsonProperty("incremental") final boolean incremental,
      @JsonProperty("tableName") final String tableName,
      @JsonProperty("hints") final Map<String, String> hints,
      @JsonProperty("data_base_path") final String databasePath,
      @JsonProperty("original_table") final String originalTable,
      @JsonProperty("see_also") final String seeAlso) {
    this.dwType = dwType;
    this.description = description;
    this.columns = columns;
    this.incremental = incremental;
    this.tableName = tableName;
    this.hints = hints;
    this.databasePath = databasePath;
    this.originalTable = originalTable;
    this.seeAlso = seeAlso;
  }

  public DataWarehouseType getDwType() {
    return dwType;
  }

  public String getDescription() {
    return description;
  }

  public boolean isIncremental() {
    return incremental;
  }

  public String getTableName() {
    return tableName;
  }

  public Map<String, String> getHints() {
    return hints;
  }

  public List<CanvasDataSchemaColumn> getColumns() {
    return columns;
  }

  public String getSeeAlso() {
    return seeAlso;
  }

  public String getDatabasePath() {
    return databasePath;
  }

  public String getOriginalTable() {
    return originalTable;
  }

}
