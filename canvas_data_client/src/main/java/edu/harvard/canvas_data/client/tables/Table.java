package edu.harvard.canvas_data.client.tables;

public enum Table {
  Account("account"),
  AssignmentDim("assignment_dim"),
  AssignmentFact("assignment_fact"),
  Conversation("conversation"),
  ConversationMessage("conversation_message"),
  ConversationMessageParticipant("conversation_message_participant"),
  Course("course"),
  CourseSection("course_section"),
  CourseUiCanvasNavigationDim("course_ui_canvas_navigation_dim"),
  CourseUiCanvasNavigationExpandedDim("course_ui_canvas_navigation_expanded_dim"),
  CourseUiNavigationDim("course_ui_navigation_dim"),
  CourseUiNavigationItemDim("course_ui_navigation_item_dim"),
  CourseUiNavigationItemFact("course_ui_navigation_item_fact"),
  Date("date"),
  DiscussionEntryDim("discussion_entry_dim"),
  DiscussionEntryFact("discussion_entry_fact"),
  DiscussionTopicDim("discussion_topic_dim"),
  DiscussionTopicFact("discussion_topic_fact"),
  EnrollmentDim("enrollment_dim"),
  EnrollmentFact("enrollment_fact"),
  EnrollmentRollup("enrollment_rollup"),
  EnrollmentTerm("enrollment_term"),
  ExternalToolActivationDim("external_tool_activation_dim"),
  ExternalToolActivationFact("external_tool_activation_fact"),
  GroupDim("group_dim"),
  GroupFact("group_fact"),
  GroupMembershipFact("group_membership_fact"),
  PseudonymDim("pseudonym_dim"),
  PseudonymFact("pseudonym_fact"),
  Quiz("quiz"),
  QuizSubmission("quiz_submission"),
  Requests("requests"),
  RoleDim("role_dim"),
  RoleExpandedDim("role_expanded_dim"),
  SubmissionCommentDim("submission_comment_dim"),
  SubmissionCommentFact("submission_comment_fact"),
  SubmissionCommentParticipantDim("submission_comment_participant_dim"),
  SubmissionCommentParticipantFact("submission_comment_participant_fact"),
  SubmissionDim("submission_dim"),
  SubmissionFact("submission_fact"),
  User("user"),
  UserExpanded("user_expanded"),
  WikiDim("wiki_dim"),
  WikiFact("wiki_fact"),
  WikiPageDim("wiki_page_dim"),
  WikiPageFact("wiki_page_fact");

  private final String sourceName;

  private Table(final String sourceName) {
    this.sourceName = sourceName;
  }

  public String getSourceName() {
    return sourceName;
  }

  public static Table fromSourceName(String sourceName) {
    switch(sourceName) {
    case "account": return Table.Account;
    case "assignment_dim": return Table.AssignmentDim;
    case "assignment_fact": return Table.AssignmentFact;
    case "conversation": return Table.Conversation;
    case "conversation_message": return Table.ConversationMessage;
    case "conversation_message_participant": return Table.ConversationMessageParticipant;
    case "course": return Table.Course;
    case "course_section": return Table.CourseSection;
    case "course_ui_canvas_navigation_dim": return Table.CourseUiCanvasNavigationDim;
    case "course_ui_canvas_navigation_expanded_dim": return Table.CourseUiCanvasNavigationExpandedDim;
    case "course_ui_navigation_dim": return Table.CourseUiNavigationDim;
    case "course_ui_navigation_item_dim": return Table.CourseUiNavigationItemDim;
    case "course_ui_navigation_item_fact": return Table.CourseUiNavigationItemFact;
    case "date": return Table.Date;
    case "discussion_entry_dim": return Table.DiscussionEntryDim;
    case "discussion_entry_fact": return Table.DiscussionEntryFact;
    case "discussion_topic_dim": return Table.DiscussionTopicDim;
    case "discussion_topic_fact": return Table.DiscussionTopicFact;
    case "enrollment_dim": return Table.EnrollmentDim;
    case "enrollment_fact": return Table.EnrollmentFact;
    case "enrollment_rollup": return Table.EnrollmentRollup;
    case "enrollment_term": return Table.EnrollmentTerm;
    case "external_tool_activation_dim": return Table.ExternalToolActivationDim;
    case "external_tool_activation_fact": return Table.ExternalToolActivationFact;
    case "group_dim": return Table.GroupDim;
    case "group_fact": return Table.GroupFact;
    case "group_membership_fact": return Table.GroupMembershipFact;
    case "pseudonym_dim": return Table.PseudonymDim;
    case "pseudonym_fact": return Table.PseudonymFact;
    case "quiz": return Table.Quiz;
    case "quiz_submission": return Table.QuizSubmission;
    case "requests": return Table.Requests;
    case "role_dim": return Table.RoleDim;
    case "role_expanded_dim": return Table.RoleExpandedDim;
    case "submission_comment_dim": return Table.SubmissionCommentDim;
    case "submission_comment_fact": return Table.SubmissionCommentFact;
    case "submission_comment_participant_dim": return Table.SubmissionCommentParticipantDim;
    case "submission_comment_participant_fact": return Table.SubmissionCommentParticipantFact;
    case "submission_dim": return Table.SubmissionDim;
    case "submission_fact": return Table.SubmissionFact;
    case "user": return Table.User;
    case "user_expanded": return Table.UserExpanded;
    case "wiki_dim": return Table.WikiDim;
    case "wiki_fact": return Table.WikiFact;
    case "wiki_page_dim": return Table.WikiPageDim;
    case "wiki_page_fact": return Table.WikiPageFact;
    default: throw new RuntimeException("Unknown table name " + sourceName);
    }
  }
}
