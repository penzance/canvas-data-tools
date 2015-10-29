// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class DiscussionEntryDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String message;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime deletedAt;
  private Integer depth;

  public DiscussionEntryDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.message = record.get(2);
    this.workflowState = record.get(3);
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
    String $depth = record.get(7);
    if ($depth != null && $depth.length() > 0) {
      this.depth = Integer.valueOf($depth);
    }
  }

  /**
   * Unique surrogate id for the discussion entry. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the Canvas discussion_entries table 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Full text of the entry's message 
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Workflow state for discussion message (values: deleted, active) 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Timestamp when the discussion entry was created. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the discussion entry was upadated. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Timestamp when the discussion entry was deleted. 
   */
  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  /**
   * Reply depth for this entry 
   */
  public Integer getDepth() {
    return this.depth;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(message);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(formatter.formatTimestamp(deletedAt));
    fields.add(depth);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("message");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("deleted_at");
      fields.add("depth");
    return fields;
  }
}
