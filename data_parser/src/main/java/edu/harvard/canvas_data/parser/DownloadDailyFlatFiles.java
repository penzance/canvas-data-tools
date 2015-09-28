package edu.harvard.canvas_data.parser;

public class DownloadDailyFlatFiles {

  //  private static final String SECURE_PROPERTIES = "secure.properties";

  public static void main(final String[] args) {
    //    try {
    //      final Configuration config = Configuration.getConfiguration(SECURE_PROPERTIES);
    //      final DataClient client = new DataClient();
    //      final CanvasApiClient api = client.getCanvasApiClient(config.getCanvasDataHost(),
    //          config.getCanvasApiKey(), config.getCanvasApiSecret());
    //      for (final CanvasDataDump dumpSummary : api.getDumps()) {
    //        try {
    //          final CanvasDataDump dump = api.getDump(dumpSummary.getDumpId());
    //          final DumpManager dumpManager = new DumpManager(dump, config);
    //          if (dumpManager.needToSaveDump()) {
    //            final long start = System.currentTimeMillis();
    //            dumpManager.saveDumpToTempDirectory(api);
    //            final long end = System.currentTimeMillis();
    //            System.out.println("Downloaded in " + ((end - start) / 1000) + " seconds");
    //            dumpManager.verifyDump();
    //            dumpManager.archiveDump();
    //
    //            final DataPartitioner partioner = new DataPartitioner();
    //          }
    //        } catch (final IOException e) {
    //          e.printStackTrace();
    //        } catch (final UnexpectedApiResponseException e) {
    //          System.err.println("Unexpected response " + e.getStatus() + " from " + e.getUrl());
    //          e.printStackTrace();
    //        } catch (final VerificationException e) {
    //          if (e.getCause() != null) {
    //            System.err.println(e.getMessage());
    //          }
    //          e.printStackTrace();
    //        }
    //      }
    //    } catch (final IOException | DataConfigurationException e) {
    //      e.printStackTrace();
    //    } catch (final UnexpectedApiResponseException e) {
    //      System.err.println("Unexpected response " + e.getStatus() + " from " + e.getUrl());
    //      e.printStackTrace();
    //    }
  }
}
