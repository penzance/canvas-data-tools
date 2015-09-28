package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class SubmissionFact implements DataTable {
  private Long submissionId;
  private Long assignmentId;
  private Long courseId;
  private Long enrollmentTermId;
  private Long userId;
  private Long graderId;
  private Long courseAccountId;
  private Long userAccountId;
  private Long enrollmentRollupId;
  private Double score;
  private Double publishedScore;
  private Double whatIfScore;
  private Integer submissionCommentsCount;

  public SubmissionFact(final TableFormat format, final CSVRecord record) {
    String $submissionId = record.get(0);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $assignmentId = record.get(1);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $courseId = record.get(2);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(3);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $userId = record.get(4);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $graderId = record.get(5);
    if ($graderId != null && $graderId.length() > 0) {
      this.graderId = Long.valueOf($graderId);
    }
    String $courseAccountId = record.get(6);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $userAccountId = record.get(7);
    if ($userAccountId != null && $userAccountId.length() > 0) {
      this.userAccountId = Long.valueOf($userAccountId);
    }
    String $enrollmentRollupId = record.get(8);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
    String $score = record.get(9);
    if ($score != null && $score.length() > 0) {
      this.score = Double.valueOf($score);
    }
    String $publishedScore = record.get(10);
    if ($publishedScore != null && $publishedScore.length() > 0) {
      this.publishedScore = Double.valueOf($publishedScore);
    }
    String $whatIfScore = record.get(11);
    if ($whatIfScore != null && $whatIfScore.length() > 0) {
      this.whatIfScore = Double.valueOf($whatIfScore);
    }
    String $submissionCommentsCount = record.get(12);
    if ($submissionCommentsCount != null && $submissionCommentsCount.length() > 0) {
      this.submissionCommentsCount = Integer.valueOf($submissionCommentsCount);
    }
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

  public Long getUserId() {
    return this.userId;
  }

  public Long getGraderId() {
    return this.graderId;
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

  public Double getScore() {
    return this.score;
  }

  public Double getPublishedScore() {
    return this.publishedScore;
  }

  public Double getWhatIfScore() {
    return this.whatIfScore;
  }

  public Integer getSubmissionCommentsCount() {
    return this.submissionCommentsCount;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(submissionId);
    fields.add(assignmentId);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(userId);
    fields.add(graderId);
    fields.add(courseAccountId);
    fields.add(userAccountId);
    fields.add(enrollmentRollupId);
    fields.add(score);
    fields.add(publishedScore);
    fields.add(whatIfScore);
    fields.add(submissionCommentsCount);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("submission_id");
      fields.add("assignment_id");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("user_id");
      fields.add("grader_id");
      fields.add("course_account_id");
      fields.add("user_account_id");
      fields.add("enrollment_rollup_id");
      fields.add("score");
      fields.add("published_score");
      fields.add("what_if_score");
      fields.add("submission_comments_count");
    return fields;
  }
}
