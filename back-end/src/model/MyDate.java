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
   * Calculates the difference in days between two MyDate objects, considering leap years.
   *
   * @param other The other MyDate object to calculate the difference.
   * @return The difference in days between the two MyDate objects.
   */
  public int differenceInDays(MyDate other) {
    int days1 = countDays(this.day, this.month, this.year);
    int days2 = countDays(other.day, other.month, other.year);

    return Math.abs(days1 - days2);
  }

  /**
   * Counts the total number of days from the beginning of a reference year (ignoring leap years).
   *
   * @param day   The day component of the date.
   * @param month The month component of the date.
   * @param year  The year component of the date.
   * @return The total number of days from the beginning of a reference year.
   */
  private int countDays(int day, int month, int year) {
    int days = day;

    for (int i = 1; i < month; i++) {
      days += getDaysInMonth(i, year);
    }

    days += (year - 1) * 365;

    return days;
  }

  /**
   * Gets the number of days in a specific month of a given year, considering leap years.
   *
   * @param month The month for which to get the number of days.
   * @param year  The year for which to get the number of days.
   * @return The number of days in the specified month of the given year.
   */
  private int getDaysInMonth(int month, int year) {
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    } else if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    } else {
      return 31;
    }
  }

  /**
   * Checks if a year is a leap year.
   *
   * @param year The year to check.
   * @return true if the year is a leap year, false otherwise.
   */
  private boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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
