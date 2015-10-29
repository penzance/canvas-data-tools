// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

  import edu.harvard.data.client.DataTable;

public enum CanvasTable {
  AccountDim("account_dim", AccountDim.class),
  AssignmentDim("assignment_dim", AssignmentDim.class),
  AssignmentFact("assignment_fact", AssignmentFact.class),
  ConversationDim("conversation_dim", ConversationDim.class),
  ConversationMessageDim("conversation_message_dim", ConversationMessageDim.class),
  ConversationMessageParticipantFact("conversation_message_participant_fact", ConversationMessageParticipantFact.class),
  CourseDim("course_dim", CourseDim.class),
  CourseSectionDim("course_section_dim", CourseSectionDim.class),
  CourseUiCanvasNavigationDim("course_ui_canvas_navigation_dim", CourseUiCanvasNavigationDim.class),
  CourseUiNavigationDimDim("course_ui_navigation_dim_dim", CourseUiNavigationDimDim.class),
  CourseUiNavigationItemDim("course_ui_navigation_item_dim", CourseUiNavigationItemDim.class),
  CourseUiNavigationItemFact("course_ui_navigation_item_fact", CourseUiNavigationItemFact.class),
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
  QuizFact("quiz_fact", QuizFact.class),
  QuizQuestionAnswerDim("quiz_question_answer_dim", QuizQuestionAnswerDim.class),
  QuizQuestionAnswerFact("quiz_question_answer_fact", QuizQuestionAnswerFact.class),
  QuizQuestionDim("quiz_question_dim", QuizQuestionDim.class),
  QuizQuestionFact("quiz_question_fact", QuizQuestionFact.class),
  QuizQuestionGroupDim("quiz_question_group_dim", QuizQuestionGroupDim.class),
  QuizQuestionGroupFact("quiz_question_group_fact", QuizQuestionGroupFact.class),
  QuizSubmissionDim("quiz_submission_dim", QuizSubmissionDim.class),
  QuizSubmissionFact("quiz_submission_fact", QuizSubmissionFact.class),
  QuizSubmissionHistoricalDim("quiz_submission_historical_dim", QuizSubmissionHistoricalDim.class),
  QuizSubmissionHistoricalFact("quiz_submission_historical_fact", QuizSubmissionHistoricalFact.class),
  Requests("requests", Requests.class),
  RoleDim("role_dim", RoleDim.class),
  SubmissionCommentDim("submission_comment_dim", SubmissionCommentDim.class),
  SubmissionCommentFact("submission_comment_fact", SubmissionCommentFact.class),
  SubmissionCommentParticipantDim("submission_comment_participant_dim", SubmissionCommentParticipantDim.class),
  SubmissionCommentParticipantFact("submission_comment_participant_fact", SubmissionCommentParticipantFact.class),
  SubmissionDim("submission_dim", SubmissionDim.class),
  SubmissionFact("submission_fact", SubmissionFact.class),
  UserDim("user_dim", UserDim.class),
  WikiDim("wiki_dim", WikiDim.class),
  WikiFact("wiki_fact", WikiFact.class),
  WikiPageDim("wiki_page_dim", WikiPageDim.class),
  WikiPageFact("wiki_page_fact", WikiPageFact.class);

  private final String sourceName;
  private final Class<? extends DataTable> tableClass;

  private CanvasTable(final String sourceName, Class<? extends DataTable> tableClass) {
    this.sourceName = sourceName;
    this.tableClass = tableClass;
  }

  public String getSourceName() {
    return sourceName;
  }

  public Class<? extends DataTable> getTableClass() {
    return tableClass;
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
    case "course_ui_navigation_dim_dim": return CourseUiNavigationDimDim;
    case "course_ui_navigation_item_dim": return CourseUiNavigationItemDim;
    case "course_ui_navigation_item_fact": return CourseUiNavigationItemFact;
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
    case "quiz_fact": return QuizFact;
    case "quiz_question_answer_dim": return QuizQuestionAnswerDim;
    case "quiz_question_answer_fact": return QuizQuestionAnswerFact;
    case "quiz_question_dim": return QuizQuestionDim;
    case "quiz_question_fact": return QuizQuestionFact;
    case "quiz_question_group_dim": return QuizQuestionGroupDim;
    case "quiz_question_group_fact": return QuizQuestionGroupFact;
    case "quiz_submission_dim": return QuizSubmissionDim;
    case "quiz_submission_fact": return QuizSubmissionFact;
    case "quiz_submission_historical_dim": return QuizSubmissionHistoricalDim;
    case "quiz_submission_historical_fact": return QuizSubmissionHistoricalFact;
    case "requests": return Requests;
    case "role_dim": return RoleDim;
    case "submission_comment_dim": return SubmissionCommentDim;
    case "submission_comment_fact": return SubmissionCommentFact;
    case "submission_comment_participant_dim": return SubmissionCommentParticipantDim;
    case "submission_comment_participant_fact": return SubmissionCommentParticipantFact;
    case "submission_dim": return SubmissionDim;
    case "submission_fact": return SubmissionFact;
    case "user_dim": return UserDim;
    case "wiki_dim": return WikiDim;
    case "wiki_fact": return WikiFact;
    case "wiki_page_dim": return WikiPageDim;
    case "wiki_page_fact": return WikiPageFact;
    default: throw new RuntimeException("Unknown table name " + sourceName);
    }
  }
}
