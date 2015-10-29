// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class GroupDim implements DataTable {
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

  public GroupDim(final TableFormat format, final CSVRecord record) {
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
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(5);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $deletedAt = record.get(6);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, format.getTimstampFormat());
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

  /**
   * Unique surrogate id for the group. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key to the groups table in canvas. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Name of the group. 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Description of the group. 
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Timestamp when the group was first saved in the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the group was last updated in the system. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Timestamp when the group was deleted. 
   */
  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  /**
   * True if the group contents are accessible to public. 
   */
  public Boolean getIsPublic() {
    return this.isPublic;
  }

  /**
   * Workflow state for group.(values: deleted,active) 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * The context type to which the group belongs to. For example- Accounts, 
   * Courses etc. 
   */
  public String getContextType() {
    return this.contextType;
  }

  /**
   * Group description by the users. 
   */
  public String getCategory() {
    return this.category;
  }

  /**
   * Permissions required to join a group. For example, it can be 
   * invitation-only or auto. 
   */
  public String getJoinLevel() {
    return this.joinLevel;
  }

  /**
   * Default view for groups is the feed. 
   */
  public String getDefaultView() {
    return this.defaultView;
  }

  /**
   * Correlated id for the record for this group in the SIS system (assuming 
   * SIS integration is configured) 
   */
  public Long getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(description);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(formatter.formatTimestamp(deletedAt));
    fields.add(isPublic);
    fields.add(workflowState);
    fields.add(contextType);
    fields.add(category);
    fields.add(joinLevel);
    fields.add(defaultView);
    fields.add(sisSourceId);
    return fields;
  }

  public static List<String> getFieldNames() {
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
