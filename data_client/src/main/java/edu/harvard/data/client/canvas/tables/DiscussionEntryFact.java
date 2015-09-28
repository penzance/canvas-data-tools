package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class DiscussionEntryFact implements DataTable {
  private Long discussionEntryId;
  private Long parentDiscussionEntryId;
  private Long userId;
  private Long topicId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long topicUserId;
  private Long topicAssignmentId;
  private Long topicEditorId;
  private Long enrollmentRollupId;
  private Integer messageLength;

  public DiscussionEntryFact(final TableFormat format, final CSVRecord record) {
    String $discussionEntryId = record.get(0);
    if ($discussionEntryId != null && $discussionEntryId.length() > 0) {
      this.discussionEntryId = Long.valueOf($discussionEntryId);
    }
    String $parentDiscussionEntryId = record.get(1);
    if ($parentDiscussionEntryId != null && $parentDiscussionEntryId.length() > 0) {
      this.parentDiscussionEntryId = Long.valueOf($parentDiscussionEntryId);
    }
    String $userId = record.get(2);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $topicId = record.get(3);
    if ($topicId != null && $topicId.length() > 0) {
      this.topicId = Long.valueOf($topicId);
    }
    String $courseId = record.get(4);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(5);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(6);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $topicUserId = record.get(7);
    if ($topicUserId != null && $topicUserId.length() > 0) {
      this.topicUserId = Long.valueOf($topicUserId);
    }
    String $topicAssignmentId = record.get(8);
    if ($topicAssignmentId != null && $topicAssignmentId.length() > 0) {
      this.topicAssignmentId = Long.valueOf($topicAssignmentId);
    }
    String $topicEditorId = record.get(9);
    if ($topicEditorId != null && $topicEditorId.length() > 0) {
      this.topicEditorId = Long.valueOf($topicEditorId);
    }
    String $enrollmentRollupId = record.get(10);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
    String $messageLength = record.get(11);
    if ($messageLength != null && $messageLength.length() > 0) {
      this.messageLength = Integer.valueOf($messageLength);
    }
  }

  public Long getDiscussionEntryId() {
    return this.discussionEntryId;
  }

  public Long getParentDiscussionEntryId() {
    return this.parentDiscussionEntryId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getTopicId() {
    return this.topicId;
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

  public Long getTopicUserId() {
    return this.topicUserId;
  }

  public Long getTopicAssignmentId() {
    return this.topicAssignmentId;
  }

  public Long getTopicEditorId() {
    return this.topicEditorId;
  }

  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  public Integer getMessageLength() {
    return this.messageLength;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(discussionEntryId);
    fields.add(parentDiscussionEntryId);
    fields.add(userId);
    fields.add(topicId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(topicUserId);
    fields.add(topicAssignmentId);
    fields.add(topicEditorId);
    fields.add(enrollmentRollupId);
    fields.add(messageLength);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("discussion_entry_id");
      fields.add("parent_discussion_entry_id");
      fields.add("user_id");
      fields.add("topic_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("topic_user_id");
      fields.add("topic_assignment_id");
      fields.add("topic_editor_id");
      fields.add("enrollment_rollup_id");
      fields.add("message_length");
    return fields;
  }
}
