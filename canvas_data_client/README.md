This project allows clients to download Canvas data flat files through the REST API. See 
https://beta.inshosteddata.com/docs/api for more details on the download process.

The project can be built using Maven. From the canvas_data_client directory, use

```
mvn clean install
```

Once this has run, you can include the client in your Maven applications using:

```
<dependency>
        <groupId>edu.harvard</groupId>
        <artifactId>canvas_data_client</artifactId>
        <version>1.0.0-BUILD-SNAPSHOT</version>
</dependency>
```

To use the library, you will need an API key and secret, and the server on which the
API is running (for now, that is https://beta.inshosteddata.com). The following code
downloads all the files for the latest dump:

```java
  public static void downloadFiles(final String apiKey, final String apiSecret) {
    // Set up a directory to store the downloaded files.
    final File downloadDir = new File("/tmp/canvas-data");

    // Create the API client object.
    final CanvasDataClient client = CanvasDataClient.getClient(
        "beta.inshosteddata.com", apiKey, apiSecret);

    // Get details of the latest dump.
    final CanvasDataDump dump;
    try {
      dump = client.getLatestDump();
    } catch (final CanvasDataConfigurationException configError) {
      System.err.println("There's a problem with something in the setup, perhaps your API key?");
      return;
    } catch (final UnexpectedApiResponseException unexpectedResponse) {
      System.err.println("The server responsed, but not with the expected success code.");
      System.err.println("Got code " + unexpectedResponse.getStatus() + " instead.");
      return;
    }

    // Iterate over the tables in the dump.
    final Map<String, CanvasDataArtifact> artifactsByTable = dump.getArtifactsByTable();
    for (final String table : artifactsByTable.keySet()) {
      final CanvasDataArtifact artifact = artifactsByTable.get(table);

      // Iterate over the files for the table.
      for (final CanvasDataFile dataFile : artifact.getFiles()) {
        final File dest = new File(downloadDir, table + "/" + dataFile.getFilename());
        // Download the file.
        try {
          dataFile.download(dest);
        } catch (final IOException ioException) {
          System.err.println("Failed to download the file");
        } catch (final UnexpectedApiResponseException unexpectedResponse) {
          System.err.println("The server responsed, but not with the expected success code.");
          System.err.println("Got code " + unexpectedResponse.getStatus() + " instead.");
        }
      }
    }
  }
```
