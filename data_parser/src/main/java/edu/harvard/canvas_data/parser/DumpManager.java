package edu.harvard.canvas_data.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetInfoFile;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataArtifact;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class DumpManager {

  private final Configuration config;

  public DumpManager(final Configuration config) {
    this.config = config;
  }

  public boolean needToSaveDump(final CanvasDataDump dump) throws IOException {
    final String dirName = String.format("%05d", dump.getSequence());
    final Path archiveDir = config.getCanvasDataArchiveDirectory().resolve(dirName);
    if (!Files.exists(archiveDir)) {
      return true;
    }
    final Path dumpInfoFile = getArchiveDumpDir(dump).resolve("dump_info.json");
    if (!Files.exists(dumpInfoFile)) {
      return true;
    }
    final DumpInformation info = DumpInformation.read(dumpInfoFile);
    if (info.getDownloadComplete() == null) {
      return true;
    }
    final Date downloadStart = info.getDownloadStart();
    // Re-download any dump that was updated less than an hour before it was
    // downloaded before.
    final Date conservativeStart = new Date(downloadStart.getTime() - (60 * 60 * 1000));
    return conservativeStart.before(dump.getUpdatedAt());
  }

  public boolean isValidDumpDirectory(final Path path) {
    if (!Files.exists(path) || !Files.isDirectory(path)) {
      return false;
    }
    final Path dumpInfoFile = path.resolve("dump_info.json");
    if (!Files.exists(dumpInfoFile)) {
      return false;
    }
    return true;
  }


  public void saveDumpToTempDirectory(final CanvasApiClient api, final CanvasDataDump dump)
      throws IOException, UnexpectedApiResponseException {
    saveDump(api, getScratchDumpDir(dump), dump);
  }

  public void saveDump(final CanvasApiClient api, final Path directory, final CanvasDataDump dump)
      throws IOException, UnexpectedApiResponseException {
    final Date downloadStart = new Date();
    final DataSetInfo dataSetInfo = new DataSetInfo(DataSetInfo.getFileName(directory));
    dataSetInfo.setFormat(FormatLibrary.Format.CanvasDataFlatFiles);
    Files.createDirectories(directory);
    final Map<String, CanvasDataArtifact> artifactsByTable = dump.getArtifactsByTable();
    for (final String table : artifactsByTable.keySet()) {
      final Path tableDir = directory.resolve(table);
      System.out.println("Dumping " + table + " to " + tableDir);
      final CanvasDataArtifact artifact = artifactsByTable.get(table);
      final DataSetInfoTable tableInfo = new DataSetInfoTable(table);
      dataSetInfo.addTable(artifact.getTableName(), tableInfo);
      final List<DataSetInfoFile> fileInfo = artifact.downloadAllFiles(tableDir);
      tableInfo.addFileInfo(fileInfo);
    }
    final Path dumpInfoFile = getScratchDumpDir(dump).resolve("dump_info.json");
    final Date downloadEnd = new Date();
    new DumpInformation(dump, downloadStart, downloadEnd).write(dumpInfoFile);
    dataSetInfo.write();
  }

  public void archiveDump(final Path fromDir, final Path toDir) throws IOException {
    Files.createDirectories(toDir.getParent());
    final Set<PosixFilePermission> readOnly = new HashSet<PosixFilePermission>();
    readOnly.add(PosixFilePermission.OWNER_READ);
    readOnly.add(PosixFilePermission.GROUP_READ);
    readOnly.add(PosixFilePermission.OTHERS_READ);
    for (final Path table : Files.newDirectoryStream(fromDir)) {
      if (Files.isDirectory(table)) {
        for (final Path dumpFile : Files.newDirectoryStream(table)) {
          Files.setPosixFilePermissions(dumpFile, readOnly);
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
