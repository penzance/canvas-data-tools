package edu.harvard.canvas_data.cli.dataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.kohsuke.args4j.Argument;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;

public class DataSetInfoCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Override
  public void execute(final Configuration config) throws IOException {
    final DataSetInfo info;
    if (input.equals("LATEST")) {
      final DataSetUtils utils = new DataSetUtils(config);
      info = utils.getLatestDataSetInfo(config);
    } else {
      final Path infoFile = DataSetInfo.getFileName(Paths.get(input));
      if (!Files.exists(infoFile)) {
        throw new RuntimeException(input + " is not a well-formed data set");
      }
      info = DataSetInfo.read(infoFile);
    }
    System.out.println(info);
  }

  @Override
  public String getDescription() {
    return "Summarize the tables in a data set.";
  }

}
