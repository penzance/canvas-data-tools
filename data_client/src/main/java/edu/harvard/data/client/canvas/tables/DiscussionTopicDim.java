// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class DiscussionTopicDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String title;
  private String message;
  private String type;
  private String workflowState;
  private ZonedDateTime lastReplyAt;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime delayedPostAt;
  private ZonedDateTime postedAt;
  private ZonedDateTime deletedAt;
  private String discussionType;
  private Boolean pinned;
  private Boolean locked;

  public DiscussionTopicDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.title = record.get(2);
    this.message = record.get(3);
    this.type = record.get(4);
    this.workflowState = record.get(5);
    String $lastReplyAt = record.get(6);
    if ($lastReplyAt != null && $lastReplyAt.length() > 0) {
      this.lastReplyAt = ZonedDateTime.parse($lastReplyAt, format.getTimstampFormat());
    }
    String $createdAt = record.get(7);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(8);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $delayedPostAt = record.get(9);
    if ($delayedPostAt != null && $delayedPostAt.length() > 0) {
      this.delayedPostAt = ZonedDateTime.parse($delayedPostAt, format.getTimstampFormat());
    }
    String $postedAt = record.get(10);
    if ($postedAt != null && $postedAt.length() > 0) {
      this.postedAt = ZonedDateTime.parse($postedAt, format.getTimstampFormat());
    }
    String $deletedAt = record.get(11);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, format.getTimstampFormat());
    }
    this.discussionType = record.get(12);
    String $pinned = record.get(13);
    if ($pinned != null && $pinned.length() > 0) {
      this.pinned = Boolean.valueOf($pinned);
    }
    String $locked = record.get(14);
    if ($locked != null && $locked.length() > 0) {
      this.locked = Boolean.valueOf($locked);
    }
  }

  /**
   * Unique surrogate id for the discussion topic. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key to the dicussion_topics table in Canvas 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Title of the discussion topic 
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Message text for the discussion topic. 
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Discussion topic type.  Two types are default (blank) and announcement. 
   */
  public String getType() {
    return this.type;
  }

  /**
   * Workflow state for this discussion topic.  Valid states are unpublished, 
   * active, locked, deleted, and post_delayed 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Timestamp of the last reply to this topic. 
   */
  public ZonedDateTime getLastReplyAt() {
    return this.lastReplyAt;
  }

  /**
   * Timestamp when the discussion topic was first saved in the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the discussion topic was last updated in the system. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Timestamp when the discussion topic was/will be delay-posted 
   */
  public ZonedDateTime getDelayedPostAt() {
    return this.delayedPostAt;
  }

  /**
   * Timestamp when the discussion topic was posted 
   */
  public ZonedDateTime getPostedAt() {
    return this.postedAt;
  }

  /**
   * Timestamp when the discussion topic was deleted. 
   */
  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  /**
   * Type of discussion topic: default(blank), side_comment, threaded.  
   * threaded indicates that replies are threaded where side_comment indicates 
   * that replies in the discussion are flat.  See related Canvas Guide 
   * https://guides.instructure.com/m/4152/l/60423-how-do-i-create-a-threaded-discussion 
   */
  public String getDiscussionType() {
    return this.discussionType;
  }

  /**
   * True if the discussion topic has been pinned 
   */
  public Boolean getPinned() {
    return this.pinned;
  }

  /**
   * True if the discussion topic has been locked 
   */
  public Boolean getLocked() {
    return this.locked;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(title);
    fields.add(message);
    fields.add(type);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(lastReplyAt));
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(formatter.formatTimestamp(delayedPostAt));
    fields.add(formatter.formatTimestamp(postedAt));
    fields.add(formatter.formatTimestamp(deletedAt));
    fields.add(discussionType);
    fields.add(pinned);
    fields.add(locked);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("title");
      fields.add("message");
      fields.add("type");
      fields.add("workflow_state");
      fields.add("last_reply_at");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("delayed_post_at");
      fields.add("posted_at");
      fields.add("deleted_at");
      fields.add("discussion_type");
      fields.add("pinned");
      fields.add("locked");
    return fields;
  }
}
