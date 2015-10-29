// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class WikiDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String parentType;
  private String title;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String frontPageUrl;
  private Boolean hasNoFrontPage;

  public WikiDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.parentType = record.get(2);
    this.title = record.get(3);
    String $createdAt = record.get(4);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(5);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    this.frontPageUrl = record.get(6);
    String $hasNoFrontPage = record.get(7);
    if ($hasNoFrontPage != null && $hasNoFrontPage.length() > 0) {
      this.hasNoFrontPage = Boolean.valueOf($hasNoFrontPage);
    }
  }

  /**
   * Unique id for the wiki. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key to the wikis table in canvas. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Type of Parent the wiki belongs to. For example, Groups or Courses. 
   */
  public String getParentType() {
    return this.parentType;
  }

  /**
   * Title for the wiki. 
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Timestamp when the wiki was first saved in the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the wiki was last updated in the system. 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * URL of the front page of the wiki. 
   */
  public String getFrontPageUrl() {
    return this.frontPageUrl;
  }

  /**
   * True if the wiki does not have a front page or is set to NULL. 
   */
  public Boolean getHasNoFrontPage() {
    return this.hasNoFrontPage;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(parentType);
    fields.add(title);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(frontPageUrl);
    fields.add(hasNoFrontPage);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("parent_type");
      fields.add("title");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("front_page_url");
      fields.add("has_no_front_page");
    return fields;
  }
}
