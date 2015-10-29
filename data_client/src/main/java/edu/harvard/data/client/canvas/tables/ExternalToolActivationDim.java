// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class ExternalToolActivationDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long courseId;
  private Long accountId;
  private String activationTargetType;
  private String url;
  private String name;
  private String description;
  private String workflowState;
  private String privacyLevel;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String toolId;
  private Boolean selectableAll;

  public ExternalToolActivationDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $courseId = record.get(2);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $accountId = record.get(3);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    this.activationTargetType = record.get(4);
    this.url = record.get(5);
    this.name = record.get(6);
    this.description = record.get(7);
    this.workflowState = record.get(8);
    this.privacyLevel = record.get(9);
    String $createdAt = record.get(10);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(11);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    this.toolId = record.get(12);
    String $selectableAll = record.get(13);
    if ($selectableAll != null && $selectableAll.length() > 0) {
      this.selectableAll = Boolean.valueOf($selectableAll);
    }
  }

  /**
   * Unique surrogate id for tool activations 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the context_external_tools table in the 
   * Canvas database 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Foreign key to the course if this tool was activated in a course 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to the account this tool was activatated in if it was 
   * activated in an account 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  /**
   * The type of object the tool was activated in, (course or account) 
   */
  public String getActivationTargetType() {
    return this.activationTargetType;
  }

  /**
   * The URL to where the tool may launch to 
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * The name of tool activation as entered by the user 
   */
  public String getName() {
    return this.name;
  }

  /**
   * The description of the tool activation as entered by the user 
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Workflow state for activation (active, deleted) 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Privacy setting for activation (name_only, email_only, anonymous, public) 
   */
  public String getPrivacyLevel() {
    return this.privacyLevel;
  }

  /**
   * Timestamp when the activation was created 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when the activation was last updated 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * The tool id received from the external tool. May be missing if the tool 
   * does not send an id. 
   */
  public String getToolId() {
    return this.toolId;
  }

  public Boolean getSelectableAll() {
    return this.selectableAll;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(courseId);
    fields.add(accountId);
    fields.add(activationTargetType);
    fields.add(url);
    fields.add(name);
    fields.add(description);
    fields.add(workflowState);
    fields.add(privacyLevel);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(toolId);
    fields.add(selectableAll);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("course_id");
      fields.add("account_id");
      fields.add("activation_target_type");
      fields.add("url");
      fields.add("name");
      fields.add("description");
      fields.add("workflow_state");
      fields.add("privacy_level");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("tool_id");
      fields.add("selectable_all");
    return fields;
  }
}
