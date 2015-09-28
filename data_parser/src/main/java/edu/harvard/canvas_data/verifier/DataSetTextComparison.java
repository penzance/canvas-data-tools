package edu.harvard.canvas_data.verifier;

import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class DataSetTextComparison {

  private final List<Path> dump1;
  private final List<Path> dump2;
  private final PrintStream out;
  private boolean identical;

  public DataSetTextComparison(final List<Path> dump1, final List<Path> dump2, final PrintStream out) {
    this.dump1 = dump1;
    this.dump2 = dump2;
    this.out = out;
    this.identical = true;
  }

  public void setTables(final Set<String> tables1, final Set<String> tables2) {
    if (!tables1.equals(tables2)) {
      identical = false;
    }
    for (final String table : tables1) {
      if (!tables2.contains(table)) {
        out.println("Table " + table + " exists in " + dump1 + " but missing in " + dump2);
      }
    }
    for (final String table : tables2) {
      if (!tables1.contains(table)) {
        out.println("Table " + table + " exists in " + dump2 + " but missing in " + dump1);
      }
    }
  }

  public void addDump1UniqueLine(final String table, final String line) {
    identical = false;
    out.println(dump1 + ":" + table + "->" + line);
  }

  public void addDump2UniqueLine(final String table, final String line) {
    identical = false;
    out.println(dump2 + ":" + table + "->" + line);
  }

  public boolean identical() {
    return identical;
  }

}
