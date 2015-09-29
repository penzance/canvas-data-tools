package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.VirtualDataSets;
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

  @Option(name = "-d", usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Option(name = "-o", usage = "Output Data Set. Must be a directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-f", usage = "Format for the new data set", metaVar = "format")
  private String format;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final TableFactory factory = new CanvasTableFactory();
    final FormatLibrary formats = new FormatLibrary();
    final DataSetReader in;
    final TableFormat inputFormat;
    if (input.equals("LATEST")) {
      in = VirtualDataSets.getLatestDataSet(config.getCanvasDataArchiveDirectory());
      inputFormat = formats.getFormat(Format.CompressedCanvasDataFlatFiles);
    } else {
      final Path inputPath = Paths.get(input);
      if (!Files.exists(inputPath) || !Files.isDirectory(inputPath)
          || !Files.exists(DataSetInfo.getFileName(inputPath))) {
        System.err.println("Input directory " + input + " is not a well-formed data set");
        return;
      }
      final DataSetInfo inputInfo = DataSetInfo.read(DataSetInfo.getFileName(inputPath));
      inputFormat = formats.getFormat(inputInfo.getFormat());
      in = new FileDataSetReader(inputPath, inputFormat, factory);
    }

    Format outputFormat;
    if (format != null) {
      try {
        outputFormat = Format.fromLabel(format);
      } catch(final IllegalArgumentException e) {
        System.err.println("Format " + format + " not found. Possible formats are:");
        for (final Format f : Format.values()) {
          System.out.println("  " + f.getLabel());
        }
        return;
      }
    } else {
      outputFormat = inputFormat.getFormat();
    }

    try {
      if (!output.exists()) {
        try (final DataSetWriter out = new FileDataSetWriter(output.toPath(),
            formats.getFormat(outputFormat), factory)) {
          out.pipe(in);
        }
      } else {
        System.err.println("Output directory " + output + " already exists");
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
