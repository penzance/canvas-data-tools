package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class DateDim implements DataTable {
  private String day;
  private String month;
  private String quarter;
  private String year;
  private Integer quarterOfYear;
  private Integer monthOfYear;
  private Integer dayOfMonth;
  private Integer dayOfQuarter;
  private Integer dayOfYear;
  private Integer weekOfYear;
  private Integer dayOfWeek;

  public DateDim(final TableFormat format, final CSVRecord record) {
    this.day = record.get(0);
    this.month = record.get(1);
    this.quarter = record.get(2);
    this.year = record.get(3);
    String $quarterOfYear = record.get(4);
    if ($quarterOfYear != null && $quarterOfYear.length() > 0) {
      this.quarterOfYear = Integer.valueOf($quarterOfYear);
    }
    String $monthOfYear = record.get(5);
    if ($monthOfYear != null && $monthOfYear.length() > 0) {
      this.monthOfYear = Integer.valueOf($monthOfYear);
    }
    String $dayOfMonth = record.get(6);
    if ($dayOfMonth != null && $dayOfMonth.length() > 0) {
      this.dayOfMonth = Integer.valueOf($dayOfMonth);
    }
    String $dayOfQuarter = record.get(7);
    if ($dayOfQuarter != null && $dayOfQuarter.length() > 0) {
      this.dayOfQuarter = Integer.valueOf($dayOfQuarter);
    }
    String $dayOfYear = record.get(8);
    if ($dayOfYear != null && $dayOfYear.length() > 0) {
      this.dayOfYear = Integer.valueOf($dayOfYear);
    }
    String $weekOfYear = record.get(9);
    if ($weekOfYear != null && $weekOfYear.length() > 0) {
      this.weekOfYear = Integer.valueOf($weekOfYear);
    }
    String $dayOfWeek = record.get(10);
    if ($dayOfWeek != null && $dayOfWeek.length() > 0) {
      this.dayOfWeek = Integer.valueOf($dayOfWeek);
    }
  }

  public String getDay() {
    return this.day;
  }

  public String getMonth() {
    return this.month;
  }

  public String getQuarter() {
    return this.quarter;
  }

  public String getYear() {
    return this.year;
  }

  public Integer getQuarterOfYear() {
    return this.quarterOfYear;
  }

  public Integer getMonthOfYear() {
    return this.monthOfYear;
  }

  public Integer getDayOfMonth() {
    return this.dayOfMonth;
  }

  public Integer getDayOfQuarter() {
    return this.dayOfQuarter;
  }

  public Integer getDayOfYear() {
    return this.dayOfYear;
  }

  public Integer getWeekOfYear() {
    return this.weekOfYear;
  }

  public Integer getDayOfWeek() {
    return this.dayOfWeek;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(day);
    fields.add(month);
    fields.add(quarter);
    fields.add(year);
    fields.add(quarterOfYear);
    fields.add(monthOfYear);
    fields.add(dayOfMonth);
    fields.add(dayOfQuarter);
    fields.add(dayOfYear);
    fields.add(weekOfYear);
    fields.add(dayOfWeek);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("day");
      fields.add("month");
      fields.add("quarter");
      fields.add("year");
      fields.add("quarter_of_year");
      fields.add("month_of_year");
      fields.add("day_of_month");
      fields.add("day_of_quarter");
      fields.add("day_of_year");
      fields.add("week_of_year");
      fields.add("day_of_week");
    return fields;
  }
}
