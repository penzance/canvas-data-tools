package edu.harvard.canvas_data.cli.dump;

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

public class DumpCommandGroup implements Command {

  @Argument(handler = SubCommandHandler.class, usage = "Dump management sub-commands.")
  @SubCommands({ @SubCommand(name = "info", impl = DumpInfoCommand.class),
    @SubCommand(name = "list", impl = ListDumpsCommand.class),
    @SubCommand(name = "listnew", impl = ListNewDumpsCommand.class),
    @SubCommand(name = "schema", impl = GetSchemaCommand.class),
    @SubCommand(name = "tablehistory", impl = TableHistoryCommand.class),
    @SubCommand(name = "archive", impl = ArchiveDumpCommand.class),
    @SubCommand(name = "download", impl = DownloadDumpCommand.class),
    @SubCommand(name = "downloadnew", impl = DownloadAllNewCommand.class), })
  public Command cmd;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    if (cmd == null) {
      throw new IllegalArgumentException("Missing sub command");
    }
    return cmd.execute(config, out);
  }

  @Override
  public String getDescription() {
    return "Dump management sub-commands";
  }

}
