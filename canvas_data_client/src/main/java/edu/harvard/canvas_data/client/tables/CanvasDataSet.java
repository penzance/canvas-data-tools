package edu.harvard.canvas_data.client.tables;

import java.io.File;
import java.io.IOException;

import edu.harvard.canvas_data.client.DataTable;
import edu.harvard.canvas_data.client.collation.ListDataTable;

public class CanvasDataSet {

  private final DataTable<DateDim> dateDim;
  private final DataTable<CourseDim> courseDim;
  private final DataTable<AccountDim> accountDim;
  private final DataTable<UserDim> userDim;
  private final DataTable<UserExpandedDim> userExpandedDim;
  private final DataTable<PseudonymDim> pseudonymDim;
  private final DataTable<PseudonymFact> pseudonymFact;
  private final DataTable<AssignmentDim> assignmentDim;
  private final DataTable<AssignmentFact> assignmentFact;
  private final DataTable<SubmissionDim> submissionDim;
  private final DataTable<SubmissionFact> submissionFact;
  private final DataTable<SubmissionCommentParticipantFact> submissionCommentParticipantFact;
  private final DataTable<SubmissionCommentParticipantDim> submissionCommentParticipantDim;
  private final DataTable<SubmissionCommentFact> submissionCommentFact;
  private final DataTable<SubmissionCommentDim> submissionCommentDim;
  private final DataTable<ConversationDim> conversationDim;
  private final DataTable<ConversationMessageDim> conversationMessageDim;
  private final DataTable<ConversationMessageParticipantFact> conversationMessageParticipantFact;
  private final DataTable<DiscussionTopicDim> discussionTopicDim;
  private final DataTable<DiscussionTopicFact> discussionTopicFact;
  private final DataTable<DiscussionEntryDim> discussionEntryDim;
  private final DataTable<DiscussionEntryFact> discussionEntryFact;
  private final DataTable<EnrollmentTermDim> enrollmentTermDim;
  private final DataTable<CourseSectionDim> courseSectionDim;
  private final DataTable<RoleDim> roleDim;
  private final DataTable<RoleExpandedDim> roleExpandedDim;
  private final DataTable<EnrollmentDim> enrollmentDim;
  private final DataTable<EnrollmentFact> enrollmentFact;
  private final DataTable<EnrollmentRollupDim> enrollmentRollupDim;
  private final DataTable<GroupDim> groupDim;
  private final DataTable<GroupFact> groupFact;
  private final DataTable<GroupMembershipFact> groupMembershipFact;
  private final DataTable<CourseUiNavigationDimDim> courseUiNavigationDimDim;
  private final DataTable<CourseUiCanvasNavigationDim> courseUiCanvasNavigationDim;
  private final DataTable<CourseUiCanvasNavigationExpandedDim> courseUiCanvasNavigationExpandedDim;
  private final DataTable<CourseUiNavigationItemDim> courseUiNavigationItemDim;
  private final DataTable<CourseUiNavigationItemFact> courseUiNavigationItemFact;
  private final DataTable<QuizSubmissionFact> quizSubmissionFact;
  private final DataTable<QuizDim> quizDim;
  private final DataTable<Requests> requests;
  private final DataTable<ExternalToolActivationDim> externalToolActivationDim;
  private final DataTable<ExternalToolActivationFact> externalToolActivationFact;
  private final DataTable<WikiDim> wikiDim;
  private final DataTable<WikiFact> wikiFact;
  private final DataTable<WikiPageDim> wikiPageDim;
  private final DataTable<WikiPageFact> wikiPageFact;

