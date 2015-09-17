package edu.harvard.canvas_data.client.api;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataFile {
  private final String url;
  private final String filename;
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

  public String getUrl() {
    return url;
  }

  public String getFilename() {
    return filename;
  }

  public void download(final File dest) throws IOException, UnexpectedApiResponseException {
    rest.downloadFile(url, dest, 200);
  }

}
