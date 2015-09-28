package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class GroupDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private String name;
  private String description;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime deletedAt;
  private Boolean isPublic;
  private String workflowState;
  private String contextType;
  private String category;
  private String joinLevel;
  private String defaultView;
  private Long sisSourceId;

  public GroupDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.name = record.get(2);
    this.description = record.get(3);
    String $createdAt = record.get(4);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(5);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $deletedAt = record.get(6);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $isPublic = record.get(7);
    if ($isPublic != null && $isPublic.length() > 0) {
      this.isPublic = Boolean.valueOf($isPublic);
    }
    this.workflowState = record.get(8);
    this.contextType = record.get(9);
    this.category = record.get(10);
    this.joinLevel = record.get(11);
    this.defaultView = record.get(12);
    String $sisSourceId = record.get(13);
    if ($sisSourceId != null && $sisSourceId.length() > 0) {
      this.sisSourceId = Long.valueOf($sisSourceId);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  public Boolean getIsPublic() {
    return this.isPublic;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public String getContextType() {
    return this.contextType;
  }

  public String getCategory() {
    return this.category;
  }

  public String getJoinLevel() {
    return this.joinLevel;
  }

  public String getDefaultView() {
    return this.defaultView;
  }

  public Long getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(description);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(formatTimestamp(deletedAt));
    fields.add(isPublic);
    fields.add(workflowState);
    fields.add(contextType);
    fields.add(category);
    fields.add(joinLevel);
    fields.add(defaultView);
    fields.add(sisSourceId);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("name");
      fields.add("description");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("deleted_at");
      fields.add("is_public");
      fields.add("workflow_state");
      fields.add("context_type");
      fields.add("category");
      fields.add("join_level");
      fields.add("default_view");
      fields.add("sis_source_id");
    return fields;
  }
}
