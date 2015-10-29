// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class SubmissionCommentDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long submissionId;
  private Long recipientId;
  private Long authorId;
  private Long assessmentRequestId;
  private String groupCommentId;
  private String comment;
  private String authorName;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private Boolean anonymous;
  private Boolean teacherOnlyComment;
  private Boolean hidden;

  public SubmissionCommentDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $submissionId = record.get(2);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $recipientId = record.get(3);
    if ($recipientId != null && $recipientId.length() > 0) {
      this.recipientId = Long.valueOf($recipientId);
    }
    String $authorId = record.get(4);
    if ($authorId != null && $authorId.length() > 0) {
      this.authorId = Long.valueOf($authorId);
    }
    String $assessmentRequestId = record.get(5);
    if ($assessmentRequestId != null && $assessmentRequestId.length() > 0) {
      this.assessmentRequestId = Long.valueOf($assessmentRequestId);
    }
    this.groupCommentId = record.get(6);
    this.comment = record.get(7);
    this.authorName = record.get(8);
    String $createdAt = record.get(9);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(10);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $anonymous = record.get(11);
    if ($anonymous != null && $anonymous.length() > 0) {
      this.anonymous = Boolean.valueOf($anonymous);
    }
    String $teacherOnlyComment = record.get(12);
    if ($teacherOnlyComment != null && $teacherOnlyComment.length() > 0) {
      this.teacherOnlyComment = Boolean.valueOf($teacherOnlyComment);
    }
    String $hidden = record.get(13);
    if ($hidden != null && $hidden.length() > 0) {
      this.hidden = Boolean.valueOf($hidden);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getSubmissionId() {
    return this.submissionId;
  }

  public Long getRecipientId() {
    return this.recipientId;
  }

  public Long getAuthorId() {
    return this.authorId;
  }

  public Long getAssessmentRequestId() {
    return this.assessmentRequestId;
  }

  public String getGroupCommentId() {
    return this.groupCommentId;
  }

  public String getComment() {
    return this.comment;
  }

  public String getAuthorName() {
    return this.authorName;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Boolean getAnonymous() {
    return this.anonymous;
  }

  public Boolean getTeacherOnlyComment() {
    return this.teacherOnlyComment;
  }

  public Boolean getHidden() {
    return this.hidden;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(submissionId);
    fields.add(recipientId);
    fields.add(authorId);
    fields.add(assessmentRequestId);
    fields.add(groupCommentId);
    fields.add(comment);
    fields.add(authorName);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(anonymous);
    fields.add(teacherOnlyComment);
    fields.add(hidden);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("submission_id");
      fields.add("recipient_id");
      fields.add("author_id");
      fields.add("assessment_request_id");
      fields.add("group_comment_id");
      fields.add("comment");
      fields.add("author_name");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("anonymous");
      fields.add("teacher_only_comment");
      fields.add("hidden");
    return fields;
  }
}