  public CanvasDataSet() {
    this.dateDim = new ListDataTable<DateDim>();
    this.courseDim = new ListDataTable<CourseDim>();
    this.accountDim = new ListDataTable<AccountDim>();
    this.userDim = new ListDataTable<UserDim>();
    this.userExpandedDim = new ListDataTable<UserExpandedDim>();
    this.pseudonymDim = new ListDataTable<PseudonymDim>();
    this.pseudonymFact = new ListDataTable<PseudonymFact>();
    this.assignmentDim = new ListDataTable<AssignmentDim>();
    this.assignmentFact = new ListDataTable<AssignmentFact>();
    this.submissionDim = new ListDataTable<SubmissionDim>();
    this.submissionFact = new ListDataTable<SubmissionFact>();
    this.submissionCommentParticipantFact = new ListDataTable<SubmissionCommentParticipantFact>();
    this.submissionCommentParticipantDim = new ListDataTable<SubmissionCommentParticipantDim>();
    this.submissionCommentFact = new ListDataTable<SubmissionCommentFact>();
    this.submissionCommentDim = new ListDataTable<SubmissionCommentDim>();
    this.conversationDim = new ListDataTable<ConversationDim>();
    this.conversationMessageDim = new ListDataTable<ConversationMessageDim>();
    this.conversationMessageParticipantFact = new ListDataTable<ConversationMessageParticipantFact>();
    this.discussionTopicDim = new ListDataTable<DiscussionTopicDim>();
    this.discussionTopicFact = new ListDataTable<DiscussionTopicFact>();
    this.discussionEntryDim = new ListDataTable<DiscussionEntryDim>();
    this.discussionEntryFact = new ListDataTable<DiscussionEntryFact>();
    this.enrollmentTermDim = new ListDataTable<EnrollmentTermDim>();
    this.courseSectionDim = new ListDataTable<CourseSectionDim>();
    this.roleDim = new ListDataTable<RoleDim>();
    this.roleExpandedDim = new ListDataTable<RoleExpandedDim>();
    this.enrollmentDim = new ListDataTable<EnrollmentDim>();
    this.enrollmentFact = new ListDataTable<EnrollmentFact>();
    this.enrollmentRollupDim = new ListDataTable<EnrollmentRollupDim>();
    this.groupDim = new ListDataTable<GroupDim>();
    this.groupFact = new ListDataTable<GroupFact>();
    this.groupMembershipFact = new ListDataTable<GroupMembershipFact>();
    this.courseUiNavigationDimDim = new ListDataTable<CourseUiNavigationDimDim>();
    this.courseUiCanvasNavigationDim = new ListDataTable<CourseUiCanvasNavigationDim>();
    this.courseUiCanvasNavigationExpandedDim = new ListDataTable<CourseUiCanvasNavigationExpandedDim>();
    this.courseUiNavigationItemDim = new ListDataTable<CourseUiNavigationItemDim>();
    this.courseUiNavigationItemFact = new ListDataTable<CourseUiNavigationItemFact>();
    this.quizSubmissionFact = new ListDataTable<QuizSubmissionFact>();
    this.quizDim = new ListDataTable<QuizDim>();
    this.requests = new ListDataTable<Requests>();
    this.externalToolActivationDim = new ListDataTable<ExternalToolActivationDim>();
    this.externalToolActivationFact = new ListDataTable<ExternalToolActivationFact>();
    this.wikiDim = new ListDataTable<WikiDim>();
    this.wikiFact = new ListDataTable<WikiFact>();
    this.wikiPageDim = new ListDataTable<WikiPageDim>();
    this.wikiPageFact = new ListDataTable<WikiPageFact>();
  }

  public void parseDataTable(final File gzipFile, final Table table, final TableClient tables)
      throws IOException, ParsedWithErrorsException {
    final DataTable<? extends CanvasDataTable> data = tables.parseCanvasDataFile(table, gzipFile);
    addData(data, table);
  }

