package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class UserExpandedDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private String name;
  private String timeZone;
  private ZonedDateTime createdAt;
  private String visibility;
  private String schoolName;
  private String schoolPosition;
  private String gender;
  private String locale;
  private String _public;
  private ZonedDateTime birthdate;
  private String countryCode;

  public UserExpandedDim(final CSVRecord record) {
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
    this.timeZone = record.get(4);
    String $createdAt = record.get(5);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.visibility = record.get(6);
    this.schoolName = record.get(7);
    this.schoolPosition = record.get(8);
    this.gender = record.get(9);
    this.locale = record.get(10);
    this._public = record.get(11);
    String $birthdate = record.get(12);
    if ($birthdate != null && $birthdate.length() > 0) {
      this.birthdate = ZonedDateTime.parse($birthdate, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.countryCode = record.get(13);
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

  public String getTimeZone() {
    return this.timeZone;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public String getVisibility() {
    return this.visibility;
  }

  public String getSchoolName() {
    return this.schoolName;
  }

  public String getSchoolPosition() {
    return this.schoolPosition;
  }

  public String getGender() {
    return this.gender;
  }

  public String getLocale() {
    return this.locale;
  }

  public String getPublic() {
    return this._public;
  }

  public ZonedDateTime getBirthdate() {
    return this.birthdate;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(name);
    fields.add(timeZone);
    fields.add(formatTimestamp(createdAt));
    fields.add(visibility);
    fields.add(schoolName);
    fields.add(schoolPosition);
    fields.add(gender);
    fields.add(locale);
    fields.add(_public);
    fields.add(formatTimestamp(birthdate));
    fields.add(countryCode);
    return fields;
  }
}
