package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a date with day, month, and year components.
 * This class provides methods for working with date information.
 * @author Samuel Kacenga
 */
public class MyDate implements Serializable
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

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public int getDay()
  {
    return day;
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
   * Counts the total number of days from the beginning of a reference year including leap years.
   *
   * @param day   The day component of the date.
   * @param month The month component of the date.
   * @param year  The year component of the date.
   * @return The total number of days from the beginning of a reference year.
   */
  private int countDays(int day, int month, int year) {
    int days = day;

    for (int i = 1; i < month; i++) {
      days += getDaysInMonth(year);
    }

    days += countLeapYears(year);

    days += (year - 1) * 365;

    return days;
  }

  /**
   * Gets the number of days in a specific month of a given year, considering leap years.
   *
   * @return The number of days in the specified month of the given year.
   */
  public int getDaysInMonth(int year)
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
   * Checks if a year is a leap year.
   *
   * @return true if the year is a leap year, false otherwise.
   */
  public boolean isLeapYear(int year)
  {
    return year % 4 == 0 && year % 100 != 0 || (year % 400 == 0);
  }

  /**
   * Counts the number of leap years from the reference year to the specified year.
   *
   * @param year The year to which the leap years are counted.
   * @return The number of leap years.
   */
  private int countLeapYears(int year) {
    int leapYears = 0;
    for (int i = 0; i < year; i++) {
      if (isLeapYear(i)) {
        leapYears++;
      }
    }
    return leapYears;
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