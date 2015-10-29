// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class EnrollmentDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private Long courseSectionId;
  private Long roleId;
  private String type;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime startAt;
  private ZonedDateTime endAt;
  private ZonedDateTime completedAt;
  private Boolean selfEnrolled;
  private String sisSourceId;
  private Long courseId;
  private Long userId;

  public EnrollmentDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $rootAccountId = record.get(2);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $courseSectionId = record.get(3);
    if ($courseSectionId != null && $courseSectionId.length() > 0) {
      this.courseSectionId = Long.valueOf($courseSectionId);
    }
    String $roleId = record.get(4);
    if ($roleId != null && $roleId.length() > 0) {
      this.roleId = Long.valueOf($roleId);
    }
    this.type = record.get(5);
    this.workflowState = record.get(6);
    String $createdAt = record.get(7);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(8);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $startAt = record.get(9);
    if ($startAt != null && $startAt.length() > 0) {
      this.startAt = ZonedDateTime.parse($startAt, format.getTimstampFormat());
    }
    String $endAt = record.get(10);
    if ($endAt != null && $endAt.length() > 0) {
      this.endAt = ZonedDateTime.parse($endAt, format.getTimstampFormat());
    }
    String $completedAt = record.get(11);
    if ($completedAt != null && $completedAt.length() > 0) {
      this.completedAt = ZonedDateTime.parse($completedAt, format.getTimstampFormat());
    }
    String $selfEnrolled = record.get(12);
    if ($selfEnrolled != null && $selfEnrolled.length() > 0) {
      this.selfEnrolled = Boolean.valueOf($selfEnrolled);
    }
    this.sisSourceId = record.get(13);
    String $courseId = record.get(14);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $userId = record.get(15);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
  }

  /**
   * Unique surrogate id for the enrollment. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the Canvas enrollments table 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Root account id associated with this enrollment 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Foreign key to the course section for this enrollment 
   */
  public Long getCourseSectionId() {
    return this.courseSectionId;
  }

  /**
   * Foreign key to the role of the person enrolled in the course 
   */
  public Long getRoleId() {
    return this.roleId;
  }

  /**
   * Enrollment type: TaEnrollment, DesignerEnrollment, StudentEnrollment, 
   * TeacherEnrollment, StudentViewEnrollment, ObserverEnrollment 
   */
  public String getType() {
    return this.type;
  }

  /**
   * Workflow state for enrollment: active, completed, rejected, deleted, 
   * invited, creation_pending 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Timestamp for when this section was entered into the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp for when the last time the section was updated 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Enrollment start date 
   */
  public ZonedDateTime getStartAt() {
    return this.startAt;
  }

  /**
   * Enrollment end date 
   */
  public ZonedDateTime getEndAt() {
    return this.endAt;
  }

  /**
   * Enrollment completed date 
   */
  public ZonedDateTime getCompletedAt() {
    return this.completedAt;
  }

  /**
   * Enrollment was created via self-enrollment 
   */
  public Boolean getSelfEnrolled() {
    return this.selfEnrolled;
  }

  /**
   * Id of correlated enrollment in the SIS (assuming the SIS is configured 
   * properly) 
   */
  public String getSisSourceId() {
    return this.sisSourceId;
  }

  /**
   * Foreign key to course for this enrollment 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to user for the enrollment 
   */
  public Long getUserId() {
    return this.userId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(courseSectionId);
    fields.add(roleId);
    fields.add(type);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(formatter.formatTimestamp(startAt));
    fields.add(formatter.formatTimestamp(endAt));
    fields.add(formatter.formatTimestamp(completedAt));
    fields.add(selfEnrolled);
    fields.add(sisSourceId);
    fields.add(courseId);
    fields.add(userId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("root_account_id");
      fields.add("course_section_id");
      fields.add("role_id");
      fields.add("type");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("start_at");
      fields.add("end_at");
      fields.add("completed_at");
      fields.add("self_enrolled");
      fields.add("sis_source_id");
      fields.add("course_id");
      fields.add("user_id");
    return fields;
  }
}
