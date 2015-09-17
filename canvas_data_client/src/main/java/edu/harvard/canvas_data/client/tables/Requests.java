package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class Requests extends CanvasDataTable {
  private String id;
  private ZonedDateTime timestamp;
  private String timestampYear;
  private String timestampMonth;
  private String timestampDay;
  private Long userId;
  private Long courseId;
  private Long rootAccountId;
  private Long courseAccountId;
  private Long quizId;
  private Long discussionId;
  private Long conversationId;
  private Long assignmentId;
  private String url;
  private String userAgent;
  private String httpMethod;
  private String remoteIp;
  private Long interactionMicros;
  private String webApplicationController;
  private String webApplicaitonAction;
  private String webApplicationContextType;
  private String webApplicationContextId;

  public Requests(final CSVRecord record) {
    this.id = record.get(0);
    String $timestamp = record.get(1);
    if ($timestamp != null && $timestamp.length() > 0) {
      this.timestamp = ZonedDateTime.parse($timestamp, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.timestampYear = record.get(2);
    this.timestampMonth = record.get(3);
    this.timestampDay = record.get(4);
    String $userId = record.get(5);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $courseId = record.get(6);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $rootAccountId = record.get(7);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $courseAccountId = record.get(8);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $quizId = record.get(9);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $discussionId = record.get(10);
    if ($discussionId != null && $discussionId.length() > 0) {
      this.discussionId = Long.valueOf($discussionId);
    }
    String $conversationId = record.get(11);
    if ($conversationId != null && $conversationId.length() > 0) {
      this.conversationId = Long.valueOf($conversationId);
    }
    String $assignmentId = record.get(12);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    this.url = record.get(13);
    this.userAgent = record.get(14);
    this.httpMethod = record.get(15);
    this.remoteIp = record.get(16);
    String $interactionMicros = record.get(17);
    if ($interactionMicros != null && $interactionMicros.length() > 0) {
      this.interactionMicros = Long.valueOf($interactionMicros);
    }
    this.webApplicationController = record.get(18);
    this.webApplicaitonAction = record.get(19);
    this.webApplicationContextType = record.get(20);
    this.webApplicationContextId = record.get(21);
  }

  public String getId() {
    return this.id;
  }

  public ZonedDateTime getTimestamp() {
    return this.timestamp;
  }

  public String getTimestampYear() {
    return this.timestampYear;
  }

  public String getTimestampMonth() {
    return this.timestampMonth;
  }

  public String getTimestampDay() {
    return this.timestampDay;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  public Long getQuizId() {
    return this.quizId;
  }

  public Long getDiscussionId() {
    return this.discussionId;
  }

  public Long getConversationId() {
    return this.conversationId;
  }

  public Long getAssignmentId() {
    return this.assignmentId;
  }

  public String getUrl() {
    return this.url;
  }

  public String getUserAgent() {
    return this.userAgent;
  }

  public String getHttpMethod() {
    return this.httpMethod;
  }

  public String getRemoteIp() {
    return this.remoteIp;
  }

  public Long getInteractionMicros() {
    return this.interactionMicros;
  }

  public String getWebApplicationController() {
    return this.webApplicationController;
  }

  public String getWebApplicaitonAction() {
    return this.webApplicaitonAction;
  }

  public String getWebApplicationContextType() {
    return this.webApplicationContextType;
  }

  public String getWebApplicationContextId() {
    return this.webApplicationContextId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(formatTimestamp(timestamp));
    fields.add(timestampYear);
    fields.add(timestampMonth);
    fields.add(timestampDay);
    fields.add(userId);
    fields.add(courseId);
    fields.add(rootAccountId);
    fields.add(courseAccountId);
    fields.add(quizId);
    fields.add(discussionId);
    fields.add(conversationId);
    fields.add(assignmentId);
    fields.add(url);
    fields.add(userAgent);
    fields.add(httpMethod);
    fields.add(remoteIp);
    fields.add(interactionMicros);
    fields.add(webApplicationController);
    fields.add(webApplicaitonAction);
    fields.add(webApplicationContextType);
    fields.add(webApplicationContextId);
    return fields;
  }
}
