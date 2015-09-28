package edu.harvard.data.client.canvas.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPInputStream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.data.client.DataSetInfoFile;

public class CanvasDataFile {
  private final String filename;
  private final String url;
  private RestUtils rest;

  @JsonCreator
  public CanvasDataFile(@JsonProperty("url") final String url,
      @JsonProperty("filename") final String filename) {
    this.url = url;
    this.filename = filename;
  }

  void setRestUtils(final RestUtils rest) {
    this.rest = rest;
  }

  @JsonIgnore
  public String getUrl() {
    return url;
  }

  public String getFilename() {
    return filename;
  }

  public DataSetInfoFile download(final Path dest)
      throws IOException, UnexpectedApiResponseException {
    rest.downloadFile(url, dest, 200);
    return new DataSetInfoFile(filename, getLineCount(dest));
  }

  private int getLineCount(final Path dest) throws IOException {
    try (LineNumberReader lineReader = new LineNumberReader(
        new InputStreamReader(new GZIPInputStream(Files.newInputStream(dest))))) {
      while (lineReader.ready()) {
        lineReader.skip(Long.MAX_VALUE);
      }
      return lineReader.getLineNumber();
    }
  }

}
