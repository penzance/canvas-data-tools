package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class AssignmentFact extends CanvasDataTable {
  private Long assignmentId;
  private Long courseId;
  private Long courseAccountId;
  private Long enrollmentTermId;
  private Double pointsPossible;
  private Integer peerReviewCount;

  public AssignmentFact(final CSVRecord record) {
    String $assignmentId = record.get(0);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseId = record.get(1);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $courseAccountId = record.get(2);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(3);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $pointsPossible = record.get(4);
    if ($pointsPossible != null && $pointsPossible.length() > 0) {
      this.pointsPossible = Double.valueOf($pointsPossible);
    }
    String $peerReviewCount = record.get(5);
    if ($peerReviewCount != null && $peerReviewCount.length() > 0) {
      this.peerReviewCount = Integer.valueOf($peerReviewCount);
    }
  }

  public Long getAssignmentId() {
    return this.assignmentId;
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

  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  public Integer getPeerReviewCount() {
    return this.peerReviewCount;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    fields.add(pointsPossible);
    fields.add(peerReviewCount);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("assignment_id");
      fields.add("course_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
      fields.add("points_possible");
      fields.add("peer_review_count");
    return fields;
  }
}
