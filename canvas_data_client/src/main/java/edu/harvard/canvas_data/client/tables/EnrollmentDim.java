package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class EnrollmentDim extends CanvasDataTable {
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

  public EnrollmentDim(final CSVRecord record) {
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
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(8);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $startAt = record.get(9);
    if ($startAt != null && $startAt.length() > 0) {
      this.startAt = ZonedDateTime.parse($startAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $endAt = record.get(10);
    if ($endAt != null && $endAt.length() > 0) {
      this.endAt = ZonedDateTime.parse($endAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $completedAt = record.get(11);
    if ($completedAt != null && $completedAt.length() > 0) {
      this.completedAt = ZonedDateTime.parse($completedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $selfEnrolled = record.get(12);
    if ($selfEnrolled != null && $selfEnrolled.length() > 0) {
      this.selfEnrolled = Boolean.valueOf($selfEnrolled);
    }
    this.sisSourceId = record.get(13);
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public Long getCourseSectionId() {
    return this.courseSectionId;
  }

  public Long getRoleId() {
    return this.roleId;
  }

  public String getType() {
    return this.type;
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

  public ZonedDateTime getStartAt() {
    return this.startAt;
  }

  public ZonedDateTime getEndAt() {
    return this.endAt;
  }

  public ZonedDateTime getCompletedAt() {
    return this.completedAt;
  }

  public Boolean getSelfEnrolled() {
    return this.selfEnrolled;
  }

  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(courseSectionId);
    fields.add(roleId);
    fields.add(type);
    fields.add(workflowState);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(formatTimestamp(startAt));
    fields.add(formatTimestamp(endAt));
    fields.add(formatTimestamp(completedAt));
    fields.add(selfEnrolled);
    fields.add(sisSourceId);
    return fields;
  }
}
