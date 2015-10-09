package edu.harvard.canvas_data.parser;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetInfoFile;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataArtifact;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.CanvasDataFile;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DumpManager {

  private static final Logger log = Logger.getLogger("Canvas Data");

  private final Configuration config;

  public DumpManager(final Configuration config) {
    this.config = config;
  }

  public boolean needToSaveDump(final CanvasDataDump dump) throws IOException {
    final String dirName = String.format("%05d", dump.getSequence());
    final Path archiveDir = config.getCanvasDataArchiveDirectory().resolve(dirName);
    if (!Files.exists(archiveDir)) {
      log.info("Dump needs to be saved; directory " + archiveDir + " does not exist.");
      return true;
    }
    final Path dumpInfoFile = DumpInformation.getFile(getArchiveDumpDir(dump));
    if (!Files.exists(dumpInfoFile)) {
      log.info("Dump needs to be saved; dump info file " + dumpInfoFile + " does not exist.");
      return true;
    }
    final DumpInformation info = DumpInformation.read(dumpInfoFile);
    if (info.getDownloadComplete() == null) {
      log.info("Dump needs to be saved; previous download to " + archiveDir + " did not complete.");
      return true;
    }
    final Date downloadStart = info.getDownloadStart();
    // Re-download any dump that was updated less than an hour before it was
    // downloaded before.
    final Date conservativeStart = new Date(downloadStart.getTime() - (60 * 60 * 1000));
    if (conservativeStart.before(dump.getUpdatedAt())) {
      log.info("Dump needs to be saved; downloaded to " + archiveDir + " less than an hour after it was last updated.");
      return true;
    }
    log.info("Dump does not need to be saved; already exists at " + archiveDir + ".");
    return false;
  }

  public boolean isValidDumpDirectory(final Path path) {
    if (!Files.exists(path) || !Files.isDirectory(path)) {
      log.info(path + " is not a valid dump. Directory does not exist");
      return false;
    }
    final Path dumpInfoFile = DumpInformation.getFile(path);
    if (!Files.exists(dumpInfoFile)) {
      log.info(path + " is not a valid dump. No dump info file at " + dumpInfoFile);
      return false;
    }
    return true;
  }


  public void saveDumpToTempDirectory(final CanvasApiClient api, final CanvasDataDump dump)
      throws IOException, UnexpectedApiResponseException, DataConfigurationException {
    final Path dumpDir = getScratchDumpDir(dump);
    log.info("Saving dump " + dump.getDumpId() + " to " + dumpDir);
    saveDump(api, dumpDir, dump);
  }

  public void saveDump(final CanvasApiClient api, final Path directory, final CanvasDataDump dump)
      throws IOException, UnexpectedApiResponseException, DataConfigurationException {
    final Date downloadStart = new Date();
    final DataSetInfo dataSetInfo = new DataSetInfo(DataSetInfo.getFileName(directory));
    dataSetInfo.setFormat(FormatLibrary.Format.CanvasDataFlatFiles);
    Files.createDirectories(directory);
    final Map<String, CanvasDataArtifact> artifactsByTable = dump.getArtifactsByTable();
    final List<String> tables = new ArrayList<String>(artifactsByTable.keySet());
    for (final String table : tables) {
      int fileIndex = 0;
      final Path tableDir = directory.resolve(table);
      final CanvasDataArtifact artifact = artifactsByTable.get(table);
      log.info("Dumping " + table + " to " + tableDir);
      final DataSetInfoTable tableInfo = new DataSetInfoTable(table);
      dataSetInfo.addTable(artifact.getTableName(), tableInfo);
      final List<CanvasDataFile> files = artifact.getFiles();
      for (int i=0; i<files.size(); i++) {
        final CanvasDataFile file = files.get(i);
        final CanvasDataDump refreshedDump = api.getDump(dump.getDumpId());
        final CanvasDataArtifact refreshedArtifact = refreshedDump.getArtifactsByTable().get(table);
        final CanvasDataFile refreshedFile = refreshedArtifact.getFiles().get(i);
        if (!refreshedFile.getFilename().equals(file.getFilename())) {
          log.warning("Mismatch in file name for refreshed dump. Expected" + refreshedFile.getFilename() + ", got " + file.getFilename());
        }
        final String filename = artifact.getTableName() + "-" + String.format("%05d", fileIndex++) + ".gz";
        final DataSetInfoFile fileInfo = refreshedFile.download(tableDir.resolve(filename));
        tableInfo.addFileInfo(fileInfo);
      }
    }
    final Path dumpInfoFile = DumpInformation.getFile(getScratchDumpDir(dump));
    final Date downloadEnd = new Date();
    new DumpInformation(dump, downloadStart, downloadEnd).write(dumpInfoFile);
    dataSetInfo.write();
  }

  public void archiveDump(final Path fromDir, final Path toDir) throws IOException {
    log.info("Archiving " + fromDir + " to " + toDir);
    Files.createDirectories(toDir.getParent());
    if (Files.exists(toDir)) {
      log.info(toDir + " exists. Deleting it");
      FileUtils.deleteDirectory(toDir.toFile());
    }
    final Set<PosixFilePermission> readOnly = new HashSet<PosixFilePermission>();
    readOnly.add(PosixFilePermission.OWNER_READ);
    readOnly.add(PosixFilePermission.GROUP_READ);
    readOnly.add(PosixFilePermission.OTHERS_READ);
    try (DirectoryStream<Path> listing = Files.newDirectoryStream(fromDir)) {
      for (final Path table : listing) {
        if (Files.isDirectory(table)) {
          try (DirectoryStream<Path> tableListing = Files.newDirectoryStream(table)) {
            for (final Path dumpFile : Files.newDirectoryStream(table)) {
              Files.setPosixFilePermissions(dumpFile, readOnly);
            }
          }
        }
      }
    }
    Files.move(fromDir, toDir);
  }

  public Path getScratchDumpDir(final CanvasDataDump dump) {
    final String dirName = String.format("%05d", dump.getSequence());
    return config.getCanvasDataScratchDirectory().resolve(dirName);
  }

  public Path getArchiveDumpDir(final CanvasDataDump dump) {
    final String dirName = String.format("%05d", dump.getSequence());
    return config.getCanvasDataArchiveDirectory().resolve(dirName);
  }

}
