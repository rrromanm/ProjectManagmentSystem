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

  public void updateProject(Project projectToUpdate) {
    ProjectList allProjects = getAllProjects();

    for (int i = 0; i < allProjects.size(); i++) {
      Project project = allProjects.get(i);

      if (project.getProjectID() == projectToUpdate.getProjectID()) {
        project.setName(projectToUpdate.getName());
        project.setStatus(projectToUpdate.getStatus());
        project.setBudget(projectToUpdate.getBudget());
        project.setTimeline(projectToUpdate.getTimeline());
        project.setStartTime(projectToUpdate.getStartTime());
        project.setCustomer(projectToUpdate.getCustomer());
        project.setResources(projectToUpdate.getResources());

        if (project.getType().equals("Industrial")) {
          IndustrialProjects updatedProject = (IndustrialProjects) projectToUpdate;
          ((IndustrialProjects) project).setSize(updatedProject.getSize());
          ((IndustrialProjects) project).setFacilityType(updatedProject.getFacilityType());
        } else if (project.getType().equals("Commercial")) {
          CommercialProject updatedProject = (CommercialProject) projectToUpdate;
          ((CommercialProject) project).setSize(updatedProject.getSize());
          ((CommercialProject) project).setFloors(updatedProject.getFloors());
          ((CommercialProject) project).setUsage(updatedProject.getUsage());
        } else if (project.getType().equals("RoadConstruction")) {
          RoadConstruction updatedProject = (RoadConstruction) projectToUpdate;
          ((RoadConstruction) project).setWidth(updatedProject.getWidth());
          ((RoadConstruction) project).setLength(updatedProject.getLength());
          ((RoadConstruction) project).setBridges(updatedProject.getBridges());
          ((RoadConstruction) project).setTunnels(updatedProject.getTunnels());
          ((RoadConstruction) project).setEnvironmentalChallenges(updatedProject.getEnvironmentalChallenges());
          ((RoadConstruction) project).setGeographicalChallenges(updatedProject.getGeographicalChallenges());
        } else if (project.getType().equals("Residential")) {
          ResidentialProjects updatedProject = (ResidentialProjects) projectToUpdate;
          ((ResidentialProjects) project).setSize(updatedProject.getSize());
          ((ResidentialProjects) project).setNumberOfKitchens(updatedProject.getNumberOfKitchens());
          ((ResidentialProjects) project).setNumberOfBathrooms(updatedProject.getNumberOfBathrooms());
          ((ResidentialProjects) project).setRoomsWithPlumbing(updatedProject.getRoomsWithPlumbing());
          ((ResidentialProjects) project).setState(updatedProject.getState());
        }
      }
    }
    saveProjects(allProjects);
  }
  public int generateProjectID()
  {
    ProjectList list = getAllProjects();
    int result = (list.size() + 1);
    return result;
  }
}
