package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class SubmissionCommentFact extends CanvasDataTable {
  private Long submissionCommentId;
  private Long submissionId;
  private Long recipientId;
  private Long authorId;
  private Long assignmentId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long userAccountId;
  private Integer messageSizeBytes;
  private Integer messageCharacterCount;
  private Integer messageWordCount;
  private Integer messageLineCount;

  public SubmissionCommentFact(final CSVRecord record) {
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
    String $userAccountId = record.get(8);
    if ($userAccountId != null && $userAccountId.length() > 0) {
      this.userAccountId = Long.valueOf($userAccountId);
    }
    String $messageSizeBytes = record.get(9);
    if ($messageSizeBytes != null && $messageSizeBytes.length() > 0) {
      this.messageSizeBytes = Integer.valueOf($messageSizeBytes);
    }
    String $messageCharacterCount = record.get(10);
    if ($messageCharacterCount != null && $messageCharacterCount.length() > 0) {
      this.messageCharacterCount = Integer.valueOf($messageCharacterCount);
    }
    String $messageWordCount = record.get(11);
    if ($messageWordCount != null && $messageWordCount.length() > 0) {
      this.messageWordCount = Integer.valueOf($messageWordCount);
    }
    String $messageLineCount = record.get(12);
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

  public Long getAssignmentId() {
    return this.assignmentId;
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

  public Long getUserAccountId() {
    return this.userAccountId;
  }

  public Integer getMessageSizeBytes() {
    return this.messageSizeBytes;
  }

  public Integer getMessageCharacterCount() {
    return this.messageCharacterCount;
  }

  public Integer getMessageWordCount() {
    return this.messageWordCount;
  }

  public Integer getMessageLineCount() {
    return this.messageLineCount;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(submissionCommentId);
    fields.add(submissionId);
    fields.add(recipientId);
    fields.add(authorId);
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(userAccountId);
    fields.add(messageSizeBytes);
    fields.add(messageCharacterCount);
    fields.add(messageWordCount);
    fields.add(messageLineCount);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("submission_comment_id");
      fields.add("submission_id");
      fields.add("recipient_id");
      fields.add("author_id");
      fields.add("assignment_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("user_account_id");
      fields.add("message_size_bytes");
      fields.add("message_character_count");
      fields.add("message_word_count");
      fields.add("message_line_count");
    return fields;
  }
}
