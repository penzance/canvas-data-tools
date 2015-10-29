// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class ConversationDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Boolean hasAttachments;
  private Boolean hasMediaObjects;
  private String subject;
  private Long courseId;
  private Long groupId;
  private Long accountId;

  public ConversationDim(final TableFormat format, final CSVRecord record) {
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

  /**
   * Unique surrogate id for the conversation. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Original primary key for conversation in the Canvas table 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * True if the conversation has attachments 
   */
  public Boolean getHasAttachments() {
    return this.hasAttachments;
  }

  /**
   * True if the conversation has media objects 
   */
  public Boolean getHasMediaObjects() {
    return this.hasMediaObjects;
  }

  /**
   * The subject of the conversation 
   */
  public String getSubject() {
    return this.subject;
  }

  /**
   * The course that owns this conversation 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * The group that owns this converation (note the group dimension has not 
   * been implemented yet) 
   */
  public Long getGroupId() {
    return this.groupId;
  }

  /**
   * The account this owns this conversation 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
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

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("has_attachments");
      fields.add("has_media_objects");
      fields.add("subject");
      fields.add("course_id");
      fields.add("group_id");
      fields.add("account_id");
    return fields;
  }
}
