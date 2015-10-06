package edu.harvard.canvas_data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetInfoTable;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.NamedFileTableWriter;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;
import edu.harvard.data.client.canvas.tables.CourseDim;
import edu.harvard.data.client.canvas.tables.Requests;

public class DataPartitioner {

  private final DataSetReader in;
  private final Path outputDir;
  private final TableFormat format;
  private final Map<String, DataSetWriter> writers;
  private final Map<Long, String> courses;
  private final TableFactory factory;
  private final Map<Long, Integer> missingIds;

  private static final Set<String> BOT_USER_AGENTS;
  private static final Set<String> BOT_IP_ADDRESSES;

  static {
    BOT_USER_AGENTS = new HashSet<String>();
    BOT_USER_AGENTS.add("Googlebot");
    BOT_IP_ADDRESSES = new HashSet<String>();
    BOT_IP_ADDRESSES.add("52.1.199.75");
    BOT_IP_ADDRESSES.add("52.7.0.32");
  }

  public DataPartitioner(final DataSetReader in, final Path outputDir) throws IOException {
    this.in = in;
    this.outputDir = outputDir;
    this.factory = new CanvasTableFactory();
    this.format = in.getFormat();
    this.writers = new HashMap<String, DataSetWriter>();
    this.courses = new HashMap<Long, String>();
    this.missingIds = new HashMap<Long, Integer>();
    Files.createDirectories(outputDir);
  }

  public void splitRequestsByCourseAndDay(final Boolean nobots) throws IOException {
    populateCourses();
    final DataSetWriter nonMatching = getWriter("non_course");
    final NamedFileTableWriter<Requests> nonMatchingTable = (NamedFileTableWriter<Requests>) nonMatching
        .getTable("requests", Requests.class);

    try {
      long processed = 0;
      for (final Requests r : in.getTable("requests", Requests.class)) {
        if (nobots && madeByBot(r)) {
          continue;
        }
        final Long courseId = r.getCourseId();
        final String day = FormatLibrary.CANVAS_DATE_FORMAT.format(r.getTimestamp());
        final String key = courses.get(courseId);
        if (key == null) {
          nonMatchingTable.add(r, day);
          if (!missingIds.containsKey(courseId)) {
            missingIds.put(courseId, 0);
          }
          missingIds.put(courseId, missingIds.get(courseId) + 1);
        } else {
          final DataSetWriter writer = getWriter(key);
          final NamedFileTableWriter<Requests> namedTable = (NamedFileTableWriter<Requests>) writer
              .getTable("requests", Requests.class);
          namedTable.add(r, day);
        }
        if (++processed % 1000000 == 0) {
          System.out.println("Flushing");
          for (final DataSetWriter writer : writers.values()) {
            writer.flush();
          }
        }
      }
    } finally {
      for (final DataSetWriter writer : writers.values()) {
        writer.close();
      }
    }
  }

  private boolean madeByBot(final Requests r) {
    if (BOT_IP_ADDRESSES.contains(r.getRemoteIp())) {
      return true;
    }
    if (r.getUserAgent() != null) {
      for (final String agent : BOT_USER_AGENTS) {
        if (r.getUserAgent().contains(agent)) {
          return true;
        }
      }
    }
    return false;
  }

  private void populateCourses() {
    for (final CourseDim course : in.getTable("course_dim", CourseDim.class)) {
      courses.put(course.getId(), course.getId() + "-" + course.getName());
    }
  }

  private DataSetWriter getWriter(final String name) throws IOException {
    if (writers.containsKey(name)) {
      return writers.get(name);
    }
    final Path datasetOutputDir = outputDir.resolve(name);
    final Path infoFile = DataSetInfo.getFileName(datasetOutputDir);
    DataSetInfoTable existingFiles = null;
    if (Files.exists(infoFile)) {
      final DataSetInfoTable table = DataSetInfo.read(infoFile).getTable("requests");
      if (table != null) {
        existingFiles = table;
      }
    }
    if (existingFiles == null) {
      existingFiles = new DataSetInfoTable("requests");
    }
    final DataSetWriter out = new FileDataSetWriter(datasetOutputDir, format, factory);
    out.setTableWriter("requests", Requests.class, new NamedFileTableWriter<Requests>(
        Requests.class, format, datasetOutputDir.resolve("requests"), "requests", existingFiles));
    writers.put(name, out);
    return out;
  }

}
