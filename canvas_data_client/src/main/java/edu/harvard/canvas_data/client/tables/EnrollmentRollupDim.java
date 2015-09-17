package edu.harvard.canvas_data.client.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class EnrollmentRollupDim extends CanvasDataTable {
  private Long id;
  private Long userId;
  private Long courseId;
  private Integer enrollmentCount;
  private Integer roleCount;
  private Integer baseRoleCount;
  private Integer accountAdminRoleCount;
  private Integer teacherEnrollmentRoleCount;
  private Integer designerEnrollmentRoleCount;
  private Integer taEnrollmentRoleCount;
  private Integer studentEnrollmentRoleCount;
  private Integer observerEnrollmentRoleCount;
  private Integer accountMembershipRoleCount;
  private Integer noPermissionsRoleCount;
  private Long accountAdminEnrollmentId;
  private Long teacherEnrollmentEnrollmentId;
  private Long designerEnrollmentEnrollmentId;
  private Long taEnrollmentEnrollmentId;
  private Long studentEnrollmentEnrollmentId;
  private Long observerEnrollmentEnrollmentId;
  private Long accountMembershipEnrollmentId;
  private Long noPermissionsEnrollmentId;
  private String mostPrivilegedRole;
  private String leastPrivilegedRole;

  public EnrollmentRollupDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $userId = record.get(1);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $courseId = record.get(2);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    String $enrollmentCount = record.get(3);
    if ($enrollmentCount != null && $enrollmentCount.length() > 0) {
      this.enrollmentCount = Integer.valueOf($enrollmentCount);
    }
    String $roleCount = record.get(4);
    if ($roleCount != null && $roleCount.length() > 0) {
      this.roleCount = Integer.valueOf($roleCount);
    }
    String $baseRoleCount = record.get(5);
    if ($baseRoleCount != null && $baseRoleCount.length() > 0) {
      this.baseRoleCount = Integer.valueOf($baseRoleCount);
    }
    String $accountAdminRoleCount = record.get(6);
    if ($accountAdminRoleCount != null && $accountAdminRoleCount.length() > 0) {
      this.accountAdminRoleCount = Integer.valueOf($accountAdminRoleCount);
    }
    String $teacherEnrollmentRoleCount = record.get(7);
    if ($teacherEnrollmentRoleCount != null && $teacherEnrollmentRoleCount.length() > 0) {
      this.teacherEnrollmentRoleCount = Integer.valueOf($teacherEnrollmentRoleCount);
    }
    String $designerEnrollmentRoleCount = record.get(8);
    if ($designerEnrollmentRoleCount != null && $designerEnrollmentRoleCount.length() > 0) {
      this.designerEnrollmentRoleCount = Integer.valueOf($designerEnrollmentRoleCount);
    }
    String $taEnrollmentRoleCount = record.get(9);
    if ($taEnrollmentRoleCount != null && $taEnrollmentRoleCount.length() > 0) {
      this.taEnrollmentRoleCount = Integer.valueOf($taEnrollmentRoleCount);
    }
    String $studentEnrollmentRoleCount = record.get(10);
    if ($studentEnrollmentRoleCount != null && $studentEnrollmentRoleCount.length() > 0) {
      this.studentEnrollmentRoleCount = Integer.valueOf($studentEnrollmentRoleCount);
    }
    String $observerEnrollmentRoleCount = record.get(11);
    if ($observerEnrollmentRoleCount != null && $observerEnrollmentRoleCount.length() > 0) {
      this.observerEnrollmentRoleCount = Integer.valueOf($observerEnrollmentRoleCount);
    }
    String $accountMembershipRoleCount = record.get(12);
    if ($accountMembershipRoleCount != null && $accountMembershipRoleCount.length() > 0) {
      this.accountMembershipRoleCount = Integer.valueOf($accountMembershipRoleCount);
    }
    String $noPermissionsRoleCount = record.get(13);
    if ($noPermissionsRoleCount != null && $noPermissionsRoleCount.length() > 0) {
      this.noPermissionsRoleCount = Integer.valueOf($noPermissionsRoleCount);
    }
    String $accountAdminEnrollmentId = record.get(14);
    if ($accountAdminEnrollmentId != null && $accountAdminEnrollmentId.length() > 0) {
      this.accountAdminEnrollmentId = Long.valueOf($accountAdminEnrollmentId);
    }
    String $teacherEnrollmentEnrollmentId = record.get(15);
    if ($teacherEnrollmentEnrollmentId != null && $teacherEnrollmentEnrollmentId.length() > 0) {
      this.teacherEnrollmentEnrollmentId = Long.valueOf($teacherEnrollmentEnrollmentId);
    }
    String $designerEnrollmentEnrollmentId = record.get(16);
    if ($designerEnrollmentEnrollmentId != null && $designerEnrollmentEnrollmentId.length() > 0) {
      this.designerEnrollmentEnrollmentId = Long.valueOf($designerEnrollmentEnrollmentId);
    }
    String $taEnrollmentEnrollmentId = record.get(17);
    if ($taEnrollmentEnrollmentId != null && $taEnrollmentEnrollmentId.length() > 0) {
      this.taEnrollmentEnrollmentId = Long.valueOf($taEnrollmentEnrollmentId);
    }
    String $studentEnrollmentEnrollmentId = record.get(18);
    if ($studentEnrollmentEnrollmentId != null && $studentEnrollmentEnrollmentId.length() > 0) {
      this.studentEnrollmentEnrollmentId = Long.valueOf($studentEnrollmentEnrollmentId);
    }
    String $observerEnrollmentEnrollmentId = record.get(19);
    if ($observerEnrollmentEnrollmentId != null && $observerEnrollmentEnrollmentId.length() > 0) {
      this.observerEnrollmentEnrollmentId = Long.valueOf($observerEnrollmentEnrollmentId);
    }
    String $accountMembershipEnrollmentId = record.get(20);
    if ($accountMembershipEnrollmentId != null && $accountMembershipEnrollmentId.length() > 0) {
      this.accountMembershipEnrollmentId = Long.valueOf($accountMembershipEnrollmentId);
    }
    String $noPermissionsEnrollmentId = record.get(21);
    if ($noPermissionsEnrollmentId != null && $noPermissionsEnrollmentId.length() > 0) {
      this.noPermissionsEnrollmentId = Long.valueOf($noPermissionsEnrollmentId);
    }
    this.mostPrivilegedRole = record.get(22);
    this.leastPrivilegedRole = record.get(23);
  }

  public Long getId() {
    return this.id;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public Integer getEnrollmentCount() {
    return this.enrollmentCount;
  }

  public Integer getRoleCount() {
    return this.roleCount;
  }

  public Integer getBaseRoleCount() {
    return this.baseRoleCount;
  }

  public Integer getAccountAdminRoleCount() {
    return this.accountAdminRoleCount;
  }

  public Integer getTeacherEnrollmentRoleCount() {
    return this.teacherEnrollmentRoleCount;
  }

  public Integer getDesignerEnrollmentRoleCount() {
    return this.designerEnrollmentRoleCount;
  }

  public Integer getTaEnrollmentRoleCount() {
    return this.taEnrollmentRoleCount;
  }

  public Integer getStudentEnrollmentRoleCount() {
    return this.studentEnrollmentRoleCount;
  }

  public Integer getObserverEnrollmentRoleCount() {
    return this.observerEnrollmentRoleCount;
  }

  public Integer getAccountMembershipRoleCount() {
    return this.accountMembershipRoleCount;
  }

  public Integer getNoPermissionsRoleCount() {
    return this.noPermissionsRoleCount;
  }

  public Long getAccountAdminEnrollmentId() {
    return this.accountAdminEnrollmentId;
  }

  public Long getTeacherEnrollmentEnrollmentId() {
    return this.teacherEnrollmentEnrollmentId;
  }

  public Long getDesignerEnrollmentEnrollmentId() {
    return this.designerEnrollmentEnrollmentId;
  }

  public Long getTaEnrollmentEnrollmentId() {
    return this.taEnrollmentEnrollmentId;
  }

  public Long getStudentEnrollmentEnrollmentId() {
    return this.studentEnrollmentEnrollmentId;
  }

  public Long getObserverEnrollmentEnrollmentId() {
    return this.observerEnrollmentEnrollmentId;
  }

  public Long getAccountMembershipEnrollmentId() {
    return this.accountMembershipEnrollmentId;
  }

  public Long getNoPermissionsEnrollmentId() {
    return this.noPermissionsEnrollmentId;
  }

  public String getMostPrivilegedRole() {
    return this.mostPrivilegedRole;
  }

  public String getLeastPrivilegedRole() {
    return this.leastPrivilegedRole;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(userId);
    fields.add(courseId);
    fields.add(enrollmentCount);
    fields.add(roleCount);
    fields.add(baseRoleCount);
    fields.add(accountAdminRoleCount);
    fields.add(teacherEnrollmentRoleCount);
    fields.add(designerEnrollmentRoleCount);
    fields.add(taEnrollmentRoleCount);
    fields.add(studentEnrollmentRoleCount);
    fields.add(observerEnrollmentRoleCount);
    fields.add(accountMembershipRoleCount);
    fields.add(noPermissionsRoleCount);
    fields.add(accountAdminEnrollmentId);
    fields.add(teacherEnrollmentEnrollmentId);
    fields.add(designerEnrollmentEnrollmentId);
    fields.add(taEnrollmentEnrollmentId);
    fields.add(studentEnrollmentEnrollmentId);
    fields.add(observerEnrollmentEnrollmentId);
    fields.add(accountMembershipEnrollmentId);
    fields.add(noPermissionsEnrollmentId);
    fields.add(mostPrivilegedRole);
    fields.add(leastPrivilegedRole);
    return fields;
  }
}