  @SuppressWarnings("unchecked")
  public void addData(final DataTable<? extends CanvasDataTable> data, final Table table) {
    switch (table) {
    case DateDim:
      dateDim.addRecords((DataTable<DateDim>) data, DateDim.class);
      break;
    case CourseDim:
      courseDim.addRecords((DataTable<CourseDim>) data, CourseDim.class);
      break;
    case AccountDim:
      accountDim.addRecords((DataTable<AccountDim>) data, AccountDim.class);
      break;
    case UserDim:
      userDim.addRecords((DataTable<UserDim>) data, UserDim.class);
      break;
    case UserExpandedDim:
      userExpandedDim.addRecords((DataTable<UserExpandedDim>) data, UserExpandedDim.class);
      break;
    case PseudonymDim:
      pseudonymDim.addRecords((DataTable<PseudonymDim>) data, PseudonymDim.class);
      break;
    case PseudonymFact:
      pseudonymFact.addRecords((DataTable<PseudonymFact>) data, PseudonymFact.class);
      break;
    case AssignmentDim:
      assignmentDim.addRecords((DataTable<AssignmentDim>) data, AssignmentDim.class);
      break;
    case AssignmentFact:
      assignmentFact.addRecords((DataTable<AssignmentFact>) data, AssignmentFact.class);
      break;
    case SubmissionDim:
      submissionDim.addRecords((DataTable<SubmissionDim>) data, SubmissionDim.class);
      break;
    case SubmissionFact:
      submissionFact.addRecords((DataTable<SubmissionFact>) data, SubmissionFact.class);
      break;
    case SubmissionCommentParticipantFact:
      submissionCommentParticipantFact.addRecords(
          (DataTable<SubmissionCommentParticipantFact>) data,
          SubmissionCommentParticipantFact.class);
      break;
    case SubmissionCommentParticipantDim:
      submissionCommentParticipantDim.addRecords((DataTable<SubmissionCommentParticipantDim>) data,
          SubmissionCommentParticipantDim.class);
      break;
    case SubmissionCommentFact:
      submissionCommentFact.addRecords((DataTable<SubmissionCommentFact>) data,
          SubmissionCommentFact.class);
      break;
    case SubmissionCommentDim:
      submissionCommentDim.addRecords((DataTable<SubmissionCommentDim>) data,
          SubmissionCommentDim.class);
      break;
    case ConversationDim:
      conversationDim.addRecords((DataTable<ConversationDim>) data, ConversationDim.class);
      break;
    case ConversationMessageDim:
      conversationMessageDim.addRecords((DataTable<ConversationMessageDim>) data,
          ConversationMessageDim.class);
      break;
    case ConversationMessageParticipantFact:
      conversationMessageParticipantFact.addRecords(
          (DataTable<ConversationMessageParticipantFact>) data,
          ConversationMessageParticipantFact.class);
      break;
    case DiscussionTopicDim:
      discussionTopicDim.addRecords((DataTable<DiscussionTopicDim>) data, DiscussionTopicDim.class);
      break;
    case DiscussionTopicFact:
      discussionTopicFact.addRecords((DataTable<DiscussionTopicFact>) data,
          DiscussionTopicFact.class);
      break;
    case DiscussionEntryDim:
      discussionEntryDim.addRecords((DataTable<DiscussionEntryDim>) data, DiscussionEntryDim.class);
      break;
    case DiscussionEntryFact:
      discussionEntryFact.addRecords((DataTable<DiscussionEntryFact>) data,
          DiscussionEntryFact.class);
      break;
    case EnrollmentTermDim:
      enrollmentTermDim.addRecords((DataTable<EnrollmentTermDim>) data, EnrollmentTermDim.class);
      break;
    case CourseSectionDim:
      courseSectionDim.addRecords((DataTable<CourseSectionDim>) data, CourseSectionDim.class);
      break;
    case RoleDim:
      roleDim.addRecords((DataTable<RoleDim>) data, RoleDim.class);
      break;
    case RoleExpandedDim:
      roleExpandedDim.addRecords((DataTable<RoleExpandedDim>) data, RoleExpandedDim.class);
      break;
    case EnrollmentDim:
      enrollmentDim.addRecords((DataTable<EnrollmentDim>) data, EnrollmentDim.class);
      break;
    case EnrollmentFact:
      enrollmentFact.addRecords((DataTable<EnrollmentFact>) data, EnrollmentFact.class);
      break;
    case EnrollmentRollupDim:
      enrollmentRollupDim.addRecords((DataTable<EnrollmentRollupDim>) data,
          EnrollmentRollupDim.class);
      break;
    case GroupDim:
      groupDim.addRecords((DataTable<GroupDim>) data, GroupDim.class);
      break;
    case GroupFact:
      groupFact.addRecords((DataTable<GroupFact>) data, GroupFact.class);
      break;
    case GroupMembershipFact:
      groupMembershipFact.addRecords((DataTable<GroupMembershipFact>) data,
          GroupMembershipFact.class);
      break;
    case CourseUiNavigationDimDim:
      courseUiNavigationDimDim.addRecords((DataTable<CourseUiNavigationDimDim>) data,
          CourseUiNavigationDimDim.class);
      break;
    case CourseUiCanvasNavigationDim:
      courseUiCanvasNavigationDim.addRecords((DataTable<CourseUiCanvasNavigationDim>) data,
          CourseUiCanvasNavigationDim.class);
      break;
    case CourseUiCanvasNavigationExpandedDim:
      courseUiCanvasNavigationExpandedDim.addRecords(
          (DataTable<CourseUiCanvasNavigationExpandedDim>) data,
          CourseUiCanvasNavigationExpandedDim.class);
      break;
    case CourseUiNavigationItemDim:
      courseUiNavigationItemDim.addRecords((DataTable<CourseUiNavigationItemDim>) data,
          CourseUiNavigationItemDim.class);
      break;
    case CourseUiNavigationItemFact:
      courseUiNavigationItemFact.addRecords((DataTable<CourseUiNavigationItemFact>) data,
          CourseUiNavigationItemFact.class);
      break;
    case QuizSubmissionFact:
      quizSubmissionFact.addRecords((DataTable<QuizSubmissionFact>) data, QuizSubmissionFact.class);
      break;
    case QuizDim:
      quizDim.addRecords((DataTable<QuizDim>) data, QuizDim.class);
      break;
    case Requests:
      requests.addRecords((DataTable<Requests>) data, Requests.class);
      break;
    case ExternalToolActivationDim:
      externalToolActivationDim.addRecords((DataTable<ExternalToolActivationDim>) data,
          ExternalToolActivationDim.class);
      break;
    case ExternalToolActivationFact:
      externalToolActivationFact.addRecords((DataTable<ExternalToolActivationFact>) data,
          ExternalToolActivationFact.class);
      break;
    case WikiDim:
      wikiDim.addRecords((DataTable<WikiDim>) data, WikiDim.class);
      break;
    case WikiFact:
      wikiFact.addRecords((DataTable<WikiFact>) data, WikiFact.class);
      break;
    case WikiPageDim:
      wikiPageDim.addRecords((DataTable<WikiPageDim>) data, WikiPageDim.class);
      break;
    case WikiPageFact:
      wikiPageFact.addRecords((DataTable<WikiPageFact>) data, WikiPageFact.class);
      break;
    }
  }

