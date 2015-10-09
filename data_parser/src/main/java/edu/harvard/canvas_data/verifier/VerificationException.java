package edu.harvard.canvas_data.verifier;

public class VerificationException extends Exception {

  private static final long serialVersionUID = 1L;

  public VerificationException(final String msg) {
    super(msg);
  }

  public VerificationException(final Throwable e) {
    super(e);
  }

}
