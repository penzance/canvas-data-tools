// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

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

  /**
   * Unique surrogate id for the assignment. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the Canvas assignments table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Foreign key to the course associated with this assignment 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Title of the assignment 
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Long description of the assignment 
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Timestamp for when the assignment is due 
   */
  public ZonedDateTime getDueAt() {
    return this.dueAt;
  }

  /**
   * Timestamp for when the assignment is unlocked or visible to the user 
   */
  public ZonedDateTime getUnlockAt() {
    return this.unlockAt;
  }

  /**
   * Timestamp for when the assignment is locked 
   */
  public ZonedDateTime getLockAt() {
    return this.lockAt;
  }

  /**
   * Total points possible for the assignment 
   */
  public Double getPointsPossible() {
    return this.pointsPossible;
  }

  /**
   * Describes how the assignment will be graded (gpa_scale, pass_fail, 
   * percent, points, not_graded, letter_grade) 
   */
  public String getGradingType() {
    return this.gradingType;
  }

  /**
   * Comma separated list of valid methods for submitting the assignment 
   * (online_url, media_recording, online_upload, online_quize, external_tool, 
   * online_text_entry, online_file_upload) 
   */
  public String getSubmissionTypes() {
    return this.submissionTypes;
  }

  /**
   * Current worflow state of the assignment.  Possible vaues are unpublished, 
   * published and deleted 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Timestamp of the first time the assignment was entered into the system 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp of the last time the assignment was updated 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * The number of pears to assign for review if using algorithmic assignment 
   */
  public Integer getPeerReviewCount() {
    return this.peerReviewCount;
  }

  /**
   * Timestamp for when peer reviews should be completed 
   */
  public ZonedDateTime getPeerReviewsDueAt() {
    return this.peerReviewsDueAt;
  }

  /**
   * True if all peer reviews have been assigned 
   */
  public Boolean getPeerReviewsAssigned() {
    return this.peerReviewsAssigned;
  }

  /**
   * True if peer reviews are enabled for this assignment 
   */
  public Boolean getPeerReviews() {
    return this.peerReviews;
  }

  /**
   * True if peer reviews are assigned algorithmically (vs. letting the 
   * instructor make manual assignments) 
   */
  public Boolean getAutomaticPeerReviews() {
    return this.automaticPeerReviews;
  }

  /**
   * True if A specific time for when the assignment is due was not given.  The 
   * effective due time will be 11:59pm. 
   */
  public Boolean getAllDay() {
    return this.allDay;
  }

  /**
   * The date version of the due date if the all_day flag is true. 
   */
  public LocalDate getAllDayDate() {
    return this.allDayDate;
  }

  /**
   * tbd 
   */
  public Boolean getCouldBeLocked() {
    return this.couldBeLocked;
  }

  /**
   * True if students who submit work as a group will each receive individual 
   * grades (vs one grade that is copied to all group members) 
   */
  public Boolean getGradeGroupStudentsIndividually() {
    return this.gradeGroupStudentsIndividually;
  }

  /**
   * (currently unimplemented, do not use) 
   */
  public Boolean getAnonymousPeerReviews() {
    return this.anonymousPeerReviews;
  }

  /**
   * Student cannot see grades left on the assignment. 
   */
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
