package model;

import java.time.LocalDate;

/**
 * Represents a date with day, month, and year components.
 * This class provides methods for working with date information.
 * @author Samuel Kačenga
 */
public class MyDate
{
  int day;
  int month;
  int year;

  /**
   * Default constructor that initializes the date to the current system date.
   */
  public MyDate(){
    LocalDate currentDate = LocalDate.now();
    day = currentDate.getDayOfMonth();
    month = currentDate.getMonthValue();
    year = currentDate.getYear();
  }

  /**
   * Parameterized constructor that allows setting the day, month, and year.
   *
   * @param day   The day component of the date.
   * @param month The month component of the date.
   * @param year  The year component of the date.
   */
  public MyDate(int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Sets the day, month, and year of the date.
   *
   * @param d   The new day component of the date.
   * @param m The new month component of the date.
   * @param y  The new year component of the date.
   */
  public void setDate(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  /**
   * Creates a new MyDate object with the same day, month, and year as the current object.
   *
   * @return A copy of the current MyDate object.
   */
  public MyDate copy()
  {
    return new MyDate(day,month,year);
  }

  /**
   * Displays the date information in the format: "Day/Month/Year".
   */
  public void getMyDate(){
    System.out.println(day + "/" + month + "/" + year);
  }

  /**
   * Returns a string representation of the date.
   *
   * @return A string containing the day, month, and year of the date.
   */
  public String toString(){
    return "Day: " + day + "\n"+
        "Month: " + month + "\n"+
        "Year: " + year;
  }

  /**
   * Checks if two MyDate objects are equal.
   *
   * @param obj The object to compare.
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    MyDate other = (MyDate) obj;

    return day == other.day &&
        month == other.month &&
        year == other.year;
  }
}