  public DataTable<DateDim> getDateDim() {
    return dateDim;
  }

  public DataTable<CourseDim> getCourseDim() {
    return courseDim;
  }

  public DataTable<AccountDim> getAccountDim() {
    return accountDim;
  }

  public DataTable<UserDim> getUserDim() {
    return userDim;
  }

  public DataTable<UserExpandedDim> getUserExpandedDim() {
    return userExpandedDim;
  }

  public DataTable<PseudonymDim> getPseudonymDim() {
    return pseudonymDim;
  }

  public DataTable<PseudonymFact> getPseudonymFact() {
    return pseudonymFact;
  }

  public DataTable<AssignmentDim> getAssignmentDim() {
    return assignmentDim;
  }

  public DataTable<AssignmentFact> getAssignmentFact() {
    return assignmentFact;
  }

  public DataTable<SubmissionDim> getSubmissionDim() {
    return submissionDim;
  }

  public DataTable<SubmissionFact> getSubmissionFact() {
    return submissionFact;
  }

  public DataTable<SubmissionCommentParticipantFact> getSubmissionCommentParticipantFact() {
    return submissionCommentParticipantFact;
  }

  public DataTable<SubmissionCommentParticipantDim> getSubmissionCommentParticipantDim() {
    return submissionCommentParticipantDim;
  }

  public DataTable<SubmissionCommentFact> getSubmissionCommentFact() {
    return submissionCommentFact;
  }

  public DataTable<SubmissionCommentDim> getSubmissionCommentDim() {
    return submissionCommentDim;
  }

  public DataTable<ConversationDim> getConversationDim() {
    return conversationDim;
  }

  public DataTable<ConversationMessageDim> getConversationMessageDim() {
    return conversationMessageDim;
  }

  public DataTable<ConversationMessageParticipantFact> getConversationMessageParticipantFact() {
    return conversationMessageParticipantFact;
  }

  public DataTable<DiscussionTopicDim> getDiscussionTopicDim() {
    return discussionTopicDim;
  }

