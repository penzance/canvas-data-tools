package edu.harvard.canvas_data.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.harvard.data.client.canvas.api.CanvasDataDump;

public class DumpInformation {

  private static final ObjectMapper mapper;
  static {
    mapper = new ObjectMapper();
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }


  private final CanvasDataDump dump;
  private final Date downloadStart;
  private final Date downloadComplete;

  @JsonCreator
  public DumpInformation(
      @JsonProperty("dump") final CanvasDataDump dump,
      @JsonProperty("downloadStart") final Date downloadStart,
      @JsonProperty("downloadComplete") final Date downloadComplete) {
    this.dump = dump;
    this.downloadStart = downloadStart;
    this.downloadComplete = downloadComplete;
  }

  public CanvasDataDump getDump() {
    return dump;
  }

  public Date getDownloadStart() {
    return downloadStart;
  }

  public Date getDownloadComplete() {
    return downloadComplete;
  }

  public void write(final Path file) throws IOException {
    mapper.writeValue(file.toFile(), this);
  }

  public static DumpInformation read(final Path file) throws IOException {
    return mapper.readValue(file.toFile(), DumpInformation.class);
  }
}
