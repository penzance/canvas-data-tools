package edu.harvard.data.client.generators;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import edu.harvard.data.client.canvas.api.CanvasDataSchema;
import edu.harvard.data.client.canvas.api.CanvasDataSchemaColumn;
import edu.harvard.data.client.canvas.api.CanvasDataSchemaTable;
import edu.harvard.data.client.canvas.api.CanvasDataSchemaType;

public class JavaSdkGenerator {

  private static final Logger log = Logger.getLogger("Canvas Data");

  private final Map<String, CanvasDataSchemaTable> tables;
  private final String version;

  private static final String CLIENT_PACKAGE = "edu.harvard.data.client";
  private static final String CODE_DIR = "edu/harvard/data/client/canvas/tables";

  public JavaSdkGenerator(final CanvasDataSchema schema) {
    this.version = schema.getVersion();
    this.tables = schema.getSchema();
  }

  public void generate(final Path outputDirectory) throws IOException {
    final Path codeBase = outputDirectory.resolve(CODE_DIR);
    log.info("Generating code in " + codeBase);

    if (!Files.exists(codeBase)) {
      Files.createDirectories(codeBase);
    }

    // Generate the model classes
    for (final String name : tables.keySet()) {
      final String className = NameGenerator.javaClass(tables.get(name).getTableName());
      final Path classFile = codeBase.resolve(className + ".java");
      try (final PrintStream out = new PrintStream(Files.newOutputStream(classFile))) {
        generateTableClass(className, tables.get(name), out);
      }
    }

    // Generate a sorted list of table names for the switch tables in the next
    // two classes.
    final List<String> tableNames = new ArrayList<String>();
    for (final String name : tables.keySet()) {
      tableNames.add(tables.get(name).getTableName());
    }
    Collections.sort(tableNames);

    // Create the CanvasTable Enum type
    final Path tableEnumFile = codeBase.resolve("CanvasTable.java");
    try (final PrintStream out = new PrintStream(Files.newOutputStream(tableEnumFile))) {
      generateTableEnum(out, tableNames);
    }

    // Create the CanvasTableFactory class
    final Path tableFactoryFile = codeBase.resolve("CanvasTableFactory.java");
    try (final PrintStream out = new PrintStream(Files.newOutputStream(tableFactoryFile))) {
      generateCanvasTableFactory(out, tableNames);
    }
  }

  private void generateCanvasTableFactory(final PrintStream out,
      final List<String> tableNames) {
    log.info("Generating CanvasTableFactory");
    writeFileHeader(out);
    out.println("package " + CLIENT_PACKAGE + ".canvas.tables;");
    out.println();
    out.println("import java.io.IOException;");
    out.println("import java.nio.file.Path;");
    out.println();
    out.println("import " + CLIENT_PACKAGE + ".DataTable;");
    out.println("import " + CLIENT_PACKAGE + ".DelimitedTableReader;");
    out.println("import " + CLIENT_PACKAGE + ".DelimitedTableWriter;");
    out.println("import " + CLIENT_PACKAGE + ".TableFactory;");
    out.println("import " + CLIENT_PACKAGE + ".TableFormat;");
    out.println("import " + CLIENT_PACKAGE + ".TableReader;");
    out.println("import " + CLIENT_PACKAGE + ".TableWriter;");
    out.println();
    out.println("public class CanvasTableFactory implements TableFactory {");
    out.println();
    out.println("  @Override");
    out.println(
        "  public TableReader<? extends DataTable> getDelimitedTableReader(String table, TableFormat format, Path file) throws IOException {");
    out.println("    switch(table) {");
    for (final String name : tableNames) {
      final String className = NameGenerator.javaClass(name);
      out.println("    case \"" + name + "\":");
      out.println("      return new DelimitedTableReader<" + className + ">(" + className
          + ".class, format, file, \"" + name + "\");");
    }
    out.println("    }");
    out.println("    return null;");
    out.println("  }");
    out.println();
    out.println("  @Override");
    out.println(
        "  public TableWriter<? extends DataTable> getDelimitedTableWriter(String table, TableFormat format, Path directory) throws IOException {");
    out.println("    switch(table) {");
    for (final String name : tableNames) {
      final String className = NameGenerator.javaClass(name);
      out.println("    case \"" + name + "\":");
      out.println("      return new DelimitedTableWriter<" + className + ">(" + className
          + ".class, format, directory, \"" + name + "\");");
    }
    out.println("    }");
    out.println("    return null;");
    out.println("  }");
    out.println("}");
  }

