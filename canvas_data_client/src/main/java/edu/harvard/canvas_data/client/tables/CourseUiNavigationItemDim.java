package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class CourseUiNavigationItemDim extends CanvasDataTable {
  private Long id;
  private Long rootAccountId;
  private String visible;
  private Integer position;

  public CourseUiNavigationItemDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $rootAccountId = record.get(1);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    this.visible = record.get(2);
    String $position = record.get(3);
    if ($position != null && $position.length() > 0) {
      this.position = Integer.valueOf($position);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public String getVisible() {
    return this.visible;
  }

  public Integer getPosition() {
    return this.position;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(rootAccountId);
    fields.add(visible);
    fields.add(position);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("root_account_id");
      fields.add("visible");
      fields.add("position");
    return fields;
  }
}
