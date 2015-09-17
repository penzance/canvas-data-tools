package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class ExternalToolActivationDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Long courseId;
  private Long accountId;
  private String activationTargetType;
  private String url;
  private String name;
  private String description;
  private String workflowState;
  private String privacyLevel;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String toolId;
  private Boolean selectableAll;

  public ExternalToolActivationDim(final CSVRecord record) {
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
    String $accountId = record.get(3);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    this.activationTargetType = record.get(4);
    this.url = record.get(5);
    this.name = record.get(6);
    this.description = record.get(7);
    this.workflowState = record.get(8);
    this.privacyLevel = record.get(9);
    String $createdAt = record.get(10);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(11);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.toolId = record.get(12);
    String $selectableAll = record.get(13);
    if ($selectableAll != null && $selectableAll.length() > 0) {
      this.selectableAll = Boolean.valueOf($selectableAll);
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

  public Long getAccountId() {
    return this.accountId;
  }

  public String getActivationTargetType() {
    return this.activationTargetType;
  }

  public String getUrl() {
    return this.url;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public String getPrivacyLevel() {
    return this.privacyLevel;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getToolId() {
    return this.toolId;
  }

  public Boolean getSelectableAll() {
    return this.selectableAll;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(courseId);
    fields.add(accountId);
    fields.add(activationTargetType);
    fields.add(url);
    fields.add(name);
    fields.add(description);
    fields.add(workflowState);
    fields.add(privacyLevel);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(toolId);
    fields.add(selectableAll);
    return fields;
  }
}
