package model;

import main.LoadInitialData;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProjectModelManager
{
  private String fileName;

  public ProjectModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public ProjectList getAllProjects()
  {
    ProjectList allProjects = new ProjectList();

    try
    {
      allProjects = (ProjectList) MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allProjects;
  }

  public ProjectList getProjectsFromType(String type)
  {
    return getAllProjects().getAllByType(type);
  }

  public ProjectList getProjectsByStatus(String status)
  {
    return getAllProjects().getAllByStatus(status);
  }

  public ProjectList getProjectsFromTypeAndStatus(String type, String status) {
   return getAllProjects().getProjectsFromTypeAndStatus(type,status);
  }

  public void saveProjects(ProjectList projects)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, projects);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  public void appendProjects(ProjectList projects) {
    ProjectList existingProjects = getAllProjects();

    existingProjects.getProjects().addAll(projects.getProjects());

    try {
      MyFileHandler.writeToBinaryFile(fileName, existingProjects);

      System.out.println("Successfully added project");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("IO Error writing to file");
    }
  }

  public void removeProject(ProjectList list){

      try {
        MyFileHandler.writeToBinaryFile(fileName, list);

        System.out.println("Successfully removed project.");
      } catch (IOException e) {
        System.out.println("Error writing to file");
        e.printStackTrace();
      }
  }

  public void changeStatus(int ID, String status)
  {
    ProjectList projectByStatus = new ProjectList();
  }

  public void updateProject(Project projectToUpdate)
  {
    ProjectList allProjects = getAllProjects();

    for (int i = 0; i < allProjects.size(); i++)
    {
      Project project = allProjects.get(i);

      if (project.getProjectID() == projectToUpdate.getProjectID())
      {
        project.setName(projectToUpdate.getName());
        project.setStatus(projectToUpdate.getStatus());
        project.setBudget(projectToUpdate.getBudget());
        project.setTimeline(projectToUpdate.getTimeline());

        int day = projectToUpdate.getStartTime().getDay();
        int month = projectToUpdate.getStartTime().getMonth();
        int year = projectToUpdate.getStartTime().getYear();
        project.setStartTime(new MyDate(day, month, year));

        String firstName = projectToUpdate.getCustomer().getFirstName();
        String surname = projectToUpdate.getCustomer().getSurname();
        int id  = projectToUpdate.getCustomer().getId();
        project.setCustomer(new Customer(firstName,surname,id));

        double expenses = projectToUpdate.getResources().getExpenses();
        int manHoursExpects = projectToUpdate.getResources().getExpectedManHours();
        int manHoursUsed = projectToUpdate.getResources().getManHoursUsed();
        project.setResources(new Resources(manHoursExpects, expenses, manHoursUsed));
      }
    }
    saveProjects(allProjects);
  }
}