  public DataTable<DiscussionTopicFact> getDiscussionTopicFact() {
    return discussionTopicFact;
  }

  public DataTable<DiscussionEntryDim> getDiscussionEntryDim() {
    return discussionEntryDim;
  }

  public DataTable<DiscussionEntryFact> getDiscussionEntryFact() {
    return discussionEntryFact;
  }

  public DataTable<EnrollmentTermDim> getEnrollmentTermDim() {
    return enrollmentTermDim;
  }

  public DataTable<CourseSectionDim> getCourseSectionDim() {
    return courseSectionDim;
  }

  public DataTable<RoleDim> getRoleDim() {
    return roleDim;
  }

  public DataTable<RoleExpandedDim> getRoleExpandedDim() {
    return roleExpandedDim;
  }

  public DataTable<EnrollmentDim> getEnrollmentDim() {
    return enrollmentDim;
  }

  public DataTable<EnrollmentFact> getEnrollmentFact() {
    return enrollmentFact;
  }

  public DataTable<EnrollmentRollupDim> getEnrollmentRollupDim() {
    return enrollmentRollupDim;
  }

  public DataTable<GroupDim> getGroupDim() {
    return groupDim;
  }

  public DataTable<GroupFact> getGroupFact() {
    return groupFact;
  }

  public DataTable<GroupMembershipFact> getGroupMembershipFact() {
    return groupMembershipFact;
  }

  public DataTable<CourseUiNavigationDimDim> getCourseUiNavigationDimDim() {
    return courseUiNavigationDimDim;
  }

  public DataTable<CourseUiCanvasNavigationDim> getCourseUiCanvasNavigationDim() {
    return courseUiCanvasNavigationDim;
  }

  public DataTable<CourseUiCanvasNavigationExpandedDim> getCourseUiCanvasNavigationExpandedDim() {
    return courseUiCanvasNavigationExpandedDim;
  }

  public DataTable<CourseUiNavigationItemDim> getCourseUiNavigationItemDim() {
    return courseUiNavigationItemDim;
  }

  public DataTable<CourseUiNavigationItemFact> getCourseUiNavigationItemFact() {
    return courseUiNavigationItemFact;
  }

  public DataTable<QuizSubmissionFact> getQuizSubmissionFact() {
    return quizSubmissionFact;
  }

  public DataTable<QuizDim> getQuizDim() {
    return quizDim;
  }

  public DataTable<Requests> getRequests() {
    return requests;
  }

  public DataTable<ExternalToolActivationDim> getExternalToolActivationDim() {
    return externalToolActivationDim;
  }

  public DataTable<ExternalToolActivationFact> getExternalToolActivationFact() {
    return externalToolActivationFact;
  }

  public DataTable<WikiDim> getWikiDim() {
    return wikiDim;
  }

  public DataTable<WikiFact> getWikiFact() {
    return wikiFact;
  }

  public DataTable<WikiPageDim> getWikiPageDim() {
    return wikiPageDim;
  }

  public DataTable<WikiPageFact> getWikiPageFact() {
    return wikiPageFact;
  }

