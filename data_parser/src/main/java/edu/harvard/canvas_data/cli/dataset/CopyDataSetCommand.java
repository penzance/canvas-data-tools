package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class CopyDataSetCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output Data set directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-f", usage = "Format for the new data set", metaVar = "format")
  private String format;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final TableFactory factory = new CanvasTableFactory();
    final FormatLibrary formats = new FormatLibrary();
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetReader in = utils.getReaderFromString(input);
    final Format outputFormat = utils.getFormatFromString(format, in.getFormat().getFormat());
    try {
      if (output.exists()) {
        throw new RuntimeException("Output directory " + output + " already exists");
      }
      try (final DataSetWriter out = new FileDataSetWriter(output.toPath(),
          formats.getFormat(outputFormat), factory)) {
        out.pipe(in);
      }
    } finally {
      in.close();
    }
  }

  @Override
  public String getDescription() {
    return "Copy a dataset, changing the formatting if required.";
  }

}
