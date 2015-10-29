// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class WikiPageDim implements DataTable {
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

  public WikiPageDim(final TableFormat format, final CSVRecord record) {
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
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(6);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    this.url = record.get(7);
    String $protectedEditing = record.get(8);
    if ($protectedEditing != null && $protectedEditing.length() > 0) {
      this.protectedEditing = Boolean.valueOf($protectedEditing);
    }
    this.editingRoles = record.get(9);
    String $revisedAt = record.get(10);
    if ($revisedAt != null && $revisedAt.length() > 0) {
      this.revisedAt = ZonedDateTime.parse($revisedAt, format.getTimstampFormat());
    }
    String $couldBeLocked = record.get(11);
    if ($couldBeLocked != null && $couldBeLocked.length() > 0) {
      this.couldBeLocked = Boolean.valueOf($couldBeLocked);
    }
  }

  /**
   * Unique id for the wiki pages. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for the wiki pages table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Title of the wiki page. 
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Body of the wiki page. Redshift will only load the first 256 bytes of the 
   * body. 
   */
  public String getBody() {
    return this.body;
  }

  /**
   * Current state the wiki is in. For Example, active, unpublished, deleted. 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Timestamp when the wiki page was created in the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the wiki page was last updated in the system. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * URL for the wiki page. 
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * Editing protection for the wiki page. It is false by default. 
   */
  public Boolean getProtectedEditing() {
    return this.protectedEditing;
  }

  /**
   * Users or roles who can edit a wiki page. 
   */
  public String getEditingRoles() {
    return this.editingRoles;
  }

  /**
   * Timestamp the wiki page was last revised in the system. 
   */
  public ZonedDateTime getRevisedAt() {
    return this.revisedAt;
  }

  /**
   * True if the wiki page can be locked. This prevents it from being visible 
   * to others until ready. 
   */
  public Boolean getCouldBeLocked() {
    return this.couldBeLocked;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(title);
    fields.add(body);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(url);
    fields.add(protectedEditing);
    fields.add(editingRoles);
    fields.add(formatter.formatTimestamp(revisedAt));
    fields.add(couldBeLocked);
    return fields;
  }

  public static List<String> getFieldNames() {
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
