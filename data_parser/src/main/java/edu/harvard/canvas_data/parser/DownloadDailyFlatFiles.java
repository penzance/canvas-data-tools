package edu.harvard.canvas_data.parser;

import java.io.IOException;

import edu.harvard.canvas_data.client.CanvasData;
import edu.harvard.canvas_data.client.CanvasDataConfigurationException;
import edu.harvard.canvas_data.client.api.ApiClient;
import edu.harvard.canvas_data.client.api.CanvasDataDump;
import edu.harvard.canvas_data.client.api.UnexpectedApiResponseException;
import edu.harvard.canvas_data.client.tables.TableClient;

public class DownloadDailyFlatFiles {

  private static final String SECURE_PROPERTIES = "secure.properties";

  public static void main(final String[] args) {
    try {
      final Configuration config = Configuration.getConfiguration(SECURE_PROPERTIES);
      final CanvasData client = new CanvasData();
      final ApiClient api = client.getApiClient(config.getCanvasDataHost(),
          config.getCanvasApiKey(), config.getCanvasApiSecret());
      final TableClient tables = client.getTableClient();
      for (final CanvasDataDump dumpSummary : api.getDumps()) {
        final CanvasDataDump dump = api.getDump(dumpSummary.getDumpId());
        final DumpManager dumpManager = new DumpManager(dump, config);
        if (dumpManager.needToSaveDump()) {
          dumpManager.saveDumpToTempDirectory(api);
          dumpManager.verifyDump(tables);
          dumpManager.archiveDump(tables);
        }
      }
    } catch (final IOException | CanvasDataConfigurationException e) {
      e.printStackTrace();
    } catch (final UnexpectedApiResponseException e) {
      System.err.println("Unexpected response " + e.getStatus());
      e.printStackTrace();
    } catch (final VerificationException e) {
      System.err.println("Verification failures");
    }
  }
}
