package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.logging.Logger;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.DumpManager;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DownloadAllNewCommand implements Command {

  private static final Logger log = Logger.getLogger("Canvas Data");

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws IOException, DataConfigurationException, UnexpectedApiResponseException {
    final DumpManager manager = new DumpManager(config);
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    for (final CanvasDataDump dump : api.getDumps()) {
      if (manager.needToSaveDump(dump)) {
        final CanvasDataDump fullDump = api.getDump(dump.getDumpId());
        final Path scratchDir = manager.getScratchDumpDir(fullDump);
        final Path archiveDir = manager.getArchiveDumpDir(fullDump);
        log.info("Saving " + fullDump.getSequence());
        manager.saveDump(api, scratchDir, fullDump);
        manager.archiveDump(scratchDir, archiveDir);
      }
    }
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Download and archive all Canvas data dumps that are not already archived.";
  }

}