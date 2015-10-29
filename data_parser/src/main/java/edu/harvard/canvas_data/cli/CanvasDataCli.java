package edu.harvard.canvas_data.cli;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import edu.harvard.canvas_data.cli.analysis.AnalysisCommandGroup;
import edu.harvard.canvas_data.cli.dataset.DataSetCommandGroup;
import edu.harvard.canvas_data.cli.dump.DumpCommandGroup;
import edu.harvard.canvas_data.cli.schema.SchemaCommandGroup;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class CanvasDataCli {

  private static final Logger log = Logger.getLogger("Canvas Data");

  @Option(name = "-q", usage = "Quiet mode. No logging information will be printed.")
  private boolean quiet = false;

  @Option(name = "-v", usage = "Verbose mode. Extra logging information will be written to standard output.")
  private boolean verbose = false;

  @Option(name = "-d", usage = "Debug mode. Fine-grained debug information will be written to standard output.")
  private boolean debug = false;

  @Option(name = "-out", usage = "Output file. By default, output is printed to standard out.")
  private File outputFile;

  @Argument(handler = SubCommandHandler.class, usage = "Top-level command.")
  @SubCommands({ @SubCommand(name = "dump", impl = DumpCommandGroup.class),
    @SubCommand(name = "schema", impl = SchemaCommandGroup.class),
    @SubCommand(name = "data", impl = DataSetCommandGroup.class),
    @SubCommand(name = "analysis", impl = AnalysisCommandGroup.class),
  })
  public Command cmd;

  public static void main(final String[] args) {
    final CanvasDataCli parser = new CanvasDataCli();
    final CmdLineParser cli = new CmdLineParser(parser);
    try {
      cli.parseArgument(args);
      parser.setVerbosityLevel();
    } catch (final CmdLineException e) {
      printUsage(System.err, cli);
      System.exit(ReturnStatus.ARGUMENT_ERROR.ordinal());
    }
    if (parser.cmd == null) {
      printUsage(System.err, cli);
    } else {
      try (PrintStream out = parser.outputFile == null ? System.out
          : new PrintStream(new FileOutputStream(parser.outputFile.toString()))) {
        final Configuration config = Configuration.getConfiguration("secure.properties");
        final ReturnStatus status = parser.cmd.execute(config, out);
        System.exit(status.ordinal());
      } catch (final IOException e) {
        log.severe("IO error: " + e.getMessage() + ". Run with -v flag for more details");
        log.log(Level.INFO, "IO error: " + e.getMessage(), e);
        System.exit(ReturnStatus.IO_ERROR.ordinal());
      } catch (final DataConfigurationException e) {
        log.severe("Data application is not configured properly: " + e.getMessage()
        + ". Run with -v flag for more details");
        log.log(Level.INFO, "Configuration error: " + e.getMessage(), e);
        System.exit(ReturnStatus.CONFIG_ERROR.ordinal());
      } catch (final IllegalArgumentException e) {
        printUsage(System.err, cli);
        log.severe(e.getMessage());
        System.exit(ReturnStatus.ARGUMENT_ERROR.ordinal());
      } catch (final UnexpectedApiResponseException e) {
        log.severe("Unexpected response from the Canvas Data API: " + e.getMessage());
        log.log(Level.INFO, "API error: " + e.getMessage(), e);
      } catch (final Throwable t) {
        log.severe("Unexpected error: " + t.getMessage() + ". Run with -v flag for more details");
        log.log(Level.INFO, "Unexpected error: " + t.getMessage(), t);
        System.exit(ReturnStatus.UNKNOWN_ERROR.ordinal());
      }
    }
  }

  private void setVerbosityLevel() {
    System.setProperty("java.util.logging.SimpleFormatter.format",
        "[%1$tc] %4$s (%3$s): %5$s %6$s%n");
    Level level = Level.SEVERE;
    log.setLevel(Level.SEVERE);
    if (quiet) {
      level = Level.OFF;
    }
    if (verbose) {
      level = Level.INFO;
    }
    if (debug) {
      level = Level.ALL;
    }
    Logger.getLogger("").setLevel(level);
    log.setLevel(level);
    for (final Handler handler : Logger.getLogger("").getHandlers()) {
      handler.setLevel(level);
    }
  }

  private static void printUsage(final PrintStream out, final CmdLineParser cli) {
    try {
      out.println("\nUsage: canvas <global options> <command> <sub-command> <options>\n");
      cli.printUsage(out);
      out.println(
          "\n*****************************************************************************");
      final SubCommands commands = CanvasDataCli.class.getField("cmd")
          .getAnnotation(SubCommands.class);
      for (final SubCommand command : commands.value()) {
        out.println("\n" + command.name() + " commands: ");
        final Command c = (Command) command.impl().newInstance();
        new CmdLineParser(c).printUsage(out);
        final SubCommands subCommands = c.getClass().getField("cmd")
            .getAnnotation(SubCommands.class);
        for (final SubCommand subCommand : subCommands.value()) {
          final Command sc = (Command) subCommand.impl().newInstance();
          out.println("\n" + command.name() + " " + subCommand.name() + ": " + sc.getDescription());
          new CmdLineParser(sc).printUsage(out);
        }
        out.println(
            "\n*****************************************************************************");
      }
      out.println();
    } catch (NoSuchFieldException | SecurityException | InstantiationException
        | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void setQuiet(final boolean quiet) {
    this.quiet = quiet;
  }

  public void setVerbose(final boolean verbose) {
    this.verbose = verbose;
  }

  public void setDebug(final boolean debug) {
    this.debug = debug;
  }

}