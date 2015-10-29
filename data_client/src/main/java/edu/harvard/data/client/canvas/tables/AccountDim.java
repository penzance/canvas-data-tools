// This file was generated on 29-10-2015 01:16:09. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class AccountDim implements DataTable {
  private Long id;
  private Long canvasId;
  private String name;
  private Integer depth;
  private String workflowState;
  private String parentAccount;
  private Long parentAccountId;
  private String grandparentAccount;
  private Long grandparentAccountId;
  private String rootAccount;
  private Long rootAccountId;
  private String subaccount1;
  private Long subaccount1Id;
  private String subaccount2;
  private Long subaccount2Id;
  private String subaccount3;
  private Long subaccount3Id;
  private String subaccount4;
  private Long subaccount4Id;
  private String subaccount5;
  private Long subaccount5Id;
  private String subaccount6;
  private Long subaccount6Id;
  private String subaccount7;
  private Long subaccount7Id;
  private String subaccount8;
  private Long subaccount8Id;
  private String subaccount9;
  private Long subaccount9Id;
  private String subaccount10;
  private Long subaccount10Id;
  private String subaccount11;
  private Long subaccount11Id;
  private String subaccount12;
  private Long subaccount12Id;
  private String subaccount13;
  private Long subaccount13Id;
  private String subaccount14;
  private Long subaccount14Id;
  private String subaccount15;
  private Long subaccount15Id;
  private String sisSourceId;

  public AccountDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.name = record.get(2);
    String $depth = record.get(3);
    if ($depth != null && $depth.length() > 0) {
      this.depth = Integer.valueOf($depth);
    }
    this.workflowState = record.get(4);
    this.parentAccount = record.get(5);
    String $parentAccountId = record.get(6);
    if ($parentAccountId != null && $parentAccountId.length() > 0) {
      this.parentAccountId = Long.valueOf($parentAccountId);
    }
    this.grandparentAccount = record.get(7);
    String $grandparentAccountId = record.get(8);
    if ($grandparentAccountId != null && $grandparentAccountId.length() > 0) {
      this.grandparentAccountId = Long.valueOf($grandparentAccountId);
    }
    this.rootAccount = record.get(9);
    String $rootAccountId = record.get(10);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    this.subaccount1 = record.get(11);
    String $subaccount1Id = record.get(12);
    if ($subaccount1Id != null && $subaccount1Id.length() > 0) {
      this.subaccount1Id = Long.valueOf($subaccount1Id);
    }
    this.subaccount2 = record.get(13);
    String $subaccount2Id = record.get(14);
    if ($subaccount2Id != null && $subaccount2Id.length() > 0) {
      this.subaccount2Id = Long.valueOf($subaccount2Id);
    }
    this.subaccount3 = record.get(15);
    String $subaccount3Id = record.get(16);
    if ($subaccount3Id != null && $subaccount3Id.length() > 0) {
      this.subaccount3Id = Long.valueOf($subaccount3Id);
    }
    this.subaccount4 = record.get(17);
    String $subaccount4Id = record.get(18);
    if ($subaccount4Id != null && $subaccount4Id.length() > 0) {
      this.subaccount4Id = Long.valueOf($subaccount4Id);
    }
    this.subaccount5 = record.get(19);
    String $subaccount5Id = record.get(20);
    if ($subaccount5Id != null && $subaccount5Id.length() > 0) {
      this.subaccount5Id = Long.valueOf($subaccount5Id);
    }
    this.subaccount6 = record.get(21);
    String $subaccount6Id = record.get(22);
    if ($subaccount6Id != null && $subaccount6Id.length() > 0) {
      this.subaccount6Id = Long.valueOf($subaccount6Id);
    }
    this.subaccount7 = record.get(23);
    String $subaccount7Id = record.get(24);
    if ($subaccount7Id != null && $subaccount7Id.length() > 0) {
      this.subaccount7Id = Long.valueOf($subaccount7Id);
    }
    this.subaccount8 = record.get(25);
    String $subaccount8Id = record.get(26);
    if ($subaccount8Id != null && $subaccount8Id.length() > 0) {
      this.subaccount8Id = Long.valueOf($subaccount8Id);
    }
    this.subaccount9 = record.get(27);
    String $subaccount9Id = record.get(28);
    if ($subaccount9Id != null && $subaccount9Id.length() > 0) {
      this.subaccount9Id = Long.valueOf($subaccount9Id);
    }
    this.subaccount10 = record.get(29);
    String $subaccount10Id = record.get(30);
    if ($subaccount10Id != null && $subaccount10Id.length() > 0) {
      this.subaccount10Id = Long.valueOf($subaccount10Id);
    }
    this.subaccount11 = record.get(31);
    String $subaccount11Id = record.get(32);
    if ($subaccount11Id != null && $subaccount11Id.length() > 0) {
      this.subaccount11Id = Long.valueOf($subaccount11Id);
    }
    this.subaccount12 = record.get(33);
    String $subaccount12Id = record.get(34);
    if ($subaccount12Id != null && $subaccount12Id.length() > 0) {
      this.subaccount12Id = Long.valueOf($subaccount12Id);
    }
    this.subaccount13 = record.get(35);
    String $subaccount13Id = record.get(36);
    if ($subaccount13Id != null && $subaccount13Id.length() > 0) {
      this.subaccount13Id = Long.valueOf($subaccount13Id);
    }
    this.subaccount14 = record.get(37);
    String $subaccount14Id = record.get(38);
    if ($subaccount14Id != null && $subaccount14Id.length() > 0) {
      this.subaccount14Id = Long.valueOf($subaccount14Id);
    }
    this.subaccount15 = record.get(39);
    String $subaccount15Id = record.get(40);
    if ($subaccount15Id != null && $subaccount15Id.length() > 0) {
      this.subaccount15Id = Long.valueOf($subaccount15Id);
    }
    this.sisSourceId = record.get(41);
  }

  /**
   * Unique surrogate id for an account 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this entry in the Canvas accounts table 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Name of the account 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Depth of the account in the heirarchy.  The root node is at 0. 
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Workflow status indicating that account is [deleted] or [active] 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * Name of this account's parent account.  This field will be NULL for the 
   * root account. 
   */
  public String getParentAccount() {
    return this.parentAccount;
  }

  /**
   * Id of this account's parent account.  This field will be NULL for the root 
   * account. 
   */
  public Long getParentAccountId() {
    return this.parentAccountId;
  }

  /**
   * Name of this account's grand parent account.  This field will be NULL for 
   * the root account and all accounts at level 1. 
   */
  public String getGrandparentAccount() {
    return this.grandparentAccount;
  }

  /**
   * Id of this account's grand parent account.  This field will be NULL for 
   * the root account and all subaccounts at level 1. 
   */
  public Long getGrandparentAccountId() {
    return this.grandparentAccountId;
  }

  /**
   * Name of the root account associated with this account. 
   */
  public String getRootAccount() {
    return this.rootAccount;
  }

  /**
   * Id of the root account associated with this account. 
   */
  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  /**
   * Name of this account's parent at subaccount level 1.  If this account is a 
   * level 1 account, this will be the name of this account. 
   */
  public String getSubaccount1() {
    return this.subaccount1;
  }

  /**
   * Id of this account's parent at subaccount level 1.  If this account is a 
   * level 1 account, this will be the id of this account. 
   */
  public Long getSubaccount1Id() {
    return this.subaccount1Id;
  }

  /**
   * Name of this account's parent at subaccount level 2.  If this account is a 
   * level 2 account, subaccount2 will be the name of this account. 
   */
  public String getSubaccount2() {
    return this.subaccount2;
  }

  /**
   * Id of this account's parent at subaccount level 2.  If this account is a 
   * level 2 account, subaccount2_id will be the id of this account. 
   */
  public Long getSubaccount2Id() {
    return this.subaccount2Id;
  }

  /**
   * Name of this account's parent at subaccount level 3.  If this account is a 
   * level 3 account, subaccount3 will be the name of this account. 
   */
  public String getSubaccount3() {
    return this.subaccount3;
  }

  /**
   * Id of this account's parent at subaccount level 3.  If this account is a 
   * level 3 account, subaccount3_id will be the id of this account. 
   */
  public Long getSubaccount3Id() {
    return this.subaccount3Id;
  }

  /**
   * Name of this account's parent at subaccount level 4.  If this account is a 
   * level 4 account, subaccount4 will be the name of this account. 
   */
  public String getSubaccount4() {
    return this.subaccount4;
  }

  /**
   * Id of this account's parent at subaccount level 4.  If this account is a 
   * level 4 account, subaccount4_id will be the id of this account. 
   */
  public Long getSubaccount4Id() {
    return this.subaccount4Id;
  }

  /**
   * Name of this account's parent at subaccount level 5.  If this account is a 
   * level 5 account, subaccount5 will be the name of this account. 
   */
  public String getSubaccount5() {
    return this.subaccount5;
  }

  /**
   * Id of this account's parent at subaccount level 5.  If this account is a 
   * level 5 account, subaccount5_id will be the id of this account. 
   */
  public Long getSubaccount5Id() {
    return this.subaccount5Id;
  }

  /**
   * Name of this account's parent at subaccount level 6.  If this account is a 
   * level 6 account, subaccount6 will be the name of this account. 
   */
  public String getSubaccount6() {
    return this.subaccount6;
  }

  /**
   * Id of this account's parent at subaccount level 6.  If this account is a 
   * level 6 account, subaccount6_id will be the id of this account. 
   */
  public Long getSubaccount6Id() {
    return this.subaccount6Id;
  }

  /**
   * Name of this account's parent at subaccount level 7.  If this account is a 
   * level 7 account, subaccount7 will be the name of this account. 
   */
  public String getSubaccount7() {
    return this.subaccount7;
  }

  /**
   * Id of this account's parent at subaccount level 7.  If this account is a 
   * level 7 account, subaccount7_id will be the id of this account. 
   */
  public Long getSubaccount7Id() {
    return this.subaccount7Id;
  }

  /**
   * Name of this account's parent at subaccount level 8.  If this account is a 
   * level 8 account, subaccount8 will be the name of this account. 
   */
  public String getSubaccount8() {
    return this.subaccount8;
  }

  /**
   * Id of this account's parent at subaccount level 8.  If this account is a 
   * level 8 account, subaccount8_id will be the id of this account. 
   */
  public Long getSubaccount8Id() {
    return this.subaccount8Id;
  }

  /**
   * Name of this account's parent at subaccount level 9.  If this account is a 
   * level 9 account, subaccount9 will be the name of this account. 
   */
  public String getSubaccount9() {
    return this.subaccount9;
  }

  /**
   * Id of this account's parent at subaccount level 9.  If this account is a 
   * level 9 account, subaccount9_id will be the id of this account. 
   */
  public Long getSubaccount9Id() {
    return this.subaccount9Id;
  }

  /**
   * Name of this account's parent at subaccount level 10.  If this account is 
   * a level 10 account, subaccount10 will be the name of this account. 
   */
  public String getSubaccount10() {
    return this.subaccount10;
  }

  /**
   * Id of this account's parent at subaccount level 10.  If this account is a 
   * level 10 account, subaccount10_id will be the id of this account. 
   */
  public Long getSubaccount10Id() {
    return this.subaccount10Id;
  }

  /**
   * Name of this account's parent at subaccount level 11.  If this account is 
   * a level 11 account, subaccount11 will be the name of this account. 
   */
  public String getSubaccount11() {
    return this.subaccount11;
  }

  /**
   * Id of this account's parent at subaccount level 11.  If this account is a 
   * level 11 account, subaccount11_id will be the id of this account. 
   */
  public Long getSubaccount11Id() {
    return this.subaccount11Id;
  }

  /**
   * Name of this account's parent at subaccount level 12.  If this account is 
   * a level 12 account, subaccount12 will be the name of this account. 
   */
  public String getSubaccount12() {
    return this.subaccount12;
  }

  /**
   * Id of this account's parent at subaccount level 12.  If this account is a 
   * level 12 account, subaccount12_id will be the id of this account. 
   */
  public Long getSubaccount12Id() {
    return this.subaccount12Id;
  }

  /**
   * Name of this account's parent at subaccount level 13.  If this account is 
   * a level 13 account, subaccount13 will be the name of this account. 
   */
  public String getSubaccount13() {
    return this.subaccount13;
  }

  /**
   * Id of this account's parent at subaccount level 13.  If this account is a 
   * level 13 account, subaccount13_id will be the id of this account. 
   */
  public Long getSubaccount13Id() {
    return this.subaccount13Id;
  }

  /**
   * Name of this account's parent at subaccount level 14.  If this account is 
   * a level 14 account, subaccount14 will be the name of this account. 
   */
  public String getSubaccount14() {
    return this.subaccount14;
  }

  /**
   * Id of this account's parent at subaccount level 14.  If this account is a 
   * level 14 account, subaccount14_id will be the id of this account. 
   */
  public Long getSubaccount14Id() {
    return this.subaccount14Id;
  }

  /**
   * Name of this account's parent at subaccount level 15.  If this account is 
   * a level 15 account, subaccount15 will be the name of this account. 
   */
  public String getSubaccount15() {
    return this.subaccount15;
  }

  /**
   * Id of this account's parent at subaccount level 15.  If this account is a 
   * level 15 account, subaccount15_id will be the id of this account. 
   */
  public Long getSubaccount15Id() {
    return this.subaccount15Id;
  }

  /**
   * Correlated id for the record for this course in the SIS system (assuming 
   * SIS integration is configured) 
   */
  public String getSisSourceId() {
    return this.sisSourceId;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(name);
    fields.add(depth);
    fields.add(workflowState);
    fields.add(parentAccount);
    fields.add(parentAccountId);
    fields.add(grandparentAccount);
    fields.add(grandparentAccountId);
    fields.add(rootAccount);
    fields.add(rootAccountId);
    fields.add(subaccount1);
    fields.add(subaccount1Id);
    fields.add(subaccount2);
    fields.add(subaccount2Id);
    fields.add(subaccount3);
    fields.add(subaccount3Id);
    fields.add(subaccount4);
    fields.add(subaccount4Id);
    fields.add(subaccount5);
    fields.add(subaccount5Id);
    fields.add(subaccount6);
    fields.add(subaccount6Id);
    fields.add(subaccount7);
    fields.add(subaccount7Id);
    fields.add(subaccount8);
    fields.add(subaccount8Id);
    fields.add(subaccount9);
    fields.add(subaccount9Id);
    fields.add(subaccount10);
    fields.add(subaccount10Id);
    fields.add(subaccount11);
    fields.add(subaccount11Id);
    fields.add(subaccount12);
    fields.add(subaccount12Id);
    fields.add(subaccount13);
    fields.add(subaccount13Id);
    fields.add(subaccount14);
    fields.add(subaccount14Id);
    fields.add(subaccount15);
    fields.add(subaccount15Id);
    fields.add(sisSourceId);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("name");
      fields.add("depth");
      fields.add("workflow_state");
      fields.add("parent_account");
      fields.add("parent_account_id");
      fields.add("grandparent_account");
      fields.add("grandparent_account_id");
      fields.add("root_account");
      fields.add("root_account_id");
      fields.add("subaccount1");
      fields.add("subaccount1_id");
      fields.add("subaccount2");
      fields.add("subaccount2_id");
      fields.add("subaccount3");
      fields.add("subaccount3_id");
      fields.add("subaccount4");
      fields.add("subaccount4_id");
      fields.add("subaccount5");
      fields.add("subaccount5_id");
      fields.add("subaccount6");
      fields.add("subaccount6_id");
      fields.add("subaccount7");
      fields.add("subaccount7_id");
      fields.add("subaccount8");
      fields.add("subaccount8_id");
      fields.add("subaccount9");
      fields.add("subaccount9_id");
      fields.add("subaccount10");
      fields.add("subaccount10_id");
      fields.add("subaccount11");
      fields.add("subaccount11_id");
      fields.add("subaccount12");
      fields.add("subaccount12_id");
      fields.add("subaccount13");
      fields.add("subaccount13_id");
      fields.add("subaccount14");
      fields.add("subaccount14_id");
      fields.add("subaccount15");
      fields.add("subaccount15_id");
      fields.add("sis_source_id");
    return fields;
  }
}
