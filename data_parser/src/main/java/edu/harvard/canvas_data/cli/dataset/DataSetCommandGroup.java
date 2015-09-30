package edu.harvard.canvas_data.cli.dataset;

import java.io.IOException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;

public class DataSetCommandGroup implements Command {

  @Argument(handler=SubCommandHandler.class, usage="Data set management sub-commands")
  @SubCommands({
    @SubCommand(name="info", impl=DataSetInfoCommand.class),
    @SubCommand(name="verify", impl=VerifyDataSetCommand.class),
    @SubCommand(name="copy", impl=CopyDataSetCommand.class),
    @SubCommand(name="split", impl=SplitRequestsCommand.class),
    @SubCommand(name="generateinfo", impl=CalculateDataSetInfoCommand.class),
  })
  public Command cmd;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    cmd.execute(config);
  }

  @Override
  public String getDescription() {
    return "Data set management sub-commands";
  }

}
