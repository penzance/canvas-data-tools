package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class WikiFact implements DataTable {
  private Long wikiId;
  private Long parentCourseId;
  private Long parentGroupId;
  private Long parentCourseAccountId;
  private Long parentGroupAccountId;
  private Long accountId;
  private Long rootAccountId;
  private Long enrollmentTermId;
  private Long groupCategoryId;

  public WikiFact(final TableFormat format, final CSVRecord record) {
    String $wikiId = record.get(0);
    if ($wikiId != null && $wikiId.length() > 0) {
      this.wikiId = Long.valueOf($wikiId);
    }
    String $parentCourseId = record.get(1);
    if ($parentCourseId != null && $parentCourseId.length() > 0) {
      this.parentCourseId = Long.valueOf($parentCourseId);
    }
    String $parentGroupId = record.get(2);
    if ($parentGroupId != null && $parentGroupId.length() > 0) {
      this.parentGroupId = Long.valueOf($parentGroupId);
    }
    String $parentCourseAccountId = record.get(3);
    if ($parentCourseAccountId != null && $parentCourseAccountId.length() > 0) {
      this.parentCourseAccountId = Long.valueOf($parentCourseAccountId);
    }
    String $parentGroupAccountId = record.get(4);
    if ($parentGroupAccountId != null && $parentGroupAccountId.length() > 0) {
      this.parentGroupAccountId = Long.valueOf($parentGroupAccountId);
    }
    String $accountId = record.get(5);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $rootAccountId = record.get(6);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $enrollmentTermId = record.get(7);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $groupCategoryId = record.get(8);
    if ($groupCategoryId != null && $groupCategoryId.length() > 0) {
      this.groupCategoryId = Long.valueOf($groupCategoryId);
    }
  }

  public Long getWikiId() {
    return this.wikiId;
  }

  public Long getParentCourseId() {
    return this.parentCourseId;
  }

  public Long getParentGroupId() {
    return this.parentGroupId;
  }

  public Long getParentCourseAccountId() {
    return this.parentCourseAccountId;
  }

  public Long getParentGroupAccountId() {
    return this.parentGroupAccountId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  public Long getGroupCategoryId() {
    return this.groupCategoryId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(wikiId);
    fields.add(parentCourseId);
    fields.add(parentGroupId);
    fields.add(parentCourseAccountId);
    fields.add(parentGroupAccountId);
    fields.add(accountId);
    fields.add(rootAccountId);
    fields.add(enrollmentTermId);
    fields.add(groupCategoryId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("wiki_id");
      fields.add("parent_course_id");
      fields.add("parent_group_id");
      fields.add("parent_course_account_id");
      fields.add("parent_group_account_id");
      fields.add("account_id");
      fields.add("root_account_id");
      fields.add("enrollment_term_id");
      fields.add("group_category_id");
    return fields;
  }
}
