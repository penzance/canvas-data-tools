package edu.harvard.canvas_data.cli;

import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import edu.harvard.canvas_data.cli.dataset.DataSetCommandGroup;
import edu.harvard.canvas_data.cli.dump.DumpCommandGroup;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;

public class CanvasDataCli {

  @Option(name = "-q", usage = "Quiet mode. Nothing will be written to standard output")
  private boolean quiet = false;

  @Option(name = "-v", usage = "Verbose mode. Extra debug information will be written to standard output")
  private boolean verbose = false;

  @Argument(handler=SubCommandHandler.class, usage="Top-level command.")
  @SubCommands({
    @SubCommand(name="dump", impl=DumpCommandGroup.class),
    @SubCommand(name="data", impl=DataSetCommandGroup.class),
  })
  public Command cmd;

  public static void main(final String[] args) {
    final CanvasDataCli parser = new CanvasDataCli();
    final CmdLineParser cli = new CmdLineParser(parser);
    try {
      cli.parseArgument(args);
      if (parser.quiet && parser.verbose) {
        parser.verbose = true;
        parser.quiet = false;
        System.out.println("In a conflict between the quiet and verbose, verbose will always be louder.");
      }
    } catch (final CmdLineException e) {
      printUsage(System.err, cli);
      return;
    }
    if (parser.cmd == null) {
      printUsage(System.err, cli);
    } else {
      try {
        final Configuration config = Configuration.getConfiguration("secure.properties");
        parser.cmd.execute(config);
      } catch (final IOException e) {
        e.printStackTrace();
      } catch (final DataConfigurationException e) {
        e.printStackTrace();
      } catch (final IllegalArgumentException e) {
        printUsage(System.err, cli);
      }
    }
  }

  private static void printUsage(final PrintStream out, final CmdLineParser cli) {
    try {
      out.println("\nUsage: canvas <global options> <command> <sub-command> <options>\n");
      cli.printUsage(out);
      out.println("\n*****************************************************************************");
      final SubCommands commands = CanvasDataCli.class.getField("cmd").getAnnotation(SubCommands.class);
      for (final SubCommand command : commands.value()) {
        out.println("\n" + command.name() + " commands: ");
        final Command c = (Command) command.impl().newInstance();
        new CmdLineParser(c).printUsage(out);
        final SubCommands subCommands = c.getClass().getField("cmd").getAnnotation(SubCommands.class);
        for (final SubCommand subCommand : subCommands.value()) {
          final Command sc = (Command) subCommand.impl().newInstance();
          out.println("\n" + command.name() + " " + subCommand.name() + ": " + sc.getDescription());
          new CmdLineParser(sc).printUsage(out);
        }
        out.println("\n*****************************************************************************");
      }
      out.println();
    } catch (NoSuchFieldException | SecurityException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

}