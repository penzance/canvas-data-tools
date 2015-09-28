package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;

public class DataSetInfoCommand implements Command {

  @Option(name = "-d", usage = "Data Set. This may be a directory or dataset label. This argument is required", metaVar = "/path/to/directory", required = true)
  private File directory;

  @Override
  public void execute(final Configuration config) throws IOException {
    final Path infoFile = DataSetInfo.getFileName(directory.toPath());
    if (!Files.exists(infoFile)) {
      throw new RuntimeException(directory + " is not a well-formed data set");
    }
    final DataSetInfo info = DataSetInfo.read(infoFile);
    System.out.println(info);
  }

  @Override
  public String getDescription() {
    return "Summarize the tables in a data set.";
  }

}
