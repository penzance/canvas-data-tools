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

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  public String getActivationTargetType() {
    return this.activationTargetType;
  }

  public String getUrl() {
    return this.url;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public String getPrivacyLevel() {
    return this.privacyLevel;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

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
