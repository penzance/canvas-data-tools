// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class EnrollmentTermDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private String name;
  private ZonedDateTime dateStart;
  private ZonedDateTime dateEnd;
  private String sisSourceId;

  public EnrollmentTermDim(final TableFormat format, final CSVRecord record) {
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
    this.name = record.get(3);
    String $dateStart = record.get(4);
    if ($dateStart != null && $dateStart.length() > 0) {
      this.dateStart = ZonedDateTime.parse($dateStart, format.getTimstampFormat());
    }
    String $dateEnd = record.get(5);
    if ($dateEnd != null && $dateEnd.length() > 0) {
      this.dateEnd = ZonedDateTime.parse($dateEnd, format.getTimstampFormat());
    }
    this.sisSourceId = record.get(6);
  }

  /**
   * Unique surrogate id for the enrollment term. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the Canvas enrollments table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Foreign key to the root account for this enrollment term 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Name of the enrollment term 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Term start date 
   */
  public ZonedDateTime getDateStart() {
    return this.dateStart;
  }

  /**
   * Term end date 
   */
  public ZonedDateTime getDateEnd() {
    return this.dateEnd;
  }

  /**
   * Correlated SIS id for this enrollment term (assuming SIS has been 
   * configured properly) 
   */
  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(name);
    fields.add(formatter.formatTimestamp(dateStart));
    fields.add(formatter.formatTimestamp(dateEnd));
    fields.add(sisSourceId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("root_account_id");
      fields.add("name");
      fields.add("date_start");
      fields.add("date_end");
      fields.add("sis_source_id");
    return fields;
  }
}
