package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class ListDumpsCommand implements Command {

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    try {
      final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
          config.getCanvasApiKey(), config.getCanvasApiSecret());
      for (final CanvasDataDump dump : api.getDumps()) {
        System.out.println(dump);
      }
    } catch (final UnexpectedApiResponseException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getDescription() {
    return "List the Canvas data dumps available for download.";
  }

}