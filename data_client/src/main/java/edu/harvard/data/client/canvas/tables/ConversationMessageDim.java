// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class ConversationMessageDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long conversationId;
  private Long authorId;
  private ZonedDateTime createdAt;
  private Boolean generated;
  private Boolean hasAttachments;
  private Boolean hasMediaObjects;
  private String body;

  public ConversationMessageDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $conversationId = record.get(2);
    if ($conversationId != null && $conversationId.length() > 0) {
      this.conversationId = Long.valueOf($conversationId);
    }
    String $authorId = record.get(3);
    if ($authorId != null && $authorId.length() > 0) {
      this.authorId = Long.valueOf($authorId);
    }
    String $createdAt = record.get(4);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $generated = record.get(5);
    if ($generated != null && $generated.length() > 0) {
      this.generated = Boolean.valueOf($generated);
    }
    String $hasAttachments = record.get(6);
    if ($hasAttachments != null && $hasAttachments.length() > 0) {
      this.hasAttachments = Boolean.valueOf($hasAttachments);
    }
    String $hasMediaObjects = record.get(7);
    if ($hasMediaObjects != null && $hasMediaObjects.length() > 0) {
      this.hasMediaObjects = Boolean.valueOf($hasMediaObjects);
    }
    this.body = record.get(8);
  }

  /**
   * Unique surrogate id for the message. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Original ID for canvas table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Parent conversation for this message. 
   */
  public Long getConversationId() {
    return this.conversationId;
  }

  /**
   * User id of the author of the message. 
   */
  public Long getAuthorId() {
    return this.authorId;
  }

  /**
   * Date and time this message was created. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * This attribute is true if the system generated this message (e.g. "John 
   * was added to this conversation") 
   */
  public Boolean getGenerated() {
    return this.generated;
  }

  /**
   * True if the message has attachments. 
   */
  public Boolean getHasAttachments() {
    return this.hasAttachments;
  }

  /**
   * True if the message has media objects. 
   */
  public Boolean getHasMediaObjects() {
    return this.hasMediaObjects;
  }

  /**
   * The content of the message. 
   */
  public String getBody() {
    return this.body;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(conversationId);
    fields.add(authorId);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(generated);
    fields.add(hasAttachments);
    fields.add(hasMediaObjects);
    fields.add(body);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("conversation_id");
      fields.add("author_id");
      fields.add("created_at");
      fields.add("generated");
      fields.add("has_attachments");
      fields.add("has_media_objects");
      fields.add("body");
    return fields;
  }
}
