package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class WikiPageDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private String title;
  private String body;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String url;
  private Boolean protectedEditing;
  private String editingRoles;
  private ZonedDateTime revisedAt;
  private Boolean couldBeLocked;

  public WikiPageDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.title = record.get(2);
    this.body = record.get(3);
    this.workflowState = record.get(4);
    String $createdAt = record.get(5);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(6);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.url = record.get(7);
    String $protectedEditing = record.get(8);
    if ($protectedEditing != null && $protectedEditing.length() > 0) {
      this.protectedEditing = Boolean.valueOf($protectedEditing);
    }
    this.editingRoles = record.get(9);
    String $revisedAt = record.get(10);
    if ($revisedAt != null && $revisedAt.length() > 0) {
      this.revisedAt = ZonedDateTime.parse($revisedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $couldBeLocked = record.get(11);
    if ($couldBeLocked != null && $couldBeLocked.length() > 0) {
      this.couldBeLocked = Boolean.valueOf($couldBeLocked);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getTitle() {
    return this.title;
  }

  public String getBody() {
    return this.body;
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

  public String getUrl() {
    return this.url;
  }

  public Boolean getProtectedEditing() {
    return this.protectedEditing;
  }

  public String getEditingRoles() {
    return this.editingRoles;
  }

  public ZonedDateTime getRevisedAt() {
    return this.revisedAt;
  }

  public Boolean getCouldBeLocked() {
    return this.couldBeLocked;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(title);
    fields.add(body);
    fields.add(workflowState);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(url);
    fields.add(protectedEditing);
    fields.add(editingRoles);
    fields.add(formatTimestamp(revisedAt));
    fields.add(couldBeLocked);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("title");
      fields.add("body");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("url");
      fields.add("protected_editing");
      fields.add("editing_roles");
      fields.add("revised_at");
      fields.add("could_be_locked");
    return fields;
  }
}
