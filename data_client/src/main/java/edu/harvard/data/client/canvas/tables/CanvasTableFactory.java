package edu.harvard.data.client.canvas.tables;

  import java.io.IOException;
  import java.nio.file.Path;

  import edu.harvard.data.client.DataTable;
  import edu.harvard.data.client.DelimitedTableReader;
  import edu.harvard.data.client.DelimitedTableWriter;
  import edu.harvard.data.client.TableFactory;
  import edu.harvard.data.client.TableFormat;
  import edu.harvard.data.client.TableReader;
  import edu.harvard.data.client.TableWriter;

public class CanvasTableFactory implements TableFactory {

  @Override
  public TableReader<? extends DataTable> getDelimitedTableReader(String table, TableFormat format, Path file) throws IOException {
    switch(table) {
    case "account_dim":
      return new DelimitedTableReader<AccountDim>(AccountDim.class, format, file);
    case "assignment_dim":
      return new DelimitedTableReader<AssignmentDim>(AssignmentDim.class, format, file);
    case "assignment_fact":
      return new DelimitedTableReader<AssignmentFact>(AssignmentFact.class, format, file);
    case "conversation_dim":
      return new DelimitedTableReader<ConversationDim>(ConversationDim.class, format, file);
    case "conversation_message_dim":
      return new DelimitedTableReader<ConversationMessageDim>(ConversationMessageDim.class, format, file);
    case "conversation_message_participant_fact":
      return new DelimitedTableReader<ConversationMessageParticipantFact>(ConversationMessageParticipantFact.class, format, file);
    case "course_dim":
      return new DelimitedTableReader<CourseDim>(CourseDim.class, format, file);
    case "course_section_dim":
      return new DelimitedTableReader<CourseSectionDim>(CourseSectionDim.class, format, file);
    case "course_ui_canvas_navigation_dim":
      return new DelimitedTableReader<CourseUiCanvasNavigationDim>(CourseUiCanvasNavigationDim.class, format, file);
    case "course_ui_canvas_navigation_expanded_dim":
      return new DelimitedTableReader<CourseUiCanvasNavigationExpandedDim>(CourseUiCanvasNavigationExpandedDim.class, format, file);
    case "course_ui_navigation_dim_dim":
      return new DelimitedTableReader<CourseUiNavigationDimDim>(CourseUiNavigationDimDim.class, format, file);
    case "course_ui_navigation_item_dim":
      return new DelimitedTableReader<CourseUiNavigationItemDim>(CourseUiNavigationItemDim.class, format, file);
    case "course_ui_navigation_item_fact":
      return new DelimitedTableReader<CourseUiNavigationItemFact>(CourseUiNavigationItemFact.class, format, file);
    case "date_dim":
      return new DelimitedTableReader<DateDim>(DateDim.class, format, file);
    case "discussion_entry_dim":
      return new DelimitedTableReader<DiscussionEntryDim>(DiscussionEntryDim.class, format, file);
    case "discussion_entry_fact":
      return new DelimitedTableReader<DiscussionEntryFact>(DiscussionEntryFact.class, format, file);
    case "discussion_topic_dim":
      return new DelimitedTableReader<DiscussionTopicDim>(DiscussionTopicDim.class, format, file);
    case "discussion_topic_fact":
      return new DelimitedTableReader<DiscussionTopicFact>(DiscussionTopicFact.class, format, file);
    case "enrollment_dim":
      return new DelimitedTableReader<EnrollmentDim>(EnrollmentDim.class, format, file);
    case "enrollment_fact":
      return new DelimitedTableReader<EnrollmentFact>(EnrollmentFact.class, format, file);
    case "enrollment_rollup_dim":
      return new DelimitedTableReader<EnrollmentRollupDim>(EnrollmentRollupDim.class, format, file);
    case "enrollment_term_dim":
      return new DelimitedTableReader<EnrollmentTermDim>(EnrollmentTermDim.class, format, file);
    case "external_tool_activation_dim":
      return new DelimitedTableReader<ExternalToolActivationDim>(ExternalToolActivationDim.class, format, file);
    case "external_tool_activation_fact":
      return new DelimitedTableReader<ExternalToolActivationFact>(ExternalToolActivationFact.class, format, file);
    case "group_dim":
      return new DelimitedTableReader<GroupDim>(GroupDim.class, format, file);
    case "group_fact":
      return new DelimitedTableReader<GroupFact>(GroupFact.class, format, file);
    case "group_membership_fact":
      return new DelimitedTableReader<GroupMembershipFact>(GroupMembershipFact.class, format, file);
    case "pseudonym_dim":
      return new DelimitedTableReader<PseudonymDim>(PseudonymDim.class, format, file);
    case "pseudonym_fact":
      return new DelimitedTableReader<PseudonymFact>(PseudonymFact.class, format, file);
    case "quiz_dim":
      return new DelimitedTableReader<QuizDim>(QuizDim.class, format, file);
    case "quiz_submission_fact":
      return new DelimitedTableReader<QuizSubmissionFact>(QuizSubmissionFact.class, format, file);
    case "requests":
      return new DelimitedTableReader<Requests>(Requests.class, format, file);
    case "role_dim":
      return new DelimitedTableReader<RoleDim>(RoleDim.class, format, file);
    case "role_expanded_dim":
      return new DelimitedTableReader<RoleExpandedDim>(RoleExpandedDim.class, format, file);
    case "submission_comment_dim":
      return new DelimitedTableReader<SubmissionCommentDim>(SubmissionCommentDim.class, format, file);
    case "submission_comment_fact":
      return new DelimitedTableReader<SubmissionCommentFact>(SubmissionCommentFact.class, format, file);
    case "submission_comment_participant_dim":
      return new DelimitedTableReader<SubmissionCommentParticipantDim>(SubmissionCommentParticipantDim.class, format, file);
    case "submission_comment_participant_fact":
      return new DelimitedTableReader<SubmissionCommentParticipantFact>(SubmissionCommentParticipantFact.class, format, file);
    case "submission_dim":
      return new DelimitedTableReader<SubmissionDim>(SubmissionDim.class, format, file);
    case "submission_fact":
      return new DelimitedTableReader<SubmissionFact>(SubmissionFact.class, format, file);
    case "user_dim":
      return new DelimitedTableReader<UserDim>(UserDim.class, format, file);
    case "user_expanded_dim":
      return new DelimitedTableReader<UserExpandedDim>(UserExpandedDim.class, format, file);
    case "wiki_dim":
      return new DelimitedTableReader<WikiDim>(WikiDim.class, format, file);
    case "wiki_fact":
      return new DelimitedTableReader<WikiFact>(WikiFact.class, format, file);
    case "wiki_page_dim":
      return new DelimitedTableReader<WikiPageDim>(WikiPageDim.class, format, file);
    case "wiki_page_fact":
      return new DelimitedTableReader<WikiPageFact>(WikiPageFact.class, format, file);
    }
    return null;
  }

