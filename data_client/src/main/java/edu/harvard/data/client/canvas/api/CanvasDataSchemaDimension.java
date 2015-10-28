package edu.harvard.data.client.canvas.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataSchemaDimension {

  private final String name;
  private final String id;
  private final String role;

  @JsonCreator
  public CanvasDataSchemaDimension(@JsonProperty("name") final String name,
      @JsonProperty("id") final String id,
      @JsonProperty("role") final String role) {
    this.name = name;
    this.id = id;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public String getRole() {
    return role;
  }

}
