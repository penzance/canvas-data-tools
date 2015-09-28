package edu.harvard.canvas_data.client.tables;

public enum Table {
  AccountDim("account_dim", AccountDim.class),
  AssignmentDim("assignment_dim", AssignmentDim.class),
  AssignmentFact("assignment_fact", AssignmentFact.class),
  ConversationDim("conversation_dim", ConversationDim.class),
  ConversationMessageDim("conversation_message_dim", ConversationMessageDim.class),
  ConversationMessageParticipantFact("conversation_message_participant_fact", ConversationMessageParticipantFact.class),
  CourseDim("course_dim", CourseDim.class),
  CourseSectionDim("course_section_dim", CourseSectionDim.class),
  CourseUiCanvasNavigationDim("course_ui_canvas_navigation_dim", CourseUiCanvasNavigationDim.class),
  CourseUiCanvasNavigationExpandedDim("course_ui_canvas_navigation_expanded_dim", CourseUiCanvasNavigationExpandedDim.class),
  CourseUiNavigationDimDim("course_ui_navigation_dim_dim", CourseUiNavigationDimDim.class),
  CourseUiNavigationItemDim("course_ui_navigation_item_dim", CourseUiNavigationItemDim.class),
  CourseUiNavigationItemFact("course_ui_navigation_item_fact", CourseUiNavigationItemFact.class),
  DateDim("date_dim", DateDim.class),
  DiscussionEntryDim("discussion_entry_dim", DiscussionEntryDim.class),
  DiscussionEntryFact("discussion_entry_fact", DiscussionEntryFact.class),
  DiscussionTopicDim("discussion_topic_dim", DiscussionTopicDim.class),
  DiscussionTopicFact("discussion_topic_fact", DiscussionTopicFact.class),
  EnrollmentDim("enrollment_dim", EnrollmentDim.class),
  EnrollmentFact("enrollment_fact", EnrollmentFact.class),
  EnrollmentRollupDim("enrollment_rollup_dim", EnrollmentRollupDim.class),
  EnrollmentTermDim("enrollment_term_dim", EnrollmentTermDim.class),
  ExternalToolActivationDim("external_tool_activation_dim", ExternalToolActivationDim.class),
  ExternalToolActivationFact("external_tool_activation_fact", ExternalToolActivationFact.class),
  GroupDim("group_dim", GroupDim.class),
  GroupFact("group_fact", GroupFact.class),
  GroupMembershipFact("group_membership_fact", GroupMembershipFact.class),
  PseudonymDim("pseudonym_dim", PseudonymDim.class),
  PseudonymFact("pseudonym_fact", PseudonymFact.class),
  QuizDim("quiz_dim", QuizDim.class),
  QuizSubmissionFact("quiz_submission_fact", QuizSubmissionFact.class),
  Requests("requests", Requests.class),
  RoleDim("role_dim", RoleDim.class),
  RoleExpandedDim("role_expanded_dim", RoleExpandedDim.class),
  SubmissionCommentDim("submission_comment_dim", SubmissionCommentDim.class),
  SubmissionCommentFact("submission_comment_fact", SubmissionCommentFact.class),
  SubmissionCommentParticipantDim("submission_comment_participant_dim", SubmissionCommentParticipantDim.class),
  SubmissionCommentParticipantFact("submission_comment_participant_fact", SubmissionCommentParticipantFact.class),
  SubmissionDim("submission_dim", SubmissionDim.class),
  SubmissionFact("submission_fact", SubmissionFact.class),
  UserDim("user_dim", UserDim.class),
  UserExpandedDim("user_expanded_dim", UserExpandedDim.class),
  WikiDim("wiki_dim", WikiDim.class),
  WikiFact("wiki_fact", WikiFact.class),
  WikiPageDim("wiki_page_dim", WikiPageDim.class),
  WikiPageFact("wiki_page_fact", WikiPageFact.class);

  private final String sourceName;
  private final Class<? extends CanvasDataTable> tableType;

  private Table(final String sourceName, Class<? extends CanvasDataTable> tableType) {
    this.sourceName = sourceName;
    this.tableType = tableType;
  }

  public String getSourceName() {
    return sourceName;
  }

  public Class<? extends CanvasDataTable> getTableType() {
    return tableType;
  }

  public static Table fromSourceName(String sourceName) {
    switch(sourceName) {
    case "account_dim": return Table.AccountDim;
    case "assignment_dim": return Table.AssignmentDim;
    case "assignment_fact": return Table.AssignmentFact;
    case "conversation_dim": return Table.ConversationDim;
    case "conversation_message_dim": return Table.ConversationMessageDim;
    case "conversation_message_participant_fact": return Table.ConversationMessageParticipantFact;
    case "course_dim": return Table.CourseDim;
    case "course_section_dim": return Table.CourseSectionDim;
    case "course_ui_canvas_navigation_dim": return Table.CourseUiCanvasNavigationDim;
    case "course_ui_canvas_navigation_expanded_dim": return Table.CourseUiCanvasNavigationExpandedDim;
    case "course_ui_navigation_dim_dim": return Table.CourseUiNavigationDimDim;
    case "course_ui_navigation_item_dim": return Table.CourseUiNavigationItemDim;
    case "course_ui_navigation_item_fact": return Table.CourseUiNavigationItemFact;
    case "date_dim": return Table.DateDim;
    case "discussion_entry_dim": return Table.DiscussionEntryDim;
    case "discussion_entry_fact": return Table.DiscussionEntryFact;
    case "discussion_topic_dim": return Table.DiscussionTopicDim;
    case "discussion_topic_fact": return Table.DiscussionTopicFact;
    case "enrollment_dim": return Table.EnrollmentDim;
    case "enrollment_fact": return Table.EnrollmentFact;
    case "enrollment_rollup_dim": return Table.EnrollmentRollupDim;
    case "enrollment_term_dim": return Table.EnrollmentTermDim;
    case "external_tool_activation_dim": return Table.ExternalToolActivationDim;
    case "external_tool_activation_fact": return Table.ExternalToolActivationFact;
    case "group_dim": return Table.GroupDim;
    case "group_fact": return Table.GroupFact;
    case "group_membership_fact": return Table.GroupMembershipFact;
    case "pseudonym_dim": return Table.PseudonymDim;
    case "pseudonym_fact": return Table.PseudonymFact;
    case "quiz_dim": return Table.QuizDim;
    case "quiz_submission_fact": return Table.QuizSubmissionFact;
    case "requests": return Table.Requests;
    case "role_dim": return Table.RoleDim;
    case "role_expanded_dim": return Table.RoleExpandedDim;
    case "submission_comment_dim": return Table.SubmissionCommentDim;
    case "submission_comment_fact": return Table.SubmissionCommentFact;
    case "submission_comment_participant_dim": return Table.SubmissionCommentParticipantDim;
    case "submission_comment_participant_fact": return Table.SubmissionCommentParticipantFact;
    case "submission_dim": return Table.SubmissionDim;
    case "submission_fact": return Table.SubmissionFact;
    case "user_dim": return Table.UserDim;
    case "user_expanded_dim": return Table.UserExpandedDim;
    case "wiki_dim": return Table.WikiDim;
    case "wiki_fact": return Table.WikiFact;
    case "wiki_page_dim": return Table.WikiPageDim;
    case "wiki_page_fact": return Table.WikiPageFact;
    default: throw new RuntimeException("Unknown table name " + sourceName);
    }
  }
}
