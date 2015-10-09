package edu.harvard.canvas_data.cli.dataset;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.kohsuke.args4j.Argument;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;

public class DataSetInfoCommand implements Command {
  private static final Logger log = Logger.getLogger("Canvas Data");

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out) throws IOException {
    final DataSetInfo info;
    if (input.equals("LATEST")) {
      final DataSetUtils utils = new DataSetUtils(config);
      info = utils.getLatestDataSetInfo(config);
    } else {
      final Path infoFile = DataSetInfo.getFileName(Paths.get(input));
      if (!Files.exists(infoFile)) {
        log.severe(input + " is not a well-formed data set");
        return ReturnStatus.BAD_DATA_SET;
      }
      info = DataSetInfo.read(infoFile);
    }
    out.println(info);
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Summarize the tables in a data set.";
  }

}
