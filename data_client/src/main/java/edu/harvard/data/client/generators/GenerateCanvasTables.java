package edu.harvard.data.client.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.harvard.data.client.canvas.tables.schema.ColumnSchema;
import edu.harvard.data.client.canvas.tables.schema.TableSchema;

public class GenerateCanvasTables {
  public static void main(final String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("arguments: /path/to/schema.json /directory/to/output/files/");
      System.exit(1);
    }
    final File schemaFile = new File(args[0]);
    final String srcPath = args[1];
    final Map<String, TableSchema> schema = parseSchema(schemaFile);
    final List<String> tableNames = new ArrayList<String>();
    for (final String name : schema.keySet()) {
      final String className = className(schema.get(name).getTableName());
      try (final PrintStream out = new PrintStream(
          new FileOutputStream(srcPath + "/" + className + ".java"))) {
        generateTableClass(className, schema.get(name), out);
      }
      tableNames.add(schema.get(name).getTableName());
    }
    Collections.sort(tableNames);

    try (final PrintStream out = new PrintStream(new FileOutputStream(srcPath + "/CanvasTable.java"))) {
      generateTableEnum(out, tableNames);
    }

    try (final PrintStream out = new PrintStream(new FileOutputStream(srcPath + "/CanvasTableFactory.java"))) {
      generateCanvasTableFactory(out, tableNames);
    }
  }

  private static Map<String, TableSchema> parseSchema(final File schemaFile)
      throws JsonParseException, JsonMappingException, IOException {
    final ObjectMapper mapper = new ObjectMapper();
    final Map<String, TableSchema> schema = mapper.readValue(schemaFile,
        new TypeReference<Map<String, TableSchema>>() {
    });
    return schema;
  }

  private static void generateCanvasTableFactory(final PrintStream out, final List<String> tableNames) {
    out.println("package edu.harvard.data.client.canvas.tables;");
    out.println();
    out.println("  import java.io.IOException;");
    out.println("  import java.nio.file.Path;");
    out.println();
    out.println("  import edu.harvard.data.client.DataTable;");
    out.println("  import edu.harvard.data.client.DelimitedTableReader;");
    out.println("  import edu.harvard.data.client.DelimitedTableWriter;");
    out.println("  import edu.harvard.data.client.TableFactory;");
    out.println("  import edu.harvard.data.client.TableFormat;");
    out.println("  import edu.harvard.data.client.TableReader;");
    out.println("  import edu.harvard.data.client.TableWriter;");
    out.println();
    out.println("public class CanvasTableFactory implements TableFactory {");
    out.println();
    out.println("  @Override");
    out.println("  public TableReader<? extends DataTable> getDelimitedTableReader(String table, TableFormat format, Path file) throws IOException {");
    out.println("    switch(table) {");
    for (final String name : tableNames) {
      out.println("    case \"" + name + "\":");
      out.println("      return new DelimitedTableReader<" + className(name) + ">(" + className(name) + ".class, format, file);");
    }
    out.println("    }");
    out.println("    return null;");
    out.println("  }");
    out.println();
    out.println("  @Override");
    out.println("  public TableWriter<? extends DataTable> getDelimitedTableWriter(String table, TableFormat format, Path directory) throws IOException {");
    out.println("    switch(table) {");
    for (final String name : tableNames) {
      out.println("    case \"" + name + "\":");
      out.println("      return new DelimitedTableWriter<" + className(name) + ">(" + className(name) + ".class, format, directory, \"" + name + "\");");
    }
    out.println("    }");
    out.println("    return null;");
    out.println("  }");
    out.println("}");
  }

  private static void generateTableEnum(final PrintStream out, final List<String> tableNames) {
    out.println("package edu.harvard.data.client.canvas.tables;");
    out.println();
    out.println("  import edu.harvard.data.client.DataTable;");
    out.println();
    out.println("public enum CanvasTable {");
    for (int i = 0; i < tableNames.size(); i++) {
      final String name = tableNames.get(i);
      out.print("  " + className(name) + "(\"" + name + "\", " + className(name) + ".class)");
      out.println(i == (tableNames.size() - 1) ? ";" : ",");
    }
    out.println();
    out.println("  private final String sourceName;");
    out.println("  private final Class<? extends DataTable> tableClass;");
    out.println();
    out.println("  private CanvasTable(final String sourceName, Class<? extends DataTable> tableClass) {");
    out.println("    this.sourceName = sourceName;");
    out.println("    this.tableClass = tableClass;");
    out.println("  }");
    out.println();
    out.println("  public String getSourceName() {");
    out.println("    return sourceName;");
    out.println("  }");
    out.println();
    out.println("  public Class<? extends DataTable> getTableClass() {");
    out.println("    return tableClass;");
    out.println("  }");
    out.println();
    out.println("  public static CanvasTable fromSourceName(String sourceName) {");
    out.println("    switch(sourceName) {");
    for (final String name : tableNames) {
      out.println("    case \"" + name + "\": return " + className(name) + ";");
    }
    out.println("    default: throw new RuntimeException(\"Unknown table name \" + sourceName);");
    out.println("    }");
    out.println("  }");
    out.println("}");
  }

  private static void generateTableClass(final String className, final TableSchema table,
      final PrintStream out) {
    out.println("package edu.harvard.data.client.canvas.tables;");
    out.println();
    if (hasTimestampColumn(table)) {
      out.println("import java.time.ZonedDateTime;");
    }
    if (hasDateColumn(table)) {
      out.println("import java.time.LocalDate;");
    }
    out.println("import java.util.ArrayList;");
    out.println("import java.util.List;");
    out.println();
    out.println("import org.apache.commons.csv.CSVRecord;");
    out.println("import edu.harvard.data.client.DataTable;");
    out.println("import edu.harvard.data.client.TableFormat;");
    out.println();

    out.println("public class " + className + " implements DataTable {");
    for (final ColumnSchema column : table.getColumns()) {
      out.println("  private " + javaType(column.getRedshiftType()) + " "
          + variableName(column.getName()) + ";");
    }
    out.println();
    out.println("  public " + className + "(final TableFormat format, final CSVRecord record) {");
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
    out.println("  public List<Object> getFieldsAsList(final TableFormat formatter) {");

    out.println("    final List<Object> fields = new ArrayList<Object>();");
    for (final ColumnSchema column : table.getColumns()) {
      if (isTimestamp(column) || isDate(column)) {
        out.println("    fields.add(formatter.formatTimestamp(" + variableName(column.getName()) + "));");
      } else {
        out.println("    fields.add(" + variableName(column.getName()) + ");");
      }
    }
    out.println("    return fields;");
    out.println("  }");

    out.println();
    out.println("  public static List<String> getFieldNames() {");
    out.println("    final List<String> fields = new ArrayList<String>();");
    for (final ColumnSchema column : table.getColumns()) {
      out.println("      fields.add(\"" + column.getName() + "\");");
    }
    out.println("    return fields;");
    out.println("  }");

    out.println("}");

  }

  private static boolean isTimestamp(final ColumnSchema c) {
    return (c.getRedshiftType().equals("timestamp") || c.getRedshiftType().equals("datetime"));
  }

  private static boolean isDate(final ColumnSchema c) {
    return c.getRedshiftType().equals("date");
  }

  private static boolean hasDateColumn(final TableSchema table) {
    for (final ColumnSchema c : table.getColumns()) {
      if (isDate(c)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasTimestampColumn(final TableSchema table) {
    for (final ColumnSchema c : table.getColumns()) {
      if (isTimestamp(c)) {
        return true;
      }
    }
    return false;
  }

  private static void generateParseFromCsv(final PrintStream out, final ColumnSchema column,
      final int idx) {
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
    case "LocalDate":
      parseMethod = "LocalDate.parse";
      extraParams = ", format.getDateFormat()";
      break;
    case "ZonedDateTime":
      parseMethod = "ZonedDateTime.parse";
      extraParams = ", format.getTimstampFormat()";
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
      out.println(
          "      this." + varName + " = " + parseMethod + "(" + tmpName + extraParams + ");");
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
      return "LocalDate";
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