  @Override
  public TableWriter<? extends DataTable> getDelimitedTableWriter(String table, TableFormat format, Path file) throws IOException {
    switch(table) {
    case "account_dim":
      return new DelimitedTableWriter<AccountDim>(AccountDim.class, format, file);
    case "assignment_dim":
      return new DelimitedTableWriter<AssignmentDim>(AssignmentDim.class, format, file);
    case "assignment_fact":
      return new DelimitedTableWriter<AssignmentFact>(AssignmentFact.class, format, file);
    case "conversation_dim":
      return new DelimitedTableWriter<ConversationDim>(ConversationDim.class, format, file);
    case "conversation_message_dim":
      return new DelimitedTableWriter<ConversationMessageDim>(ConversationMessageDim.class, format, file);
    case "conversation_message_participant_fact":
      return new DelimitedTableWriter<ConversationMessageParticipantFact>(ConversationMessageParticipantFact.class, format, file);
    case "course_dim":
      return new DelimitedTableWriter<CourseDim>(CourseDim.class, format, file);
    case "course_section_dim":
      return new DelimitedTableWriter<CourseSectionDim>(CourseSectionDim.class, format, file);
    case "course_ui_canvas_navigation_dim":
      return new DelimitedTableWriter<CourseUiCanvasNavigationDim>(CourseUiCanvasNavigationDim.class, format, file);
    case "course_ui_canvas_navigation_expanded_dim":
      return new DelimitedTableWriter<CourseUiCanvasNavigationExpandedDim>(CourseUiCanvasNavigationExpandedDim.class, format, file);
    case "course_ui_navigation_dim_dim":
      return new DelimitedTableWriter<CourseUiNavigationDimDim>(CourseUiNavigationDimDim.class, format, file);
    case "course_ui_navigation_item_dim":
      return new DelimitedTableWriter<CourseUiNavigationItemDim>(CourseUiNavigationItemDim.class, format, file);
    case "course_ui_navigation_item_fact":
      return new DelimitedTableWriter<CourseUiNavigationItemFact>(CourseUiNavigationItemFact.class, format, file);
    case "date_dim":
      return new DelimitedTableWriter<DateDim>(DateDim.class, format, file);
    case "discussion_entry_dim":
      return new DelimitedTableWriter<DiscussionEntryDim>(DiscussionEntryDim.class, format, file);
    case "discussion_entry_fact":
      return new DelimitedTableWriter<DiscussionEntryFact>(DiscussionEntryFact.class, format, file);
    case "discussion_topic_dim":
      return new DelimitedTableWriter<DiscussionTopicDim>(DiscussionTopicDim.class, format, file);
    case "discussion_topic_fact":
      return new DelimitedTableWriter<DiscussionTopicFact>(DiscussionTopicFact.class, format, file);
    case "enrollment_dim":
      return new DelimitedTableWriter<EnrollmentDim>(EnrollmentDim.class, format, file);
    case "enrollment_fact":
      return new DelimitedTableWriter<EnrollmentFact>(EnrollmentFact.class, format, file);
    case "enrollment_rollup_dim":
      return new DelimitedTableWriter<EnrollmentRollupDim>(EnrollmentRollupDim.class, format, file);
    case "enrollment_term_dim":
      return new DelimitedTableWriter<EnrollmentTermDim>(EnrollmentTermDim.class, format, file);
    case "external_tool_activation_dim":
      return new DelimitedTableWriter<ExternalToolActivationDim>(ExternalToolActivationDim.class, format, file);
    case "external_tool_activation_fact":
      return new DelimitedTableWriter<ExternalToolActivationFact>(ExternalToolActivationFact.class, format, file);
    case "group_dim":
      return new DelimitedTableWriter<GroupDim>(GroupDim.class, format, file);
    case "group_fact":
      return new DelimitedTableWriter<GroupFact>(GroupFact.class, format, file);
    case "group_membership_fact":
      return new DelimitedTableWriter<GroupMembershipFact>(GroupMembershipFact.class, format, file);
    case "pseudonym_dim":
      return new DelimitedTableWriter<PseudonymDim>(PseudonymDim.class, format, file);
    case "pseudonym_fact":
      return new DelimitedTableWriter<PseudonymFact>(PseudonymFact.class, format, file);
    case "quiz_dim":
      return new DelimitedTableWriter<QuizDim>(QuizDim.class, format, file);
    case "quiz_submission_fact":
      return new DelimitedTableWriter<QuizSubmissionFact>(QuizSubmissionFact.class, format, file);
    case "requests":
      return new DelimitedTableWriter<Requests>(Requests.class, format, file);
    case "role_dim":
      return new DelimitedTableWriter<RoleDim>(RoleDim.class, format, file);
    case "role_expanded_dim":
      return new DelimitedTableWriter<RoleExpandedDim>(RoleExpandedDim.class, format, file);
    case "submission_comment_dim":
      return new DelimitedTableWriter<SubmissionCommentDim>(SubmissionCommentDim.class, format, file);
    case "submission_comment_fact":
      return new DelimitedTableWriter<SubmissionCommentFact>(SubmissionCommentFact.class, format, file);
    case "submission_comment_participant_dim":
      return new DelimitedTableWriter<SubmissionCommentParticipantDim>(SubmissionCommentParticipantDim.class, format, file);
    case "submission_comment_participant_fact":
      return new DelimitedTableWriter<SubmissionCommentParticipantFact>(SubmissionCommentParticipantFact.class, format, file);
    case "submission_dim":
      return new DelimitedTableWriter<SubmissionDim>(SubmissionDim.class, format, file);
    case "submission_fact":
      return new DelimitedTableWriter<SubmissionFact>(SubmissionFact.class, format, file);
    case "user_dim":
      return new DelimitedTableWriter<UserDim>(UserDim.class, format, file);
    case "user_expanded_dim":
      return new DelimitedTableWriter<UserExpandedDim>(UserExpandedDim.class, format, file);
    case "wiki_dim":
      return new DelimitedTableWriter<WikiDim>(WikiDim.class, format, file);
    case "wiki_fact":
      return new DelimitedTableWriter<WikiFact>(WikiFact.class, format, file);
    case "wiki_page_dim":
      return new DelimitedTableWriter<WikiPageDim>(WikiPageDim.class, format, file);
    case "wiki_page_fact":
      return new DelimitedTableWriter<WikiPageFact>(WikiPageFact.class, format, file);
    }
    return null;
  }
}
