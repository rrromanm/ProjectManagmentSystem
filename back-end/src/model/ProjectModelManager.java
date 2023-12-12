package model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The ProjectModelManager class manage the files of the projects.
 * It provides methods to read, write, update and retrieve project information
 * It utilizes serialization for storing and retrieving project data in binary format.
 *
 * @author Samuel Kacenga
 */
public class ProjectModelManager
{
  private String fileName;

  /**
   * Constructs a ProjectModelManager with the specified file name.
   * @param fileName The name of the file used for project data storage.
   */
  public ProjectModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  /**
   * Return all projects stored in the binary file.
   *
   * @return A ProjectList containing all projects.
   */
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
  /**
   * Returns projects based on the type.
   *
   * @param type The type of projects to return.
   * @return A ProjectList containing projects of the specified type.
   */
  public ProjectList getProjectsFromType(String type)
  {
    return getAllProjects().getAllByType(type);
  }

  /**
   * Return projects of a specific type and status.
   *
   * @param type   The type of projects to return.
   * @param status The status of projects to return.
   * @return A ProjectList containing projects of the specified type and status.
   */
  public ProjectList getProjectsFromTypeAndStatus(String type, String status) {
   return getAllProjects().getProjectsFromTypeAndStatus(type,status);
  }

  /**
   * Saves the provided projects to the file.
   *
   * @param projects The {@code ProjectList} to be saved.
   */
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
  /**
   * Appends the provided project to the existing projects in the binary file.
   *
   * @param project The {@code ProjectList} to be appended.
   */
  public void appendProject(Project project) {
    ProjectList existingProjects = getAllProjects();

    existingProjects.addProject(project);

    try {
      MyFileHandler.writeToBinaryFile(fileName, existingProjects);
      System.out.println("Successfully added project");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("IO Error writing to file");
    }
  }

  /**
   * Removes projects specified in the list from the file.
   *
   * @param list The {@code ProjectList} containing projects to be removed.
   */
  public void removeProject(ProjectList list){

      try {
        MyFileHandler.writeToBinaryFile(fileName, list);

        System.out.println("Successfully removed project.");
      } catch (IOException e) {
        System.out.println("Error writing to file");
        e.printStackTrace();
      }
  }
  /**
   * Updates the information of a specific project in the file.
   *
   * @param projectToUpdate The {@code Project} with updated information.
   */
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
        } else if (project instanceof RoadConstruction) {
          RoadConstruction updatedProject = (RoadConstruction) projectToUpdate;
          ((RoadConstruction) project).setWidth(updatedProject.getWidth());
          ((RoadConstruction) project).setLength(updatedProject.getLength());
          ((RoadConstruction) project).setBridges(updatedProject.getBridges());
          ((RoadConstruction) project).setTunnels(updatedProject.getTunnels());
          ((RoadConstruction) project).setEnvironmentalChallenges(updatedProject.getEnvironmentalChallenges());
          ((RoadConstruction) project).setGeographicalChallenges(updatedProject.getGeographicalChallenges());
        } else if (project instanceof ResidentialProjects) {
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
  /**
   * Generates a new unique project ID based on the existing projects.
   *
   * @return A new project ID.
   */
  public int generateProjectID()
  {
    ProjectList list = getAllProjects();
    int result = (list.size() + 1);
    return result;
  }
}
