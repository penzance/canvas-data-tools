package edu.harvard.canvas_data.analysis;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVPrinter;

import edu.harvard.canvas_data.analysis.Histogram.SortOrder;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.TableReader;
import edu.harvard.data.client.analysis_utils.UserAgentParser;
import edu.harvard.data.client.canvas.tables.Requests;
import net.sf.uadetector.ReadableUserAgent;

public class RequestAnalysis {

  private static final Logger log = Logger.getLogger("Canvas Data");

  private final Histogram<Long> userRequests;
  private final Histogram<String> controllers;
  private final Histogram<String> actions;
  private final Histogram<Integer> hours;
  private final Histogram<Integer> minutes;
  private final Histogram<DayOfWeek> localDays;
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
  private final Histogram<String> browsers;
  private final Histogram<String> os;
  private final UserAgentParser uaParser;
  private final Map<DayOfWeek, Histogram<Integer>> minuteOfDayPerDay;

  public RequestAnalysis() {
    this.userRequests = new Histogram<Long>("user_id");
    this.controllers = new Histogram<String>("controller");
    this.actions = new Histogram<String>("action");
    this.hours = new Histogram<Integer>("hour_of_day");
    this.minutes = new Histogram<Integer>("minute_of_day");
    this.urls = new Histogram<String>("url");
    this.userAgents = new Histogram<String>("user_agent");
    this.localDates = new Histogram<String>("date");
    this.localDays = new Histogram<DayOfWeek>("day_of_week");
    this.courses = new Histogram<Long>("course_id");
    this.discussions = new Histogram<Long>("discussion_id");
    this.quizzes = new Histogram<Long>("quiz_id");
    this.assignments = new Histogram<Long>("assignment_id");
    this.conversations = new Histogram<Long>("conversation_id");
    this.accounts = new Histogram<Long>("account_id");
    this.userIps = new HashMap<Long, Histogram<String>>();
    this.browsers = new Histogram<String>("browser");
    this.os = new Histogram<String>("os");
    this.uaParser = new UserAgentParser();
    this.minuteOfDayPerDay = new HashMap<DayOfWeek, Histogram<Integer>>();
    for (final DayOfWeek day : DayOfWeek.values()) {
      minuteOfDayPerDay.put(day, new Histogram<Integer>("minute_of_day"));
    }
  }

