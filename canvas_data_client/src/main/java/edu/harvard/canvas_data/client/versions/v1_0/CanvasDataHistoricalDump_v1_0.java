package edu.harvard.canvas_data.client.versions.v1_0;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.CanvasDataFile;
import edu.harvard.canvas_data.client.CanvasDataHistoricalDump;

public class CanvasDataHistoricalDump_v1_0 implements CanvasDataHistoricalDump {
  private final String dumpId;
  private final long sequence;
  private final boolean partial;
  private final List<CanvasDataFile_v1_0> files;

  @JsonCreator
  public CanvasDataHistoricalDump_v1_0(@JsonProperty("dumpId") final String dumpId,
      @JsonProperty("sequence") final long sequence,
      @JsonProperty("partial") final boolean partial,
      @JsonProperty("files") final List<CanvasDataFile_v1_0> files) {
    this.dumpId = dumpId;
    this.sequence = sequence;
    this.partial = partial;
    this.files = files;
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
  public boolean isPartial() {
    return partial;
  }

  @Override
  public List<CanvasDataFile> getFiles() {
    return Collections.unmodifiableList(files);
  }

}
