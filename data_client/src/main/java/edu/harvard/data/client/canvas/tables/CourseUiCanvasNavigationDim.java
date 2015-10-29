// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseUiCanvasNavigationDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String name;
  private String _default;
  private String originalPosition;

  public CourseUiCanvasNavigationDim(final TableFormat format, final CSVRecord record) {
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

  /**
   * Primary key for navigational item 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * ID in Canvas system 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Name of navigational item 
   */
  public String getName() {
    return this.name;
  }

  /**
   * (Defualt|NotDefault) - set to Default if this is one of the navigation 
   * items enabled in a course by default 
   */
  public String getDefault() {
    return this._default;
  }

  /**
   * Original position of this navigation item 
   */
  public String getOriginalPosition() {
    return this.originalPosition;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(_default);
    fields.add(originalPosition);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("name");
      fields.add("default");
      fields.add("original_position");
    return fields;
  }
}
