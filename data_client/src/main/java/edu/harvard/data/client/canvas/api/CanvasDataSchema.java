package edu.harvard.data.client.canvas.api;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataSchema {
  private final String version;
  private final Map<String, CanvasDataSchemaTable> schema;

  @JsonCreator
  public CanvasDataSchema(@JsonProperty("version") final String version,
      @JsonProperty("schema") final Map<String, CanvasDataSchemaTable> schema) {
    this.version = version;
    this.schema = schema;
  }

  public String getVersion() {
    return version;
  }

  public Map<String, CanvasDataSchemaTable> getSchema() {
    return schema;
  }

}
