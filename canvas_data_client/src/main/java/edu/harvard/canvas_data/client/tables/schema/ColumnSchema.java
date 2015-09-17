package edu.harvard.canvas_data.client.tables.schema;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnSchema {
  private final String type;
  private final String description;
  private final String name;
  private final String hiveType;
  private final String redshiftType;
  private final Integer length;
  private final Boolean snowflake;
  private final Boolean sortKey;
  private final String seeAlso;
  private final Map<String, String> dimension;
  private final Map<String, String> foreignKey;

  @JsonCreator
  public ColumnSchema(@JsonProperty("type") final String type,
      @JsonProperty("description") final String description,
      @JsonProperty("name") final String name,
      @JsonProperty("hiveType") final String hiveType,
      @JsonProperty("redshiftType") final String redshiftType,
      @JsonProperty("length") final Integer length,
      @JsonProperty("snowflake") final Boolean snowflake,
      @JsonProperty("sortKey") final Boolean sortKey,
      @JsonProperty("see_also") final String seeAlso,
      @JsonProperty("foreign_key") final Map<String, String> foreignKey,
    @JsonProperty("dimension") final Map<String, String> dimension) {
    this.type = type;
    this.description = description;
    this.name = name;
    this.hiveType = hiveType;
    this.length = length;
    this.snowflake = snowflake;
    this.sortKey = sortKey;
    this.redshiftType = redshiftType;
    this.seeAlso = seeAlso;
    this.foreignKey = foreignKey;
    this.dimension = dimension;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public String getHiveType() {
    return hiveType;
  }

  public String getRedshiftType() {
    return redshiftType;
  }

  public Map<String, String> getDimension() {
    return dimension;
  }

  public Integer getLength() {
    return length;
  }

  public Boolean getSnowflake() {
    return snowflake;
  }

  public Boolean getSortKey() {
    return sortKey;
  }

  public String getSeeAlso() {
    return seeAlso;
  }

  public Map<String, String> getForeignKey() {
    return foreignKey;
  }

}
