// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class ConversationMessageParticipantFact implements DataTable {
  private Long conversationMessageId;
  private Long conversationId;
  private Long userId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long groupId;
  private Long accountId;
  private Long enrollmentRollupId;
  private Integer messageSizeBytes;
  private Integer messageCharacterCount;
  private Integer messageWordCount;
  private Integer messageLineCount;

  public ConversationMessageParticipantFact(final TableFormat format, final CSVRecord record) {
    String $conversationMessageId = record.get(0);
    if ($conversationMessageId != null && $conversationMessageId.length() > 0) {
      this.conversationMessageId = Long.valueOf($conversationMessageId);
    }
    String $conversationId = record.get(1);
    if ($conversationId != null && $conversationId.length() > 0) {
      this.conversationId = Long.valueOf($conversationId);
    }
    String $userId = record.get(2);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $courseId = record.get(3);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(5);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $groupId = record.get(6);
    if ($groupId != null && $groupId.length() > 0) {
      this.groupId = Long.valueOf($groupId);
    }
    String $accountId = record.get(7);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $enrollmentRollupId = record.get(8);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
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

  /**
   * Foreign key to the message dimension for the associated message. 
   */
  public Long getConversationMessageId() {
    return this.conversationMessageId;
  }

  /**
   * Foreign key to the conversation dimension for the associated conversation 
   */
  public Long getConversationId() {
    return this.conversationId;
  }

  /**
   * Foreign key to the user dimension for the associated user 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * Foreign key to the course dimension for the associated course. 
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
   * Foreign Key to the course's account 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * tbd 
   */
  public Long getGroupId() {
    return this.groupId;
  }

  /**
   * tbd 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  /**
   * Foreign key to the enrollment rollup dimension table 
   */
  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
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
    fields.add(conversationMessageId);
    fields.add(conversationId);
    fields.add(userId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(groupId);
    fields.add(accountId);
    fields.add(enrollmentRollupId);
    fields.add(messageSizeBytes);
    fields.add(messageCharacterCount);
    fields.add(messageWordCount);
    fields.add(messageLineCount);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("conversation_message_id");
      fields.add("conversation_id");
      fields.add("user_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("group_id");
      fields.add("account_id");
      fields.add("enrollment_rollup_id");
      fields.add("message_size_bytes");
      fields.add("message_character_count");
      fields.add("message_word_count");
      fields.add("message_line_count");
    return fields;
  }
}
