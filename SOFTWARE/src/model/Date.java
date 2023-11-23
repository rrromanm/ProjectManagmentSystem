package model;

import java.time.LocalDate;

public class Date
{
  int day;
  int month;
  int year;

  public Date(){
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
  }

  public Date(int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDate(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  public Date copy()
  {
    return new Date(day,month,year);
  }

  public void getMyDate(){
    System.out.println("Project start date is: " + day + "/" + month + "/" + year);
  }

  public String toString(){
    return "Day: " + day + "\n"+
        "Month: " + month + "\n"+
        "Year: " + year;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Date other = (Date) obj;

    return day == other.day &&
        month == other.month &&
        year == other.year;
  }
}
