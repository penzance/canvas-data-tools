// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class EnrollmentRollupDim implements DataTable {
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

  public EnrollmentRollupDim(final TableFormat format, final CSVRecord record) {
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

  /**
   * Unique surrogate id for the user and the course. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Foreign key to the enrolled user. 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * Foreign key to the enrolled course. 
   */
  public Long getCourseId() {
    return this.courseId;
  }

  /**
   * Total number of enrollments associated with the user in the course for 
   * his/her all roles under all base roles, duplicate or not. 
   */
  public Integer getEnrollmentCount() {
    return this.enrollmentCount;
  }

  /**
   * Total number of unique roles associated with the user in the course. 
   */
  public Integer getRoleCount() {
    return this.roleCount;
  }

  /**
   * Total number of unique base roles associated with the user in the course. 
   */
  public Integer getBaseRoleCount() {
    return this.baseRoleCount;
  }

  /**
   * Total number of 'AccountAdmin' roles associated with the user in the 
   * course. 
   */
  public Integer getAccountAdminRoleCount() {
    return this.accountAdminRoleCount;
  }

  /**
   * Total number of 'TeacherEnrollment' roles associated with the user in the 
   * course. 
   */
  public Integer getTeacherEnrollmentRoleCount() {
    return this.teacherEnrollmentRoleCount;
  }

  /**
   * Total number of 'DesignerEnrollment' roles associated with the user in the 
   * course. 
   */
  public Integer getDesignerEnrollmentRoleCount() {
    return this.designerEnrollmentRoleCount;
  }

  /**
   * Total number of 'TaEnrollment' roles associated with the user in the 
   * course. 
   */
  public Integer getTaEnrollmentRoleCount() {
    return this.taEnrollmentRoleCount;
  }

  /**
   * Total number of 'StudentEnrollment' roles associated with the user in the 
   * course. 
   */
  public Integer getStudentEnrollmentRoleCount() {
    return this.studentEnrollmentRoleCount;
  }

  /**
   * Total number of 'ObserverEnrollment' roles associated with the user in the 
   * course. 
   */
  public Integer getObserverEnrollmentRoleCount() {
    return this.observerEnrollmentRoleCount;
  }

  /**
   * Total number of 'AccountMembership' roles associated with the user in the 
   * course. 
   */
  public Integer getAccountMembershipRoleCount() {
    return this.accountMembershipRoleCount;
  }

  /**
   * Total number of 'NoPermissions' roles associated with the user in the 
   * course. 
   */
  public Integer getNoPermissionsRoleCount() {
    return this.noPermissionsRoleCount;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getAccountAdminEnrollmentId() {
    return this.accountAdminEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getTeacherEnrollmentEnrollmentId() {
    return this.teacherEnrollmentEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getDesignerEnrollmentEnrollmentId() {
    return this.designerEnrollmentEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getTaEnrollmentEnrollmentId() {
    return this.taEnrollmentEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getStudentEnrollmentEnrollmentId() {
    return this.studentEnrollmentEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getObserverEnrollmentEnrollmentId() {
    return this.observerEnrollmentEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getAccountMembershipEnrollmentId() {
    return this.accountMembershipEnrollmentId;
  }

  /**
   * Enrollment ID if this a valid role for the user in the course, else NULL. 
   */
  public Long getNoPermissionsEnrollmentId() {
    return this.noPermissionsEnrollmentId;
  }

  /**
   * The most privileged role associated with the user in the course. 
   */
  public String getMostPrivilegedRole() {
    return this.mostPrivilegedRole;
  }

  /**
   * The least privileged role associated with the user in the course. 
   */
  public String getLeastPrivilegedRole() {
    return this.leastPrivilegedRole;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
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

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("user_id");
      fields.add("course_id");
      fields.add("enrollment_count");
      fields.add("role_count");
      fields.add("base_role_count");
      fields.add("account_admin_role_count");
      fields.add("teacher_enrollment_role_count");
      fields.add("designer_enrollment_role_count");
      fields.add("ta_enrollment_role_count");
      fields.add("student_enrollment_role_count");
      fields.add("observer_enrollment_role_count");
      fields.add("account_membership_role_count");
      fields.add("no_permissions_role_count");
      fields.add("account_admin_enrollment_id");
      fields.add("teacher_enrollment_enrollment_id");
      fields.add("designer_enrollment_enrollment_id");
      fields.add("ta_enrollment_enrollment_id");
      fields.add("student_enrollment_enrollment_id");
      fields.add("observer_enrollment_enrollment_id");
      fields.add("account_membership_enrollment_id");
      fields.add("no_permissions_enrollment_id");
      fields.add("most_privileged_role");
      fields.add("least_privileged_role");
    return fields;
  }
}
