package edu.harvard.data.client.canvas.tables.schema;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TableSchema {
  private final String dwType;
  private final String description;
  private final List<ColumnSchema> columns;
  private final String key;
  private final String name;
  private final boolean incremental;
  private final boolean isDwTable;
  private final String tableName;
  private final String seeAlso;
  private final String databasePath;
  private final String originalTable;
  private final Object hints;

  @JsonCreator
  public TableSchema(@JsonProperty("dw_type") final String dwType,
      @JsonProperty("description") final String description,
      @JsonProperty("columns") final List<ColumnSchema> columns,
      @JsonProperty("key") final String key,
      @JsonProperty("name") final String name,
      @JsonProperty("incremental") final boolean incremental,
      @JsonProperty("isDwTable") final boolean isDwTable,
      @JsonProperty("tableName") final String tableName,
      @JsonProperty("see_also") final String seeAlso,
      @JsonProperty("data_base_path") final String databasePath,
      @JsonProperty("original_table") final String originalTable,
      @JsonProperty("hints") final Map<String, String> hints) {
    this.dwType = dwType;
    this.description = description;
    this.columns = columns;
    this.key = key;
    this.name = name;
    this.incremental = incremental;
    this.isDwTable = isDwTable;
    this.tableName = tableName;
    this.seeAlso = seeAlso;
    this.databasePath = databasePath;
    this.originalTable = originalTable;
    this.hints = hints;
  }

  public String getDwType() {
    return dwType;
  }

  public String getDescription() {
    return description;
  }

  public List<ColumnSchema> getColumns() {
    return columns;
  }

  public String getKey() {
    return key;
  }

  public String getName() {
    return name;
  }

  public boolean isIncremental() {
    return incremental;
  }

  public boolean isDwTable() {
    return isDwTable;
  }

  public String getTableName() {
    return tableName;
  }

  public Object getHints() {
    return hints;
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
