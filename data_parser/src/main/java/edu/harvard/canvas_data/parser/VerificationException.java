package edu.harvard.canvas_data.parser;

import java.io.File;

import edu.harvard.canvas_data.client.api.CanvasDataArtifact;
import edu.harvard.canvas_data.client.api.CanvasDataFile;
import edu.harvard.canvas_data.client.tables.ParsedWithErrorsException;
import edu.harvard.canvas_data.verifier.TextComparison;

public class VerificationException extends Exception {

  private static final long serialVersionUID = 1L;

  private final CanvasDataFile file;
  private final CanvasDataArtifact artifact;

  public VerificationException(final CanvasDataArtifact artifact, final CanvasDataFile file,
      final TextComparison<File, File> comparison) {
    super();
    this.file = file;
    this.artifact = artifact;
  }

  public VerificationException(final CanvasDataArtifact artifact, final CanvasDataFile file,
      final ParsedWithErrorsException e) {
    super(e);
    this.file = file;
    this.artifact = artifact;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public CanvasDataFile getFile() {
    return file;
  }

  public CanvasDataArtifact getArtifact() {
    return artifact;
  }

}
