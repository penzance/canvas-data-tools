package edu.harvard.canvas_data.client;

public class UnexpectedApiResponseException extends Exception {

  private static final long serialVersionUID = 1L;
  private final int status;

  public UnexpectedApiResponseException(final int status) {
    this.status = status;
  }

  public int getStatus() {
    return status;
  }

}