  private void generateTableEnum(final PrintStream out, final List<String> tableNames) {
    log.info("Generating CanvasTable Enum");
    writeFileHeader(out);
    out.println("package " + CLIENT_PACKAGE + ".canvas.tables;");
    out.println();
    out.println("  import " + CLIENT_PACKAGE + ".DataTable;");
    out.println();
    out.println("public enum CanvasTable {");
    for (int i = 0; i < tableNames.size(); i++) {
      final String name = tableNames.get(i);
      final String className = NameGenerator.javaClass(name);
      out.print("  " + className + "(\"" + name + "\", " + className + ".class)");
      out.println(i == (tableNames.size() - 1) ? ";" : ",");
    }
    out.println();
    out.println("  private final String sourceName;");
    out.println("  private final Class<? extends DataTable> tableClass;");
    out.println();
    out.println(
        "  private CanvasTable(final String sourceName, Class<? extends DataTable> tableClass) {");
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
      final String className = NameGenerator.javaClass(name);
      out.println("    case \"" + name + "\": return " + className + ";");
    }
    out.println("    default: throw new RuntimeException(\"Unknown table name \" + sourceName);");
    out.println("    }");
    out.println("  }");
    out.println("}");
  }

  private void generateTableClass(final String className, final CanvasDataSchemaTable table,
      final PrintStream out) {
    log.info("Generating table " + className);
    writeFileHeader(out);
    out.println("package " + CLIENT_PACKAGE + ".canvas.tables;");
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
    out.println("import " + CLIENT_PACKAGE + ".DataTable;");
    out.println("import " + CLIENT_PACKAGE + ".TableFormat;");
    out.println();

    out.println("public class " + className + " implements DataTable {");
    for (final CanvasDataSchemaColumn column : table.getColumns()) {
      final String typeName = NameGenerator.javaType(column.getType());
      final String variableName = NameGenerator.javaVariable(column.getName());
      out.println("  private " + typeName + " " + variableName + ";");
    }
    out.println();
    out.println("  public " + className + "(final TableFormat format, final CSVRecord record) {");
    int columnIdx = 0;
    for (final CanvasDataSchemaColumn column : table.getColumns()) {
      generateParseFromCsv(out, column, columnIdx++);
    }
    out.println("  }");
    out.println();

    for (final CanvasDataSchemaColumn column : table.getColumns()) {
      final String typeName = NameGenerator.javaType(column.getType());
      final String methodName = "get" + NameGenerator.javaClass(column.getName());
      final String variableName = NameGenerator.javaVariable(column.getName());
      writeComment(column.getDescription(), 2, out, true);
      out.println("  public " + typeName + " " + methodName + "() {");
      out.println("    return this." + variableName + ";");
      out.println("  }");
      out.println();
    }

    out.println("  @Override");
    out.println("  public List<Object> getFieldsAsList(final TableFormat formatter) {");

    out.println("    final List<Object> fields = new ArrayList<Object>();");
    for (final CanvasDataSchemaColumn column : table.getColumns()) {
      final String variableName = NameGenerator.javaVariable(column.getName());
      if (isTimestamp(column) || isDate(column)) {
        out.println("    fields.add(formatter.formatTimestamp(" + variableName + "));");
      } else {
        out.println("    fields.add(" + variableName + ");");
      }
    }
    out.println("    return fields;");
    out.println("  }");

    out.println();
    out.println("  public static List<String> getFieldNames() {");
    out.println("    final List<String> fields = new ArrayList<String>();");
    for (final CanvasDataSchemaColumn column : table.getColumns()) {
      out.println("      fields.add(\"" + column.getName() + "\");");
    }
    out.println("    return fields;");
    out.println("  }");

    out.println("}");

  }

  private boolean isTimestamp(final CanvasDataSchemaColumn c) {
    return (c.getType() == CanvasDataSchemaType.Timestamp
        || c.getType() == CanvasDataSchemaType.DateTime);
  }

  private boolean isDate(final CanvasDataSchemaColumn c) {
    return c.getType() == CanvasDataSchemaType.Date;
  }

  private boolean hasDateColumn(final CanvasDataSchemaTable table) {
    for (final CanvasDataSchemaColumn c : table.getColumns()) {
      if (isDate(c)) {
        return true;
      }
    }
    return false;
  }

  private boolean hasTimestampColumn(final CanvasDataSchemaTable table) {
    for (final CanvasDataSchemaColumn c : table.getColumns()) {
      if (isTimestamp(c)) {
        return true;
      }
    }
    return false;
  }

  private void generateParseFromCsv(final PrintStream out,
      final CanvasDataSchemaColumn column, final int idx) {
    String parseMethod = null;
    String extraParams = "";
    switch (column.getType()) {

    case BigInt:
      parseMethod = "Long.valueOf";
      break;
    case Boolean:
      parseMethod = "Boolean.valueOf";
      break;
    case DateTime:
    case Timestamp:
      parseMethod = "ZonedDateTime.parse";
      extraParams = ", format.getTimstampFormat()";
      break;
    case Date:
      parseMethod = "LocalDate.parse";
      extraParams = ", format.getDateFormat()";
      break;
    case DoublePrecision:
      parseMethod = "Double.valueOf";
      break;
    case Int:
    case Integer:
      parseMethod = "Integer.valueOf";
      break;
    case Text:
    case VarChar:
      break;
    default:
      throw new RuntimeException("Unknown data type: " + column.getType());
    }
    final String getRecord = "record.get(" + idx + ")";
    final String varName = NameGenerator.javaVariable(column.getName());
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

  private void writeFileHeader(final PrintStream out) {
    writeComment("This file was generated on " +
        new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date()) +
        ". Do not manually edit.", 0, out, false);
    writeComment("This class is based on Version " + version + " of the Canvas Data schema", 0, out, false);
    out.println();
  }

  private void writeComment(final String text, final int indent, final PrintStream out, final boolean javadoc) {
    if (text == null) {
      return;
    }
    if (javadoc) {
      writeIndent(indent, out);
      out.println("/**");
    }
    final int maxLine = 80;
    startNewCommentLine(indent, out, javadoc);
    int currentLine = indent + 3;
    for (final String word : text.split(" ")) {
      currentLine += word.length() + 1;
      if (currentLine > maxLine) {
        out.println();
        startNewCommentLine(indent, out, javadoc);
        currentLine = indent + 3 + word.length();
      }
      out.print(word + " ");
    }
    if (javadoc) {
      out.println();
      writeIndent(indent, out);
      out.print(" */");
    }
    out.println();
  }

  private void writeIndent(final int indent, final PrintStream out) {
    for (int i = 0; i < indent; i++) {
      out.print(" ");
    }
  }

  private int startNewCommentLine(final int indent, final PrintStream out, final boolean javadoc) {
    writeIndent(indent, out);
    if (javadoc) {
      out.print(" * ");
      return 2;
    } else {
      out.print("// ");
      return 3;
    }
  }
}
