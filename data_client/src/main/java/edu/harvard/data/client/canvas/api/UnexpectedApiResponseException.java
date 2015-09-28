package edu.harvard.data.client.canvas.api;

public class UnexpectedApiResponseException extends Exception {

  private static final long serialVersionUID = 1L;
  private final int status;
  private final String url;

  public UnexpectedApiResponseException(final int status, final String url) {
    this.status = status;
    this.url = url;
  }

  public int getStatus() {
    return status;
  }

  public String getUrl() {
    return url;
  }

}
