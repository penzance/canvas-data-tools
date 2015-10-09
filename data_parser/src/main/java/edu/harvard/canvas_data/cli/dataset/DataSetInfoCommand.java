package edu.harvard.canvas_data.cli.dataset;

import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;

public class DataSetInfoCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out) throws IOException {
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetInfo info = utils.getDataSetInfo(input);
    if (info == null) {
      return ReturnStatus.BAD_DATA_SET;
    }
    out.println(info);
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Summarize the tables in a data set.";
  }

}
