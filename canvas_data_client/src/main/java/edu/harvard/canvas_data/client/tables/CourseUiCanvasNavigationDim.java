package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class CourseUiCanvasNavigationDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private String name;
  private String _default;
  private String originalPosition;

  public CourseUiCanvasNavigationDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.name = record.get(2);
    this._default = record.get(3);
    this.originalPosition = record.get(4);
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getName() {
    return this.name;
  }

  public String getDefault() {
    return this._default;
  }

  public String getOriginalPosition() {
    return this.originalPosition;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(_default);
    fields.add(originalPosition);
    return fields;
  }
}
