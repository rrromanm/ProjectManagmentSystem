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

  public void changeStatus(int ID, String status)
  {
    ProjectList projectByStatus = new ProjectList();
  }
}
