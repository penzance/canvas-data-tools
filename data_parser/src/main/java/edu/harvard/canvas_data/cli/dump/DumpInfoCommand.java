package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DumpInfoCommand implements Command {

  @Option(name = "-i", usage = "Dump ID. Either this or the dump sequence number is required",
      metaVar="dump_id", forbids={"-s"})
  private String id;

  @Option(name = "-s", usage = "Dump sequence number. Either this or the dump ID is required.",
      metaVar="sequence_number", forbids={"-i"})
  private String seq;

  @Override
  public void execute(final Configuration config) throws IOException, DataConfigurationException {
    try {
      final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
          config.getCanvasApiKey(), config.getCanvasApiSecret());
      if (id != null) {
        System.out.println(api.getDump(id));
        return;
      } else if (seq != null) {
        for (final CanvasDataDump d : api.getDumps()) {
          if (("" + d.getSequence()).equals(seq)) {
            System.out.println(api.getDump(d.getDumpId()));
            return;
          }
        }
        System.err.println("Dump sequence " + seq + " is not available");
      } else {
        System.err.println("Either dump ID or sequence number is required.");
      }
    } catch (final UnexpectedApiResponseException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getDescription() {
    return "Get details of a single Canvas data dump from the remote server.";
  }

}
