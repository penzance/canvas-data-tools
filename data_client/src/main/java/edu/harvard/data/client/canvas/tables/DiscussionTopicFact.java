// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class DiscussionTopicFact implements DataTable {
  private Long discussionTopicId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long userId;
  private Long assignmentId;
  private Long editorId;
  private Long enrollmentRollupId;
  private Integer messageLength;

  public DiscussionTopicFact(final TableFormat format, final CSVRecord record) {
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

  /**
   * Foreign key to the discussion topic dimension for the associated 
   * discussion topic. 
   */
  public Long getDiscussionTopicId() {
    return this.discussionTopicId;
  }

  /**
   * Foreign key to the course dimension 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign Key to enrollment term table 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * (currently unpopulated) Foreign key to the account dimension for the 
   * account associated with the associated course 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Foreign key to the user dimension for the user that created the discussion 
   * topic. 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * Foreign key to the assignment dimension 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * Foreign key to the user dimension. (tbd) 
   */
  public Long getEditorId() {
    return this.editorId;
  }

  /**
   * Foreign key to the enrollment rollup dimension table 
   */
  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  /**
   * The length of the message in bytes. 
   */
  public Integer getMessageLength() {
    return this.messageLength;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
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

  public static List<String> getFieldNames() {
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
