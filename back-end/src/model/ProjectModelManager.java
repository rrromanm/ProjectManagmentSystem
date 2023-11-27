package model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
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

  public ArrayList<Object> getProjectsFromType(String type)
  {
    ProjectList projectsByType = new ProjectList();

    return projectsByType.getAllByType(type);
  }

  public ArrayList<Object> getProjectsByStatus(String status)
  {
    ProjectList projectByStatus = new ProjectList();

    return projectByStatus.getAllByStatus(status);
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

  public void changeStatus(int ID, String status)
  {
    ProjectList projectByStatus = new ProjectList();
  }
}
