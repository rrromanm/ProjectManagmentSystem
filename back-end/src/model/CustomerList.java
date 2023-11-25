package model;

import java.util.ArrayList;


/**
 * Represents a list of customers.
 * This class manages a list of Customer objects, providing methods for adding, removing, and retrieving customers.
 * @author Samuel Kacenga
 */
public class CustomerList
{
  private ArrayList<Customer> customers;

  /**
   * Constructs an empty CustomerList.
   */
  public CustomerList()
  {
    customers = new ArrayList<>();
  }

  /**
   * Gets the number of customers in the list.
   *
   * @return The number of customers in the list.
   */
  public int getNumberOfCustomers()
  {
    return customers.size();
  }

  /**
   * Adds a customer to the list.
   *
   * @param customer The customer to be added.
   */
  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }

  /**
   * Removes a customer from the list based on the first name.
   *
   * @param name The first name of the customer to be removed.
   */
  public void removeCustomer(String name)
  {
    for (int i = 0; i < customers.size(); i++)
    {
      if (customers.get(i).getFirstName().equals(name))
      {
        customers.remove(customers.get(i));
      }
    }
  }

  /**
   * Gets the list of customers.
   *
   * @return The list of customers.
   */
  public ArrayList<Customer> getCustomers()
  {
    return customers;
  }

  /**
   * Checks if two CustomerList objects are equal.
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

    CustomerList other = (CustomerList) obj;

    return customers.equals(other.customers);
  }

  /**
   * Returns a string representation of the CustomerList object.
   *
   * @return A string containing the details of the CustomerList.
   */
  @Override public String toString()
  {
    return super.toString();
  }
}
