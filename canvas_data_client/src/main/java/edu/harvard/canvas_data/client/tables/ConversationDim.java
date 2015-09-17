package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class ConversationDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Boolean hasAttachments;
  private Boolean hasMediaObjects;
  private String subject;
  private Long courseId;
  private Long groupId;
  private Long accountId;

  public ConversationDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $hasAttachments = record.get(2);
    if ($hasAttachments != null && $hasAttachments.length() > 0) {
      this.hasAttachments = Boolean.valueOf($hasAttachments);
    }
    String $hasMediaObjects = record.get(3);
    if ($hasMediaObjects != null && $hasMediaObjects.length() > 0) {
      this.hasMediaObjects = Boolean.valueOf($hasMediaObjects);
    }
    this.subject = record.get(4);
    String $courseId = record.get(5);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $groupId = record.get(6);
    if ($groupId != null && $groupId.length() > 0) {
      this.groupId = Long.valueOf($groupId);
    }
    String $accountId = record.get(7);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Boolean getHasAttachments() {
    return this.hasAttachments;
  }

  public Boolean getHasMediaObjects() {
    return this.hasMediaObjects;
  }

  public String getSubject() {
    return this.subject;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getGroupId() {
    return this.groupId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(hasAttachments);
    fields.add(hasMediaObjects);
    fields.add(subject);
    fields.add(courseId);
    fields.add(groupId);
    fields.add(accountId);
    return fields;
  }
}
