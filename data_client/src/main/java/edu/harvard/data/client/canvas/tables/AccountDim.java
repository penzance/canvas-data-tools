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
  private Integer parentAccountId;
  private String grandparentAccount;
  private Integer grandparentAccountId;
  private String rootAccount;
  private Integer rootAccountId;
  private String subaccount1;
  private Integer subaccount1Id;
  private String subaccount2;
  private Integer subaccount2Id;
  private String subaccount3;
  private Integer subaccount3Id;
  private String subaccount4;
  private Integer subaccount4Id;
  private String subaccount5;
  private Integer subaccount5Id;
  private String subaccount6;
  private Integer subaccount6Id;
  private String subaccount7;
  private Integer subaccount7Id;
  private String subaccount8;
  private Integer subaccount8Id;
  private String subaccount9;
  private Integer subaccount9Id;
  private String subaccount10;
  private Integer subaccount10Id;
  private String subaccount11;
  private Integer subaccount11Id;
  private String subaccount12;
  private Integer subaccount12Id;
  private String subaccount13;
  private Integer subaccount13Id;
  private String subaccount14;
  private Integer subaccount14Id;
  private String subaccount15;
  private Integer subaccount15Id;
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
      this.parentAccountId = Integer.valueOf($parentAccountId);
    }
    this.grandparentAccount = record.get(7);
    String $grandparentAccountId = record.get(8);
    if ($grandparentAccountId != null && $grandparentAccountId.length() > 0) {
      this.grandparentAccountId = Integer.valueOf($grandparentAccountId);
    }
    this.rootAccount = record.get(9);
    String $rootAccountId = record.get(10);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Integer.valueOf($rootAccountId);
    }
    this.subaccount1 = record.get(11);
    String $subaccount1Id = record.get(12);
    if ($subaccount1Id != null && $subaccount1Id.length() > 0) {
      this.subaccount1Id = Integer.valueOf($subaccount1Id);
    }
    this.subaccount2 = record.get(13);
    String $subaccount2Id = record.get(14);
    if ($subaccount2Id != null && $subaccount2Id.length() > 0) {
      this.subaccount2Id = Integer.valueOf($subaccount2Id);
    }
    this.subaccount3 = record.get(15);
    String $subaccount3Id = record.get(16);
    if ($subaccount3Id != null && $subaccount3Id.length() > 0) {
      this.subaccount3Id = Integer.valueOf($subaccount3Id);
    }
    this.subaccount4 = record.get(17);
    String $subaccount4Id = record.get(18);
    if ($subaccount4Id != null && $subaccount4Id.length() > 0) {
      this.subaccount4Id = Integer.valueOf($subaccount4Id);
    }
    this.subaccount5 = record.get(19);
    String $subaccount5Id = record.get(20);
    if ($subaccount5Id != null && $subaccount5Id.length() > 0) {
      this.subaccount5Id = Integer.valueOf($subaccount5Id);
    }
    this.subaccount6 = record.get(21);
    String $subaccount6Id = record.get(22);
    if ($subaccount6Id != null && $subaccount6Id.length() > 0) {
      this.subaccount6Id = Integer.valueOf($subaccount6Id);
    }
    this.subaccount7 = record.get(23);
    String $subaccount7Id = record.get(24);
    if ($subaccount7Id != null && $subaccount7Id.length() > 0) {
      this.subaccount7Id = Integer.valueOf($subaccount7Id);
    }
    this.subaccount8 = record.get(25);
    String $subaccount8Id = record.get(26);
    if ($subaccount8Id != null && $subaccount8Id.length() > 0) {
      this.subaccount8Id = Integer.valueOf($subaccount8Id);
    }
    this.subaccount9 = record.get(27);
    String $subaccount9Id = record.get(28);
    if ($subaccount9Id != null && $subaccount9Id.length() > 0) {
      this.subaccount9Id = Integer.valueOf($subaccount9Id);
    }
    this.subaccount10 = record.get(29);
    String $subaccount10Id = record.get(30);
    if ($subaccount10Id != null && $subaccount10Id.length() > 0) {
      this.subaccount10Id = Integer.valueOf($subaccount10Id);
    }
    this.subaccount11 = record.get(31);
    String $subaccount11Id = record.get(32);
    if ($subaccount11Id != null && $subaccount11Id.length() > 0) {
      this.subaccount11Id = Integer.valueOf($subaccount11Id);
    }
    this.subaccount12 = record.get(33);
    String $subaccount12Id = record.get(34);
    if ($subaccount12Id != null && $subaccount12Id.length() > 0) {
      this.subaccount12Id = Integer.valueOf($subaccount12Id);
    }
    this.subaccount13 = record.get(35);
    String $subaccount13Id = record.get(36);
    if ($subaccount13Id != null && $subaccount13Id.length() > 0) {
      this.subaccount13Id = Integer.valueOf($subaccount13Id);
    }
    this.subaccount14 = record.get(37);
    String $subaccount14Id = record.get(38);
    if ($subaccount14Id != null && $subaccount14Id.length() > 0) {
      this.subaccount14Id = Integer.valueOf($subaccount14Id);
    }
    this.subaccount15 = record.get(39);
    String $subaccount15Id = record.get(40);
    if ($subaccount15Id != null && $subaccount15Id.length() > 0) {
      this.subaccount15Id = Integer.valueOf($subaccount15Id);
    }
    this.sisSourceId = record.get(41);
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getName() {
    return this.name;
  }

  public Integer getDepth() {
    return this.depth;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public String getParentAccount() {
    return this.parentAccount;
  }

  public Integer getParentAccountId() {
    return this.parentAccountId;
  }

  public String getGrandparentAccount() {
    return this.grandparentAccount;
  }

  public Integer getGrandparentAccountId() {
    return this.grandparentAccountId;
  }

  public String getRootAccount() {
    return this.rootAccount;
  }

  public Integer getRootAccountId() {
    return this.rootAccountId;
  }

  public String getSubaccount1() {
    return this.subaccount1;
  }

  public Integer getSubaccount1Id() {
    return this.subaccount1Id;
  }

  public String getSubaccount2() {
    return this.subaccount2;
  }

  public Integer getSubaccount2Id() {
    return this.subaccount2Id;
  }

  public String getSubaccount3() {
    return this.subaccount3;
  }

  public Integer getSubaccount3Id() {
    return this.subaccount3Id;
  }

  public String getSubaccount4() {
    return this.subaccount4;
  }

  public Integer getSubaccount4Id() {
    return this.subaccount4Id;
  }

  public String getSubaccount5() {
    return this.subaccount5;
  }

  public Integer getSubaccount5Id() {
    return this.subaccount5Id;
  }

  public String getSubaccount6() {
    return this.subaccount6;
  }

  public Integer getSubaccount6Id() {
    return this.subaccount6Id;
  }

  public String getSubaccount7() {
    return this.subaccount7;
  }

  public Integer getSubaccount7Id() {
    return this.subaccount7Id;
  }

  public String getSubaccount8() {
    return this.subaccount8;
  }

  public Integer getSubaccount8Id() {
    return this.subaccount8Id;
  }

  public String getSubaccount9() {
    return this.subaccount9;
  }

  public Integer getSubaccount9Id() {
    return this.subaccount9Id;
  }

  public String getSubaccount10() {
    return this.subaccount10;
  }

  public Integer getSubaccount10Id() {
    return this.subaccount10Id;
  }

  public String getSubaccount11() {
    return this.subaccount11;
  }

  public Integer getSubaccount11Id() {
    return this.subaccount11Id;
  }

  public String getSubaccount12() {
    return this.subaccount12;
  }

  public Integer getSubaccount12Id() {
    return this.subaccount12Id;
  }

  public String getSubaccount13() {
    return this.subaccount13;
  }

  public Integer getSubaccount13Id() {
    return this.subaccount13Id;
  }

  public String getSubaccount14() {
    return this.subaccount14;
  }

  public Integer getSubaccount14Id() {
    return this.subaccount14Id;
  }

  public String getSubaccount15() {
    return this.subaccount15;
  }

  public Integer getSubaccount15Id() {
    return this.subaccount15Id;
  }

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
