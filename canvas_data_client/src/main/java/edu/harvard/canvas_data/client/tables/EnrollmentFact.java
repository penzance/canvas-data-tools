package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class EnrollmentFact extends CanvasDataTable {
  private Long enrollmentId;
  private Long userId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long courseSectionId;
  private Double computedFinalScore;
  private Double computedCurrentScore;

  public EnrollmentFact(final CSVRecord record) {
    String $enrollmentId = record.get(0);
    if ($enrollmentId != null && $enrollmentId.length() > 0) {
      this.enrollmentId = Long.valueOf($enrollmentId);
    }
    String $userId = record.get(1);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $courseId = record.get(2);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(3);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(4);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $courseSectionId = record.get(5);
    if ($courseSectionId != null && $courseSectionId.length() > 0) {
      this.courseSectionId = Long.valueOf($courseSectionId);
    }
    String $computedFinalScore = record.get(6);
    if ($computedFinalScore != null && $computedFinalScore.length() > 0) {
      this.computedFinalScore = Double.valueOf($computedFinalScore);
    }
    String $computedCurrentScore = record.get(7);
    if ($computedCurrentScore != null && $computedCurrentScore.length() > 0) {
      this.computedCurrentScore = Double.valueOf($computedCurrentScore);
    }
  }

  public Long getEnrollmentId() {
    return this.enrollmentId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  public Long getCourseSectionId() {
    return this.courseSectionId;
  }

  public Double getComputedFinalScore() {
    return this.computedFinalScore;
  }

  public Double getComputedCurrentScore() {
    return this.computedCurrentScore;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(enrollmentId);
    fields.add(userId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(courseSectionId);
    fields.add(computedFinalScore);
    fields.add(computedCurrentScore);
    return fields;
  }
}
