package edu.harvard.canvas_data.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

import edu.harvard.canvas_data.client.CanvasData;
import edu.harvard.canvas_data.client.tables.schema.ColumnSchema;
import edu.harvard.canvas_data.client.tables.schema.TableSchema;

public class GenerateClasses {

  private static final String SRC_PATH = "/Users/mcgachey/work/harvard/canvas-data-tools/canvas_data_client/src/main/java/edu/harvard/canvas_data/client/tables/";

  public static void main(final String[] args) throws Exception {
    final CanvasData client = new CanvasData();
    final File schemaFile = new File("/tmp/canvas-data/schema.json");
    final Map<String, TableSchema> schema = client.getTableClient().parseSchema(schemaFile);
    for (final String name : schema.keySet()) {
      final String className = className(schema.get(name).getTableName());
      try (final PrintStream out = new PrintStream(
          new FileOutputStream(SRC_PATH + className + ".java"))) {
        generateClass(className, schema.get(name), out);
      }
      // System.out.println(" public DataSet<" + className + "> parse" +
      // className + "CanvasDataFile(final File gzipFile) throws IOException
      // {");
      // System.out.println(" return parseCanvasDataFile(gzipFile, " + className
      // + ".class);");
      // System.out.println(" }");
      // System.out.println();

//      System.out.println("    case \"" + schema.get(name).getTableName() + "\":");
//      System.out.println("      return parse" + className + "CanvasDataFile(gzipFile);");
    }
  }

  private static void generateClass(final String className, final TableSchema table,
      final PrintStream out) {
    out.println("package edu.harvard.canvas_data.client.tables;");
    out.println();
    if (hasTimestampColumn(table)) {
      out.println("import java.time.ZonedDateTime;");
    }
    out.println("import java.util.ArrayList;");
    out.println("import java.util.List;");
    out.println();
    out.println("import org.apache.commons.csv.CSVRecord;");
    out.println();

    out.println("public class " + className + " extends CanvasDataTable {");
    for (final ColumnSchema column : table.getColumns()) {
      out.println(
          "  private " + javaType(column.getRedshiftType()) + " " + variableName(column.getName())
              + ";");
    }
    out.println();
    out.println("  public " + className + "(final CSVRecord record) {");
    int columnIdx = 0;
    for (final ColumnSchema column : table.getColumns()) {
      generateParseFromCsv(out, column, columnIdx++);
    }
    out.println("  }");
    out.println();

    for (final ColumnSchema column : table.getColumns()) {
      out.println("  public " + javaType(column.getRedshiftType()) + " get"
          + className(column.getName()) + "() {");
      out.println("    return this." + variableName(column.getName()) + ";");
      out.println("  }");
      out.println();
    }

    out.println("  @Override");
    out.println("    public List<Object> getCsvFields() {");

    out.println("    final List<Object> fields = new ArrayList<Object>();");
    for (final ColumnSchema column : table.getColumns()) {
      if (isTimestamp(column)) {
        out.println("    fields.add(formatTimestamp(" + variableName(column.getName()) + "));");
      } else {
        out.println("    fields.add(" + variableName(column.getName()) + ");");
      }
    }
    out.println("    return fields;");
    out.println("  }");

    out.println("}");

  }

  private static boolean isTimestamp(final ColumnSchema c) {
    return (c.getRedshiftType().equals("timestamp") || c.getRedshiftType().equals("datetime"));
  }

  private static boolean hasTimestampColumn(final TableSchema table) {
    for (final ColumnSchema c : table.getColumns()) {
      if (isTimestamp(c)) {
        return true;
      }
    }
    return false;
  }

  private static void generateParseFromCsv(final PrintStream out, final ColumnSchema column, final int idx) {
    String parseMethod = null;
    String extraParams = "";
    switch (javaType(column.getRedshiftType())) {
    case "Boolean":
      parseMethod = "Boolean.valueOf";
      break;
    case "Double":
      parseMethod = "Double.valueOf";
      break;
    case "Integer":
      parseMethod = "Integer.valueOf";
      break;
    case "Long":
      parseMethod = "Long.valueOf";
      break;
    case "ZonedDateTime":
      parseMethod = "ZonedDateTime.parse";
      extraParams = ", CANVAS_DATA_TIMESTAMP_FORMAT";
      break;
    case "String":
      break;
    default:
      throw new RuntimeException("Unknown data type: " + column.getRedshiftType());
    }
    final String getRecord = "record.get(" + idx + ")";
    final String varName = variableName(column.getName());
    if (parseMethod == null) {
      out.println("    this." + varName + " = " + getRecord + ";");
    } else {
      final String tmpName = "$" + varName;
      out.println("    String " + tmpName + " = " + getRecord + ";");
      out.println("    if (" + tmpName + " != null && " + tmpName + ".length() > 0) {");
      out.println("      this." + varName + " = " + parseMethod + "(" + tmpName + extraParams + ");");
      out.println("    }");
    }
  }

  private static String javaType(final String dataType) {
    if (dataType.startsWith("varchar (")) {
      return "String";
    }
    switch (dataType) {
    case "boolean":
      return "Boolean";
    case "double precision":
      return "Double";
    case "int":
      return "Integer";
    case "bigint":
      return "Long";
    case "date":
    case "datetime":
    case "timestamp":
    case "timestamp without time zone":
      return "ZonedDateTime";
    case "character varying":
    case "text":
      return "String";
    default:
      throw new RuntimeException("Unknown data type: " + dataType);
    }
  }

  private static String className(final String name) {
    String className = "";
    for (final String part : name.split("_")) {
      className += part.substring(0, 1).toUpperCase() + part.substring(1);
    }
    return className;
  }

  private static String variableName(final String name) {
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
