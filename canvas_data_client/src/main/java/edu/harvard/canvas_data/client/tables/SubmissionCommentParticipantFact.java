package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class SubmissionCommentParticipantFact extends CanvasDataTable {
  private Long submissionCommentParticipantId;
  private Long submissionCommentId;
  private Long userId;
  private Long submissionId;
  private Long assignmentId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long userAccountId;
  private Long enrollmentRollupId;

  public SubmissionCommentParticipantFact(final CSVRecord record) {
    String $submissionCommentParticipantId = record.get(0);
    if ($submissionCommentParticipantId != null && $submissionCommentParticipantId.length() > 0) {
      this.submissionCommentParticipantId = Long.valueOf($submissionCommentParticipantId);
    }
    String $submissionCommentId = record.get(1);
    if ($submissionCommentId != null && $submissionCommentId.length() > 0) {
      this.submissionCommentId = Long.valueOf($submissionCommentId);
    }
    String $userId = record.get(2);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $submissionId = record.get(3);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $assignmentId = record.get(4);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseId = record.get(5);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(6);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(7);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $userAccountId = record.get(8);
    if ($userAccountId != null && $userAccountId.length() > 0) {
      this.userAccountId = Long.valueOf($userAccountId);
    }
    String $enrollmentRollupId = record.get(9);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
  }

  public Long getSubmissionCommentParticipantId() {
    return this.submissionCommentParticipantId;
  }

  public Long getSubmissionCommentId() {
    return this.submissionCommentId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getSubmissionId() {
    return this.submissionId;
  }

  public Long getAssignmentId() {
    return this.assignmentId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  public Long getUserAccountId() {
    return this.userAccountId;
  }

  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(submissionCommentParticipantId);
    fields.add(submissionCommentId);
    fields.add(userId);
    fields.add(submissionId);
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(userAccountId);
    fields.add(enrollmentRollupId);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("submission_comment_participant_id");
      fields.add("submission_comment_id");
      fields.add("user_id");
      fields.add("submission_id");
      fields.add("assignment_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("user_account_id");
      fields.add("enrollment_rollup_id");
    return fields;
  }
}
