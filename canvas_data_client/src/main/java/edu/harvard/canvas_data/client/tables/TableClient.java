package edu.harvard.canvas_data.client.tables;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.harvard.canvas_data.client.DataTable;
import edu.harvard.canvas_data.client.collation.ListDataTable;
import edu.harvard.canvas_data.client.tables.schema.TableSchema;

public class TableClient {

  public Map<String, TableSchema> parseSchema(final File schemaFile)
      throws JsonParseException, JsonMappingException, IOException {
    final ObjectMapper mapper = new ObjectMapper();
    final Map<String, TableSchema> schema = mapper.readValue(schemaFile,
        new TypeReference<Map<String, TableSchema>>() {
    });
    return schema;
  }

  public DataTable<DateDim> parseDateDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, DateDim.class);
  }

  public DataTable<CourseDim> parseCourseDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseDim.class);
  }

  public DataTable<AccountDim> parseAccountDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, AccountDim.class);
  }

  public DataTable<UserDim> parseUserDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, UserDim.class);
  }

  public DataTable<UserExpandedDim> parseUserExpandedDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, UserExpandedDim.class);
  }

  public DataTable<PseudonymDim> parsePseudonymDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, PseudonymDim.class);
  }

  public DataTable<PseudonymFact> parsePseudonymFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, PseudonymFact.class);
  }

  public DataTable<AssignmentDim> parseAssignmentDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, AssignmentDim.class);
  }

  public DataTable<AssignmentFact> parseAssignmentFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, AssignmentFact.class);
  }

  public DataTable<SubmissionDim> parseSubmissionDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionDim.class);
  }

  public DataTable<SubmissionFact> parseSubmissionFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionFact.class);
  }

  public DataTable<SubmissionCommentParticipantFact> parseSubmissionCommentParticipantFactCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionCommentParticipantFact.class);
  }

  public DataTable<SubmissionCommentParticipantDim> parseSubmissionCommentParticipantDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionCommentParticipantDim.class);
  }

  public DataTable<SubmissionCommentFact> parseSubmissionCommentFactCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionCommentFact.class);
  }

  public DataTable<SubmissionCommentDim> parseSubmissionCommentDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, SubmissionCommentDim.class);
  }

  public DataTable<ConversationDim> parseConversationDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, ConversationDim.class);
  }

  public DataTable<ConversationMessageDim> parseConversationMessageDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, ConversationMessageDim.class);
  }

  public DataTable<ConversationMessageParticipantFact> parseConversationMessageParticipantFactCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, ConversationMessageParticipantFact.class);
  }

  public DataTable<DiscussionTopicDim> parseDiscussionTopicDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, DiscussionTopicDim.class);
  }

  public DataTable<DiscussionTopicFact> parseDiscussionTopicFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, DiscussionTopicFact.class);
  }

  public DataTable<DiscussionEntryDim> parseDiscussionEntryDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, DiscussionEntryDim.class);
  }

  public DataTable<DiscussionEntryFact> parseDiscussionEntryFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, DiscussionEntryFact.class);
  }

  public DataTable<EnrollmentTermDim> parseEnrollmentTermDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, EnrollmentTermDim.class);
  }

  public DataTable<CourseSectionDim> parseCourseSectionDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseSectionDim.class);
  }

  public DataTable<RoleDim> parseRoleDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, RoleDim.class);
  }

  public DataTable<RoleExpandedDim> parseRoleExpandedDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, RoleExpandedDim.class);
  }

  public DataTable<EnrollmentDim> parseEnrollmentDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, EnrollmentDim.class);
  }

  public DataTable<EnrollmentFact> parseEnrollmentFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, EnrollmentFact.class);
  }

  public DataTable<EnrollmentRollupDim> parseEnrollmentRollupDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, EnrollmentRollupDim.class);
  }

  public DataTable<GroupDim> parseGroupDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, GroupDim.class);
  }

  public DataTable<GroupFact> parseGroupFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, GroupFact.class);
  }

  public DataTable<GroupMembershipFact> parseGroupMembershipFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, GroupMembershipFact.class);
  }

  public DataTable<CourseUiNavigationDimDim> parseCourseUiNavigationDimDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseUiNavigationDimDim.class);
  }

  public DataTable<CourseUiCanvasNavigationDim> parseCourseUiCanvasNavigationDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseUiCanvasNavigationDim.class);
  }

  public DataTable<CourseUiCanvasNavigationExpandedDim> parseCourseUiCanvasNavigationExpandedDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseUiCanvasNavigationExpandedDim.class);
  }

  public DataTable<CourseUiNavigationItemDim> parseCourseUiNavigationItemDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseUiNavigationItemDim.class);
  }

  public DataTable<CourseUiNavigationItemFact> parseCourseUiNavigationItemFactCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, CourseUiNavigationItemFact.class);
  }

  public DataTable<QuizSubmissionFact> parseQuizSubmissionFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, QuizSubmissionFact.class);
  }

  public DataTable<QuizDim> parseQuizDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, QuizDim.class);
  }

  public DataTable<Requests> parseRequestsCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, Requests.class);
  }

  public DataTable<ExternalToolActivationDim> parseExternalToolActivationDimCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, ExternalToolActivationDim.class);
  }

  public DataTable<ExternalToolActivationFact> parseExternalToolActivationFactCanvasDataFile(
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, ExternalToolActivationFact.class);
  }

  public DataTable<WikiDim> parseWikiDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, WikiDim.class);
  }

  public DataTable<WikiFact> parseWikiFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, WikiFact.class);
  }

  public DataTable<WikiPageDim> parseWikiPageDimCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, WikiPageDim.class);
  }

  public DataTable<WikiPageFact> parseWikiPageFactCanvasDataFile(final File gzipFile)
      throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, WikiPageFact.class);
  }

  public DataTable<? extends CanvasDataTable> parseCanvasDataFile(final Table table,
      final File gzipFile) throws IOException, ParsedWithErrorsException {
    return parseCanvasDataFile(gzipFile, table.getTableType());
  }

  private <T extends CanvasDataTable> DataTable<T> parseCanvasDataFile(final File gzipFile,
      final Class<T> tableType) throws IOException, ParsedWithErrorsException {
    final List<ParseError> errors = new ArrayList<ParseError>();
    final InputStream in = new GZIPInputStream(new FileInputStream(gzipFile));
    final List<T> records = new ArrayList<T>();
    try (final CSVParser requestParser = new CSVParser(
        new InputStreamReader(in, CanvasDataTable.CANVAS_DATA_ENCODING),
        CanvasDataTable.CANVAS_DATA_FILE_FORMAT)) {
      final Iterator<CSVRecord> iterator = requestParser.iterator();
      while (iterator.hasNext()) {
        final CSVRecord record = iterator.next();
        try {
          final T row = tableType.getConstructor(CSVRecord.class).newInstance(record);
          records.add(row);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
            | NoSuchMethodException | SecurityException e) {
          throw new RuntimeException("Error while creating data object.", e);
        } catch (final InvocationTargetException e) {
          errors.add(new ParseError(record, e.getCause()));
        }
      }
    }
    final DataTable<T> dataSet = new ListDataTable<T>(records);
    if (errors.size() == 0) {
      return dataSet;
    } else {
      throw new ParsedWithErrorsException(dataSet, errors, gzipFile, tableType);
    }
  }

}
