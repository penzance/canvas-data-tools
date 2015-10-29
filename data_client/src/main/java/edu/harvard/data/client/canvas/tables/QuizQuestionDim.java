// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long quizId;
  private Long quizQuestionGroupId;
  private Integer position;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private Long assessmentQuestionId;
  private Integer assessmentQuestionVersion;
  private String name;
  private String questionType;
  private String questionText;
  private String regradeOption;
  private String correctComments;
  private String incorrectComments;
  private String neutralComments;

  public QuizQuestionDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $quizId = record.get(2);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $quizQuestionGroupId = record.get(3);
    if ($quizQuestionGroupId != null && $quizQuestionGroupId.length() > 0) {
      this.quizQuestionGroupId = Long.valueOf($quizQuestionGroupId);
    }
    String $position = record.get(4);
    if ($position != null && $position.length() > 0) {
      this.position = Integer.valueOf($position);
    }
    this.workflowState = record.get(5);
    String $createdAt = record.get(6);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(7);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $assessmentQuestionId = record.get(8);
    if ($assessmentQuestionId != null && $assessmentQuestionId.length() > 0) {
      this.assessmentQuestionId = Long.valueOf($assessmentQuestionId);
    }
    String $assessmentQuestionVersion = record.get(9);
    if ($assessmentQuestionVersion != null && $assessmentQuestionVersion.length() > 0) {
      this.assessmentQuestionVersion = Integer.valueOf($assessmentQuestionVersion);
    }
    this.name = record.get(10);
    this.questionType = record.get(11);
    this.questionText = record.get(12);
    this.regradeOption = record.get(13);
    this.correctComments = record.get(14);
    this.incorrectComments = record.get(15);
    this.neutralComments = record.get(16);
  }

  /**
   * Unique surrogate key for the quiz question. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this quiz question in the 'quiz_questions' table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
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
   * Order in which the question will be displayed in the quiz relative to 
   * other questions associated with the quiz. 
   */
  public Integer getPosition() {
    return this.position;
  }

  /**
   * Denotes where the quiz question is in the workflow. Possible values are 
   * 'unpublished', 'published' and 'deleted'. Defaults to 'unpublished'. 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Time when the quiz question was created. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Time when the quiz question was last updated. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Foreign key to the assessment question dimension table (to be made 
   * available in later releases). 
   */
  public Long getAssessmentQuestionId() {
    return this.assessmentQuestionId;
  }

  /**
   * Version of the assessment question associated with the quiz question (to 
   * be made available in later releases). 
   */
  public Integer getAssessmentQuestionVersion() {
    return this.assessmentQuestionVersion;
  }

  /**
   * Name of the question. 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Denotes the type of the question. Possible values are 
   * 'calculated_question', 'essay_question', 'file_upload_question', 
   * 'fill_in_multiple_blanks_question', 'matching_question', 
   * 'multiple_answers_question', 'multiple_choice_question', 
   * 'multiple_dropdowns_question', 'numerical_question', 
   * 'short_answer_question', 'text_only_question' and 'true_false_question'. 
   * Defaults to ?? (incomplete) 
   */
  public String getQuestionType() {
    return this.questionType;
  }

  /**
   * Text content of the question. 
   */
  public String getQuestionText() {
    return this.questionText;
  }

  /**
   * Denotes if regrading is available for the question. Possible values are 
   * 'available' and 'unavailable' for question types 
   * 'multiple_answers_question', 'multiple_choice_question', 
   * 'true_false_question' and 'NULL' for others. Defaults to 'available' for 
   * the allowed question types and 'NULL' for the rest. 
   */
  public String getRegradeOption() {
    return this.regradeOption;
  }

  /**
   * Comments to be displayed if the student answers the question correctly. 
   */
  public String getCorrectComments() {
    return this.correctComments;
  }

  /**
   * Comments to be displayed if the student answers the question incorrectly. 
   */
  public String getIncorrectComments() {
    return this.incorrectComments;
  }

  /**
   * Comments to be displayed regardless of how the student answers the 
   * question. 
   */
  public String getNeutralComments() {
    return this.neutralComments;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(quizId);
    fields.add(quizQuestionGroupId);
    fields.add(position);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(assessmentQuestionId);
    fields.add(assessmentQuestionVersion);
    fields.add(name);
    fields.add(questionType);
    fields.add(questionText);
    fields.add(regradeOption);
    fields.add(correctComments);
    fields.add(incorrectComments);
    fields.add(neutralComments);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("quiz_id");
      fields.add("quiz_question_group_id");
      fields.add("position");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("assessment_question_id");
      fields.add("assessment_question_version");
      fields.add("name");
      fields.add("question_type");
      fields.add("question_text");
      fields.add("regrade_option");
      fields.add("correct_comments");
      fields.add("incorrect_comments");
      fields.add("neutral_comments");
    return fields;
  }
}
