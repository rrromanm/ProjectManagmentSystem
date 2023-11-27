package model;

import java.util.Date;

public class test
{
  public static void main(String[] args)
  {
    MyDate date = new MyDate(10,2,2023);

    Resources resources = new Resources(10,100);
    Customer customer = new Customer("null","null",date, 1, 123, "null","null");
    Project project = new ResidentialProjects(10,1,1,2,500,"new build",date, "In progress",1,20,customer, resources);

    System.out.println(project.getEndTime());
    System.out.println(project.getStartTime());
    System.out.println(project);
  }
}
