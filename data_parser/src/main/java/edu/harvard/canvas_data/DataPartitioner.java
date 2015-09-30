package edu.harvard.canvas_data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.TableFactory;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableWriter;
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

  public DataPartitioner(final DataSetReader in, final Path outputDir) {
    this.in = in;
    this.outputDir = outputDir;
    this.factory = new CanvasTableFactory();
    this.format = in.getFormat();
    this.writers = new HashMap<String, DataSetWriter>();
    this.courses = new HashMap<Long, String>();
    this.missingIds = new HashMap<Long, Integer>();
  }

  public void splitRequestsByDay() throws IOException {
    final DataSetWriter nonMatching = getWriter("date_unknown");
    final SplitCriteria splitter = new SplitCriteria() {
      @Override
      public final String getKey(final Requests r) {
        if (r.getTimestamp() == null) {
          throw new NullPointerException("Request " + r.getId() + " has no timestamp");
        }
        return FormatLibrary.CANVAS_DATE_FORMAT.format(r.getTimestamp());
      }
    };
    splitRequests(splitter, nonMatching);
  }

  public void splitRequestsByCourse() throws IOException {
    populateCourses();
    final DataSetWriter nonMatching = getWriter("non_course");
    final SplitCriteria splitter = new SplitCriteria() {
      @Override
      public final String getKey(final Requests r) {
        final Long courseId = r.getCourseId();
        //        if (!isValidCourseId(courseId)) {
        //          return null;
        //        }
        final String courseKey = courses.get(courseId);
        if (courseKey == null) {
          if (!missingIds.containsKey(courseId)) {
            missingIds.put(courseId, 0);
          }
          missingIds.put(courseId, missingIds.get(courseId) + 1);
        }
        return courseKey;
      }
    };
    splitRequests(splitter, nonMatching);
    System.out.println("Missing course IDs:");
    for (final Long missingId : missingIds.keySet()) {
      System.out.println("  " + missingId + ": " + missingIds.get(missingId));
    }
  }

  private void splitRequests(final SplitCriteria splitter, final DataSetWriter nonMatching) throws IOException {
    final TableWriter<Requests> nonMatchingTable = nonMatching.getTable("requests", Requests.class);
    createOutputDirectory();
    try {
      for (final Requests r : in.getTable("requests", Requests.class)) {
        final String key = splitter.getKey(r);
        if (key == null) {
          nonMatchingTable.add(r);
        } else {
          final DataSetWriter writer = getWriter(key);
          writer.getTable("requests", Requests.class).add(r);
        }
      }
    } finally {
      for (final DataSetWriter writer : writers.values()) {
        writer.close();
      }
    }
  }

  private boolean isValidCourseId(final Long courseId) {
    return courseId != null && courseId != 18749999999999999L && courseId != 18750000000000000L;
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
    final DataSetWriter out = new FileDataSetWriter(outputDir.resolve(name), format, factory);
    writers.put(name, out);
    return out;
  }

  private void createOutputDirectory() throws IOException {
    if (Files.exists(outputDir)) {
      throw new RuntimeException("Output directory " + outputDir + " exists");
    }
    Files.createDirectories(outputDir);
  }

}

interface SplitCriteria {
  String getKey(Requests r);
}