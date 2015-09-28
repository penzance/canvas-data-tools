package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class GroupFact implements DataTable {
  private Long groupId;
  private Long parentCourseId;
  private Long parentAccountId;
  private Long parentCourseAccountId;
  private Long enrollmentTermId;
  private Integer maxMembership;
  private Long storageQuota;

  public GroupFact(final TableFormat format, final CSVRecord record) {
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
    String $maxMembership = record.get(5);
    if ($maxMembership != null && $maxMembership.length() > 0) {
      this.maxMembership = Integer.valueOf($maxMembership);
    }
    String $storageQuota = record.get(6);
    if ($storageQuota != null && $storageQuota.length() > 0) {
      this.storageQuota = Long.valueOf($storageQuota);
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

  public Integer getMaxMembership() {
    return this.maxMembership;
  }

  public Long getStorageQuota() {
    return this.storageQuota;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(groupId);
    fields.add(parentCourseId);
    fields.add(parentAccountId);
    fields.add(parentCourseAccountId);
    fields.add(enrollmentTermId);
    fields.add(maxMembership);
    fields.add(storageQuota);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("group_id");
      fields.add("parent_course_id");
      fields.add("parent_account_id");
      fields.add("parent_course_account_id");
      fields.add("enrollment_term_id");
      fields.add("max_membership");
      fields.add("storage_quota");
    return fields;
  }
}