  public void write(final File dir, final boolean headers, final boolean gzip) throws IOException {
    if (dateDim.size() > 0) {
      dateDim.writeCanvasDataFormat(new File(dir, "date_dim/date_dim.gz"), headers, gzip);
    }
    if (courseDim.size() > 0) {
      courseDim.writeCanvasDataFormat(new File(dir, "course_dim/course_dim.gz"), headers, gzip);
    }
    if (accountDim.size() > 0) {
      accountDim.writeCanvasDataFormat(new File(dir, "account_dim/account_dim.gz"), headers, gzip);
    }
    if (userDim.size() > 0) {
      userDim.writeCanvasDataFormat(new File(dir, "user_dim/user_dim.gz"), headers, gzip);
    }
    if (userExpandedDim.size() > 0) {
      userExpandedDim.writeCanvasDataFormat(new File(dir, "user_expanded_dim/user_expanded_dim.gz"),
          headers, gzip);
    }
    if (pseudonymDim.size() > 0) {
      pseudonymDim.writeCanvasDataFormat(new File(dir, "pseudonym_dim/pseudonym_dim.gz"), headers, gzip);
    }
    if (pseudonymFact.size() > 0) {
      pseudonymFact.writeCanvasDataFormat(new File(dir, "pseudonym_fact/pseudonym_fact.gz"), headers, gzip);
    }
    if (assignmentDim.size() > 0) {
      assignmentDim.writeCanvasDataFormat(new File(dir, "assignment_dim/assignment_dim.gz"), headers, gzip);
    }
    if (assignmentFact.size() > 0) {
      assignmentFact.writeCanvasDataFormat(new File(dir, "assignment_fact/assignment_fact.gz"),
          headers, gzip);
    }
    if (submissionDim.size() > 0) {
      submissionDim.writeCanvasDataFormat(new File(dir, "submission_dim/submission_dim.gz"), headers, gzip);
    }
    if (submissionFact.size() > 0) {
      submissionFact.writeCanvasDataFormat(new File(dir, "submission_fact/submission_fact.gz"),
          headers, gzip);
    }
    if (submissionCommentParticipantFact.size() > 0) {
      submissionCommentParticipantFact.writeCanvasDataFormat(new File(dir,
          "submission_comment_participant_fact/submission_comment_participant_fact.gz"), headers, gzip);
    }
    if (submissionCommentParticipantDim.size() > 0) {
      submissionCommentParticipantDim.writeCanvasDataFormat(
          new File(dir, "submission_comment_participant_dim/submission_comment_participant_dim.gz"),
          headers, gzip);
    }
    if (submissionCommentFact.size() > 0) {
      submissionCommentFact.writeCanvasDataFormat(
          new File(dir, "submission_comment_fact/submission_comment_fact.gz"), headers, gzip);
    }
    if (submissionCommentDim.size() > 0) {
      submissionCommentDim.writeCanvasDataFormat(
          new File(dir, "submission_comment_dim/submission_comment_dim.gz"), headers, gzip);
    }
    if (conversationDim.size() > 0) {
      conversationDim.writeCanvasDataFormat(new File(dir, "conversation_dim/conversation_dim.gz"),
          headers, gzip);
    }
    if (conversationMessageDim.size() > 0) {
      conversationMessageDim.writeCanvasDataFormat(
          new File(dir, "conversation_message_dim/conversation_message_dim.gz"), headers, gzip);
    }
    if (conversationMessageParticipantFact.size() > 0) {
      conversationMessageParticipantFact.writeCanvasDataFormat(
          new File(dir,
              "conversation_message_participant_fact/conversation_message_participant_fact.gz"),
          headers, gzip);
    }
    if (discussionTopicDim.size() > 0) {
      discussionTopicDim.writeCanvasDataFormat(
          new File(dir, "discussion_topic_dim/discussion_topic_dim.gz"), headers, gzip);
    }
    if (discussionTopicFact.size() > 0) {
      discussionTopicFact.writeCanvasDataFormat(
          new File(dir, "discussion_topic_fact/discussion_topic_fact.gz"), headers, gzip);
    }
    if (discussionEntryDim.size() > 0) {
      discussionEntryDim.writeCanvasDataFormat(
          new File(dir, "discussion_entry_dim/discussion_entry_dim.gz"), headers, gzip);
    }
    if (discussionEntryFact.size() > 0) {
      discussionEntryFact.writeCanvasDataFormat(
          new File(dir, "discussion_entry_fact/discussion_entry_fact.gz"), headers, gzip);
    }
    if (enrollmentTermDim.size() > 0) {
      enrollmentTermDim
      .writeCanvasDataFormat(new File(dir, "enrollment_term_dim/enrollment_term_dim.gz"), headers, gzip);
    }
    if (courseSectionDim.size() > 0) {
      courseSectionDim
      .writeCanvasDataFormat(new File(dir, "course_section_dim/course_section_dim.gz"), headers, gzip);
    }
    if (roleDim.size() > 0) {
      roleDim.writeCanvasDataFormat(new File(dir, "role_dim/role_dim.gz"), headers, gzip);
    }
    if (roleExpandedDim.size() > 0) {
      roleExpandedDim.writeCanvasDataFormat(new File(dir, "role_expanded_dim/role_expanded_dim.gz"),
          headers, gzip);
    }
    if (enrollmentDim.size() > 0) {
      enrollmentDim.writeCanvasDataFormat(new File(dir, "enrollment_dim/enrollment_dim.gz"), headers, gzip);
    }
    if (enrollmentFact.size() > 0) {
      enrollmentFact.writeCanvasDataFormat(new File(dir, "enrollment_fact/enrollment_fact.gz"),
          headers, gzip);
    }
    if (enrollmentRollupDim.size() > 0) {
      enrollmentRollupDim.writeCanvasDataFormat(
          new File(dir, "enrollment_rollup_dim/enrollment_rollup_dim.gz"), headers, gzip);
    }
    if (groupDim.size() > 0) {
      groupDim.writeCanvasDataFormat(new File(dir, "group_dim/group_dim.gz"), headers, gzip);
    }
    if (groupFact.size() > 0) {
      groupFact.writeCanvasDataFormat(new File(dir, "group_fact/group_fact.gz"), headers, gzip);
    }
    if (groupMembershipFact.size() > 0) {
      groupMembershipFact.writeCanvasDataFormat(
          new File(dir, "group_membership_fact/group_membership_fact.gz"), headers, gzip);
    }
    if (courseUiNavigationDimDim.size() > 0) {
      courseUiNavigationDimDim.writeCanvasDataFormat(
          new File(dir, "course_ui_navigation_dim_dim/course_ui_navigation_dim_dim.gz"), headers, gzip);
    }
    if (courseUiCanvasNavigationDim.size() > 0) {
      courseUiCanvasNavigationDim.writeCanvasDataFormat(
          new File(dir, "course_ui_canvas_navigation_dim/course_ui_canvas_navigation_dim.gz"),
          headers, gzip);
    }
    if (courseUiCanvasNavigationExpandedDim.size() > 0) {
      courseUiCanvasNavigationExpandedDim.writeCanvasDataFormat(
          new File(dir,
              "course_ui_canvas_navigation_expanded_dim/course_ui_canvas_navigation_expanded_dim.gz"),
          headers, gzip);
    }
    if (courseUiNavigationItemDim.size() > 0) {
      courseUiNavigationItemDim.writeCanvasDataFormat(
          new File(dir, "course_ui_navigation_item_dim/course_ui_navigation_item_dim.gz"), headers, gzip);
    }
    if (courseUiNavigationItemFact.size() > 0) {
      courseUiNavigationItemFact.writeCanvasDataFormat(
          new File(dir, "course_ui_navigation_item_fact/course_ui_navigation_item_fact.gz"), headers, gzip);
    }
    if (quizSubmissionFact.size() > 0) {
      quizSubmissionFact.writeCanvasDataFormat(
          new File(dir, "quiz_submission_fact/quiz_submission_fact.gz"), headers, gzip);
    }
    if (quizDim.size() > 0) {
      quizDim.writeCanvasDataFormat(new File(dir, "quiz_dim/quiz_dim.gz"), headers, gzip);
    }
    if (requests.size() > 0) {
      requests.writeCanvasDataFormat(new File(dir, "requests/requests.gz"), headers, gzip);
    }
    if (externalToolActivationDim.size() > 0) {
      externalToolActivationDim.writeCanvasDataFormat(
          new File(dir, "external_tool_activation_dim/external_tool_activation_dim.gz"), headers, gzip);
    }
    if (externalToolActivationFact.size() > 0) {
      externalToolActivationFact.writeCanvasDataFormat(
          new File(dir, "external_tool_activation_fact/external_tool_activation_fact.gz"), headers, gzip);
    }
    if (wikiDim.size() > 0) {
      wikiDim.writeCanvasDataFormat(new File(dir, "wiki_dim/wiki_dim.gz"), headers, gzip);
    }
    if (wikiFact.size() > 0) {
      wikiFact.writeCanvasDataFormat(new File(dir, "wiki_fact/wiki_fact.gz"), headers, gzip);
    }
    if (wikiPageDim.size() > 0) {
      wikiPageDim.writeCanvasDataFormat(new File(dir, "wiki_page_dim/wiki_page_dim.gz"), headers, gzip);
    }
    if (wikiPageFact.size() > 0) {
      wikiPageFact.writeCanvasDataFormat(new File(dir, "wiki_page_fact/wiki_page_fact.gz"), headers, gzip);
    }
  }

}
