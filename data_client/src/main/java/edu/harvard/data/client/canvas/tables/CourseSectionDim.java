// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseSectionDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String name;
  private Long courseId;
  private Long enrollmentTermId;
  private Boolean defaultSection;
  private Boolean acceptingEnrollments;
  private Boolean canManuallyEnroll;
  private ZonedDateTime startAt;
  private ZonedDateTime endAt;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String workflowState;
  private Boolean restrictEnrollmentsToSectionDates;
  private Long nonxlistCourseId;
  private String sisSourceId;

  public CourseSectionDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.name = record.get(2);
    String $courseId = record.get(3);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $defaultSection = record.get(5);
    if ($defaultSection != null && $defaultSection.length() > 0) {
      this.defaultSection = Boolean.valueOf($defaultSection);
    }
    String $acceptingEnrollments = record.get(6);
    if ($acceptingEnrollments != null && $acceptingEnrollments.length() > 0) {
      this.acceptingEnrollments = Boolean.valueOf($acceptingEnrollments);
    }
    String $canManuallyEnroll = record.get(7);
    if ($canManuallyEnroll != null && $canManuallyEnroll.length() > 0) {
      this.canManuallyEnroll = Boolean.valueOf($canManuallyEnroll);
    }
    String $startAt = record.get(8);
    if ($startAt != null && $startAt.length() > 0) {
      this.startAt = ZonedDateTime.parse($startAt, format.getTimstampFormat());
    }
    String $endAt = record.get(9);
    if ($endAt != null && $endAt.length() > 0) {
      this.endAt = ZonedDateTime.parse($endAt, format.getTimstampFormat());
    }
    String $createdAt = record.get(10);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(11);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    this.workflowState = record.get(12);
    String $restrictEnrollmentsToSectionDates = record.get(13);
    if ($restrictEnrollmentsToSectionDates != null && $restrictEnrollmentsToSectionDates.length() > 0) {
      this.restrictEnrollmentsToSectionDates = Boolean.valueOf($restrictEnrollmentsToSectionDates);
    }
    String $nonxlistCourseId = record.get(14);
    if ($nonxlistCourseId != null && $nonxlistCourseId.length() > 0) {
      this.nonxlistCourseId = Long.valueOf($nonxlistCourseId);
    }
    this.sisSourceId = record.get(15);
  }

  /**
   * Unique surrogate id for the course section. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this record in the Canvas course_sections table. 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Name of the section 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Foreign key to the associated course 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Foreign key to the associated enrollment term 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * True if this is the default section 
   */
  public Boolean getDefaultSection() {
    return this.defaultSection;
  }

  /**
   * True if this section is open for enrollment 
   */
  public Boolean getAcceptingEnrollments() {
    return this.acceptingEnrollments;
  }

  /**
   * tbd 
   */
  public Boolean getCanManuallyEnroll() {
    return this.canManuallyEnroll;
  }

  /**
   * Section start date 
   */
  public ZonedDateTime getStartAt() {
    return this.startAt;
  }

  /**
   * Section end date 
   */
  public ZonedDateTime getEndAt() {
    return this.endAt;
  }

  /**
   * Timestamp for when this section was entered into the system. 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp for when the last time the section was updated 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Lifecycle state for section. (active, deleted) 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * True when "Users can only partipate in the course between these dates" is 
   * checked 
   */
  public Boolean getRestrictEnrollmentsToSectionDates() {
    return this.restrictEnrollmentsToSectionDates;
  }

  /**
   * The course id for the original course if this course has been cross listed 
   */
  public Long getNonxlistCourseId() {
    return this.nonxlistCourseId;
  }

  /**
   * Id for the correlated record for the section in the SIS (assumming SIS 
   * integration has been properly configured) 
   */
  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(defaultSection);
    fields.add(acceptingEnrollments);
    fields.add(canManuallyEnroll);
    fields.add(formatter.formatTimestamp(startAt));
    fields.add(formatter.formatTimestamp(endAt));
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(workflowState);
    fields.add(restrictEnrollmentsToSectionDates);
    fields.add(nonxlistCourseId);
    fields.add(sisSourceId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("name");
      fields.add("course_id");
      fields.add("enrollment_term_id");
      fields.add("default_section");
      fields.add("accepting_enrollments");
      fields.add("can_manually_enroll");
      fields.add("start_at");
      fields.add("end_at");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("workflow_state");
      fields.add("restrict_enrollments_to_section_dates");
      fields.add("nonxlist_course_id");
      fields.add("sis_source_id");
    return fields;
  }
}
