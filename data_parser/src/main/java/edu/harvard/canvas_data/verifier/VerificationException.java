package edu.harvard.canvas_data.verifier;

public class VerificationException extends Exception {

  private static final long serialVersionUID = 1L;
  private DataSetTextComparison comparison;

  public VerificationException(final DataSetTextComparison comparison) {
    super();
    this.comparison = comparison;
  }

  public VerificationException(final Throwable e) {
    super(e);
  }

  public DataSetTextComparison getComparison() {
    return comparison;
  }

}
