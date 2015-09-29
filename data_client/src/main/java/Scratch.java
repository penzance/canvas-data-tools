import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataSetWriter;
import edu.harvard.data.client.FileDataSetReader;
import edu.harvard.data.client.FileDataSetWriter;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.TableWriter;
import edu.harvard.data.client.canvas.tables.AssignmentDim;
import edu.harvard.data.client.canvas.tables.AssignmentFact;
import edu.harvard.data.client.canvas.tables.CanvasTable;
import edu.harvard.data.client.canvas.tables.CanvasTableFactory;
import edu.harvard.data.client.canvas.tables.CourseDim;
import edu.harvard.data.client.canvas.tables.CourseSectionDim;
import edu.harvard.data.client.canvas.tables.EnrollmentDim;
import edu.harvard.data.client.canvas.tables.EnrollmentFact;
import edu.harvard.data.client.canvas.tables.Requests;
import edu.harvard.data.client.canvas.tables.UserDim;
import edu.harvard.data.client.canvas.tables.UserExpandedDim;

public class Scratch {

  public static void main(final String[] args) throws Exception {
    final long start = System.currentTimeMillis();
    new Scratch().splitIntoCourses();
    final long end = System.currentTimeMillis();
    System.out.println("Complete in " + ((end - start) / 1000) + " seconds");
  }

  private final Path inDir;
  private final Path outDir;
  private final TableFormat inFormat;
  private final TableFormat outFormat;
  private final CanvasTableFactory factory;
  private final HashMap<Long, DataSetWriter> courseMap;
  private DataSetReader dataSet;
  private DataSetWriter nonCourse;
  private DataSetWriter unknown;

  public Scratch() {
    factory = new CanvasTableFactory();
    final FormatLibrary formats = new FormatLibrary();
    inFormat = formats.getFormat(Format.CompressedCanvasDataFlatFiles);
    outFormat = formats.getFormat(Format.CanvasDataFlatFiles);
    inDir = Paths.get("/tmp/canvas_archive/00034");
    outDir = Paths.get("/tmp/canvas_archive/00034-split");
    courseMap = new HashMap<Long, DataSetWriter>();
  }

  public void splitIntoCourses() throws IOException {
    try (DataSetReader tmpDataSet = new FileDataSetReader(inDir, inFormat, factory);
        DataSetWriter tmpNonCourse = new FileDataSetWriter(outDir.resolve("non_course"), outFormat, factory);
        DataSetWriter tmpUnknown = new FileDataSetWriter(outDir.resolve("unknown"), outFormat, factory);) {
      this.dataSet = tmpDataSet;
      this.nonCourse = tmpNonCourse;
      this.unknown = tmpUnknown;
      splitCourses();
      splitRequests();
      Map<Long, Set<Long>> userToCourses = splitEnrollments();
      splitUsers(userToCourses);
      userToCourses = null;
      splitAssignments();
      splitSections();
    }
    for (final Long courseKey : courseMap.keySet()) {
      final DataSetWriter writer = courseMap.get(courseKey);
      writer.close();
    }
  }

  private void splitCourses() throws IOException {
    final String tableName = CanvasTable.CourseDim.getSourceName();
    final TableReader<CourseDim> courses = dataSet.getTable(tableName, CourseDim.class);
    for (final CourseDim course : courses) {
      final Path courseDir = outDir.resolve(course.getCanvasId().toString());
      final DataSetWriter writer = new FileDataSetWriter(courseDir, outFormat, factory);
      final TableWriter<CourseDim> table = writer.getTable(tableName, CourseDim.class);
      table.add(course);
      courseMap.put(course.getId(), writer);
    }
  }

  private void splitUsers(final Map<Long, Set<Long>> userToCourses) throws IOException {
    final String userName = CanvasTable.UserDim.getSourceName();
    final TableReader<UserDim> users = dataSet.getTable(userName, UserDim.class);
    for (final UserDim user : users) {
      final long id = user.getId();
      if (userToCourses.containsKey(id)) {
        for (final long courseId : userToCourses.get(id)) {
          courseMap.get(courseId).getTable(userName, UserDim.class).add(user);
        }
      } else {
        nonCourse.getTable(userName, UserDim.class).add(user);
      }
    }

    final String userExpandedName = CanvasTable.UserExpandedDim.getSourceName();
    final TableReader<UserExpandedDim> expanded = dataSet.getTable(userExpandedName,
        UserExpandedDim.class);
    if (expanded != null) {
      for (final UserExpandedDim user : expanded) {
        final long id = user.getId();
        if (userToCourses.containsKey(id)) {
          for (final long courseId : userToCourses.get(id)) {
            courseMap.get(courseId).getTable(userExpandedName, UserExpandedDim.class).add(user);
          }
        } else {
          nonCourse.getTable(userExpandedName, UserExpandedDim.class).add(user);
        }
      }
    }
  }

