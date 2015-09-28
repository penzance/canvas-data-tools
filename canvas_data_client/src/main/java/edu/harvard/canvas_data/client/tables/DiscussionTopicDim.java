package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class DiscussionTopicDim extends CanvasDataTable {
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

  public DiscussionTopicDim(final CSVRecord record) {
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
      this.lastReplyAt = ZonedDateTime.parse($lastReplyAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $createdAt = record.get(7);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(8);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $delayedPostAt = record.get(9);
    if ($delayedPostAt != null && $delayedPostAt.length() > 0) {
      this.delayedPostAt = ZonedDateTime.parse($delayedPostAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $postedAt = record.get(10);
    if ($postedAt != null && $postedAt.length() > 0) {
      this.postedAt = ZonedDateTime.parse($postedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $deletedAt = record.get(11);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
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

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getTitle() {
    return this.title;
  }

  public String getMessage() {
    return this.message;
  }

  public String getType() {
    return this.type;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public ZonedDateTime getLastReplyAt() {
    return this.lastReplyAt;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public ZonedDateTime getDelayedPostAt() {
    return this.delayedPostAt;
  }

  public ZonedDateTime getPostedAt() {
    return this.postedAt;
  }

  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  public String getDiscussionType() {
    return this.discussionType;
  }

  public Boolean getPinned() {
    return this.pinned;
  }

  public Boolean getLocked() {
    return this.locked;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(title);
    fields.add(message);
    fields.add(type);
    fields.add(workflowState);
    fields.add(formatTimestamp(lastReplyAt));
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(formatTimestamp(delayedPostAt));
    fields.add(formatTimestamp(postedAt));
    fields.add(formatTimestamp(deletedAt));
    fields.add(discussionType);
    fields.add(pinned);
    fields.add(locked);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
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
