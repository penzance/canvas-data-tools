package edu.harvard.canvas_data.verifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class VerificationUtils {

  public static TextComparison<File, File> compareText(final File t1, final File t2)
      throws IOException {
    final TextComparison<File, File> differences =  new TextComparison<File, File>(t1, t2);
    try (BufferedReader r1 = getReaderForFile(t1);
         BufferedReader r2 = getReaderForFile(t2);
        ) {
      String line1 = r1.readLine();
      String line2 = r2.readLine();
      int line = 0;
      while ((line1 != null) && (line2 != null)) {
        if (!line1.equals(line2)) {
          differences.addDifferentLine(line, line1, line2);
        }
        line++;
        line1 = r1.readLine();
        line2 = r2.readLine();
      }
      int size1;
      int size2;
      if ((line1 == null) && (line2 == null)) {
        size1 = size2 = line;
      } else if (line1 == null) {
        size1 = line;
        size2 = line + getRemainingLineCount(r2);
      } else {
        size1 = line + getRemainingLineCount(r1);
        size2 = line;
      }
      differences.setSizes(size1, size2);
    }
    return differences;
  }

  public static TextComparison<List<String>, List<String>> compareText(final List<String> t1,
      final List<String> t2) throws IOException {
    final TextComparison<List<String>, List<String>> differences =
        new TextComparison<List<String>, List<String>>(t1, t2);
    final int size1 = t1.size();
    final int size2 = t2.size();

    differences.setSizes(size1, size2);
    final int smallerSize = size1 > size2 ? size2 : size1;
    for (int line = 0; line < smallerSize; line++) {
      final String str1 = t1.get(line);
      final String str2 = t2.get(line);
      if (!str1.equals(str2)) {
        differences.addDifferentLine(line, str1, str2);
      }
    }
    return differences;
  }

  public static final TextComparison<List<String>, File> compareText(final List<String> t1,
      final File t2) throws IOException {
    final TextComparison<List<String>, File> differences =  new TextComparison<List<String>, File>(t1, t2);
    try (BufferedReader r2 = getReaderForFile(t2);) {
      for (int line = 0; line < t1.size(); line++) {
        final String line1 = t1.get(line);
        final String line2 = r2.readLine();
        if (line2 == null) {
          final int size1 = t1.size();
          final int size2 = line;
          differences.setSizes(size1, size2);
          return differences;
        }
        if (!line1.equals(line2)) {
          differences.addDifferentLine(line, line1, line2);
        }
      }
      final int size1 = t1.size();
      final int size2 = t1.size() + getRemainingLineCount(r2);
      differences.setSizes(size1, size2);
    }
    return differences;
  }

  private static int getRemainingLineCount(final BufferedReader r) throws IOException {
    int remaining = 0;
    while (r.readLine() != null) {
      remaining++;
    }
    return remaining;
  }

  private static BufferedReader getReaderForFile(final File file) throws FileNotFoundException, IOException {
    final String extension = file.getName().substring(file.getName().lastIndexOf(".")).toLowerCase();
    InputStream in = null;
    switch (extension) {
    case ".gz":
      in = new GZIPInputStream(new FileInputStream(file));
      break;
    default:
      in = new FileInputStream(file);
    }
    return new BufferedReader(new InputStreamReader(in));
  }

}
