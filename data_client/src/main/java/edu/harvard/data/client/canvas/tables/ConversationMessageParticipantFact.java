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
  private Long userAccountId;
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
    String $userAccountId = record.get(3);
    if ($userAccountId != null && $userAccountId.length() > 0) {
      this.userAccountId = Long.valueOf($userAccountId);
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
    String $groupId = record.get(7);
    if ($groupId != null && $groupId.length() > 0) {
      this.groupId = Long.valueOf($groupId);
    }
    String $accountId = record.get(8);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $enrollmentRollupId = record.get(9);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
    String $messageSizeBytes = record.get(10);
    if ($messageSizeBytes != null && $messageSizeBytes.length() > 0) {
      this.messageSizeBytes = Integer.valueOf($messageSizeBytes);
    }
    String $messageCharacterCount = record.get(11);
    if ($messageCharacterCount != null && $messageCharacterCount.length() > 0) {
      this.messageCharacterCount = Integer.valueOf($messageCharacterCount);
    }
    String $messageWordCount = record.get(12);
    if ($messageWordCount != null && $messageWordCount.length() > 0) {
      this.messageWordCount = Integer.valueOf($messageWordCount);
    }
    String $messageLineCount = record.get(13);
    if ($messageLineCount != null && $messageLineCount.length() > 0) {
      this.messageLineCount = Integer.valueOf($messageLineCount);
    }
  }

  public Long getConversationMessageId() {
    return this.conversationMessageId;
  }

  public Long getConversationId() {
    return this.conversationId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getUserAccountId() {
    return this.userAccountId;
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

  public Long getGroupId() {
    return this.groupId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
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
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(conversationMessageId);
    fields.add(conversationId);
    fields.add(userId);
    fields.add(userAccountId);
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
      fields.add("user_account_id");
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
