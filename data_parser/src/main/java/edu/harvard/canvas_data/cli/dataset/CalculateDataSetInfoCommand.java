package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.Argument;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class CalculateDataSetInfoCommand implements Command {

  @Argument(index = 0, usage = "Input data set directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File input;

  @Argument(index = 1, usage = "Data set format. This argument is required", metaVar = "format", required = true)
  private String format;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final TableFactory factory = new CanvasTableFactory();
    final FormatLibrary formats = new FormatLibrary();
    final TableFormat tableFormat = formats.getFormat(Format.fromLabel(format));
    try (DataSetReader in = new FileDataSetReader(input.toPath(), tableFormat, factory)) {
      in.generateDataSetInfo();
    }
  }

  @Override
  public String getDescription() {
    return "Regenerate the datasetinfo.json file for a dataset directory.";
  }

}
