package edu.harvard.data.client.canvas.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataSchemaColumn {

  private final String name;
  private final String description;
  private final String descripton; // Typo shows up in around half the columns.
  private final CanvasDataSchemaType type;
  private final CanvasDataSchemaDimension dimension;
  private final int length;
  private final Boolean snowflake; // true for:
                                   // conversation_message_participant.conversation_message_id,
                                   // conversation_message_participant.conversation_id,
                                   // conversation_message_participant.user_id
  private final String seeAlso;
  private final Boolean sortKey; // true for requests.timestamp

  @JsonCreator
  public CanvasDataSchemaColumn(@JsonProperty("name") final String name,
      @JsonProperty("description") final String description,
      @JsonProperty("type") final String type,
      @JsonProperty("dimension") final CanvasDataSchemaDimension dimension,
      @JsonProperty("length") final int length, @JsonProperty("snowflake") final Boolean snowflake,
      @JsonProperty("sortKey") final Boolean sortKey,
      @JsonProperty("descripton") final String descripton,
      @JsonProperty("see_also") final String seeAlso) {
    this.name = name;
    this.description = description;
    this.sortKey = sortKey;
    this.descripton = descripton;
    this.type = CanvasDataSchemaType.parse(type);
    this.dimension = dimension;
    this.length = length;
    this.snowflake = snowflake;
    this.seeAlso = seeAlso;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getDescripton() {
    return descripton;
  }

  public CanvasDataSchemaType getType() {
    return type;
  }

  public CanvasDataSchemaDimension getDimension() {
    return dimension;
  }

  public int getLength() {
    return length;
  }

  public Boolean getSnowflake() {
    return snowflake;
  }

  public String getSeeAlso() {
    return seeAlso;
  }

  public Boolean getSortKey() {
    return sortKey;
  }

}
