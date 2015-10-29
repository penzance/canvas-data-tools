// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionFact implements DataTable {
  private Long quizQuestionId;
  private Long quizId;
  private Long quizQuestionGroupId;
  private Long assessmentQuestionId;
  private Long courseId;
  private Long assignmentId;
  private Long courseAccountId;
  private Long enrollmentTermId;
  private Double pointsPossible;

  public QuizQuestionFact(final TableFormat format, final CSVRecord record) {
    String $quizQuestionId = record.get(0);
    if ($quizQuestionId != null && $quizQuestionId.length() > 0) {
      this.quizQuestionId = Long.valueOf($quizQuestionId);
    }
    String $quizId = record.get(1);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $quizQuestionGroupId = record.get(2);
    if ($quizQuestionGroupId != null && $quizQuestionGroupId.length() > 0) {
      this.quizQuestionGroupId = Long.valueOf($quizQuestionGroupId);
    }
    String $assessmentQuestionId = record.get(3);
    if ($assessmentQuestionId != null && $assessmentQuestionId.length() > 0) {
      this.assessmentQuestionId = Long.valueOf($assessmentQuestionId);
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
    String $pointsPossible = record.get(8);
    if ($pointsPossible != null && $pointsPossible.length() > 0) {
      this.pointsPossible = Double.valueOf($pointsPossible);
    }
  }

  /**
   * Foreign key to the quiz question dimension table. 
   */
  public Long getQuizQuestionId() {
    return this.quizQuestionId;
  }

  /**
   * Foreign key to the quiz dimension table. 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Foreign key to the quiz group dimension table. 
   */
  public Long getQuizQuestionGroupId() {
    return this.quizQuestionGroupId;
  }

  /**
   * Foreign key to the assessment question dimension table (to be made 
   * available in later releases). 
   */
  public Long getAssessmentQuestionId() {
    return this.assessmentQuestionId;
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

  /**
   * Maximum number of points that can be awarded for answering the question 
   * correctly. 
   */
  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(quizQuestionId);
    fields.add(quizId);
    fields.add(quizQuestionGroupId);
    fields.add(assessmentQuestionId);
    fields.add(courseId);
    fields.add(assignmentId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    fields.add(pointsPossible);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("quiz_question_id");
      fields.add("quiz_id");
      fields.add("quiz_question_group_id");
      fields.add("assessment_question_id");
      fields.add("course_id");
      fields.add("assignment_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
      fields.add("points_possible");
    return fields;
  }
}
