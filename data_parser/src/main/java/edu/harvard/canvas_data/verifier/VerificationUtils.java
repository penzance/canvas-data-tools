package edu.harvard.canvas_data.verifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class VerificationUtils {

  public static void textualCompareDumps(final List<Path> d1, final List<Path> d2,
      final BufferedWriter errors) throws IOException, VerificationException {
    final Set<String> d1Tables = getTables(d1);
    final Set<String> d2Tables = getTables(d2);
    final Set<String> tables = new HashSet<String>(d1Tables);
    tables.retainAll(d2Tables);

    boolean passed = true;
    for (final String table : tables) {
      passed &= compareTable(table, d1, d2, errors);
      System.out.println("Compared " + table);
    }
    if (!passed) {
      throw new VerificationException(
          "Textual comparison of dumps " + d1 + " and " + d2 + " failed.");
    }
  }

  private static boolean compareTable(final String table, final List<Path> d1, final List<Path> d2,
      final BufferedWriter errors) throws IOException {
    final Map<String, Integer> d1LineMap = new HashMap<String, Integer>();
    for (final Path dir : d1) {
      final Path tableDir = dir.resolve(table);
      if (!(Files.exists(tableDir) && Files.isDirectory(tableDir))) {
        errors.write("Dump directory " + tableDir + " doesn't exist");
        return false;
      }
      buildLineMap(d1LineMap, tableDir);
    }

    boolean passed = true;
    for (final Path dir : d2) {
      final Path tableDir = dir.resolve(table);
      if (!(Files.exists(tableDir) && Files.isDirectory(tableDir))) {
        errors.write("Dump directory " + tableDir + " doesn't exist");
        return false;
      }
      passed &= removeMatchingLines(d1LineMap, tableDir, table, errors);
    }

    for (final String line : d1LineMap.keySet()) {
      for (int i = 0; i < d1LineMap.get(line); i++) {
        passed = false;
        errors.write("< " + table + ":" + line);
      }
    }
    return passed;
  }

  private static boolean removeMatchingLines(final Map<String, Integer> d1LineMap, final Path tableDir,
      final String table, final BufferedWriter errors) throws IOException {
    boolean passed = true;
    try (DirectoryStream<Path> listing = Files.newDirectoryStream(tableDir)) {
      for (final Path file : listing) {
        try (BufferedReader in = getReaderForFile(file)) {
          String line = in.readLine();
          while (line != null) {
            if (!d1LineMap.containsKey(line)) {
              passed = false;
              errors.write("> " + table + ": " + line);
            }
            if (d1LineMap.get(line) == 1) {
              d1LineMap.remove(line);
            } else {
              d1LineMap.put(line, d1LineMap.get(line) - 1);
            }
            line = in.readLine();
          }
        }
      }
    }
    return passed;
  }

  private static void buildLineMap(final Map<String, Integer> d1LineMap, final Path tableDir)
      throws IOException {
    try (DirectoryStream<Path> listing = Files.newDirectoryStream(tableDir)) {
      for (final Path file : listing) {
        try (BufferedReader in = getReaderForFile(file)) {
          String line = in.readLine();
          while (line != null) {
            if (d1LineMap.containsKey(line)) {
              d1LineMap.put(line, d1LineMap.get(line) + 1);
            } else {
              d1LineMap.put(line, 1);
            }
            line = in.readLine();
          }
        }
      }
    }
  }

  private static Set<String> getTables(final List<Path> d1) throws IOException {
    final Set<String> tables = new HashSet<String>();
    for (final Path dir : d1) {
      try (DirectoryStream<Path> listing = Files.newDirectoryStream(dir)) {
        for (final Path table : listing) {
          if (Files.isDirectory(table)) {
            tables.add(table.getFileName().toString());
          }
        }
      }
    }
    return tables;
  }

  private static BufferedReader getReaderForFile(final Path file)
      throws FileNotFoundException, IOException {
    final String filename = file.getFileName().toString().toLowerCase();
    if (filename.endsWith(".gz")) {
      return new BufferedReader(
          new InputStreamReader(new GZIPInputStream(Files.newInputStream(file))));
    }
    return Files.newBufferedReader(file);
  }

}
