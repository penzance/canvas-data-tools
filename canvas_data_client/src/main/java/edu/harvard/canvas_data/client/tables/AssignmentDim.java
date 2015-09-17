package edu.harvard.canvas_data.client.tables;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class AssignmentDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Long courseId;
  private final String title;
  private final String description;
  private ZonedDateTime dueAt;
  private ZonedDateTime unlockAt;
  private ZonedDateTime lockAt;
  private Double pointsPossible;
  private final String gradingType;
  private final String submissionTypes;
  private final String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private Integer peerReviewCount;
  private ZonedDateTime peerReviewsDueAt;
  private Boolean peerReviewsAssigned;
  private Boolean peerReviews;
  private Boolean automaticPeerReviews;
  private Boolean allDay;
  private LocalDate allDayDate;
  private Boolean couldBeLocked;
  private Boolean gradeGroupStudentsIndividually;
  private Boolean anonymousPeerReviews;
  private Boolean muted;

  public AssignmentDim(final CSVRecord record) {
    final String $id = record.get(0);
    if (($id != null) && ($id.length() > 0)) {
      this.id = Long.valueOf($id);
    }
    final String $canvasId = record.get(1);
    if (($canvasId != null) && ($canvasId.length() > 0)) {
      this.canvasId = Long.valueOf($canvasId);
    }
    final String $courseId = record.get(2);
    if (($courseId != null) && ($courseId.length() > 0)) {
      this.courseId = Long.valueOf($courseId);
    }
    this.title = record.get(3);
    this.description = record.get(4);
    final String $dueAt = record.get(5);
    if (($dueAt != null) && ($dueAt.length() > 0)) {
      this.dueAt = ZonedDateTime.parse($dueAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $unlockAt = record.get(6);
    if (($unlockAt != null) && ($unlockAt.length() > 0)) {
      this.unlockAt = ZonedDateTime.parse($unlockAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $lockAt = record.get(7);
    if (($lockAt != null) && ($lockAt.length() > 0)) {
      this.lockAt = ZonedDateTime.parse($lockAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $pointsPossible = record.get(8);
    if (($pointsPossible != null) && ($pointsPossible.length() > 0)) {
      this.pointsPossible = Double.valueOf($pointsPossible);
    }
    this.gradingType = record.get(9);
    this.submissionTypes = record.get(10);
    this.workflowState = record.get(11);
    final String $createdAt = record.get(12);
    if (($createdAt != null) && ($createdAt.length() > 0)) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $updatedAt = record.get(13);
    if (($updatedAt != null) && ($updatedAt.length() > 0)) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $peerReviewCount = record.get(14);
    if (($peerReviewCount != null) && ($peerReviewCount.length() > 0)) {
      this.peerReviewCount = Integer.valueOf($peerReviewCount);
    }
    final String $peerReviewsDueAt = record.get(15);
    if (($peerReviewsDueAt != null) && ($peerReviewsDueAt.length() > 0)) {
      this.peerReviewsDueAt = ZonedDateTime.parse($peerReviewsDueAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    final String $peerReviewsAssigned = record.get(16);
    if (($peerReviewsAssigned != null) && ($peerReviewsAssigned.length() > 0)) {
      this.peerReviewsAssigned = Boolean.valueOf($peerReviewsAssigned);
    }
    final String $peerReviews = record.get(17);
    if (($peerReviews != null) && ($peerReviews.length() > 0)) {
      this.peerReviews = Boolean.valueOf($peerReviews);
    }
    final String $automaticPeerReviews = record.get(18);
    if (($automaticPeerReviews != null) && ($automaticPeerReviews.length() > 0)) {
      this.automaticPeerReviews = Boolean.valueOf($automaticPeerReviews);
    }
    final String $allDay = record.get(19);
    if (($allDay != null) && ($allDay.length() > 0)) {
      this.allDay = Boolean.valueOf($allDay);
    }
    final String $allDayDate = record.get(20);
    if (($allDayDate != null) && ($allDayDate.length() > 0)) {
      this.allDayDate = LocalDate.parse($allDayDate, CANVAS_DATA_ALL_DAY_FORMAT);
    }
    final String $couldBeLocked = record.get(21);
    if (($couldBeLocked != null) && ($couldBeLocked.length() > 0)) {
      this.couldBeLocked = Boolean.valueOf($couldBeLocked);
    }
    final String $gradeGroupStudentsIndividually = record.get(22);
    if (($gradeGroupStudentsIndividually != null) && ($gradeGroupStudentsIndividually.length() > 0)) {
      this.gradeGroupStudentsIndividually = Boolean.valueOf($gradeGroupStudentsIndividually);
    }
    final String $anonymousPeerReviews = record.get(23);
    if (($anonymousPeerReviews != null) && ($anonymousPeerReviews.length() > 0)) {
      this.anonymousPeerReviews = Boolean.valueOf($anonymousPeerReviews);
    }
    final String $muted = record.get(24);
    if (($muted != null) && ($muted.length() > 0)) {
      this.muted = Boolean.valueOf($muted);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public ZonedDateTime getDueAt() {
    return this.dueAt;
  }

  public ZonedDateTime getUnlockAt() {
    return this.unlockAt;
  }

  public ZonedDateTime getLockAt() {
    return this.lockAt;
  }

  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  public String getGradingType() {
    return this.gradingType;
  }

  public String getSubmissionTypes() {
    return this.submissionTypes;
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

  public Integer getPeerReviewCount() {
    return this.peerReviewCount;
  }

  public ZonedDateTime getPeerReviewsDueAt() {
    return this.peerReviewsDueAt;
  }

  public Boolean getPeerReviewsAssigned() {
    return this.peerReviewsAssigned;
  }

  public Boolean getPeerReviews() {
    return this.peerReviews;
  }

  public Boolean getAutomaticPeerReviews() {
    return this.automaticPeerReviews;
  }

  public Boolean getAllDay() {
    return this.allDay;
  }

  public LocalDate getAllDayDate() {
    return this.allDayDate;
  }

  public Boolean getCouldBeLocked() {
    return this.couldBeLocked;
  }

  public Boolean getGradeGroupStudentsIndividually() {
    return this.gradeGroupStudentsIndividually;
  }

  public Boolean getAnonymousPeerReviews() {
    return this.anonymousPeerReviews;
  }

  public Boolean getMuted() {
    return this.muted;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(courseId);
    fields.add(title);
    fields.add(description);
    fields.add(formatTimestamp(dueAt));
    fields.add(formatTimestamp(unlockAt));
    fields.add(formatTimestamp(lockAt));
    fields.add(pointsPossible);
    fields.add(gradingType);
    fields.add(submissionTypes);
    fields.add(workflowState);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(peerReviewCount);
    fields.add(formatTimestamp(peerReviewsDueAt));
    fields.add(peerReviewsAssigned);
    fields.add(peerReviews);
    fields.add(automaticPeerReviews);
    fields.add(allDay);
    fields.add(allDayDate == null ? null : allDayDate.format(CANVAS_DATA_ALL_DAY_FORMAT));
    fields.add(couldBeLocked);
    fields.add(gradeGroupStudentsIndividually);
    fields.add(anonymousPeerReviews);
    fields.add(muted);
    return fields;
  }
}
