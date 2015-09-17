package edu.harvard.canvas_data.verifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextComparison<S, T> {

  private final S src1;
  private final T src2;
  private int size1;
  private int size2;
  private final List<Integer> differentLineNumbers;
  private final List<String[]> differentLines;
  private final Map<Integer, String> differentLines1;
  private final Map<Integer, String> differentLines2;

  public TextComparison(final S src1, final T src2) {
    this.src1 = src1;
    this.src2 = src2;
    this.differentLineNumbers = new ArrayList<Integer>();
    this.differentLines = new ArrayList<String[]>();
    this.differentLines1 = new HashMap<Integer, String>();
    this.differentLines2 = new HashMap<Integer, String>();
  }

  public void setSizes(final int size1, final int size2) {
    this.size1 = size1;
    this.size2 = size2;
  }

  public void addDifferentLine(final int line, final String str1, final String str2) {
    differentLineNumbers.add(line);
    differentLines.add(new String[] { str1, str2 });
    differentLines1.put(line, str1);
    differentLines2.put(line, str2);
  }

  public boolean identical() {
    return (size1 == size2) && (differentLines1.size() == 0);
  }

  public boolean sameSize() {
    return (size1 == size2);
  }

  public int getDifferenceCount() {
    return differentLines1.size();
  }

  public Map<Integer, String> getSource1Differences() {
    return differentLines1;
  }

  public Map<Integer, String> getSource2Differences() {
    return differentLines1;
  }

  public List<String[]> getDifferentLines() {
    return differentLines;
  }

  public S getSrc1() {
    return src1;
  }

  public T getSrc2() {
    return src2;
  }

}
