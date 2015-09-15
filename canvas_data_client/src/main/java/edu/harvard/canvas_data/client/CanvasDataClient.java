package edu.harvard.canvas_data.client;

import java.util.List;

import edu.harvard.canvas_data.client.versions.v1_0.CanvasDataClient_v1_0;

public interface CanvasDataClient {

  public static CanvasDataClient getClient(
      final String host, final String key, final String secret){
    return new CanvasDataClient_v1_0(host, key, secret);
  }

  List<CanvasDataDump> getDumps()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException;

  CanvasDataDump getLatestDump()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException;

  CanvasDataDump getDump(int id)
      throws CanvasDataConfigurationException, UnexpectedApiResponseException;
}
