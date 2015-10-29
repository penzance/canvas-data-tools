// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionAnswerFact implements DataTable {
  private Long quizQuestionAnswerId;
  private Long quizQuestionId;
  private Long quizQuestionGroupId;
  private Long quizId;
  private Long assessmentQuestionId;
  private Long courseId;
  private Long assignmentId;
  private Long courseAccountId;
  private Long enrollmentTermId;
  private Double weight;
  private Double exact;
  private Double margin;
  private Double startingRange;
  private Double endingRange;

  public QuizQuestionAnswerFact(final TableFormat format, final CSVRecord record) {
    String $quizQuestionAnswerId = record.get(0);
    if ($quizQuestionAnswerId != null && $quizQuestionAnswerId.length() > 0) {
      this.quizQuestionAnswerId = Long.valueOf($quizQuestionAnswerId);
    }
    String $quizQuestionId = record.get(1);
    if ($quizQuestionId != null && $quizQuestionId.length() > 0) {
      this.quizQuestionId = Long.valueOf($quizQuestionId);
    }
    String $quizQuestionGroupId = record.get(2);
    if ($quizQuestionGroupId != null && $quizQuestionGroupId.length() > 0) {
      this.quizQuestionGroupId = Long.valueOf($quizQuestionGroupId);
    }
    String $quizId = record.get(3);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $assessmentQuestionId = record.get(4);
    if ($assessmentQuestionId != null && $assessmentQuestionId.length() > 0) {
      this.assessmentQuestionId = Long.valueOf($assessmentQuestionId);
    }
    String $courseId = record.get(5);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $assignmentId = record.get(6);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseAccountId = record.get(7);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(8);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $weight = record.get(9);
    if ($weight != null && $weight.length() > 0) {
      this.weight = Double.valueOf($weight);
    }
    String $exact = record.get(10);
    if ($exact != null && $exact.length() > 0) {
      this.exact = Double.valueOf($exact);
    }
    String $margin = record.get(11);
    if ($margin != null && $margin.length() > 0) {
      this.margin = Double.valueOf($margin);
    }
    String $startingRange = record.get(12);
    if ($startingRange != null && $startingRange.length() > 0) {
      this.startingRange = Double.valueOf($startingRange);
    }
    String $endingRange = record.get(13);
    if ($endingRange != null && $endingRange.length() > 0) {
      this.endingRange = Double.valueOf($endingRange);
    }
  }

  /**
   * Foreign key to the quiz question answer dimension table. 
   */
  public Long getQuizQuestionAnswerId() {
    return this.quizQuestionAnswerId;
  }

  /**
   * Foreign key to the quiz question dimension table. 
   */
  public Long getQuizQuestionId() {
    return this.quizQuestionId;
  }

  /**
   * Foreign key to the quiz group dimension table. 
   */
  public Long getQuizQuestionGroupId() {
    return this.quizQuestionGroupId;
  }

  /**
   * Foreign key to the quiz dimension table. 
   */
  public Long getQuizId() {
    return this.quizId;
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
   * Integer value to determine correctness of the answer. Incorrect answers 
   * should be 0, correct answers should be non-negative. 
   */
  public Double getWeight() {
    return this.weight;
  }

  /**
   * (Used in 'numerical_question' with answer type 'exact_answer', set to 
   * 'NULL' otherwise) Value the answer must be equal to. 
   */
  public Double getExact() {
    return this.exact;
  }

  /**
   * (Used in 'numerical_question' with answer type 'exact_answer', set to 
   * 'NULL' otherwise) Margin of error allowed for a student's answer. 
   */
  public Double getMargin() {
    return this.margin;
  }

  /**
   * (Used in 'numerical_question' with answer type 'range_answer', set to 
   * 'NULL' otherwise) Start of the allowed range (inclusive). 
   */
  public Double getStartingRange() {
    return this.startingRange;
  }

  /**
   * (Used in 'numerical_question' with answer type 'range_answer', set to 
   * 'NULL' otherwise) End of the allowed range (inclusive). 
   */
  public Double getEndingRange() {
    return this.endingRange;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(quizQuestionAnswerId);
    fields.add(quizQuestionId);
    fields.add(quizQuestionGroupId);
    fields.add(quizId);
    fields.add(assessmentQuestionId);
    fields.add(courseId);
    fields.add(assignmentId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    fields.add(weight);
    fields.add(exact);
    fields.add(margin);
    fields.add(startingRange);
    fields.add(endingRange);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("quiz_question_answer_id");
      fields.add("quiz_question_id");
      fields.add("quiz_question_group_id");
      fields.add("quiz_id");
      fields.add("assessment_question_id");
      fields.add("course_id");
      fields.add("assignment_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
      fields.add("weight");
      fields.add("exact");
      fields.add("margin");
      fields.add("starting_range");
      fields.add("ending_range");
    return fields;
  }
}
