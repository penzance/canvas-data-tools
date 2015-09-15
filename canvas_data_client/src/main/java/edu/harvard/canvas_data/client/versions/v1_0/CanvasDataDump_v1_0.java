package edu.harvard.canvas_data.client.versions.v1_0;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.CanvasDataArtifact;
import edu.harvard.canvas_data.client.CanvasDataDump;
import edu.harvard.canvas_data.client.RestUtils;

public class CanvasDataDump_v1_0 implements CanvasDataDump {
  private final String dumpId;
  private final long sequence;
  private final String accountId;
  private final int numFiles;
  private final boolean finished;
  private final Date expires;
  private final Date createdAt;
  private final Date updatedAt;
  private final Map<String, CanvasDataArtifact_v1_0> artifactsByTable;

  @JsonCreator
  public CanvasDataDump_v1_0(@JsonProperty("dumpId") final String dumpId,
      @JsonProperty("sequence") final long sequence,
      @JsonProperty("accountId") final String accountId,
      @JsonProperty("numFiles") final int numFiles,
      @JsonProperty("finished") final boolean finished,
      @JsonProperty("expires") final Date expires,
      @JsonProperty("createdAt") final Date createdAt,
      @JsonProperty("updatedAt") final Date updatedAt,
      @JsonProperty("artifactsByTable") final Map<String, CanvasDataArtifact_v1_0> artifactsByTable) {
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

  @Override
  public String getDumpId() {
    return dumpId;
  }

  @Override
  public long getSequence() {
    return sequence;
  }

  @Override
  public String getAccountId() {
    return accountId;
  }

  @Override
  public int getNumFiles() {
    return numFiles;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }

  @Override
  public Date getExpires() {
    return expires;
  }

  @Override
  public Date getCreatedAt() {
    return createdAt;
  }

  @Override
  public Date getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public Map<String, CanvasDataArtifact> getArtifactsByTable() {
    return Collections.unmodifiableMap(artifactsByTable);
  }

  void setRestUtils(final RestUtils rest) {
    if (artifactsByTable != null) {
      for (final CanvasDataArtifact artifact : artifactsByTable.values()) {
        ((CanvasDataArtifact_v1_0) artifact).setRestUtils(rest);
      }
    }
  }

}
