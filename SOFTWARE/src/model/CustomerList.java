package model;

import java.util.ArrayList;

public class CustomerList
{
  private final ArrayList<Customer> customers;

  public CustomerList()
  {
    customers = new ArrayList<>();
  }

  public int getNumberOfCustomers()
  {
    return customers.size();
  }

  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }

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

  public ArrayList<Customer> getCustomers()
  {
    return customers;
  }

  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    CustomerList other = (CustomerList) obj;

    return customers.equals(other.customers);
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