  private Map<Long, Set<Long>> splitEnrollments() throws IOException {
    final String dimName = CanvasTable.EnrollmentDim.getSourceName();
    final String factName = CanvasTable.EnrollmentFact.getSourceName();
    final TableReader<EnrollmentDim> dimTable = dataSet.getTable(dimName, EnrollmentDim.class);
    final TableReader<EnrollmentFact> factTable = dataSet.getTable(factName, EnrollmentFact.class);

    final Map<Long, Long> idToCourse = new HashMap<Long, Long>();
    final Set<Long> unknownEnrollments = new HashSet<Long>();
    final Map<Long, Set<Long>> userToCourses = new HashMap<Long, Set<Long>>();
    for (final EnrollmentFact fact : factTable) {
      final Long courseId = fact.getCourseId();
      if (courseId == null) {
        nonCourse.getTable(factName, EnrollmentFact.class).add(fact);
      } else if (courseMap.containsKey(courseId)) {
        courseMap.get(courseId).getTable(factName, EnrollmentFact.class).add(fact);
        idToCourse.put(fact.getEnrollmentId(), courseId);
        final long userId = fact.getUserId();
        if (!userToCourses.containsKey(userId)) {
          userToCourses.put(userId, new HashSet<Long>());
        }
        userToCourses.get(userId).add(courseId);
      } else {
        unknown.getTable(factName, EnrollmentFact.class).add(fact);
        unknownEnrollments.add(fact.getEnrollmentId());
      }
    }
    for (final EnrollmentDim dim : dimTable) {
      final Long id = dim.getId();
      final Long courseId = idToCourse.get(id);
      if (courseId == null) {
        nonCourse.getTable(dimName, EnrollmentDim.class).add(dim);
      } else {
        if (unknownEnrollments.contains(courseId)) {
          unknown.getTable(dimName, EnrollmentDim.class).add(dim);
        } else {
          courseMap.get(courseId).getTable(dimName, EnrollmentDim.class).add(dim);
        }
      }
    }
    return userToCourses;
  }

  private void splitAssignments() throws IOException {
    final String dimName = CanvasTable.AssignmentDim.getSourceName();
    final String factName = CanvasTable.AssignmentFact.getSourceName();
    final TableReader<AssignmentDim> dimTable = dataSet.getTable(dimName, AssignmentDim.class);
    final TableReader<AssignmentFact> factTable = dataSet.getTable(factName, AssignmentFact.class);

    final Map<Long, Long> idToCourse = new HashMap<Long, Long>();
    final Set<Long> unknownCourseIds = new HashSet<Long>();
    for (final AssignmentFact fact : factTable) {
      final Long courseId = fact.getCourseId();
      if (courseId == null) {
        nonCourse.getTable(factName, AssignmentFact.class).add(fact);
      } else if (courseMap.containsKey(courseId)) {
        courseMap.get(courseId).getTable(factName, AssignmentFact.class).add(fact);
        idToCourse.put(fact.getAssignmentId(), courseId);
      } else {
        unknown.getTable(factName, AssignmentFact.class).add(fact);
        unknownCourseIds.add(courseId);
      }
    }
    for (final AssignmentDim dim : dimTable) {
      final Long id = dim.getId();
      final Long courseId = idToCourse.get(id);
      if (courseId == null) {
        nonCourse.getTable(dimName, AssignmentDim.class).add(dim);
      } else {
        if (unknownCourseIds.contains(courseId)) {
          unknown.getTable(dimName, AssignmentDim.class).add(dim);
        } else {
          courseMap.get(courseId).getTable(dimName, AssignmentDim.class).add(dim);
        }
      }
    }
  }

  private void splitSections() throws IOException {
    final String dimName = CanvasTable.CourseSectionDim.getSourceName();
    for(final CourseSectionDim dim : dataSet.getTable(dimName, CourseSectionDim.class)) {
      final long courseId = dim.getCourseId();
      if (courseMap.containsKey(courseId)) {
        courseMap.get(courseId).getTable(dimName, CourseSectionDim.class).add(dim);
      } else {
        unknown.getTable(dimName,  CourseSectionDim.class).add(dim);
      }
    }
  }

  private void splitRequests() throws IOException {
    final String requestName = CanvasTable.Requests.getSourceName();
    final TableReader<Requests> requests = dataSet.getTable(requestName, Requests.class);
    for (final Requests request : requests) {
      final Long id = request.getCourseId();
      if (id == null) {
        nonCourse.getTable(requestName, Requests.class).add(request);
      } else {
        try {
          courseMap.get(request.getCourseId()).getTable(requestName, Requests.class).add(request);
        } catch (final NullPointerException e) {
          unknown.getTable(requestName, Requests.class).add(request);
        }
      }
    }
  }

}

class Histogram {
  private final Map<Integer, Long> map;

  public Histogram() {
    map = new HashMap<Integer, Long>();
  }

  public void add(final Integer value) {
    if (!map.containsKey(value)) {
      map.put(value, 0L);
    }
    map.put(value, map.get(value) + 1);
  }

  public void print() {
    final List<Integer> keys = new ArrayList<Integer>(map.keySet());
    Collections.sort(keys);
    for (final Integer k : keys) {
      System.out.println(k + ": " + map.get(k));
    }
  }
}
