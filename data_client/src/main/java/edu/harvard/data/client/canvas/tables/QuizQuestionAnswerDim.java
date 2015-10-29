// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionAnswerDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long quizQuestionId;
  private String text;
  private String html;
  private String comments;
  private String textAfterAnswers;
  private String answerMatchLeft;
  private String answerMatchRight;
  private String matchingAnswerIncorrectMatches;
  private String numericalAnswerType;
  private String blankId;
  private Double exact;
  private Double margin;
  private Double startingRange;
  private Double endingRange;

  public QuizQuestionAnswerDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $quizQuestionId = record.get(2);
    if ($quizQuestionId != null && $quizQuestionId.length() > 0) {
      this.quizQuestionId = Long.valueOf($quizQuestionId);
    }
    this.text = record.get(3);
    this.html = record.get(4);
    this.comments = record.get(5);
    this.textAfterAnswers = record.get(6);
    this.answerMatchLeft = record.get(7);
    this.answerMatchRight = record.get(8);
    this.matchingAnswerIncorrectMatches = record.get(9);
    this.numericalAnswerType = record.get(10);
    this.blankId = record.get(11);
    String $exact = record.get(12);
    if ($exact != null && $exact.length() > 0) {
      this.exact = Double.valueOf($exact);
    }
    String $margin = record.get(13);
    if ($margin != null && $margin.length() > 0) {
      this.margin = Double.valueOf($margin);
    }
    String $startingRange = record.get(14);
    if ($startingRange != null && $startingRange.length() > 0) {
      this.startingRange = Double.valueOf($startingRange);
    }
    String $endingRange = record.get(15);
    if ($endingRange != null && $endingRange.length() > 0) {
      this.endingRange = Double.valueOf($endingRange);
    }
  }

  /**
   * Unique surrogate key for the quiz question answer. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this quiz question answer. No table available in Canvas. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Foreign key to the quiz question dimension column. 
   */
  public Long getQuizQuestionId() {
    return this.quizQuestionId;
  }

  /**
   * Text of the answer. 
   */
  public String getText() {
    return this.text;
  }

  /**
   * HTML markup of the text. 
   */
  public String getHtml() {
    return this.html;
  }

  /**
   * Specific contextual comments for a particular answer. 
   */
  public String getComments() {
    return this.comments;
  }

  /**
   * (Used in 'short_answer_question', also known as 'fill_in_the_blank'. Set 
   * to 'NULL' in others) Text following the missing word. 
   */
  public String getTextAfterAnswers() {
    return this.textAfterAnswers;
  }

  /**
   * (Used in 'matching_question', set to 'NULL' in others) Static value of the 
   * answer that will be displayed on the left for students to match for. 
   */
  public String getAnswerMatchLeft() {
    return this.answerMatchLeft;
  }

  /**
   * (Used in 'matching_question', set to 'NULL' in others) Correct match for 
   * the value given in 'answer_match_left', displayed in a dropdown with other 
   * 'answer_match_right' values. 
   */
  public String getAnswerMatchRight() {
    return this.answerMatchRight;
  }

  /**
   * (Used in 'matching_question', set to 'NULL' in others) List of distractors 
   * (incorrect answers), delimited by new lines, that will be seeded with all 
   * the 'answer_match_right' values. 
   */
  public String getMatchingAnswerIncorrectMatches() {
    return this.matchingAnswerIncorrectMatches;
  }

  /**
   * (Used in 'numerical_question', set to 'NULL' in others) Denotes the type 
   * of numerical answer that is expected. Possible values are 'exact_answer' 
   * and 'range_answer'. 
   */
  public String getNumericalAnswerType() {
    return this.numericalAnswerType;
  }

  /**
   * (Used in 'fill_in_multiple_blanks_question' and 
   * 'multiple_dropdowns_question', set to 'NULL' otherwise) Refers to the ID of 
   * the blank(s) in the question text. 
   */
  public String getBlankId() {
    return this.blankId;
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
    fields.add(id);
    fields.add(canvasId);
    fields.add(quizQuestionId);
    fields.add(text);
    fields.add(html);
    fields.add(comments);
    fields.add(textAfterAnswers);
    fields.add(answerMatchLeft);
    fields.add(answerMatchRight);
    fields.add(matchingAnswerIncorrectMatches);
    fields.add(numericalAnswerType);
    fields.add(blankId);
    fields.add(exact);
    fields.add(margin);
    fields.add(startingRange);
    fields.add(endingRange);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("quiz_question_id");
      fields.add("text");
      fields.add("html");
      fields.add("comments");
      fields.add("text_after_answers");
      fields.add("answer_match_left");
      fields.add("answer_match_right");
      fields.add("matching_answer_incorrect_matches");
      fields.add("numerical_answer_type");
      fields.add("blank_id");
      fields.add("exact");
      fields.add("margin");
      fields.add("starting_range");
      fields.add("ending_range");
    return fields;
  }
}
