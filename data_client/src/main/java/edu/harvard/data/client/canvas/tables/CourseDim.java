// This file was generated on 29-10-2015 01:16:09. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private Long accountId;
  private Long enrollmentTermId;
  private String name;
  private String code;
  private String type;
  private ZonedDateTime createdAt;
  private ZonedDateTime startAt;
  private ZonedDateTime concludeAt;
  private Boolean publiclyVisible;
  private String sisSourceId;
  private String workflowState;

  public CourseDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $rootAccountId = record.get(2);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $accountId = record.get(3);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    this.name = record.get(5);
    this.code = record.get(6);
    this.type = record.get(7);
    String $createdAt = record.get(8);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $startAt = record.get(9);
    if ($startAt != null && $startAt.length() > 0) {
      this.startAt = ZonedDateTime.parse($startAt, format.getTimstampFormat());
    }
    String $concludeAt = record.get(10);
    if ($concludeAt != null && $concludeAt.length() > 0) {
      this.concludeAt = ZonedDateTime.parse($concludeAt, format.getTimstampFormat());
    }
    String $publiclyVisible = record.get(11);
    if ($publiclyVisible != null && $publiclyVisible.length() > 0) {
      this.publiclyVisible = Boolean.valueOf($publiclyVisible);
    }
    this.sisSourceId = record.get(12);
    this.workflowState = record.get(13);
  }

  /**
   * Unique surrogate id for a course 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this course in the canvas courses table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * The root account associated with this course. 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * The parent account for this course. 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  /**
   * Foreign key to enrollment term table 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * The friendly name of the course. 
   */
  public String getName() {
    return this.name;
  }

  /**
   * The code for the course (eg FA12 MATH 2000) 
   */
  public String getCode() {
    return this.code;
  }

  /**
   * tbd 
   */
  public String getType() {
    return this.type;
  }

  /**
   * Timestamp when the course object was created in Canvas 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp for when the course starts. 
   */
  public ZonedDateTime getStartAt() {
    return this.startAt;
  }

  /**
   * Timestamp for when the course finishes 
   */
  public ZonedDateTime getConcludeAt() {
    return this.concludeAt;
  }

  /**
   * True if the course is publically visible 
   */
  public Boolean getPubliclyVisible() {
    return this.publiclyVisible;
  }

  /**
   * Correlated id for the record for this course in the SIS system (assuming 
   * SIS integration is configured) 
   */
  public String getSisSourceId() {
    return this.sisSourceId;
  }

  /**
   * Workflow status indicating the current state of the course, valid values 
   * are: completed, created, deleted, available, claimed 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(accountId);
    fields.add(enrollmentTermId);
    fields.add(name);
    fields.add(code);
    fields.add(type);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(startAt));
    fields.add(formatter.formatTimestamp(concludeAt));
    fields.add(publiclyVisible);
    fields.add(sisSourceId);
    fields.add(workflowState);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("root_account_id");
      fields.add("account_id");
      fields.add("enrollment_term_id");
      fields.add("name");
      fields.add("code");
      fields.add("type");
      fields.add("created_at");
      fields.add("start_at");
      fields.add("conclude_at");
      fields.add("publicly_visible");
      fields.add("sis_source_id");
      fields.add("workflow_state");
    return fields;
  }
}
