package edu.harvard.canvas_data.cli.analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.analysis.WordCloudGenerator;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetReader;

public class WordCloudCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output file. This argument is required", metaVar = "/path/to/file.png", required = true)
  private File output;

  @Argument(index = 2, usage = "Data table to analyze. This argument is required", metaVar = "discussion_entry_dim", required = true)
  private String table;

  @Argument(index = 3, usage = "Data field in the table to analyze. This argument is required", metaVar = "message", required = true)
  private String field;

  @Option(name = "-w", usage = "Number of words to include", metaVar = "400")
  private Integer wordCount;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws IOException {
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetInfo info = utils.getDataSetInfo(input);
    if (info == null) {
      return ReturnStatus.BAD_DATA_SET;
    }

    if (!output.exists() && output.getParentFile() != null) {
      output.getParentFile().mkdirs();
    }
    if (wordCount == null) {
      wordCount = 400;
    }
    try (DataSetReader in = utils.getReaderFromString(input)) {
      new WordCloudGenerator().generateCloud(in, table, field, output.toPath(), wordCount);
    }
    return ReturnStatus.OK;
  }


  @Override
  public String getDescription() {
    return "Generate request statistics for a data set";
  }

}
