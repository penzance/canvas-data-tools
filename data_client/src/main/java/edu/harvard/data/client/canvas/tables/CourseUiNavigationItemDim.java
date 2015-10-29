// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseUiNavigationItemDim implements DataTable {
  private Long id;
  private Long rootAccountId;
  private String visible;
  private Integer position;

  public CourseUiNavigationItemDim(final TableFormat format, final CSVRecord record) {
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

  /**
   * Primary key for navigational item 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Foreign key to root account of the course 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * (visible|hidden) Visible if this element is visible, hidden if hidden/not 
   * available in the navigation 
   */
  public String getVisible() {
    return this.visible;
  }

  /**
   * Position in the navigation.  NULL if hidden. 
   */
  public Integer getPosition() {
    return this.position;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(rootAccountId);
    fields.add(visible);
    fields.add(position);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("root_account_id");
      fields.add("visible");
      fields.add("position");
    return fields;
  }
}
