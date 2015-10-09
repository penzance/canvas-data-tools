package edu.harvard.canvas_data.cli.dataset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.verifier.CanvasDumpVerifier;
import edu.harvard.canvas_data.verifier.VerificationException;
import edu.harvard.data.client.DataConfigurationException;

public class VerifyDataSetCommand implements Command {
  private static final Logger log = Logger.getLogger("Canvas Data");

  @Argument(index = 0, usage = "Data set directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File directory;

  @Option(name = "-o", usage = "Output file for verification errors. Defaults to current_directory/verification.log", metaVar = "/path/to/directory")
  private File verificationFile;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out) throws DataConfigurationException, IOException {
    final CanvasDumpVerifier verifier = new CanvasDumpVerifier();
    final Path scratchDir = config.getCanvasDataScratchDirectory().resolve("" + UUID.randomUUID().toString());
    try {
      try (BufferedWriter errors = Files.newBufferedWriter(verificationFile.toPath())) {
        verifier.parseAndOutput(directory.toPath(), scratchDir, errors);
      } catch (final VerificationException e) {
        log.severe("Verification failed " + e.getMessage());
        return ReturnStatus.VERIFICATION_FAILURE;
      }
    } finally {
      FileUtils.deleteDirectory(scratchDir.toFile());
    }
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Run verification over the tables in a dataset.";
  }

}
