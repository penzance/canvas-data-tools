// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionGroupFact implements DataTable {
  private Long quizQuestionGroupId;
  private Integer pickCount;
  private Double questionPoints;
  private Long quizId;
  private Long courseId;
  private Long assignmentId;
  private Long courseAccountId;
  private Long enrollmentTermId;

  public QuizQuestionGroupFact(final TableFormat format, final CSVRecord record) {
    String $quizQuestionGroupId = record.get(0);
    if ($quizQuestionGroupId != null && $quizQuestionGroupId.length() > 0) {
      this.quizQuestionGroupId = Long.valueOf($quizQuestionGroupId);
    }
    String $pickCount = record.get(1);
    if ($pickCount != null && $pickCount.length() > 0) {
      this.pickCount = Integer.valueOf($pickCount);
    }
    String $questionPoints = record.get(2);
    if ($questionPoints != null && $questionPoints.length() > 0) {
      this.questionPoints = Double.valueOf($questionPoints);
    }
    String $quizId = record.get(3);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $courseId = record.get(4);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $assignmentId = record.get(5);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseAccountId = record.get(6);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(7);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
  }

  /**
   * Foreign key to quiz group. 
   */
  public Long getQuizQuestionGroupId() {
    return this.quizQuestionGroupId;
  }

  /**
   * Number of questions picked from the group for the quiz the group is 
   * associated with. 
   */
  public Integer getPickCount() {
    return this.pickCount;
  }

  /**
   * Number of points to assign per question in the group. 
   */
  public Double getQuestionPoints() {
    return this.questionPoints;
  }

  /**
   * Foreign key to quiz dimension. 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Foreign key to the course this group's quiz belongs to. 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to the assignment the quiz belongs to. 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * Foreign key to the account of the course this group belongs to. 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Foreign key to the enrollment term of the course this group belongs to. 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(quizQuestionGroupId);
    fields.add(pickCount);
    fields.add(questionPoints);
    fields.add(quizId);
    fields.add(courseId);
    fields.add(assignmentId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("quiz_question_group_id");
      fields.add("pick_count");
      fields.add("question_points");
      fields.add("quiz_id");
      fields.add("course_id");
      fields.add("assignment_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
    return fields;
  }
}
