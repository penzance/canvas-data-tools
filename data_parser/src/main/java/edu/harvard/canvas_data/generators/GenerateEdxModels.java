package edu.harvard.canvas_data.generators;

public class GenerateEdxModels {

  //  public static void main(final String[] args) throws Exception {
  //    if (args.length != 2) {
  //      System.err.println("arguments: /path/to/schema/directory /directory/to/output/files/");
  //      System.exit(1);
  //    }
  //    final File schemaDir = new File(args[0]);
  //    final File srcDir = new File(args[1]);
  //
  //    for (final String schema : schemaDir.list()) {
  //      if (schema.endsWith(".json")) {
  //        System.out.println(new File(schemaDir, schema));
  //        generateSchemaClass(new File(schemaDir, schema), System.out);
  //      }
  //    }
  //  }
  //
  //  private static void generateSchemaClass(final File schemaFile, final PrintStream out)
  //      throws JsonParseException, JsonMappingException, IOException {
  //    final Map<String, EdxTableSchema> tables = new EdxData().parseSchema(schemaFile);
  //    for (final String key : tables.keySet()) {
  //      System.out.println(key);
  //    }
  //  }
}
