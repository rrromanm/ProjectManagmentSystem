package main;

import model.*;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args)
  {
    ProjectList projects = new ProjectList();
    String[] projectArray = null;

    try
    {
      projectArray = MyFileHandler.readArrayFromTextFile("projects.txt");

      for(int i = 0; i<projectArray.length; i++)
      {
        String temp = projectArray[i];
        String[] tempArr = temp.split(",");

        int budget = Integer.parseInt(tempArr[0]);
        MyDate startTime = new MyDate();
        String status = tempArr[1];
        int projectID = Integer.parseInt(tempArr[2]);
        int timeline = Integer.parseInt(tempArr[3]);

        Customer customer = new Customer();
        Resources resources = new Resources();

        Project project = new Project(budget, startTime, status, projectID, timeline, customer, resources);

        projects.addProject(project);
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("projects.bin", projects);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error opening file ");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }

    System.out.println("Done");
  }
}
