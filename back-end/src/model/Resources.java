package model;

import java.io.Serializable;

/**
 * The Resources class represents the resources (man-hours, materials, and expenses)
 * associated with a project.
 * It provides methods to manipulate and retrieve information about these resources.
 *
 * @author Romans Mihalonoks / Samuel Kacenga / Maciej Matuszewski
 */
public class Resources implements Serializable
{

  /**
   * The total man-hours used for the project.
   */
  private int manHoursUsed;

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
  public Resources(int expectedManHours, double materialExpenses, int manHoursUsed){
    this.manHoursUsed = manHoursUsed;
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
   * Generates a string representation of the Resources object.
   *
   * @return A string containing information about man-hours, expenses, and expected man-hours.
   */
  public String toString(){
    return manHoursUsed + "," + materialExpenses + "," + expectedManHours;
  }
}
