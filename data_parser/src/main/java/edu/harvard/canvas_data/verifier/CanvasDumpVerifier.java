package edu.harvard.canvas_data.verifier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.RecordParsingException;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;

public class CanvasDumpVerifier {

  private final FormatLibrary formats;

  public CanvasDumpVerifier() {
    formats = new FormatLibrary();
  }

  public void parseAndOutput(final Path dumpDirectory, final Path scratchDirectory,
      final BufferedWriter errors) throws IOException, VerificationException {
    final TableFormat inFormat = formats.getFormat(Format.CanvasDataFlatFiles);
    final TableFormat outFormat = formats.getFormat(Format.DecompressedCanvasDataFlatFiles);
    final TableFactory factory = new CanvasTableFactory();
    try (final DataSetReader in = new FileDataSetReader(dumpDirectory, inFormat, factory);
        final DataSetWriter out = new FileDataSetWriter(scratchDirectory, outFormat, factory);) {
      out.pipe(in);
    } catch (final RecordParsingException e) {
      errors.write("Error parsing " + e.getRecord().toString() + ": " + e.getMessage());
      throw new VerificationException(e);
    }

    final List<Path> dump1 = Collections.singletonList(dumpDirectory);
    final List<Path> dump2 = Collections.singletonList(scratchDirectory);

    VerificationUtils.textualCompareDumps(dump1, dump2, errors);
  }
}
