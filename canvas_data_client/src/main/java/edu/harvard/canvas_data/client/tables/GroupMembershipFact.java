package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class GroupMembershipFact extends CanvasDataTable {
  private Long groupId;
  private Long parentCourseId;
  private Long parentAccountId;
  private Long parentCourseAccountId;
  private Long enrollmentTermId;
  private Long userId;

  public GroupMembershipFact(final CSVRecord record) {
    String $groupId = record.get(0);
    if ($groupId != null && $groupId.length() > 0) {
      this.groupId = Long.valueOf($groupId);
    }
    String $parentCourseId = record.get(1);
    if ($parentCourseId != null && $parentCourseId.length() > 0) {
      this.parentCourseId = Long.valueOf($parentCourseId);
    }
    String $parentAccountId = record.get(2);
    if ($parentAccountId != null && $parentAccountId.length() > 0) {
      this.parentAccountId = Long.valueOf($parentAccountId);
    }
    String $parentCourseAccountId = record.get(3);
    if ($parentCourseAccountId != null && $parentCourseAccountId.length() > 0) {
      this.parentCourseAccountId = Long.valueOf($parentCourseAccountId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $userId = record.get(5);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
  }

  public Long getGroupId() {
    return this.groupId;
  }

  public Long getParentCourseId() {
    return this.parentCourseId;
  }

  public Long getParentAccountId() {
    return this.parentAccountId;
  }

  public Long getParentCourseAccountId() {
    return this.parentCourseAccountId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Long getUserId() {
    return this.userId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(groupId);
    fields.add(parentCourseId);
    fields.add(parentAccountId);
    fields.add(parentCourseAccountId);
    fields.add(enrollmentTermId);
    fields.add(userId);
    return fields;
  }
}
