package model;

import java.util.Date;

public class Customer
{
  private String firstName;
  private String surname;
  private Date birthday;
  private int id;
  private int phoneNumber;
  private String email;
  private String address;

  public Customer(String firstName, String surname, Date birthday, int id, int phoneNumber, String email, String address)
  {
    this.firstName = firstName;
    this.surname = surname;
    this.birthday = birthday;
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public void setPhoneNumber(int phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getAddress()
  {
    return address;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    Customer other = (Customer) obj;

    return firstName.equals(other.firstName) &&
        surname.equals(other.surname) &&
        birthday.equals(other.birthday) &&
        id == other.id &&
        phoneNumber == other.phoneNumber &&
        email.equals(other.email) &&
        address.equals(other.address);
  }

  public String toString()
  {
    return "First Name: " + firstName + "\n" +
        "Surname: " + surname + "\n" +
        "Birthday: " + birthday + "\n" +
        "ID: " + id + "\n" +
        "Address: " + address + "\n" +
        "Phone number: " + phoneNumber + "\n" +
        "Email: " + email;
  }
}
