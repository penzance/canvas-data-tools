package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class SubmissionDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private String body;
  private String url;
  private String grade;
  private ZonedDateTime submittedAt;
  private String submissionType;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private Boolean processed;
  private Integer processAttempts;
  private Boolean gradeMatchesCurrentSubmission;
  private String publishedGrade;
  private ZonedDateTime gradedAt;
  private Boolean hasRubricAssessment;
  private Integer attempt;
  private Boolean hasAdminComment;

  public SubmissionDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.body = record.get(2);
    this.url = record.get(3);
    this.grade = record.get(4);
    String $submittedAt = record.get(5);
    if ($submittedAt != null && $submittedAt.length() > 0) {
      this.submittedAt = ZonedDateTime.parse($submittedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.submissionType = record.get(6);
    this.workflowState = record.get(7);
    String $createdAt = record.get(8);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(9);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $processed = record.get(10);
    if ($processed != null && $processed.length() > 0) {
      this.processed = Boolean.valueOf($processed);
    }
    String $processAttempts = record.get(11);
    if ($processAttempts != null && $processAttempts.length() > 0) {
      this.processAttempts = Integer.valueOf($processAttempts);
    }
    String $gradeMatchesCurrentSubmission = record.get(12);
    if ($gradeMatchesCurrentSubmission != null && $gradeMatchesCurrentSubmission.length() > 0) {
      this.gradeMatchesCurrentSubmission = Boolean.valueOf($gradeMatchesCurrentSubmission);
    }
    this.publishedGrade = record.get(13);
    String $gradedAt = record.get(14);
    if ($gradedAt != null && $gradedAt.length() > 0) {
      this.gradedAt = ZonedDateTime.parse($gradedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $hasRubricAssessment = record.get(15);
    if ($hasRubricAssessment != null && $hasRubricAssessment.length() > 0) {
      this.hasRubricAssessment = Boolean.valueOf($hasRubricAssessment);
    }
    String $attempt = record.get(16);
    if ($attempt != null && $attempt.length() > 0) {
      this.attempt = Integer.valueOf($attempt);
    }
    String $hasAdminComment = record.get(17);
    if ($hasAdminComment != null && $hasAdminComment.length() > 0) {
      this.hasAdminComment = Boolean.valueOf($hasAdminComment);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getBody() {
    return this.body;
  }

  public String getUrl() {
    return this.url;
  }

  public String getGrade() {
    return this.grade;
  }

  public ZonedDateTime getSubmittedAt() {
    return this.submittedAt;
  }

  public String getSubmissionType() {
    return this.submissionType;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Boolean getProcessed() {
    return this.processed;
  }

  public Integer getProcessAttempts() {
    return this.processAttempts;
  }

  public Boolean getGradeMatchesCurrentSubmission() {
    return this.gradeMatchesCurrentSubmission;
  }

  public String getPublishedGrade() {
    return this.publishedGrade;
  }

  public ZonedDateTime getGradedAt() {
    return this.gradedAt;
  }

  public Boolean getHasRubricAssessment() {
    return this.hasRubricAssessment;
  }

  public Integer getAttempt() {
    return this.attempt;
  }

  public Boolean getHasAdminComment() {
    return this.hasAdminComment;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(body);
    fields.add(url);
    fields.add(grade);
    fields.add(formatTimestamp(submittedAt));
    fields.add(submissionType);
    fields.add(workflowState);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(processed);
    fields.add(processAttempts);
    fields.add(gradeMatchesCurrentSubmission);
    fields.add(publishedGrade);
    fields.add(formatTimestamp(gradedAt));
    fields.add(hasRubricAssessment);
    fields.add(attempt);
    fields.add(hasAdminComment);
    return fields;
  }
}
