package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The ProjectList class represents a collection of projects.
 * It provides methods to add and remove projects, as well as retrieve projects based on status or type.
 * The class also has a method to generate a string representation of all projects in the list.
 *
 * @author Group 1
 */
public class ProjectList implements Serializable
{

  /**
   * The list that holds all the projects.
   */
  private ArrayList<Project> projects;

  /**
   * Constructs a new ProjectList with an empty list of projects.
   */
  public ProjectList(){
    projects = new ArrayList<Project>();
  }

  /**
   * Adds a project to the list.
   *
   * @param project The project to be added.
   */
  public void addProject(Project project){
    projects.add(project);
  }

  /**
   * Removes a project from the list.
   *
   * @param project The project to be removed.
   */
  public void removeProject(Project project){
    projects.remove(project);
  }

  /**
   * Retrieves the list of projects.
   *
   * @return An {@code ArrayList} containing the projects.
   */
  public ArrayList<Project> getProjects() {
    return projects;
  }

  /**
   * Retrieves a list of projects based on a given type and status.
   *
   * @param type   The type of project to filter by.
   * @param status The status of the projects to filter by.
   * @return A ProjectList containing projects matching the provided type and status.
   */
  public ProjectList getProjectsFromTypeAndStatus(String type, String status) {
    ProjectList filteredProjects = new ProjectList();

    for (Project project : projects) {
      if (project.getType().equals(type) && project.getStatus().equals(status)) {
        filteredProjects.addProject(project);
      }
    }

    return filteredProjects;
  }

  /**
   * Retrieves all projects with a specified type.
   *
   * @param type The type to filter projects by.
   * @return An ArrayList containing indices of projects with the specified type.
   */
  public ProjectList getAllByType(String type)
  {
    ProjectList projectListByType = new ProjectList();

    for (Project project : projects)
    {
      if (project.getType().equals(type))
      {
        projectListByType.addProject(project);
      }
    }

    return projectListByType;
  }

  /**
   * Retrieves the number of projects in the list.
   *
   * @return The number of projects in the list.
   */
  public int size()
  {
    return projects.size();
  }

  /**
   * Retrieves a project at a specific index from the list.
   *
   * @param index The index of the project to retrieve.
   * @return The project at the specified index, or null if the index is out of bounds.
   */
  public Project get(int index)
  {
    if(index<projects.size())
    {
      return projects.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * Generates a string representation of all projects in the list.
   *
   * @return A string containing information about all projects in the list.
   */
  public String toString()
  {
    StringBuilder returnStr = new StringBuilder();

    for(int i = 0; i<projects.size(); i++)
    {
      Project temp = projects.get(i);

      returnStr.append(temp);
    }
    return returnStr.toString();
  }
}
