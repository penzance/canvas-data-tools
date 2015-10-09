package edu.harvard.canvas_data.analysis;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.canvas.tables.Requests;

public class RequestAnalysis {

  private static final Logger log = Logger.getLogger("Canvas Data");

  private final Histogram<Long> userRequests;
  private final Histogram<String> controllers;
  private final Histogram<String> actions;
  private final Histogram<Integer> hours;
  private final Histogram<Integer> minutes;
  private final Histogram<String> urls;
  private final Histogram<String> userAgents;
  private final Histogram<String> localDates;
  private final Map<Long, Histogram<String>> userIps;

  private final Histogram<Long> courses;

  private final Histogram<Long> discussions;

  private final Histogram<Long> quizzes;

  private final Histogram<Long> assignments;

  private final Histogram<Long> conversations;

  private final Histogram<Long> accounts;

  public RequestAnalysis() {
    this.userRequests = new Histogram<Long>("user_id");
    this.controllers = new Histogram<String>("controller");
    this.actions = new Histogram<String>("action");
    this.hours = new Histogram<Integer>("hour_of_day");
    this.minutes = new Histogram<Integer>("minute_of_day");
    this.urls = new Histogram<String>("url");
    this.userAgents = new Histogram<String>("user_agent");
    this.localDates = new Histogram<String>("user_agent");
    this.courses = new Histogram<Long>("course_id");
    this.discussions = new Histogram<Long>("discussion_id");
    this.quizzes = new Histogram<Long>("quiz_id");
    this.assignments = new Histogram<Long>("assignment_id");
    this.conversations = new Histogram<Long>("conversation_id");
    this.accounts = new Histogram<Long>("account_id");
    this.userIps = new HashMap<Long, Histogram<String>>();
  }

  public void analyzeRequests(final DataSetReader inputDataSet) {
    final TableReader<Requests> in = inputDataSet.getTable("requests", Requests.class);
    long records = 0;
    final DateTimeFormatter localFormatter = FormatLibrary.LOCAL_DATE_FORMAT;
    for (final Requests request : in) {
      userRequests.put(request.getUserId());
      controllers.put(request.getWebApplicationController());
      actions.put(request.getWebApplicationController() + "." + request.getWebApplicaitonAction());
      hours.put(request.getTimestamp().getHour());
      minutes.put((request.getTimestamp().getHour() * 60) + request.getTimestamp().getMinute());
      urls.put(request.getUrl());
      userAgents.put(request.getUserAgent());
      localDates.put(request.getTimestamp().format(localFormatter));
      if (request.getCourseId() != null) {
        courses.put(request.getCourseId());
      }
      if (request.getDiscussionId() != null) {
        discussions.put(request.getDiscussionId());
      }
      if (request.getQuizId() != null) {
        quizzes.put(request.getQuizId());
      }
      if (request.getAssignmentId() != null) {
        assignments.put(request.getAssignmentId());
      }
      if (request.getConversationId() != null) {
        conversations.put(request.getConversationId());
      }
      if (request.getCourseAccountId() != null) {
        accounts.put(request.getCourseAccountId());
      }
      addUserIp(request);
      records++;
    }
    log.info("Analyzed " + records + " requests");
  }

  private void addUserIp(final Requests request) {
    final Long userId = request.getUserId();
    if (userId == null) {
      return;
    }
    if (!userIps.containsKey(userId)) {
      userIps.put(userId, new Histogram<String>("ip_address"));
    }
    userIps.get(userId).put(request.getRemoteIp());
  }

  public Histogram<Long> getUserRequests() {
    return userRequests;
  }

  public Histogram<String> getControllers() {
    return controllers;
  }

  public Histogram<String> getActions() {
    return actions;
  }

  public Histogram<Integer> getHours() {
    return hours;
  }

  public Histogram<Integer> getMinutes() {
    return minutes;
  }

  public Histogram<String> getUrls() {
    return urls;
  }

  public Histogram<String> getUserAgents() {
    return userAgents;
  }

  public Histogram<String> getLocalDates() {
    return localDates;
  }

  public Map<Long, Histogram<String>> getUserIps() {
    return userIps;
  }

  public Histogram<Long> getCourses() {
    return courses;
  }

  public Histogram<Long> getDiscussions() {
    return discussions;
  }

  public Histogram<Long> getQuizzes() {
    return quizzes;
  }

  public Histogram<Long> getAssignments() {
    return assignments;
  }

  public Histogram<Long> getConversations() {
    return conversations;
  }

  public Histogram<Long> getAccounts() {
    return accounts;
  }

}
