package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a date with day, month, and year components.
 * This class provides methods for working with date information.
 *
 * @author Group 1
 */
public class MyDate implements Serializable
{
  private int day;
  private int month;
  private int year;

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
   * Gets the month of the date.
   *
   * @return The month value of the date.
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Sets the month of the date.
   *
   * @param month The month value to set.
   */
  public void setMonth(int month)
  {
    this.month = month;
  }

  /**
   * Gets the year of the date.
   *
   * @return The year value of the date.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Sets the year of the date.
   *
   * @param year The year value to set.
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * Gets the day of the date.
   *
   * @return The day value of the date.
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Sets the day of the date.
   *
   * @param day The day value to set.
   */
  public void setDay(int day)
  {
    this.day = day;
  }

  /**
   * Checks if a year is a leap year.
   *
   * @return true if the year is a leap year, false otherwise.
   */
  public boolean isLeapYear(int year)
  {
    return year % 4 == 0 && year % 100 != 0 || (year % 400 == 0);
  }

  /**
   * Gets the number of days in a specific month of a given year, considering leap years.
   *
   * @return The number of days in the specified month of the given year.
   */
  public int getDaysInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else if (isLeapYear(year) && month == 2)
    {
      return 29;
    }
    else if (month == 2)
    {
      return 28;
    }
    return 0;
  }

  /**
   * Adds a specified number of months to the current date and returns a new MyDate object.
   *
   * @param months The number of months to add to the current date.
   * @return A new MyDate object representing the date after adding the specified months.
   */
  public MyDate convertMonthsToDate(int months){
    int yearsToAdd = months / 12;
    int remainingMonths = months % 12;

    int newYear = year + yearsToAdd;
    int newMonth = month + remainingMonths;

    if (newMonth > 12) {
      newYear += 1;
      newMonth -= 12;
    }

    return new MyDate(day, newMonth, newYear);
  }

  /**
   * Checks if the current date is a valid date.
   *
   * @return {@code true} if the date is valid, otherwise {@code false}.
   */
  public boolean isValidDate() {
    int daysInMonth = getDaysInMonth();

    if (this.day > daysInMonth || this.day <= 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Returns a string representation of the date.
   *
   * @return A string containing the day, month, and year of the date.
   */
  public String toString(){
    return day + "/" + month + "/" + year;
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