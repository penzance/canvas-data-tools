package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataPartitioner;
import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetReader;

public class SplitRequestsCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output Data set directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-f", usage = "Format for the new data set", metaVar = "format")
  private String format;

  @Option(name = "-nobots", usage = "Strip out automated user agents, including TLT tools or the Googlebot")
  private Boolean nobots;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException {
    if (nobots == null) {
      nobots = false;
    }
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetReader in = utils.getReaderFromString(input);
    try {
      final DataPartitioner partitioner = new DataPartitioner(in, output.toPath());
      partitioner.splitRequestsByCourseAndDay(nobots);
    } finally {
      in.close();
    }
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Copy all requests records into new datasets according to some criteria.";
  }

}
