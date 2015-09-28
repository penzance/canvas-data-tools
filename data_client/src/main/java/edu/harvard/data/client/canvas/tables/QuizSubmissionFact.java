package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class QuizSubmissionFact implements DataTable {
  private Double score;
  private Double keptScore;
  private String date;
  private Long courseId;
  private Long enrollmentTermId;
  private Long courseAccountId;
  private Long quizId;
  private Long userId;
  private Long submissionId;
  private Long enrollmentRollupId;

  public QuizSubmissionFact(final TableFormat format, final CSVRecord record) {
    String $score = record.get(0);
    if ($score != null && $score.length() > 0) {
      this.score = Double.valueOf($score);
    }
    String $keptScore = record.get(1);
    if ($keptScore != null && $keptScore.length() > 0) {
      this.keptScore = Double.valueOf($keptScore);
    }
    this.date = record.get(2);
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
    String $userId = record.get(7);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $submissionId = record.get(8);
    if ($submissionId != null && $submissionId.length() > 0) {
      this.submissionId = Long.valueOf($submissionId);
    }
    String $enrollmentRollupId = record.get(9);
    if ($enrollmentRollupId != null && $enrollmentRollupId.length() > 0) {
      this.enrollmentRollupId = Long.valueOf($enrollmentRollupId);
    }
  }

  public Double getScore() {
    return this.score;
  }

  public Double getKeptScore() {
    return this.keptScore;
  }

  public String getDate() {
    return this.date;
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

  public Long getQuizId() {
    return this.quizId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getSubmissionId() {
    return this.submissionId;
  }

  public Long getEnrollmentRollupId() {
    return this.enrollmentRollupId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(score);
    fields.add(keptScore);
    fields.add(date);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    fields.add(quizId);
    fields.add(userId);
    fields.add(submissionId);
    fields.add(enrollmentRollupId);
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
      fields.add("user_id");
      fields.add("submission_id");
      fields.add("enrollment_rollup_id");
    return fields;
  }
}
