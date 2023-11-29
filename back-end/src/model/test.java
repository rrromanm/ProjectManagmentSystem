package model;

import java.util.Date;

public class test
{
  public static void main(String[] args)
  {
    MyDate date = new MyDate();
    Customer customer = new Customer("Samuel","Abramek", 1,123,"sas", "ssa");
    Resources resources = new Resources(10,10);
    Project project1 = new IndustrialProjects(100, date, 1, customer, resources, 100,"plant");

    ProjectList projectList = new ProjectList();

    projectList.addProject(project1);

    System.out.println(projectList.toString());
  }

}
