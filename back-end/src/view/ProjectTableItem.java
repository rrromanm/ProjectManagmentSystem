// ProjectTableItem.java
package view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import model.MyDate;

/**
 * This class defines properties for various attributes of a project to be displayed in a table view.
 *
 * @author Group 1
 */
public class ProjectTableItem {
  private final SimpleIntegerProperty projectId;
  private final SimpleStringProperty projectType;
  private final SimpleStringProperty projectName;
  private final SimpleStringProperty projectStatus;
  private final SimpleIntegerProperty projectBudget;
  private final SimpleIntegerProperty projectTimeline;
  private final SimpleObjectProperty<MyDate> projectDeadline;
  private final SimpleStringProperty projectCustomer;
  private final SimpleIntegerProperty projectCustomerID;
  private final SimpleIntegerProperty projectExpectedManHours;
  private final SimpleIntegerProperty projectManHours;
  private final SimpleDoubleProperty projectCosts;

  /**
   * Constructs a ProjectTableItem with specified project attributes.
   *
   * @param projectId            The ID of the project.
   * @param projectType          The type of the project.
   * @param projectName          The name of the project.
   * @param projectStatus        The status of the project.
   * @param projectBudget        The budget allocated for the project.
   * @param projectTimeline      The timeline for the project.
   * @param projectDeadline      The deadline of the project.
   * @param projectCustomer      The customer associated with the project.
   * @param projectCustomerID    The ID of the customer associated with the project.
   * @param projectExpectedManHours The expected man-hours for the project.
   * @param projectManHours      The man-hours used for the project.
   * @param projectCosts         The total costs incurred for the project.
   */
  public ProjectTableItem(int projectId, String projectType, String projectName ,String projectStatus, int projectBudget,
      int projectTimeline, MyDate projectDeadline, String projectCustomer, int projectCustomerID,
      int projectExpectedManHours ,int projectManHours, double projectCosts) {
    this.projectId = new SimpleIntegerProperty(projectId);
    this.projectType = new SimpleStringProperty(projectType);
    this.projectName = new SimpleStringProperty(projectName);
    this.projectStatus = new SimpleStringProperty(projectStatus);
    this.projectBudget = new SimpleIntegerProperty(projectBudget);
    this.projectTimeline = new SimpleIntegerProperty(projectTimeline);
    this.projectDeadline = new SimpleObjectProperty<>(projectDeadline);
    this.projectCustomer = new SimpleStringProperty(projectCustomer);
    this.projectExpectedManHours = new SimpleIntegerProperty(projectExpectedManHours);
    this.projectManHours = new SimpleIntegerProperty(projectManHours);
    this.projectCosts = new SimpleDoubleProperty(projectCosts);
    this.projectCustomerID = new SimpleIntegerProperty(projectCustomerID);
  }


  /**
   * Retrieves the ID of the project.
   *
   * @return The ID of the project.
   */
  public int getProjectId() {
    return projectId.get();
  }

  /**
   * Retrieves the type of the project.
   *
   * @return The type of the project.
   */
  public String getProjectType() {
    return projectType.get();
  }

  /**
   * Retrieves the name of the project.
   *
   * @return The name of the project.
   */
  public String getProjectName() {return projectName.get();}

  /**
   * Retrieves the status of the project.
   *
   * @return The name of the project.
   */
  public String getProjectStatus() {
    return projectStatus.get();
  }

  /**
   * Retrieves the budget of the project.
   *
   * @return The name of the project.
   */
  public int getProjectBudget() {
    return projectBudget.get();
  }

  /**
   * Retrieves the timeline of the project.
   *
   * @return The name of the project.
   */
  public int getProjectTimeline() {
    return projectTimeline.get();
  }

  /**
   * Retrieves the deadline of the project.
   *
   * @return The name of the project.
   */
  public MyDate getProjectDeadline() {
    return projectDeadline.get();
  }

  /**
   * Retrieves the customer of the project.
   *
   * @return The name of the project.
   */
  public String getProjectCustomer() {
    return projectCustomer.get();
  }

  /**
   * Retrieves the customer id of the project.
   *
   * @return The name of the project.
   */
  public int getProjectCustomerID() {
    return projectCustomerID.get();
  }

  /**
   * Retrieves the expected man-hours of the project.
   *
   * @return The name of the project.
   */
  public int getExpectedProjectManHours() {
    return projectExpectedManHours.get();
  }

  /**
   * Retrieves the man-hours used of the project.
   *
   * @return The name of the project.
   */
  public int getProjectManHours() {
    return projectManHours.get();
  }

  /**
   * Retrieves the costs of the project.
   *
   * @return The name of the project.
   */
  public double getProjectCosts() {
    return projectCosts.get();
  }
}
