package edu.harvard.canvas_data.client.api;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasDataDump {
  private final String dumpId;
  private final long sequence;
  private final String accountId;
  private final int numFiles;
  private final boolean finished;
  private final Date expires;
  private final Date createdAt;
  private final Date updatedAt;
  private final Map<String, CanvasDataArtifact> artifactsByTable;

  @JsonCreator
  public CanvasDataDump(@JsonProperty("dumpId") final String dumpId,
      @JsonProperty("sequence") final long sequence,
      @JsonProperty("accountId") final String accountId,
      @JsonProperty("numFiles") final int numFiles,
      @JsonProperty("finished") final boolean finished,
      @JsonProperty("expires") final Date expires,
      @JsonProperty("createdAt") final Date createdAt,
      @JsonProperty("updatedAt") final Date updatedAt,
      @JsonProperty("artifactsByTable") final Map<String, CanvasDataArtifact> artifactsByTable) {
        this.dumpId = dumpId;
        this.sequence = sequence;
        this.accountId = accountId;
        this.numFiles = numFiles;
        this.finished = finished;
        this.expires = expires;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.artifactsByTable = artifactsByTable;
  }

  public String getDumpId() {
    return dumpId;
  }

  public long getSequence() {
    return sequence;
  }

  public String getAccountId() {
    return accountId;
  }

  public int getNumFiles() {
    return numFiles;
  }

  public boolean isFinished() {
    return finished;
  }

  public Date getExpires() {
    return expires;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public Map<String, CanvasDataArtifact> getArtifactsByTable() {
    return Collections.unmodifiableMap(artifactsByTable);
  }

  public void downloadAllFiles(final File directory)
      throws IOException, UnexpectedApiResponseException {
    for (final String table : artifactsByTable.keySet()) {
      final CanvasDataArtifact artifact = artifactsByTable.get(table);
      artifact.downloadAllFiles(new File(directory, table));
    }
  }

  void setRestUtils(final RestUtils rest) {
    if (artifactsByTable != null) {
      for (final CanvasDataArtifact artifact : artifactsByTable.values()) {
        artifact.setRestUtils(rest);
      }
    }
  }

}
