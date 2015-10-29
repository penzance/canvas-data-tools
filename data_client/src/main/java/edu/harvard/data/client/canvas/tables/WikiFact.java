// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

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

  /**
   * Foreign key to the wiki dimension. 
   */
  public Long getWikiId() {
    return this.wikiId;
  }

  /**
   * Foreign key to the courses table if the wiki is associated with a Course. 
   * Otherwise this field is set to NULL. 
   */
  public Long getParentCourseId() {
    return this.parentCourseId;
  }

  /**
   * Foreign key to the groups table if the wiki is associated with a Group. 
   * Otherwise this field is set to NULL. 
   */
  public Long getParentGroupId() {
    return this.parentGroupId;
  }

  /**
   * Foreign key to the account dimension for the account associated with the 
   * wiki's course. If the wiki is not associated to a Course, this field is set 
   * to NULL. 
   */
  public Long getParentCourseAccountId() {
    return this.parentCourseAccountId;
  }

  /**
   * Foreign key to the account dimension for the account associated with the 
   * wiki's group. If the wiki is not associated to a Group, this field is set 
   * to NULL. 
   */
  public Long getParentGroupAccountId() {
    return this.parentGroupAccountId;
  }

  /**
   * Foreign key to the accounts table that this wiki belongs to. Helpful for 
   * directly finding the account associated with the wiki, irrespective of 
   * whether it belongs to a Course or a Group. 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  /**
   * Root account Id of the account the wiki belongs to. Foreign key to the 
   * accounts table. 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Foreign key to the enrollment term table of the course this wiki is 
   * associated with. Otherwise this is set to NULL. 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * Foreign key to the group categories table of the group this wiki is 
   * associated with. Otherwise this is set to NULL. 
   */
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
