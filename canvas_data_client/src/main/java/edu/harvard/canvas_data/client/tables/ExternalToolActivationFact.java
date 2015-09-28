package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class ExternalToolActivationFact extends CanvasDataTable {
  private Long externalToolActivationId;
  private Long courseId;
  private Long accountId;
  private Long rootAccountId;
  private Long enrollmentTermId;
  private Long courseAccountId;

  public ExternalToolActivationFact(final CSVRecord record) {
    String $externalToolActivationId = record.get(0);
    if ($externalToolActivationId != null && $externalToolActivationId.length() > 0) {
      this.externalToolActivationId = Long.valueOf($externalToolActivationId);
    }
    String $courseId = record.get(1);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $accountId = record.get(2);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $rootAccountId = record.get(3);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $enrollmentTermId = record.get(4);
    if ($enrollmentTermId != null && $enrollmentTermId.length() > 0) {
      this.enrollmentTermId = Long.valueOf($enrollmentTermId);
    }
    String $courseAccountId = record.get(5);
    if ($courseAccountId != null && $courseAccountId.length() > 0) {
      this.courseAccountId = Long.valueOf($courseAccountId);
    }
  }

  public Long getExternalToolActivationId() {
    return this.externalToolActivationId;
  }

  public Long getCourseId() {
    return this.courseId;
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

  public Long getCourseAccountId() {
    return this.courseAccountId;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(externalToolActivationId);
    fields.add(courseId);
    fields.add(accountId);
    fields.add(rootAccountId);
    fields.add(enrollmentTermId);
    fields.add(courseAccountId);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("external_tool_activation_id");
      fields.add("course_id");
      fields.add("account_id");
      fields.add("root_account_id");
      fields.add("enrollment_term_id");
      fields.add("course_account_id");
    return fields;
  }
}
