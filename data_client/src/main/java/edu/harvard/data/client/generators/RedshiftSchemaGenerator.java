package edu.harvard.data.client.generators;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import edu.harvard.data.client.canvas.api.CanvasDataSchema;
import edu.harvard.data.client.canvas.api.CanvasDataSchemaColumn;
import edu.harvard.data.client.canvas.api.CanvasDataSchemaTable;

public class RedshiftSchemaGenerator {


  private final Map<String, CanvasDataSchemaTable> tables;

  public RedshiftSchemaGenerator(final CanvasDataSchema schema) {
    this.tables = schema.getSchema();
  }

  public void generate(final PrintStream out) throws IOException {
    for (final CanvasDataSchemaTable table : tables.values()) {
      out.println("create table " + table.getTableName() + "(");
      final List<CanvasDataSchemaColumn> columns = table.getColumns();
      for (int i=0; i<columns.size(); i++) {
        final CanvasDataSchemaColumn column = columns.get(i);
        out.print("    " + column.getName() + " " + column.getRedshiftType());
        if (i < columns.size() - 1) {
          out.println(",");
        } else {
          out.println();
        }
      }
      out.println(");");
    }

  }
}
