package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class CopyDataSetCommand implements Command {

  @Option(name = "-d", usage = "Input Data Set (either a directory or dataset label). This argument is required", metaVar = "/path/to/directory", required = true)
  private File input;

  @Option(name = "-o", usage = "Output Data Set. Must be a directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final TableFactory factory = new CanvasTableFactory();
    final FormatLibrary formats = new FormatLibrary();
    if (!input.exists() || !input.isDirectory()
        || !Files.exists(DataSetInfo.getFileName(input.toPath()))) {
      System.err.println("Input directory " + input + " is not a well-formed data set");
      return;
    }
    final DataSetInfo inputInfo = DataSetInfo.read(DataSetInfo.getFileName(input.toPath()));
    final TableFormat inputFormat = formats.getFormat(inputInfo.getFormat());
    if (output.exists()) {
      System.err.println("Output directory " + output + " already exists");
      return;
    }

    try (final DataSetReader in = new FileDataSetReader(input.toPath(), inputFormat, factory);
        final DataSetWriter out = new FileDataSetWriter(output.toPath(),
            formats.getFormat(Format.DecompressedCanvasDataFlatFiles), factory)) {
      out.pipe(in);
    }

  }

  @Override
  public String getDescription() {
    return "Copy a dataset, changing the formatting if required.";
  }

}
