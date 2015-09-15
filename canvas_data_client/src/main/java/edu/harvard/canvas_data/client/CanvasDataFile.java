package edu.harvard.canvas_data.client;

import java.io.File;
import java.io.IOException;

public interface CanvasDataFile {

  String getUrl();

  String getFilename();

  void download(File dest) throws IOException, UnexpectedApiResponseException;

}
