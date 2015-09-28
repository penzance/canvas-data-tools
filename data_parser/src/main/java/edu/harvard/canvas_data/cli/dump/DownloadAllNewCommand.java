package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.nio.file.Path;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.DumpManager;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DownloadAllNewCommand implements Command {

  @Override
  public void execute(final Configuration config) throws IOException, DataConfigurationException {
    final DumpManager manager = new DumpManager(config);
    try {
      final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
          config.getCanvasApiKey(), config.getCanvasApiSecret());
      for (final CanvasDataDump dump : api.getDumps()) {
        if (manager.needToSaveDump(dump)) {
          final CanvasDataDump fullDump = api.getDump(dump.getDumpId());
          final Path scratchDir = manager.getScratchDumpDir(fullDump);
          final Path archiveDir = manager.getArchiveDumpDir(fullDump);
          System.out.println("Saving " + fullDump.getSequence());
          manager.saveDump(api, scratchDir, fullDump);
          manager.archiveDump(scratchDir, archiveDir);
        }
      }
    } catch (final UnexpectedApiResponseException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getDescription() {
    return "Download and archive all Canvas data dumps that are not already archived.";
  }

}