package edu.harvard.data.client.generators;

import edu.harvard.data.client.canvas.api.CanvasDataSchemaType;

public class NameGenerator {

  public static String javaClass(final String str) {
    String className = "";
    for (final String part : str.split("_")) {
      className += part.substring(0, 1).toUpperCase() + part.substring(1);
    }
    return className;
  }

  //    case "timestamp without time zone":
  //      return "ZonedDateTime";
  public static String javaType(final CanvasDataSchemaType dataType) {
    switch (dataType) {
    case BigInt:
      return "Long";
    case Boolean:
      return "Boolean";
    case Date:
      return "LocalDate";
    case DateTime:
    case Timestamp:
      return "ZonedDateTime";
    case DoublePrecision:
      return "Double";
    case Int:
    case Integer:
      return "Integer";
    case Text:
    case VarChar:
      return "String";
    default:
      throw new RuntimeException("Unknown data type: " + dataType);
    }
  }

  public static String javaVariable(final String name) {
    final String[] parts = name.split("_");
    String variableName = parts[0];
    for (int i = 1; i < parts.length; i++) {
      final String part = parts[i];
      variableName += part.substring(0, 1).toUpperCase() + part.substring(1);
    }
    if (variableName.equals("public")) {
      variableName = "_public";
    }
    if (variableName.equals("default")) {
      variableName = "_default";
    }
    return variableName;
  }

}
