package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class EnrollmentTermDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private String name;
  private ZonedDateTime dateStart;
  private ZonedDateTime dateEnd;
  private String sisSourceId;

  public EnrollmentTermDim(final CSVRecord record) {
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
      this.dateStart = ZonedDateTime.parse($dateStart, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $dateEnd = record.get(5);
    if ($dateEnd != null && $dateEnd.length() > 0) {
      this.dateEnd = ZonedDateTime.parse($dateEnd, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.sisSourceId = record.get(6);
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public String getName() {
    return this.name;
  }

  public ZonedDateTime getDateStart() {
    return this.dateStart;
  }

  public ZonedDateTime getDateEnd() {
    return this.dateEnd;
  }

  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(name);
    fields.add(formatTimestamp(dateStart));
    fields.add(formatTimestamp(dateEnd));
    fields.add(sisSourceId);
    return fields;
  }
}
