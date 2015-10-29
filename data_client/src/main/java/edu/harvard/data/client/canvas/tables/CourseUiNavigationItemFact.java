// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseUiNavigationItemFact implements DataTable {
  private Long rootAccountId;
  private Long courseUiNavigationItemId;
  private Long courseUiCanvasNavigationId;
  private Long externalToolActivationId;
  private Long courseId;
  private Long courseAccountId;
  private Long enrollmentTermId;

  public CourseUiNavigationItemFact(final TableFormat format, final CSVRecord record) {
    String $rootAccountId = record.get(0);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $courseUiNavigationItemId = record.get(1);
    if ($courseUiNavigationItemId != null && $courseUiNavigationItemId.length() > 0) {
      this.courseUiNavigationItemId = Long.valueOf($courseUiNavigationItemId);
    }
    String $courseUiCanvasNavigationId = record.get(2);
    if ($courseUiCanvasNavigationId != null && $courseUiCanvasNavigationId.length() > 0) {
      this.courseUiCanvasNavigationId = Long.valueOf($courseUiCanvasNavigationId);
    }
    String $externalToolActivationId = record.get(3);
    if ($externalToolActivationId != null && $externalToolActivationId.length() > 0) {
      this.externalToolActivationId = Long.valueOf($externalToolActivationId);
    }
    String $courseId = record.get(4);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $courseAccountId = record.get(5);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
    String $enrollmentTermId = record.get(6);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
  }

  /**
   * Foreign key to root account of the course 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Foreign key to course_ui_navigation_item_dim 
   */
  public Long getCourseUiNavigationItemId() {
    return this.courseUiNavigationItemId;
  }

  /**
   * Foreign key to navigation function 
   */
  public Long getCourseUiCanvasNavigationId() {
    return this.courseUiCanvasNavigationId;
  }

  /**
   * Foreign key toexternal_tool_activation_dim 
   */
  public Long getExternalToolActivationId() {
    return this.externalToolActivationId;
  }

  /**
   * Foreign key to course 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to account for course 
   */
  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  /**
   * Foreign key to enrollment term 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(rootAccountId);
    fields.add(courseUiNavigationItemId);
    fields.add(courseUiCanvasNavigationId);
    fields.add(externalToolActivationId);
    fields.add(courseId);
    fields.add(courseAccountId);
    fields.add(enrollmentTermId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("root_account_id");
      fields.add("course_ui_navigation_item_id");
      fields.add("course_ui_canvas_navigation_id");
      fields.add("external_tool_activation_id");
      fields.add("course_id");
      fields.add("course_account_id");
      fields.add("enrollment_term_id");
    return fields;
  }
}
