package edu.harvard.canvas_data.parser;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.harvard.canvas_data.client.api.CanvasDataDump;

public class DumpInformation {

  private final CanvasDataDump dump;
  private final Date downloadStart;
  private final Date downloadComplete;
  private final Date verificationStart;
  private final Date verificationComplete;

  @JsonCreator
  public DumpInformation(
      @JsonProperty("dump") final CanvasDataDump dump,
      @JsonProperty("downloadStart") final Date downloadStart,
      @JsonProperty("downloadComplete") final Date downloadComplete,
      @JsonProperty("vericationStart") final Date verificationStart,
      @JsonProperty("vericationComplete") final Date verificationComplete) {
    this.dump = dump;
    this.downloadStart = downloadStart;
    this.downloadComplete = downloadComplete;
    this.verificationStart = verificationStart;
    this.verificationComplete = verificationComplete;
  }

  public CanvasDataDump getDump() {
    return dump;
  }

  public Date getDownloadStart() {
    return downloadStart;
  }

  public Date getDownloadComplete() {
    return downloadComplete;
  }

  public Date getVerificationStart() {
    return verificationStart;
  }

  public Date getVerificationComplete() {
    return verificationComplete;
  }

}
