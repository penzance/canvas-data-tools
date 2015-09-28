package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class DiscussionTopicFact extends CanvasDataTable {
  private Long discussionTopicId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long userId;
  private Long assignmentId;
  private Long editorId;
  private Long enrollmentRollupId;
  private Integer messageLength;

  public DiscussionTopicFact(final CSVRecord record) {
    String $discussionTopicId = record.get(0);
    if ($discussionTopicId != null && $discussionTopicId.length() > 0) {
      this.discussionTopicId = Long.valueOf($discussionTopicId);
    }
    String $courseId = record.get(1);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(2);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(3);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $userId = record.get(4);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $assignmentId = record.get(5);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $editorId = record.get(6);
    if ($editorId != null && $editorId.length() > 0) {
      this.editorId = Long.valueOf($editorId);
    }
    String $enrollmentRollupId = record.get(7);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
    String $messageLength = record.get(8);
    if ($messageLength != null && $messageLength.length() > 0) {
      this.messageLength = Integer.valueOf($messageLength);
    }
  }

  public Long getDiscussionTopicId() {
    return this.discussionTopicId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getAssignmentId() {
    return this.assignmentId;
  }

  public Long getEditorId() {
    return this.editorId;
  }

  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  public Integer getMessageLength() {
    return this.messageLength;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(discussionTopicId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(userId);
    fields.add(assignmentId);
    fields.add(editorId);
    fields.add(enrollmentRollupId);
    fields.add(messageLength);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("discussion_topic_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("user_id");
      fields.add("assignment_id");
      fields.add("editor_id");
      fields.add("enrollment_rollup_id");
      fields.add("message_length");
    return fields;
  }
}
