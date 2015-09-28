package edu.harvard.canvas_data.client;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.harvard.canvas_data.client.edx_tables.schema.EdxTableSchema;

public class EdxData {

  public Map<String, EdxTableSchema> parseSchema(final File schemaFile)
      throws JsonParseException, JsonMappingException, IOException {
    final ObjectMapper mapper = new ObjectMapper();
    final Map<String, EdxTableSchema> schema = mapper.readValue(schemaFile,
        new TypeReference<Map<String, EdxTableSchema>>() {
        });
    return schema;
  }
}
