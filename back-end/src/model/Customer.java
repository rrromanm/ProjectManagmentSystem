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
  private int phoneNumber;
  private String email;
  private String address;

  /**
   * Creates a customer object with specified attributes
   *
   * @param firstName to set customers first name
   * @param surname to set customers last name
   * @param id to set customers id
   * @param phoneNumber to set customers phone number
   * @param email to set customers email
   * @param address to set customers email
   */

  public Customer(String firstName, String surname,int id, int phoneNumber, String email, String address)
  {
    this.firstName = firstName;
    this.surname = surname;
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
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
   * Sets the phone number of the customer.
   *
   * @param phoneNumber The new phone number of the customer.
   */
  public void setPhoneNumber(int phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns the phone number of the customer.
   *
   * @return The phone number of the customer.
   */
  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * Sets the email address of the customer.
   *
   * @param email The new email address of the customer.
   */
  public void setEmail(String email)
  {
    this.email = email;
  }

  /**
   * Returns the email address of the customer.
   *
   * @return The email address of the customer.
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * Sets the address of the customer.
   *
   * @param address The new address of the customer.
   */
  public void setAddress(String address)
  {
    this.address = address;
  }

  /**
   * Returns the address of the customer.
   *
   * @return The address of the customer.
   */
  public String getAddress()
  {
    return address;
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
        id == other.id &&
        phoneNumber == other.phoneNumber &&
        email.equals(other.email) &&
        address.equals(other.address);
  }

  /**
   * Returns a string representation of the Customer object.
   *
   * @return A string containing the customer's details.
   */
  public String toString()
  {
    return "First Name: " + firstName + "Surname: " + surname +
          "ID: " + id +
        "Address: " + address + "Phone number: " + phoneNumber +
        "Email: " + email;
  }
}
