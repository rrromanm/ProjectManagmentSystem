package model;

import java.io.Serializable;

/**
 * Represents information about a customer.
 * This class includes details such as first name, surname, birthday, etc.
 * @author Samuel Kacenga
 */

public class Customer implements Serializable
{
  private String firstName;
  private String surname;
  private int id;

  /**
   * Creates a customer object with specified attributes
   *
   * @param firstName to set customers first name
   * @param surname to set customers last name
   * @param id to set customers id
   */

  public Customer(String firstName, String surname,int id)
  {
    this.firstName = firstName;
    this.surname = surname;
    this.id = id;
  }

  /**
   * Sets the first name of the customer.
   *
   * @param firstName The new first name of customer
   */

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * Returns the first name of the customer
   *
   * @return The first name of customer
   */

  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Sets the last name of the customer
   *
   * @param surname The new last name of customer
   */

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  /**
   * Returns the last name of the customer.
   *
   * @return The last name of the customer.
   */

  public String getSurname()
  {
    return surname;
  }

  /**
   * Sets the unique identifier for the customer.
   *
   * @param id The new unique identifier for the customer.
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   * Returns the unique identifier for the customer.
   *
   * @return The unique identifier for the customer.
   */
  public int getId()
  {
    return id;
  }

  /**
   * Checks if two Customer objects are equal.
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

    Customer other = (Customer) obj;

    return firstName.equals(other.firstName) &&
        surname.equals(other.surname) &&
        id == other.id;
  }

  /**
   * Returns a string representation of the Customer object.
   *
   * @return A string containing the customer's details.
   */
  public String toString()
  {
    return firstName  + "," + surname + "," + id;
  }
}
