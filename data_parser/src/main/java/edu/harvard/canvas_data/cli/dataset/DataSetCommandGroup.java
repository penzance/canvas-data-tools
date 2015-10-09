package edu.harvard.canvas_data.cli.dataset;

import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DataSetCommandGroup implements Command {

  @Argument(handler = SubCommandHandler.class, usage = "Data set management sub-commands")
  @SubCommands({ @SubCommand(name = "info", impl = DataSetInfoCommand.class),
    @SubCommand(name = "verify", impl = VerifyDataSetCommand.class),
    @SubCommand(name = "copy", impl = CopyDataSetCommand.class),
    @SubCommand(name = "split", impl = SplitRequestsCommand.class),
    @SubCommand(name = "generateinfo", impl = CalculateDataSetInfoCommand.class), })
  public Command cmd;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    return cmd.execute(config, out);
  }

  @Override
  public String getDescription() {
    return "Data set management sub-commands";
  }

}
