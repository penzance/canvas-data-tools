package edu.harvard.data.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DataSetInfo {

  private static final ObjectMapper mapper;

  static {
    mapper = new ObjectMapper();
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  private Path file;
  private FormatLibrary.Format format;
  private final Map<String, DataSetInfoTable> tables;

  public DataSetInfo(final Path file) {
    this.file = file;
    this.tables= new HashMap<String, DataSetInfoTable>();
  }

  public DataSetInfo() {
    this.tables= new HashMap<String, DataSetInfoTable>();
  }

  public DataSetInfo(@JsonProperty("format") final FormatLibrary.Format format) {
    this.format = format;
    this.tables = new HashMap<String, DataSetInfoTable>();
  }

  public static DataSetInfo read(final Path file)
      throws JsonParseException, JsonMappingException, IOException {
    final DataSetInfo info = mapper.readValue(file.toFile(), DataSetInfo.class);
    info.file = file;
    return info;
  }

  public void write() throws IOException {
    Files.createDirectories(file.getParent());
    mapper.writeValue(file.toFile(), this);
  }

  public FormatLibrary.Format getFormat() {
    return format;
  }

  public void setFormat(final FormatLibrary.Format format) {
    this.format = format;
  }

  public Map<String, DataSetInfoTable> getTables() {
    return tables;
  }

  public DataSetInfoTable getTable(final String name) {
    return tables.get(name);
  }

  public void addTable(final String name, final DataSetInfoTable table) {
    tables.put(name, table);
  }

  public static Path getFileName(final Path path) {
    return path.resolve("dataset.json");
  }

  @Override
  public String toString() {
    String str = "format: " + format + "\n";
    final List<String> tableNames = new ArrayList<String>(tables.keySet());
    Collections.sort(tableNames);
    for (final String table : tableNames) {
      str += "  " + tables.get(table);
    }
    return str;
  }

  public void setFile(final Path file) {
    this.file = file;
  }
}
