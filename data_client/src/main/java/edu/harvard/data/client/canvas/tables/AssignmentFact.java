// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class AssignmentFact implements DataTable {
  private Long assignmentId;
  private Long courseId;
  private Long courseAccountId;
  private Long enrollmentTermId;
  private Double pointsPossible;
  private Integer peerReviewCount;

  public AssignmentFact(final TableFormat format, final CSVRecord record) {
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

  /**
   * Foreign key to assignment dimension 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * Foreign key to the course associated with this assignment 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to the account associated with the course associated with this 
   * assignment 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Foreign Key to enrollment term table 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * Total points possible for the assignment 
   */
  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  /**
   * The number of pears to assign for review if using algorithmic assignment 
   */
  public Integer getPeerReviewCount() {
    return this.peerReviewCount;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    fields.add(pointsPossible);
    fields.add(peerReviewCount);
    return fields;
  }

  public static List<String> getFieldNames() {
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
