package edu.harvard.canvas_data.client.versions.v1_0;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.CanvasDataFile;
import edu.harvard.canvas_data.client.RestUtils;
import edu.harvard.canvas_data.client.UnexpectedApiResponseException;

public class CanvasDataFile_v1_0 implements CanvasDataFile {
  private final String url;
  private final String filename;
  private RestUtils rest;

  @JsonCreator
  public CanvasDataFile_v1_0(@JsonProperty("url") final String url,
      @JsonProperty("filename") final String filename) {
    this.url = url;
    this.filename = filename;
  }

  void setRestUtils(final RestUtils rest) {
    this.rest = rest;
  }

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public String getFilename() {
    return filename;
  }

  @Override
  public void download(final File dest) throws IOException, UnexpectedApiResponseException {
    rest.downloadFile(url, dest, 200);
  }

}
