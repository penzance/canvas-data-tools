package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.verifier.CanvasDumpVerifier;
import edu.harvard.canvas_data.verifier.VerificationException;
import edu.harvard.data.client.DataConfigurationException;

public class VerifyDataSetCommand implements Command {

  @Option(name = "-d", usage = "Data Set. This may be a directory or dataset label. This argument is required", metaVar = "/path/to/directory", required = true)
  private File directory;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final CanvasDumpVerifier verifier = new CanvasDumpVerifier();
    final Path scratchDir = config.getCanvasDataScratchDirectory().resolve("" + UUID.randomUUID().toString());
    try {
      try {
        verifier.parseAndOutput(directory.toPath(), scratchDir);
      } catch (final VerificationException e) {
        System.err.println("Verification failures");
        return;
      }
    } finally {
      FileUtils.deleteDirectory(scratchDir.toFile());
    }
  }

  @Override
  public String getDescription() {
    return "Run verification over the tables in a dataset.";
  }

}
