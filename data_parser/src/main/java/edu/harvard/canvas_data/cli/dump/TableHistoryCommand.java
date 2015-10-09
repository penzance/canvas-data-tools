package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataHistoricalDump;
import edu.harvard.data.client.canvas.api.CanvasDataTableHistory;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class TableHistoryCommand implements Command {

  @Argument(index = 0, usage = "Table for which to fetch history.", required=true, metaVar="table_name")
  private String table;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    final CanvasDataTableHistory history = api.getTableHistory(table);
    for (final CanvasDataHistoricalDump dump : history.getHistory()) {
      out.println(dump);
    }
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Get details of a single table across available Canvas data dumps.";
  }

}