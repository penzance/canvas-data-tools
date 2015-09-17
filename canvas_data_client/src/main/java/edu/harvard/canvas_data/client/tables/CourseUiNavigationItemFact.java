package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class CourseUiNavigationItemFact extends CanvasDataTable {
  private Long rootAccountId;
  private Long courseUiNavigationItemId;
  private Long courseUiCanvasNavigationId;
  private Long externalToolActivationId;
  private Long courseId;
  private Long courseAccountId;
  private Long enrollmentTermId;

  public CourseUiNavigationItemFact(final CSVRecord record) {
    String $rootAccountId = record.get(0);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $courseUiNavigationItemId = record.get(1);
    if ($courseUiNavigationItemId != null && $courseUiNavigationItemId.length() > 0) {
      this.courseUiNavigationItemId = Long.valueOf($courseUiNavigationItemId);
    }
    String $courseUiCanvasNavigationId = record.get(2);
    if ($courseUiCanvasNavigationId != null && $courseUiCanvasNavigationId.length() > 0) {
      this.courseUiCanvasNavigationId = Long.valueOf($courseUiCanvasNavigationId);
    }
    String $externalToolActivationId = record.get(3);
    if ($externalToolActivationId != null && $externalToolActivationId.length() > 0) {
      this.externalToolActivationId = Long.valueOf($externalToolActivationId);
    }
    String $courseId = record.get(4);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $courseAccountId = record.get(5);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(6);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public Long getCourseUiNavigationItemId() {
    return this.courseUiNavigationItemId;
  }

  public Long getCourseUiCanvasNavigationId() {
    return this.courseUiCanvasNavigationId;
  }

  public Long getExternalToolActivationId() {
    return this.externalToolActivationId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(rootAccountId);
    fields.add(courseUiNavigationItemId);
    fields.add(courseUiCanvasNavigationId);
    fields.add(externalToolActivationId);
    fields.add(courseId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    return fields;
  }
}
