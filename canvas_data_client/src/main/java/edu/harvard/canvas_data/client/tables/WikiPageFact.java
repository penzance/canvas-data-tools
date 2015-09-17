package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class WikiPageFact extends CanvasDataTable {
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

  public WikiPageFact(final CSVRecord record) {
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

  public Long getWikiPageId() {
    return this.wikiPageId;
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

  public Long getUserId() {
    return this.userId;
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

  public Integer getWikiPageCommentsCount() {
    return this.wikiPageCommentsCount;
  }

  public Integer getViewCount() {
    return this.viewCount;
  }

  @Override
    public List<Object> getCsvFields() {
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
}
