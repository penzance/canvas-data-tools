package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class CourseSectionDim extends CanvasDataTable {
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

  public CourseSectionDim(final CSVRecord record) {
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
      this.startAt = ZonedDateTime.parse($startAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $endAt = record.get(9);
    if ($endAt != null && $endAt.length() > 0) {
      this.endAt = ZonedDateTime.parse($endAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $createdAt = record.get(10);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(11);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
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

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getName() {
    return this.name;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Boolean getDefaultSection() {
    return this.defaultSection;
  }

  public Boolean getAcceptingEnrollments() {
    return this.acceptingEnrollments;
  }

  public Boolean getCanManuallyEnroll() {
    return this.canManuallyEnroll;
  }

  public ZonedDateTime getStartAt() {
    return this.startAt;
  }

  public ZonedDateTime getEndAt() {
    return this.endAt;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public Boolean getRestrictEnrollmentsToSectionDates() {
    return this.restrictEnrollmentsToSectionDates;
  }

  public Long getNonxlistCourseId() {
    return this.nonxlistCourseId;
  }

  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(courseId);
    fields.add(enrollmentTermId);
    fields.add(defaultSection);
    fields.add(acceptingEnrollments);
    fields.add(canManuallyEnroll);
    fields.add(formatTimestamp(startAt));
    fields.add(formatTimestamp(endAt));
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(workflowState);
    fields.add(restrictEnrollmentsToSectionDates);
    fields.add(nonxlistCourseId);
    fields.add(sisSourceId);
    return fields;
  }
}