  private void analyzeRequest(final Requests request) {
    final DateTimeFormatter localFormatter = FormatLibrary.LOCAL_DATE_FORMAT;
    userRequests.put(request.getUserId());
    controllers.put(request.getWebApplicationController());
    actions.put(request.getWebApplicationController() + "." + request.getWebApplicaitonAction());
    hours.put(request.getTimestamp().getHour());
    final int minute = (request.getTimestamp().getHour() * 60) + request.getTimestamp().getMinute();
    minutes.put(minute);
    urls.put(request.getUrl());
    localDates.put(request.getTimestamp().format(localFormatter));
    // TODO: this doesn't account for requests made during DST
    final DayOfWeek localDayOfWeek = request.getTimestamp().toLocalDate().getDayOfWeek();
    localDays.put(localDayOfWeek);
    minuteOfDayPerDay.get(localDayOfWeek).put(minute);
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
      accounts.put(request.getRootAccountId());
    }
    addUserIp(request);
    parseUserAgent(request);
  }

  public static RequestAnalysis analyseDataSet(final DataSetReader inputDataSet) {
    final RequestAnalysis analysis = new RequestAnalysis();
    final TableReader<Requests> in = inputDataSet.getTable("requests", Requests.class);
    long records = 0;
    for (final Requests request : in) {
      analysis.analyzeRequest(request);
      records++;
    }
    log.info("Analyzed " + records + " requests");
    return analysis;
  }

  public static Map<Long, RequestAnalysis> analyseDataSetPerAccount(final DataSetReader inputDataSet) {
    final Map<Long, RequestAnalysis> perAccount = new HashMap<Long, RequestAnalysis>();
    final TableReader<Requests> in = inputDataSet.getTable("requests", Requests.class);
    long records = 0;
    for (final Requests request : in) {
      final Long account = request.getRootAccountId();
      if (!perAccount.containsKey(account)) {
        perAccount.put(account, new RequestAnalysis());
      }
      perAccount.get(account).analyzeRequest(request);
      records++;
    }
    log.info("Analyzed " + records + " requests");
    return perAccount;
  }

  private void parseUserAgent(final Requests request) {
    final String agentString = request.getUserAgent();
    userAgents.put(agentString);
    if (agentString != null) {
      final ReadableUserAgent agent = uaParser.parse(agentString);
      browsers.put(agent.getName());
      os.put(agent.getOperatingSystem().getName());
    }
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

  public void dumpOutput(final Path dir, final TableFormat tableFormat) throws IOException {
    if (!Files.exists(dir)) {
      Files.createDirectories(dir);
    }
    final String ext = tableFormat.getExtension();
    actions.write(dir.resolve("requestsPerAction" + ext), tableFormat, SortOrder.Value);
    controllers.write(dir.resolve("requestsPerController" + ext), tableFormat, SortOrder.Value);
    hours.write(dir.resolve("requestsPerHour" + ext), tableFormat, SortOrder.Key);
    minutes.write(dir.resolve("requestsPerMinute" + ext), tableFormat, SortOrder.Key);
    userRequests.write(dir.resolve("requestsPerUser" + ext), tableFormat, SortOrder.Value);
    urls.write(dir.resolve("requestsPerUrl" + ext), tableFormat, SortOrder.Value);
    userAgents.write(dir.resolve("requestsPerUserAgent" + ext), tableFormat, SortOrder.Value);
    localDates.write(dir.resolve("requestsPerLocalDate" + ext), tableFormat, SortOrder.Key);
    courses.write(dir.resolve("requestsPerCourse" + ext), tableFormat, SortOrder.Value);
    discussions.write(dir.resolve("requestsPerDiscussion" + ext), tableFormat, SortOrder.Value);
    quizzes.write(dir.resolve("requestsPerQuiz" + ext), tableFormat, SortOrder.Value);
    assignments.write(dir.resolve("requestsPerAssignment" + ext), tableFormat, SortOrder.Value);
    conversations.write(dir.resolve("requestsPerConversation" + ext), tableFormat, SortOrder.Value);
    accounts.write(dir.resolve("requestsPerAccount" + ext), tableFormat, SortOrder.Key);
    browsers.write(dir.resolve("requestsPerBrowser" + ext), tableFormat, SortOrder.Value);
    os.write(dir.resolve("requestsPerOS" + ext), tableFormat, SortOrder.Value);
    localDays.write(dir.resolve("requestsPerDayOfWeek" + ext), tableFormat, SortOrder.Key);
    writeUserIps(dir, tableFormat);
  }

  private void writeUserIps(final Path dir, final TableFormat tableFormat) throws IOException {
    final Path totalFile = dir.resolve("ipCountPerUser" + tableFormat.getExtension());
    final Path detailFile = dir.resolve("ipsPerUser" + tableFormat.getExtension());
    try (OutputStream totalOut = tableFormat.getOutputStream(totalFile);
        OutputStream detailOut = tableFormat.getOutputStream(detailFile);
        CSVPrinter totalPrinter = new CSVPrinter(new OutputStreamWriter(totalOut), tableFormat.getCsvFormat());
        CSVPrinter detailPrinter = new CSVPrinter(new OutputStreamWriter(detailOut), tableFormat.getCsvFormat())) {
      for (final Long user : userIps.keySet()) {
        final Histogram<String> ips = userIps.get(user);
        totalPrinter.printRecord(user, ips.size());
        for (final String ip : ips.keySet()) {
          detailPrinter.printRecord(user, ip, ips.get(ip));
        }
      }
    }
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

  public Histogram<String> getBrowsers() {
    return browsers;
  }

  public Histogram<String> getOperatingSystems() {
    return os;
  }

  public Histogram<DayOfWeek> getDaysOfWeek() {
    return localDays;
  }
}
