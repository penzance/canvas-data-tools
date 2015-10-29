// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizQuestionGroupDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long quizId;
  private String name;
  private Integer position;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;

  public QuizQuestionGroupDim(final TableFormat format, final CSVRecord record) {
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
    this.name = record.get(3);
    String $position = record.get(4);
    if ($position != null && $position.length() > 0) {
      this.position = Integer.valueOf($position);
    }
    String $createdAt = record.get(5);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(6);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
  }

  /**
   * Unique surrogate ID for the quiz group. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this quiz group in the 'quiz_question_groups' table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Foreign key to quiz dimension. 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Name of the quiz group. 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Order in which the questions from this group will be displayed in the quiz 
   * relative to other questions in the quiz from other groups. 
   */
  public Integer getPosition() {
    return this.position;
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

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(quizId);
    fields.add(name);
    fields.add(position);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("quiz_id");
      fields.add("name");
      fields.add("position");
      fields.add("created_at");
      fields.add("updated_at");
    return fields;
  }
}
