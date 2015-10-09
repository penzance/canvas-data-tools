package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.io.PrintStream;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class ListDumpsCommand implements Command {

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    for (final CanvasDataDump dump : api.getDumps()) {
      out.println(dump);
    }
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "List the Canvas data dumps available for download.";
  }

}