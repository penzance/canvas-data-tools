package edu.harvard.canvas_data.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.harvard.canvas_data.client.DataSet;
import edu.harvard.canvas_data.client.api.ApiClient;
import edu.harvard.canvas_data.client.api.CanvasDataArtifact;
import edu.harvard.canvas_data.client.api.CanvasDataDump;
import edu.harvard.canvas_data.client.api.CanvasDataFile;
import edu.harvard.canvas_data.client.api.UnexpectedApiResponseException;
import edu.harvard.canvas_data.client.tables.CanvasDataTable;
import edu.harvard.canvas_data.client.tables.ParsedWithErrorsException;
import edu.harvard.canvas_data.client.tables.TableClient;
import edu.harvard.canvas_data.verifier.TextComparison;
import edu.harvard.canvas_data.verifier.VerificationUtils;

public class DumpManager {

  private final CanvasDataDump dump;
  private final ObjectMapper mapper;
  private final File dumpDir;

  private Date downloadStart;
  private Date downloadComplete;
  private Date verificationStart;
  private Date verificationComplete;
  private final File archiveDir;

  public DumpManager(final CanvasDataDump dump, final Configuration config) {
    this.dump = dump;
    this.mapper = new ObjectMapper();
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    final String dirName = String.format("%05d", dump.getSequence());
    this.dumpDir = new File(config.getCanvasDataScratchDirectory() + File.separator + dirName);
    this.archiveDir = new File(config.getCanvasDataArchiveDirectory() + File.separator + dirName);
  }

  public boolean needToSaveDump() throws IOException {
    if (!archiveDir.exists()) {
      return true;
    }
    final DumpInformation info = getArchiveDumpInformation();
    if (info.getVerificationComplete() == null) {
      return true;
    }
    final Date downloadStart = info.getDownloadStart();
    // Re-download any dump that was updated less than an hour before it was
    // downloaded before.
    final Date conservativeStart = new Date(downloadStart.getTime() - (60 * 60 * 1000));
    return conservativeStart.before(dump.getUpdatedAt());
  }

  public void saveDumpToTempDirectory(final ApiClient api)
      throws IOException, UnexpectedApiResponseException {
    downloadStart = new Date();
    dumpDir.mkdirs();
    writeDumpInformation();
    final Map<String, CanvasDataArtifact> artifactsByTable = dump.getArtifactsByTable();
    for (final String table : artifactsByTable.keySet()) {
      final File tableDir = new File(dumpDir, table);
      System.out.println("Dumping " + table + " to " + tableDir);
      final CanvasDataArtifact artifact = artifactsByTable.get(table);
      artifact.downloadAllFiles(tableDir);
    }
    downloadComplete = new Date();
    writeDumpInformation();
  }

  public void verifyDump(final TableClient tables) throws IOException, VerificationException {
    verificationStart = new Date();
    writeDumpInformation();
    final Map<String, CanvasDataArtifact> artifactsByTable = dump.getArtifactsByTable();
    for (final String table : artifactsByTable.keySet()) {
      final File tableDir = new File(dumpDir, table);
      final CanvasDataArtifact artifact = artifactsByTable.get(table);
      for (final CanvasDataFile file : artifact.getFiles()) {
        final File f = new File(tableDir, file.getFilename());
        try {
          System.out.println("Verifying " + f);
          final File tmpFile = Files.createTempFile(file.getFilename(), ".tsv").toFile();
          final DataSet<? extends CanvasDataTable> dataSet = tables.parseCanvasDataFile(table, f);
          dataSet.writeCanvasDataFormat(tmpFile, false);
          final TextComparison<File, File> comparison = VerificationUtils.compareText(f, tmpFile);
          if (!comparison.identical()) {
            throw new VerificationException(artifact, file, comparison);
          }
        } catch (final ParsedWithErrorsException e) {
          throw new VerificationException(artifact, file, e);
        }
      }
    }
    verificationComplete = new Date();
    writeDumpInformation();
  }

  public void archiveDump(final TableClient tables) {
    archiveDir.getParentFile().mkdirs();
    dumpDir.renameTo(archiveDir);
  }

  public File getDumpDirectory() {
    return dumpDir;
  }

  private File getTempDumpInfoFile() {
    return new File(dumpDir, "dump_info.json");
  }

  private File getArchiveDumpInfoFile() {
    return new File(archiveDir, "dump_info.json");
  }

  public DumpInformation getDumpInformation() throws IOException {
    final File infoFile = getTempDumpInfoFile();
    return mapper.readValue(infoFile, DumpInformation.class);
  }

  public DumpInformation getArchiveDumpInformation() throws IOException {
    final File infoFile = getArchiveDumpInfoFile();
    return mapper.readValue(infoFile, DumpInformation.class);
  }

  private void writeDumpInformation() throws IOException {
    final DumpInformation dumpInfo = new DumpInformation(dump, downloadStart, downloadComplete,
        verificationStart, verificationComplete);
    final File infoFile = getTempDumpInfoFile();
    mapper.writeValue(infoFile, dumpInfo);
  }

}
