package model;

/**
 * The Resources class represents the resources (man-hours, materials, and expenses)
 * associated with a project.
 * It provides methods to manipulate and retrieve information about these resources.
 *
 * @author Romans Mihalonoks / Samuel Kačenga
 */
public class Resources
{

  /**
   * The total man-hours used for the project.
   */
  private int manHoursUsed;

  /**
   * The quantity of materials used for the project.
   */
  private int materials;

  /**
   * The total expenses related to materials for the project.
   */
  private double materialExpenses;

  /**
   * The expected man-hours for the project.
   */
  private int expectedManHours;

  /**
   * Constructs a new Resources object with the given expected man-hours and material expenses.
   *
   * @param expectedManHours The expected man-hours for the project.
   * @param materialExpenses The initial material expenses for the project.
   */
  public Resources(int expectedManHours, int materialExpenses){
    manHoursUsed = 0;
    this.expectedManHours = expectedManHours;
    this.materialExpenses = materialExpenses;
  }

  /**
   * Sets the expected man-hours for the project.
   *
   * @param expectedManHours The new expected man-hours.
   */
  public void setExpectedManHours(int expectedManHours){
    this.expectedManHours = expectedManHours;
  }

  /**
   * Retrieves the expected man-hours for the project.
   *
   * @return The expected man-hours.
   */
  public int getExpectedManHours(){
    return expectedManHours;
  }


  /**
   * Retrieves the total expenses related to materials for the project.
   *
   * @return The material expenses.
   */
  public double getExpenses(){
    return materialExpenses;
  }

  /**
   * Sets the material expenses for the project.
   *
   * @param ex The new material expenses.
   */
  public void setExpenses(double ex){
    this.materialExpenses = ex;
  }

  /**
   * Adds expenses to the total material expenses for the project.
   *
   * @param value The value to be added to the material expenses.
   */
  public void addExpenses(double value)
  {
    materialExpenses += value;
  }

  /**
   * Retrieves the total man-hours used for the project.
   *
   * @return The total man-hours used.
   */
  public int getManHoursUsed()
  {
    return manHoursUsed;
  }

  /**
   * Sets the total man-hours used for the project.
   *
   * @param manHoursUsed The new total man-hours used.
   */
  public void setManHoursUsed(int manHoursUsed)
  {
    this.manHoursUsed = manHoursUsed;
  }

  /**
   * Adds hours to the total man-hours used for the project.
   *
   * @param hours The hours to be added to the total man-hours used.
   */
  public void addManHoursUsed(int hours)
  {
    manHoursUsed += hours;
  }

  /**
   * Generates a string representation of the Resources object.
   *
   * @return A string containing information about man-hours, expenses, and expected man-hours.
   */
  public String toString(){
    return "Man hours: " + manHoursUsed + "Expenses: " + materialExpenses + "Expected man hours: " + expectedManHours;
  }
}
