package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class AssignmentDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long courseId;
  private String title;
  private String description;
  private ZonedDateTime dueAt;
  private ZonedDateTime unlockAt;
  private ZonedDateTime lockAt;
  private Double pointsPossible;
  private String gradingType;
  private String submissionTypes;
  private String workflowState;
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

  public AssignmentDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $courseId = record.get(2);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    this.title = record.get(3);
    this.description = record.get(4);
    String $dueAt = record.get(5);
    if ($dueAt != null && $dueAt.length() > 0) {
      this.dueAt = ZonedDateTime.parse($dueAt, format.getTimstampFormat());
    }
    String $unlockAt = record.get(6);
    if ($unlockAt != null && $unlockAt.length() > 0) {
      this.unlockAt = ZonedDateTime.parse($unlockAt, format.getTimstampFormat());
    }
    String $lockAt = record.get(7);
    if ($lockAt != null && $lockAt.length() > 0) {
      this.lockAt = ZonedDateTime.parse($lockAt, format.getTimstampFormat());
    }
    String $pointsPossible = record.get(8);
    if ($pointsPossible != null && $pointsPossible.length() > 0) {
      this.pointsPossible = Double.valueOf($pointsPossible);
    }
    this.gradingType = record.get(9);
    this.submissionTypes = record.get(10);
    this.workflowState = record.get(11);
    String $createdAt = record.get(12);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(13);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $peerReviewCount = record.get(14);
    if ($peerReviewCount != null && $peerReviewCount.length() > 0) {
      this.peerReviewCount = Integer.valueOf($peerReviewCount);
    }
    String $peerReviewsDueAt = record.get(15);
    if ($peerReviewsDueAt != null && $peerReviewsDueAt.length() > 0) {
      this.peerReviewsDueAt = ZonedDateTime.parse($peerReviewsDueAt, format.getTimstampFormat());
    }
    String $peerReviewsAssigned = record.get(16);
    if ($peerReviewsAssigned != null && $peerReviewsAssigned.length() > 0) {
      this.peerReviewsAssigned = Boolean.valueOf($peerReviewsAssigned);
    }
    String $peerReviews = record.get(17);
    if ($peerReviews != null && $peerReviews.length() > 0) {
      this.peerReviews = Boolean.valueOf($peerReviews);
    }
    String $automaticPeerReviews = record.get(18);
    if ($automaticPeerReviews != null && $automaticPeerReviews.length() > 0) {
      this.automaticPeerReviews = Boolean.valueOf($automaticPeerReviews);
    }
    String $allDay = record.get(19);
    if ($allDay != null && $allDay.length() > 0) {
      this.allDay = Boolean.valueOf($allDay);
    }
    String $allDayDate = record.get(20);
    if ($allDayDate != null && $allDayDate.length() > 0) {
      this.allDayDate = LocalDate.parse($allDayDate, format.getDateFormat());
    }
    String $couldBeLocked = record.get(21);
    if ($couldBeLocked != null && $couldBeLocked.length() > 0) {
      this.couldBeLocked = Boolean.valueOf($couldBeLocked);
    }
    String $gradeGroupStudentsIndividually = record.get(22);
    if ($gradeGroupStudentsIndividually != null && $gradeGroupStudentsIndividually.length() > 0) {
      this.gradeGroupStudentsIndividually = Boolean.valueOf($gradeGroupStudentsIndividually);
    }
    String $anonymousPeerReviews = record.get(23);
    if ($anonymousPeerReviews != null && $anonymousPeerReviews.length() > 0) {
      this.anonymousPeerReviews = Boolean.valueOf($anonymousPeerReviews);
    }
    String $muted = record.get(24);
    if ($muted != null && $muted.length() > 0) {
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
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(courseId);
    fields.add(title);
    fields.add(description);
    fields.add(formatter.formatTimestamp(dueAt));
    fields.add(formatter.formatTimestamp(unlockAt));
    fields.add(formatter.formatTimestamp(lockAt));
    fields.add(pointsPossible);
    fields.add(gradingType);
    fields.add(submissionTypes);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(peerReviewCount);
    fields.add(formatter.formatTimestamp(peerReviewsDueAt));
    fields.add(peerReviewsAssigned);
    fields.add(peerReviews);
    fields.add(automaticPeerReviews);
    fields.add(allDay);
    fields.add(formatter.formatTimestamp(allDayDate));
    fields.add(couldBeLocked);
    fields.add(gradeGroupStudentsIndividually);
    fields.add(anonymousPeerReviews);
    fields.add(muted);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("course_id");
      fields.add("title");
      fields.add("description");
      fields.add("due_at");
      fields.add("unlock_at");
      fields.add("lock_at");
      fields.add("points_possible");
      fields.add("grading_type");
      fields.add("submission_types");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("peer_review_count");
      fields.add("peer_reviews_due_at");
      fields.add("peer_reviews_assigned");
      fields.add("peer_reviews");
      fields.add("automatic_peer_reviews");
      fields.add("all_day");
      fields.add("all_day_date");
      fields.add("could_be_locked");
      fields.add("grade_group_students_individually");
      fields.add("anonymous_peer_reviews");
      fields.add("muted");
    return fields;
  }
}
