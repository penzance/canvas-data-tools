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
    return fields;
  }
}
