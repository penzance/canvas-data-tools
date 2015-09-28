package edu.harvard.data.client.canvas.tables;

public enum CanvasTable {
  AccountDim("account_dim"),
  AssignmentDim("assignment_dim"),
  AssignmentFact("assignment_fact"),
  ConversationDim("conversation_dim"),
  ConversationMessageDim("conversation_message_dim"),
  ConversationMessageParticipantFact("conversation_message_participant_fact"),
  CourseDim("course_dim"),
  CourseSectionDim("course_section_dim"),
  CourseUiCanvasNavigationDim("course_ui_canvas_navigation_dim"),
  CourseUiCanvasNavigationExpandedDim("course_ui_canvas_navigation_expanded_dim"),
  CourseUiNavigationDimDim("course_ui_navigation_dim_dim"),
  CourseUiNavigationItemDim("course_ui_navigation_item_dim"),
  CourseUiNavigationItemFact("course_ui_navigation_item_fact"),
  DateDim("date_dim"),
  DiscussionEntryDim("discussion_entry_dim"),
  DiscussionEntryFact("discussion_entry_fact"),
  DiscussionTopicDim("discussion_topic_dim"),
  DiscussionTopicFact("discussion_topic_fact"),
  EnrollmentDim("enrollment_dim"),
  EnrollmentFact("enrollment_fact"),
  EnrollmentRollupDim("enrollment_rollup_dim"),
  EnrollmentTermDim("enrollment_term_dim"),
  ExternalToolActivationDim("external_tool_activation_dim"),
  ExternalToolActivationFact("external_tool_activation_fact"),
  GroupDim("group_dim"),
  GroupFact("group_fact"),
  GroupMembershipFact("group_membership_fact"),
  PseudonymDim("pseudonym_dim"),
  PseudonymFact("pseudonym_fact"),
  QuizDim("quiz_dim"),
  QuizSubmissionFact("quiz_submission_fact"),
  Requests("requests"),
  RoleDim("role_dim"),
  RoleExpandedDim("role_expanded_dim"),
  SubmissionCommentDim("submission_comment_dim"),
  SubmissionCommentFact("submission_comment_fact"),
  SubmissionCommentParticipantDim("submission_comment_participant_dim"),
  SubmissionCommentParticipantFact("submission_comment_participant_fact"),
  SubmissionDim("submission_dim"),
  SubmissionFact("submission_fact"),
  UserDim("user_dim"),
  UserExpandedDim("user_expanded_dim"),
  WikiDim("wiki_dim"),
  WikiFact("wiki_fact"),
  WikiPageDim("wiki_page_dim"),
  WikiPageFact("wiki_page_fact");

  private final String sourceName;

  private CanvasTable(final String sourceName) {
    this.sourceName = sourceName;
  }

  public String getSourceName() {
    return sourceName;
  }

  public static CanvasTable fromSourceName(String sourceName) {
    switch(sourceName) {
    case "account_dim": return AccountDim;
    case "assignment_dim": return AssignmentDim;
    case "assignment_fact": return AssignmentFact;
    case "conversation_dim": return ConversationDim;
    case "conversation_message_dim": return ConversationMessageDim;
    case "conversation_message_participant_fact": return ConversationMessageParticipantFact;
    case "course_dim": return CourseDim;
    case "course_section_dim": return CourseSectionDim;
    case "course_ui_canvas_navigation_dim": return CourseUiCanvasNavigationDim;
    case "course_ui_canvas_navigation_expanded_dim": return CourseUiCanvasNavigationExpandedDim;
    case "course_ui_navigation_dim_dim": return CourseUiNavigationDimDim;
    case "course_ui_navigation_item_dim": return CourseUiNavigationItemDim;
    case "course_ui_navigation_item_fact": return CourseUiNavigationItemFact;
    case "date_dim": return DateDim;
    case "discussion_entry_dim": return DiscussionEntryDim;
    case "discussion_entry_fact": return DiscussionEntryFact;
    case "discussion_topic_dim": return DiscussionTopicDim;
    case "discussion_topic_fact": return DiscussionTopicFact;
    case "enrollment_dim": return EnrollmentDim;
    case "enrollment_fact": return EnrollmentFact;
    case "enrollment_rollup_dim": return EnrollmentRollupDim;
    case "enrollment_term_dim": return EnrollmentTermDim;
    case "external_tool_activation_dim": return ExternalToolActivationDim;
    case "external_tool_activation_fact": return ExternalToolActivationFact;
    case "group_dim": return GroupDim;
    case "group_fact": return GroupFact;
    case "group_membership_fact": return GroupMembershipFact;
    case "pseudonym_dim": return PseudonymDim;
    case "pseudonym_fact": return PseudonymFact;
    case "quiz_dim": return QuizDim;
    case "quiz_submission_fact": return QuizSubmissionFact;
    case "requests": return Requests;
    case "role_dim": return RoleDim;
    case "role_expanded_dim": return RoleExpandedDim;
    case "submission_comment_dim": return SubmissionCommentDim;
    case "submission_comment_fact": return SubmissionCommentFact;
    case "submission_comment_participant_dim": return SubmissionCommentParticipantDim;
    case "submission_comment_participant_fact": return SubmissionCommentParticipantFact;
    case "submission_dim": return SubmissionDim;
    case "submission_fact": return SubmissionFact;
    case "user_dim": return UserDim;
    case "user_expanded_dim": return UserExpandedDim;
    case "wiki_dim": return WikiDim;
    case "wiki_fact": return WikiFact;
    case "wiki_page_dim": return WikiPageDim;
    case "wiki_page_fact": return WikiPageFact;
    default: throw new RuntimeException("Unknown table name " + sourceName);
    }
  }
}
