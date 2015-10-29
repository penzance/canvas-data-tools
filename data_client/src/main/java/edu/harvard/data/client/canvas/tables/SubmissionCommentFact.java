// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class SubmissionCommentFact implements DataTable {
  private Long submissionCommentId;
  private Long submissionId;
  private Long recipientId;
  private Long authorId;
  private Long assignmentId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Integer messageSizeBytes;
  private Integer messageCharacterCount;
  private Integer messageWordCount;
  private Integer messageLineCount;

  public SubmissionCommentFact(final TableFormat format, final CSVRecord record) {
    String $submissionCommentId = record.get(0);
    if ($submissionCommentId != null && $submissionCommentId.length() > 0) {
      this.submissionCommentId = Long.valueOf($submissionCommentId);
    }
    String $submissionId = record.get(1);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $recipientId = record.get(2);
    if ($recipientId != null && $recipientId.length() > 0) {
      this.recipientId = Long.valueOf($recipientId);
    }
    String $authorId = record.get(3);
    if ($authorId != null && $authorId.length() > 0) {
      this.authorId = Long.valueOf($authorId);
    }
    String $assignmentId = record.get(4);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseId = record.get(5);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(6);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(7);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $messageSizeBytes = record.get(8);
    if ($messageSizeBytes != null && $messageSizeBytes.length() > 0) {
      this.messageSizeBytes = Integer.valueOf($messageSizeBytes);
    }
    String $messageCharacterCount = record.get(9);
    if ($messageCharacterCount != null && $messageCharacterCount.length() > 0) {
      this.messageCharacterCount = Integer.valueOf($messageCharacterCount);
    }
    String $messageWordCount = record.get(10);
    if ($messageWordCount != null && $messageWordCount.length() > 0) {
      this.messageWordCount = Integer.valueOf($messageWordCount);
    }
    String $messageLineCount = record.get(11);
    if ($messageLineCount != null && $messageLineCount.length() > 0) {
      this.messageLineCount = Integer.valueOf($messageLineCount);
    }
  }

  public Long getSubmissionCommentId() {
    return this.submissionCommentId;
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

  /**
   * Foreign key to assignment dimension 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * Foreign key to course dimension of course associated with the assignment. 
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
   * Foreign key to the account dimension of the account associated with the 
   * course associated with the assignment 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * The message size in bytes. 
   */
  public Integer getMessageSizeBytes() {
    return this.messageSizeBytes;
  }

  /**
   * The message size in characters. 
   */
  public Integer getMessageCharacterCount() {
    return this.messageCharacterCount;
  }

  /**
   * The message size in words using space and common punctualtion as word 
   * breaks. 
   */
  public Integer getMessageWordCount() {
    return this.messageWordCount;
  }

  /**
   * The number of lines in a message. 
   */
  public Integer getMessageLineCount() {
    return this.messageLineCount;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(submissionCommentId);
    fields.add(submissionId);
    fields.add(recipientId);
    fields.add(authorId);
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(messageSizeBytes);
    fields.add(messageCharacterCount);
    fields.add(messageWordCount);
    fields.add(messageLineCount);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("submission_comment_id");
      fields.add("submission_id");
      fields.add("recipient_id");
      fields.add("author_id");
      fields.add("assignment_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("message_size_bytes");
      fields.add("message_character_count");
      fields.add("message_word_count");
      fields.add("message_line_count");
    return fields;
  }
}
