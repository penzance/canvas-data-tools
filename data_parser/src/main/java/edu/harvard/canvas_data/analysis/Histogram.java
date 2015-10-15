package edu.harvard.canvas_data.analysis;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVPrinter;

import edu.harvard.data.client.TableFormat;

public class Histogram<T extends Comparable<T>> {

  public enum SortOrder { None, Key, Value }

  private final Map<T, Long> map;
  private final String keyName;

  public Histogram(final String keyName) {
    this.keyName = keyName;
    map = new LinkedHashMap<T, Long>();
  }

  public void put(final T value) {
    put(value, 1L);
  }

  public void put(final T value, final Long count) {
    if (!map.containsKey(value)) {
      map.put(value, 0L);
    }
    map.put(value, map.get(value) + count);
  }


  public Collection<T> keySet() {
    return map.keySet();
  }

  public Collection<Long> values() {
    return map.values();
  }

  public List<T> sortedKeys() {
    final List<T> keys = new ArrayList<T>(map.keySet());
    Collections.sort(keys);
    return keys;
  }

  public Long get(final T key) {
    return map.get(key);
  }

  public Object size() {
    return map.size();
  }

  public void write(final Path file, final TableFormat format, final SortOrder sort) throws IOException {
    try (OutputStream out = format.getOutputStream(file);
        final CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(out), format.getCsvFormat())) {
      if (format.includeHeaders()) {
        printer.printRecord(keyName, "Count");
      }
      switch(sort) {
      case None:
        for (final Entry<T, Long> entry : map.entrySet()) {
          printer.printRecord(entry.getKey(), entry.getValue());
        }
        break;
      case Key:
        final List<T> keys = new ArrayList<T>(map.keySet());
        Collections.sort(keys);
        for (final T key : keys) {
          printer.printRecord(key, map.get(key));
        }
        break;
      case Value:
        try (Stream <Entry<T, Long>> st = map.entrySet().stream();
            Stream<Entry<T, Long>> sorted = st.sorted(Comparator.comparing(e -> e.getValue()))){
          final Iterator<Entry<T, Long>> iterator = sorted.iterator();
          while(iterator.hasNext()) {
            final Entry<T, Long> entry = iterator.next();
            printer.printRecord(entry.getKey(), entry.getValue());
          }
        }
      }
    }
  }
}
