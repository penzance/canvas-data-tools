package edu.harvard.canvas_data.client.sample_code;

import java.io.File;
import java.io.IOException;

import edu.harvard.canvas_data.client.CanvasData;
import edu.harvard.canvas_data.client.CanvasDataConfigurationException;
import edu.harvard.canvas_data.client.api.ApiClient;
import edu.harvard.canvas_data.client.api.CanvasDataDump;
import edu.harvard.canvas_data.client.api.UnexpectedApiResponseException;

public class DownloadFiles {

  public static void downloadFiles(final String apiKey, final String apiSecret) {
    // Set up a directory to store the downloaded files.
    final File downloadDir = new File("/tmp/canvas-data/dump-sept-17");

    // Create the API client object.
    final CanvasData client = new CanvasData();
    final ApiClient api = client.getApiClient("beta.inshosteddata.com", apiKey, apiSecret);

    // Get details of the latest dump.
    final CanvasDataDump dump;
    try {
      dump = api.getLatestDump();
    } catch (final CanvasDataConfigurationException configError) {
      System.err.println("There's a problem with something in the setup, perhaps your API key?");
      return;
    } catch (final UnexpectedApiResponseException unexpectedResponse) {
      System.err.println("The server responsed, but not with the expected success code.");
      System.err.println("Got code " + unexpectedResponse.getStatus() + " instead.");
      return;
    }

    try {
      dump.downloadAllFiles(downloadDir);
    } catch (final IOException ioException) {
      System.err.println("Failed to download the file");
    } catch (final UnexpectedApiResponseException unexpectedResponse) {
      System.err.println("The server responsed, but not with the expected success code.");
      System.err.println("Got code " + unexpectedResponse.getStatus() + " instead.");
    }
  }
}
