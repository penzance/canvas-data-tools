// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizFact implements DataTable {
  private Long quizId;
  private Double pointsPossible;
  private Integer timeLimit;
  private Integer allowedAttempts;
  private Integer unpublishedQuestionCount;
  private Integer questionCount;
  private Long courseId;
  private Long assignmentId;
  private Long courseAccountId;
  private Long enrollmentTermId;

  public QuizFact(final TableFormat format, final CSVRecord record) {
    String $quizId = record.get(0);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $pointsPossible = record.get(1);
    if ($pointsPossible != null && $pointsPossible.length() > 0) {
      this.pointsPossible = Double.valueOf($pointsPossible);
    }
    String $timeLimit = record.get(2);
    if ($timeLimit != null && $timeLimit.length() > 0) {
      this.timeLimit = Integer.valueOf($timeLimit);
    }
    String $allowedAttempts = record.get(3);
    if ($allowedAttempts != null && $allowedAttempts.length() > 0) {
      this.allowedAttempts = Integer.valueOf($allowedAttempts);
    }
    String $unpublishedQuestionCount = record.get(4);
    if ($unpublishedQuestionCount != null && $unpublishedQuestionCount.length() > 0) {
      this.unpublishedQuestionCount = Integer.valueOf($unpublishedQuestionCount);
    }
    String $questionCount = record.get(5);
    if ($questionCount != null && $questionCount.length() > 0) {
      this.questionCount = Integer.valueOf($questionCount);
    }
    String $courseId = record.get(6);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $assignmentId = record.get(7);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseAccountId = record.get(8);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(9);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
  }

  /**
   * Foreign key to quiz dimension table. 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Total point value given to the quiz. 
   */
  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  /**
   * Time limit, in minutes, to complete the quiz. Set to -1 for no time limit. 
   * Defaults to -1. 
   */
  public Integer getTimeLimit() {
    return this.timeLimit;
  }

  /**
   * Number of attempts allowed to complete the quiz. Set to -1 for unlimited 
   * attempts. Defaults to -1. 
   */
  public Integer getAllowedAttempts() {
    return this.allowedAttempts;
  }

  /**
   * Number of questions in the current unpublished version of the quiz. 
   */
  public Integer getUnpublishedQuestionCount() {
    return this.unpublishedQuestionCount;
  }

  /**
   * Number of questions in the last published version of the quizs 
   */
  public Integer getQuestionCount() {
    return this.questionCount;
  }

  /**
   * Foreign key to the course the quiz belongs to. 
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
   * Foreign key to the account associated with the course associated with this 
   * quiz. 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Foreign key to enrollment term the quiz belongs to. 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(quizId);
    fields.add(pointsPossible);
    fields.add(timeLimit);
    fields.add(allowedAttempts);
    fields.add(unpublishedQuestionCount);
    fields.add(questionCount);
    fields.add(courseId);
    fields.add(assignmentId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("quiz_id");
      fields.add("points_possible");
      fields.add("time_limit");
      fields.add("allowed_attempts");
      fields.add("unpublished_question_count");
      fields.add("question_count");
      fields.add("course_id");
      fields.add("assignment_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
    return fields;
  }
}
