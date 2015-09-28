package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class CourseUiNavigationDimDim implements DataTable {
  private Long courseId;
  private String position00;
  private String position01;
  private String position02;
  private String position03;
  private String position04;
  private String position05;
  private String position06;
  private String position07;
  private String position08;
  private String position09;
  private String position10;
  private String position11;
  private String position12;
  private String position13;
  private String position14;
  private String position15;
  private String position16;
  private String position17;
  private String position18;
  private String position19;
  private String position20;
  private String position21;
  private String position22;
  private String position23;
  private String position24;
  private String position25;
  private String position26;
  private String position27;
  private String position28;
  private String position29;

  public CourseUiNavigationDimDim(final TableFormat format, final CSVRecord record) {
    String $courseId = record.get(0);
    if ($courseId != null && $courseId.length() > 0) {
      this.courseId = Long.valueOf($courseId);
    }
    this.position00 = record.get(1);
    this.position01 = record.get(2);
    this.position02 = record.get(3);
    this.position03 = record.get(4);
    this.position04 = record.get(5);
    this.position05 = record.get(6);
    this.position06 = record.get(7);
    this.position07 = record.get(8);
    this.position08 = record.get(9);
    this.position09 = record.get(10);
    this.position10 = record.get(11);
    this.position11 = record.get(12);
    this.position12 = record.get(13);
    this.position13 = record.get(14);
    this.position14 = record.get(15);
    this.position15 = record.get(16);
    this.position16 = record.get(17);
    this.position17 = record.get(18);
    this.position18 = record.get(19);
    this.position19 = record.get(20);
    this.position20 = record.get(21);
    this.position21 = record.get(22);
    this.position22 = record.get(23);
    this.position23 = record.get(24);
    this.position24 = record.get(25);
    this.position25 = record.get(26);
    this.position26 = record.get(27);
    this.position27 = record.get(28);
    this.position28 = record.get(29);
    this.position29 = record.get(30);
  }

  public Long getCourseId() {
    return this.courseId;
  }

  public String getPosition00() {
    return this.position00;
  }

  public String getPosition01() {
    return this.position01;
  }

  public String getPosition02() {
    return this.position02;
  }

  public String getPosition03() {
    return this.position03;
  }

  public String getPosition04() {
    return this.position04;
  }

  public String getPosition05() {
    return this.position05;
  }

  public String getPosition06() {
    return this.position06;
  }

  public String getPosition07() {
    return this.position07;
  }

  public String getPosition08() {
    return this.position08;
  }

  public String getPosition09() {
    return this.position09;
  }

  public String getPosition10() {
    return this.position10;
  }

  public String getPosition11() {
    return this.position11;
  }

  public String getPosition12() {
    return this.position12;
  }

  public String getPosition13() {
    return this.position13;
  }

  public String getPosition14() {
    return this.position14;
  }

  public String getPosition15() {
    return this.position15;
  }

  public String getPosition16() {
    return this.position16;
  }

  public String getPosition17() {
    return this.position17;
  }

  public String getPosition18() {
    return this.position18;
  }

  public String getPosition19() {
    return this.position19;
  }

  public String getPosition20() {
    return this.position20;
  }

  public String getPosition21() {
    return this.position21;
  }

  public String getPosition22() {
    return this.position22;
  }

  public String getPosition23() {
    return this.position23;
  }

  public String getPosition24() {
    return this.position24;
  }

  public String getPosition25() {
    return this.position25;
  }

  public String getPosition26() {
    return this.position26;
  }

  public String getPosition27() {
    return this.position27;
  }

  public String getPosition28() {
    return this.position28;
  }

  public String getPosition29() {
    return this.position29;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(courseId);
    fields.add(position00);
    fields.add(position01);
    fields.add(position02);
    fields.add(position03);
    fields.add(position04);
    fields.add(position05);
    fields.add(position06);
    fields.add(position07);
    fields.add(position08);
    fields.add(position09);
    fields.add(position10);
    fields.add(position11);
    fields.add(position12);
    fields.add(position13);
    fields.add(position14);
    fields.add(position15);
    fields.add(position16);
    fields.add(position17);
    fields.add(position18);
    fields.add(position19);
    fields.add(position20);
    fields.add(position21);
    fields.add(position22);
    fields.add(position23);
    fields.add(position24);
    fields.add(position25);
    fields.add(position26);
    fields.add(position27);
    fields.add(position28);
    fields.add(position29);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("course_id");
      fields.add("position00");
      fields.add("position01");
      fields.add("position02");
      fields.add("position03");
      fields.add("position04");
      fields.add("position05");
      fields.add("position06");
      fields.add("position07");
      fields.add("position08");
      fields.add("position09");
      fields.add("position10");
      fields.add("position11");
      fields.add("position12");
      fields.add("position13");
      fields.add("position14");
      fields.add("position15");
      fields.add("position16");
      fields.add("position17");
      fields.add("position18");
      fields.add("position19");
      fields.add("position20");
      fields.add("position21");
      fields.add("position22");
      fields.add("position23");
      fields.add("position24");
      fields.add("position25");
      fields.add("position26");
      fields.add("position27");
      fields.add("position28");
      fields.add("position29");
    return fields;
  }
}
