// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class WikiPageFact implements DataTable {
  private Long wikiPageId;
  private Long wikiId;
  private Long parentCourseId;
  private Long parentGroupId;
  private Long parentCourseAccountId;
  private Long parentGroupAccountId;
  private Long userId;
  private Long accountId;
  private Long rootAccountId;
  private Long enrollmentTermId;
  private Long groupCategoryId;
  private Integer wikiPageCommentsCount;
  private Integer viewCount;

  public WikiPageFact(final TableFormat format, final CSVRecord record) {
    String $wikiPageId = record.get(0);
    if ($wikiPageId != null && $wikiPageId.length() > 0) {
      this.wikiPageId = Long.valueOf($wikiPageId);
    }
    String $wikiId = record.get(1);
    if ($wikiId != null && $wikiId.length() > 0) {
      this.wikiId = Long.valueOf($wikiId);
    }
    String $parentCourseId = record.get(2);
    if ($parentCourseId != null && $parentCourseId.length() > 0) {
      this.parentCourseId = Long.valueOf($parentCourseId);
    }
    String $parentGroupId = record.get(3);
    if ($parentGroupId != null && $parentGroupId.length() > 0) {
      this.parentGroupId = Long.valueOf($parentGroupId);
    }
    String $parentCourseAccountId = record.get(4);
    if ($parentCourseAccountId != null && $parentCourseAccountId.length() > 0) {
      this.parentCourseAccountId = Long.valueOf($parentCourseAccountId);
    }
    String $parentGroupAccountId = record.get(5);
    if ($parentGroupAccountId != null && $parentGroupAccountId.length() > 0) {
      this.parentGroupAccountId = Long.valueOf($parentGroupAccountId);
    }
    String $userId = record.get(6);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $accountId = record.get(7);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $rootAccountId = record.get(8);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $enrollmentTermId = record.get(9);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $groupCategoryId = record.get(10);
    if ($groupCategoryId != null && $groupCategoryId.length() > 0) {
      this.groupCategoryId = Long.valueOf($groupCategoryId);
    }
    String $wikiPageCommentsCount = record.get(11);
    if ($wikiPageCommentsCount != null && $wikiPageCommentsCount.length() > 0) {
      this.wikiPageCommentsCount = Integer.valueOf($wikiPageCommentsCount);
    }
    String $viewCount = record.get(12);
    if ($viewCount != null && $viewCount.length() > 0) {
      this.viewCount = Integer.valueOf($viewCount);
    }
  }

  /**
   * Foreign key to the wiki pages dimension. 
   */
  public Long getWikiPageId() {
    return this.wikiPageId;
  }

  /**
   * Foreign key to the wikis dimension. 
   */
  public Long getWikiId() {
    return this.wikiId;
  }

  /**
   * Foreign key to the courses table if the wiki that owns the wiki page is 
   * associated with a Course. Otherwise this field is set to NULL. 
   */
  public Long getParentCourseId() {
    return this.parentCourseId;
  }

  /**
   * Foreign key to the groups table if the wiki that owns the wiki page is 
   * associated with a Group. Otherwise this field is set to NULL. 
   */
  public Long getParentGroupId() {
    return this.parentGroupId;
  }

  /**
   * Foreign key to the account dimension for the account associated with the 
   * wiki page's course. If the wiki page is not associated to a Course, this 
   * field is set to NULL. 
   */
  public Long getParentCourseAccountId() {
    return this.parentCourseAccountId;
  }

  /**
   * Foreign key to the account dimension for the account associated with the 
   * wiki page's group. If the wiki page is not associated to a Group, this 
   * field is set to NULL. 
   */
  public Long getParentGroupAccountId() {
    return this.parentGroupAccountId;
  }

  /**
   * Foreign key to the user table. 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * Foreign key to the accounts table that this wiki page belongs to. Helpful 
   * for directly finding the account associated with the wiki page, 
   * irrespective of whether it belongs to a Course or a Group. 
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
   * Foreign key to the enrollment term table of the course this wiki page is 
   * associated with. Otherwise this is set to NULL. 
   */
  public Long getEnrollmentTermId() {
    return this.enrollmentTermId;
  }

  /**
   * Foreign key to the group categories table of the group this wiki page is 
   * associated with. Otherwise this is set to NULL. 
   */
  public Long getGroupCategoryId() {
    return this.groupCategoryId;
  }

  /**
   * Count of number of comments per wiki page. 
   */
  public Integer getWikiPageCommentsCount() {
    return this.wikiPageCommentsCount;
  }

  /**
   * Number of views per wiki page. 
   */
  public Integer getViewCount() {
    return this.viewCount;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(wikiPageId);
    fields.add(wikiId);
    fields.add(parentCourseId);
    fields.add(parentGroupId);
    fields.add(parentCourseAccountId);
    fields.add(parentGroupAccountId);
    fields.add(userId);
    fields.add(accountId);
    fields.add(rootAccountId);
    fields.add(enrollmentTermId);
    fields.add(groupCategoryId);
    fields.add(wikiPageCommentsCount);
    fields.add(viewCount);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("wiki_page_id");
      fields.add("wiki_id");
      fields.add("parent_course_id");
      fields.add("parent_group_id");
      fields.add("parent_course_account_id");
      fields.add("parent_group_account_id");
      fields.add("user_id");
      fields.add("account_id");
      fields.add("root_account_id");
      fields.add("enrollment_term_id");
      fields.add("group_category_id");
      fields.add("wiki_page_comments_count");
      fields.add("view_count");
    return fields;
  }
}
