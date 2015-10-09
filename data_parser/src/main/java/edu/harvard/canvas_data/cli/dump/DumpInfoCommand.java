package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DumpInfoCommand implements Command {

  private static final Logger log = Logger.getLogger("Canvas Data");

  @Option(name = "-i", usage = "Dump ID. Either this or the dump sequence number is required", metaVar = "dump_id", forbids = {
  "-s" })
  private String id;

  @Option(name = "-s", usage = "Dump sequence number. Either this or the dump ID is required.", metaVar = "sequence_number", forbids = {
  "-i" })
  private String seq;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws IOException, DataConfigurationException, UnexpectedApiResponseException {
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    CanvasDataDump dump = null;
    if (id != null) {
      dump = api.getDump(id);
    } else if (seq != null) {
      for (final CanvasDataDump d : api.getDumps()) {
        if (("" + d.getSequence()).equals(seq)) {
          dump = api.getDump(d.getDumpId());
        }
      }
      if (dump == null) {
        log.severe("Dump sequence " + seq + " is not available");
        return ReturnStatus.MISSING_DUMP;
      }
    } else {
      log.severe("Either dump ID or sequence number is required.");
      return ReturnStatus.ARGUMENT_ERROR;
    }
    out.println(dump);
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Get details of a single Canvas data dump from the remote server.";
  }

}
