// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class UserDim implements DataTable {
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
  private String workflowState;

  public UserDim(final TableFormat format, final CSVRecord record) {
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
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    this.visibility = record.get(6);
    this.schoolName = record.get(7);
    this.schoolPosition = record.get(8);
    this.gender = record.get(9);
    this.locale = record.get(10);
    this._public = record.get(11);
    String $birthdate = record.get(12);
    if ($birthdate != null && $birthdate.length() > 0) {
      this.birthdate = ZonedDateTime.parse($birthdate, format.getTimstampFormat());
    }
    this.countryCode = record.get(13);
    this.workflowState = record.get(14);
  }

  /**
   * Unique surrogate id for the user. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this user in the Canvas users table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Root account associated with this user. 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Name of the user 
   */
  public String getName() {
    return this.name;
  }

  /**
   * User's primary timezone 
   */
  public String getTimeZone() {
    return this.timeZone;
  }

  /**
   * Timestamp when the user was created in the Canvas system 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * tbd 
   */
  public String getVisibility() {
    return this.visibility;
  }

  /**
   * tbd 
   */
  public String getSchoolName() {
    return this.schoolName;
  }

  /**
   * tbd 
   */
  public String getSchoolPosition() {
    return this.schoolPosition;
  }

  /**
   * The user's gender.  This is an optional field and may not be entered by 
   * the user. 
   */
  public String getGender() {
    return this.gender;
  }

  /**
   * The user's locale.  This is an optional field and may not be entered by 
   * the user. 
   */
  public String getLocale() {
    return this.locale;
  }

  /**
   * tbd 
   */
  public String getPublic() {
    return this._public;
  }

  /**
   * The user's birthdate.  This is an optional field and may not be entered by 
   * the user. 
   */
  public ZonedDateTime getBirthdate() {
    return this.birthdate;
  }

  /**
   * The user's country code.  This is an optional field and may not be entered 
   * by the user. 
   */
  public String getCountryCode() {
    return this.countryCode;
  }

  /**
   * Workflow status indicating the status of the user, valid values are: 
   * creation_pending, deleted, pre_registered, registered 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(name);
    fields.add(timeZone);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(visibility);
    fields.add(schoolName);
    fields.add(schoolPosition);
    fields.add(gender);
    fields.add(locale);
    fields.add(_public);
    fields.add(formatter.formatTimestamp(birthdate));
    fields.add(countryCode);
    fields.add(workflowState);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("root_account_id");
      fields.add("name");
      fields.add("time_zone");
      fields.add("created_at");
      fields.add("visibility");
      fields.add("school_name");
      fields.add("school_position");
      fields.add("gender");
      fields.add("locale");
      fields.add("public");
      fields.add("birthdate");
      fields.add("country_code");
      fields.add("workflow_state");
    return fields;
  }
}
