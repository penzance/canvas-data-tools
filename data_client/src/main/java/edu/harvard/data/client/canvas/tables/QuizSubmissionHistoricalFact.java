// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizSubmissionHistoricalFact implements DataTable {
  private Double score;
  private Double keptScore;
  private ZonedDateTime date;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long quizId;
  private Long assignmentId;
  private Long userId;
  private Long submissionId;
  private Long enrollmentRollupId;
  private Long quizSubmissionHistoricalId;
  private Double quizPointsPossible;
  private Double scoreBeforeRegrade;
  private Double fudgePoints;
  private Integer totalAttempts;
  private Integer extraAttempts;
  private Integer extraTime;
  private Integer timeTaken;

  public QuizSubmissionHistoricalFact(final TableFormat format, final CSVRecord record) {
    String $score = record.get(0);
    if ($score != null && $score.length() > 0) {
      this.score = Double.valueOf($score);
    }
    String $keptScore = record.get(1);
    if ($keptScore != null && $keptScore.length() > 0) {
      this.keptScore = Double.valueOf($keptScore);
    }
    String $date = record.get(2);
    if ($date != null && $date.length() > 0) {
      this.date = ZonedDateTime.parse($date, format.getTimstampFormat());
    }
    String $courseId = record.get(3);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(5);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $quizId = record.get(6);
    if ($quizId != null && $quizId.length() > 0) {
      this.quizId = Long.valueOf($quizId);
    }
    String $assignmentId = record.get(7);
    if ($assignmentId != null && $assignmentId.length() > 0) {
      this.assignmentId = Long.valueOf($assignmentId);
    }
    String $userId = record.get(8);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $submissionId = record.get(9);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $enrollmentRollupId = record.get(10);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
    String $quizSubmissionHistoricalId = record.get(11);
    if ($quizSubmissionHistoricalId != null && $quizSubmissionHistoricalId.length() > 0) {
      this.quizSubmissionHistoricalId = Long.valueOf($quizSubmissionHistoricalId);
    }
    String $quizPointsPossible = record.get(12);
    if ($quizPointsPossible != null && $quizPointsPossible.length() > 0) {
      this.quizPointsPossible = Double.valueOf($quizPointsPossible);
    }
    String $scoreBeforeRegrade = record.get(13);
    if ($scoreBeforeRegrade != null && $scoreBeforeRegrade.length() > 0) {
      this.scoreBeforeRegrade = Double.valueOf($scoreBeforeRegrade);
    }
    String $fudgePoints = record.get(14);
    if ($fudgePoints != null && $fudgePoints.length() > 0) {
      this.fudgePoints = Double.valueOf($fudgePoints);
    }
    String $totalAttempts = record.get(15);
    if ($totalAttempts != null && $totalAttempts.length() > 0) {
      this.totalAttempts = Integer.valueOf($totalAttempts);
    }
    String $extraAttempts = record.get(16);
    if ($extraAttempts != null && $extraAttempts.length() > 0) {
      this.extraAttempts = Integer.valueOf($extraAttempts);
    }
    String $extraTime = record.get(17);
    if ($extraTime != null && $extraTime.length() > 0) {
      this.extraTime = Integer.valueOf($extraTime);
    }
    String $timeTaken = record.get(18);
    if ($timeTaken != null && $timeTaken.length() > 0) {
      this.timeTaken = Integer.valueOf($timeTaken);
    }
  }

  /**
   * Denotes the score for this submission. Its value would be NULL when they 
   * are in the 'preview', 'untaken' OR 'settings_only' workflow states (since 
   * it is associated with quiz moderation events). Or its value should not be 
   * NULL when workflow state is either 'complete' or 'pending_review'. It 
   * defaults to NULL. 
   */
  public Double getScore() {
    return this.score;
  }

  /**
   * For quizzes that allow multiple attempts, this is the actual score that 
   * will be associated with the user for this quiz. This score depends on the 
   * scoring policy we have for the submission in the quiz submission dimension 
   * table, the workflow state being 'completed' or 'pending_review' and the 
   * allowed attempts to be greater than 1. Its value can be NULL when not all 
   * these required conditions are met. 
   */
  public Double getKeptScore() {
    return this.keptScore;
  }

  /**
   * Contains the same value as 'finished_at'. Provided to support backward 
   * compatibility with the existing table in production. 
   */
  public ZonedDateTime getDate() {
    return this.date;
  }

  /**
   * Foreign key to the course this submission belongs to. 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to the enrollment term of the course this submission belongs 
   * to. 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * Foreign key to the account of the course this submission belongs to. 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * ID of the quiz the quiz submission represents. Foreign key to the quiz 
   * dimension table. 
   */
  public Long getQuizId() {
    return this.quizId;
  }

  /**
   * Foreign key to the assignment the quiz belongs to. 
   */
  public Long getAssignmentId() {
    return this.assignmentId;
  }

  /**
   * ID of the user (who is a student) who made the submission. Foreign key to 
   * the user dimension table. 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * ID to the submission the quiz submission represents. Foreign key to the 
   * quiz submissio dimension table. 
   */
  public Long getSubmissionId() {
    return this.submissionId;
  }

  /**
   * Foreign key to the enrollment rollup dimension table. 
   */
  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  /**
   * Foreign key to the quiz submission dimension table. 
   */
  public Long getQuizSubmissionHistoricalId() {
    return this.quizSubmissionHistoricalId;
  }

  /**
   * Maximum points that can be scored in this quiz. 
   */
  public Double getQuizPointsPossible() {
    return this.quizPointsPossible;
  }

  /**
   * Original score of the quiz submission prior to any re-grading. It's NULL 
   * if the submission has never been regraded. Defaults to NULL. 
   */
  public Double getScoreBeforeRegrade() {
    return this.scoreBeforeRegrade;
  }

  /**
   * Number of points the quiz submission's score was fudged (changed) by. 
   * Values can be negative or positive. Defaults to 0. 
   */
  public Double getFudgePoints() {
    return this.fudgePoints;
  }

  /**
   * Denotes the total number of attempts made by the student for the quiz. Is 
   * valid only if the quiz allows multiple attempts. 
   */
  public Integer getTotalAttempts() {
    return this.totalAttempts;
  }

  /**
   * Number of times the student was allowed to re-take the quiz over the 
   * multiple-attempt limit. 
   */
  public Integer getExtraAttempts() {
    return this.extraAttempts;
  }

  /**
   * Amount of extra time allowed for the quiz submission, in minutes. 
   */
  public Integer getExtraTime() {
    return this.extraTime;
  }

  /**
   * Time taken, in seconds, to finish the quiz. 
   */
  public Integer getTimeTaken() {
    return this.timeTaken;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(score);
    fields.add(keptScore);
    fields.add(formatter.formatTimestamp(date));
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(quizId);
    fields.add(assignmentId);
    fields.add(userId);
    fields.add(submissionId);
    fields.add(enrollmentRollupId);
    fields.add(quizSubmissionHistoricalId);
    fields.add(quizPointsPossible);
    fields.add(scoreBeforeRegrade);
    fields.add(fudgePoints);
    fields.add(totalAttempts);
    fields.add(extraAttempts);
    fields.add(extraTime);
    fields.add(timeTaken);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("score");
      fields.add("kept_score");
      fields.add("date");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
      fields.add("quiz_id");
      fields.add("assignment_id");
      fields.add("user_id");
      fields.add("submission_id");
      fields.add("enrollment_rollup_id");
      fields.add("quiz_submission_historical_id");
      fields.add("quiz_points_possible");
      fields.add("score_before_regrade");
      fields.add("fudge_points");
      fields.add("total_attempts");
      fields.add("extra_attempts");
      fields.add("extra_time");
      fields.add("time_taken");
    return fields;
  }
}
