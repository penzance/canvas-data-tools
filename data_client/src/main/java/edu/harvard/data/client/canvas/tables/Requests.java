// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class Requests implements DataTable {
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

  public Requests(final TableFormat format, final CSVRecord record) {
    this.id = record.get(0);
    String $timestamp = record.get(1);
    if ($timestamp != null && $timestamp.length() > 0) {
      this.timestamp = ZonedDateTime.parse($timestamp, format.getTimstampFormat());
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

  /**
   * the request ID assigned by the canvas system 
   */
  public String getId() {
    return this.id;
  }

  /**
   * timestamp when the request was made in UTC 
   */
  public ZonedDateTime getTimestamp() {
    return this.timestamp;
  }

  /**
   * year when the request was made 
   */
  public String getTimestampYear() {
    return this.timestampYear;
  }

  /**
   * month when the request was made 
   */
  public String getTimestampMonth() {
    return this.timestampMonth;
  }

  /**
   * day when the request was made 
   */
  public String getTimestampDay() {
    return this.timestampDay;
  }

  /**
   * The foreign key in user_dim for the user that made the request. 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * The foreign key in course_dim for the course that owned the page requested 
   * (NULL if not applicable) 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * The foreign key in account_dim for the root account on which this request 
   * was made 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * The foreign key in account_dim for the account the associated course is 
   * owned by. 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Quiz foreign key if page request is for a quiz, otherwise NULL 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Discussion foreign key if page request is for a discussion, otherwise NULL 
   */
  public Long getDiscussionId() {
    return this.discussionId;
  }

  /**
   * Conversation foreign key if page request is for a conversation, otherwise 
   * NULL 
   */
  public Long getConversationId() {
    return this.conversationId;
  }

  /**
   * Assignment foreign key if page request is for an assingnment, otherwise 
   * NULL 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * first 256 characters of the requested URL 
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * first 256 characters of the User Agent header received from the users 
   * browser/client software. 
   */
  public String getUserAgent() {
    return this.userAgent;
  }

  /**
   * HTTP method/verb (GET,PUT,POST etc.) that was sent with the request 
   */
  public String getHttpMethod() {
    return this.httpMethod;
  }

  /**
   * IP address that was recorded from the request. 
   */
  public String getRemoteIp() {
    return this.remoteIp;
  }

  /**
   * Total time required to service the request in microseconds. 
   */
  public Long getInteractionMicros() {
    return this.interactionMicros;
  }

  /**
   * The controller the Canvas web application used to service this request 
   */
  public String getWebApplicationController() {
    return this.webApplicationController;
  }

  /**
   * The controller the Canvas web application used to service this request 
   */
  public String getWebApplicaitonAction() {
    return this.webApplicaitonAction;
  }

  /**
   * The containing object type the Canvas web application used to service this 
   * request 
   */
  public String getWebApplicationContextType() {
    return this.webApplicationContextType;
  }

  /**
   * The containing object's id the Canvas web application used to service this 
   * request 
   */
  public String getWebApplicationContextId() {
    return this.webApplicationContextId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(formatter.formatTimestamp(timestamp));
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

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("timestamp");
      fields.add("timestamp_year");
      fields.add("timestamp_month");
      fields.add("timestamp_day");
      fields.add("user_id");
      fields.add("course_id");
      fields.add("root_account_id");
      fields.add("course_account_id");
      fields.add("quiz_id");
      fields.add("discussion_id");
      fields.add("conversation_id");
      fields.add("assignment_id");
      fields.add("url");
      fields.add("user_agent");
      fields.add("http_method");
      fields.add("remote_ip");
      fields.add("interaction_micros");
      fields.add("web_application_controller");
      fields.add("web_applicaiton_action");
      fields.add("web_application_context_type");
      fields.add("web_application_context_id");
    return fields;
  }
}
