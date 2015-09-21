package edu.harvard.canvas_data.client.sample_code;

import java.io.File;
import java.io.IOException;

import edu.harvard.canvas_data.client.CanvasData;
import edu.harvard.canvas_data.client.CanvasDataConfigurationException;
import edu.harvard.canvas_data.client.DataTable;
import edu.harvard.canvas_data.client.api.ApiClient;
import edu.harvard.canvas_data.client.api.CanvasDataArtifact;
import edu.harvard.canvas_data.client.api.CanvasDataDump;
import edu.harvard.canvas_data.client.api.CanvasDataFile;
import edu.harvard.canvas_data.client.api.UnexpectedApiResponseException;
import edu.harvard.canvas_data.client.tables.CanvasDataTable;
import edu.harvard.canvas_data.client.tables.ParsedWithErrorsException;
import edu.harvard.canvas_data.client.tables.TableClient;

public class ParseAndWriteAllFiles {

  public static void parseAndWriteAllFiles(final File downloadDir, final File rewrittenDir,
      final String apiKey, final String apiSecret) {

    // Set up the client, and get the API and table modules
    final CanvasData client = new CanvasData();
    final ApiClient api = client.getApiClient("beta.inshosteddata.com", apiKey, apiSecret);
    final TableClient tables = client.getTableClient();

    // Fetch the metadata for the latest dump from the server.
    CanvasDataDump dump;
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

    // Iterate over the artifacts in the dump.
    for (final String table : dump.getArtifactsByTable().keySet()) {
      final CanvasDataArtifact artifact = dump.getArtifactsByTable().get(table);

      // Download the files belonging to the artifact.
      try {
        artifact.downloadAllFiles(new File(downloadDir, table));
        // Parse each of the files that were downloaded
        for (final CanvasDataFile f : artifact.getFiles()) {
          final File src = new File(downloadDir, table + "/" + f.getFilename());
          DataTable<? extends CanvasDataTable> dataSet;
          try {
            // Parse the file into a DataSet object
            dataSet = tables.parseCanvasDataFile(table, src);
          } catch (final ParsedWithErrorsException e) {
            // Retrieve the data that was correctly parsed from the exception.
            // We can write out the records that we did understand.
            dataSet = e.getDataTable();
            System.err.println(e.getErrors().size() + " errors when parsing " + e.getFile());
          }

          // Write out the parsed data into a gzipped file. The contents of that
          // file
          // should be identical to the raw Canvas Data file that was
          // downloaded.
          final File output = new File(rewrittenDir, table + "/" + f.getFilename() + ".tsv");
          dataSet.writeCanvasDataFormat(output, true);
        }
      } catch (final IOException ioException) {
        System.err.println("Some error reading or writing files");
        ioException.printStackTrace();
      } catch (final UnexpectedApiResponseException unexpectedResponse) {
        System.err.println("The server responsed, but not with the expected success code.");
        System.err.println("Got code " + unexpectedResponse.getStatus() + " instead.");
      }

    }
  }

}
