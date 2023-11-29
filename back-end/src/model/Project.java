package model;

import java.io.Serializable;

/**
 * This class contains all variables that will be shared by project types.
 *
 * @author Maciej Matuszewski
 */
public abstract class Project implements Serializable
{
  private int budget;
  private MyDate startTime;
  private MyDate endTime;
  private Customer customer;
  private Resources resources;
  private String status;
  private int projectID;
  private int timeline;
  private String type;

  /**
   * This is the constructor method for the Project class with variables that will be inherited by project type classes.
   * @param budget The budget for the project.
   * @param startTime The start time of the project.
   * @param status The status of the project.
   * @param projectID The ID of the project.
   * @param timeline The timeline of the project.
   * @param customer The customer of the project.
   * @param resources The resources of the project.
   */
  public Project(int budget, MyDate startTime,String status, int projectID, int timeline, Customer customer, Resources resources){
    this.budget = budget;
    this.status = status;
    this.projectID = projectID;
    this.startTime = startTime;
    this.timeline = timeline;
    this.customer = customer;
    this.resources = resources;
    this.type = null;
  }
  /**
   * @param budget set the budget that will be assigned to the project
   */
  public void setBudget(int budget) {
      this.budget = budget;
  }
  /**
   * @param customer set the customer that reported creation of the project 
   */
  public void setCustomer(Customer customer) {
      this.customer = customer;
  }
  /**
   * @param endTime set the date when the project will be finished
   */
  public void setEndTime(MyDate endTime) {
      this.endTime = endTime;
  }
  /**
   * @param resources set the resources that will be assigned to the project
   */
  public void setResources(Resources resources) {
      this.resources = resources;
  }
  /**
   * @param startTime set the start date of the project
   */
  public void setStartTime(MyDate startTime) {
      this.startTime = startTime;
  }
  /**
   * @return the customer that reported creation of the project
   */
  public Customer getCustomer() {
      return customer;
  }
  /**
   * @return the end date of the project
   */
  public MyDate getEndTime() {
      return endTime;
  }
  /**
   * @return the resources used in a project
   */
  public Resources getResources() {
      return resources;
  }
  /**
   * @return the start date of the project
   */
  public MyDate getStartTime() {
      return startTime;
  }
  /**
   * @return the budget assigned to the project
   */
  public int getBudget() {
      return budget;
  }
  /**
   * @return the unique projectID
   */
  public int getProjectID() {
      return projectID;
  }
  /**
   * @return the project status
   */
  public String getStatus() {
      return status;
  }
  /**
   * @return the timeline that was assigned to the project
   */
  public int getTimeline() {
      return timeline;
  }
  /**
   * @param projectID set the unique projectID
   */
  public void setProjectID(int projectID) {
      this.projectID = projectID;
  }
  /**
   * @param status set the project status
   */
  public void setStatus(String status) {
      this.status = status;
  }
  /**
   * @param timeline set the timeline that will be assigned to the project
   */
  public void setTimeline(int timeline) {
      this.timeline = timeline;
  }
  /**
   * @return the project type
   */
  public String getType() {
      return type;
  }
  /**
   * @param type set the project type
   */
  public void setType(String type) {
      this.type = type;
  }


  /**
   * This method checks if the current object is equal to the given object.
   * @param obj The object to compare with.
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equals(Object obj){
    if(obj == null || getClass() != obj.getClass()){
      return false;
    }
    Project other = (Project) obj;
    return budget == other.budget && status.equals(other.status) && projectID == other.projectID && timeline == other.timeline &&
    startTime == other.startTime && endTime == other.endTime && resources == other.resources && customer == other.customer &&
    type.equals(other.type);
  }

  /**
   * This method returns a string representation of the Project object.
   * @return A string representation of the Project object.
   */
  public String toString(){
    return "project type: "+type+"\nbudget: "+budget+"\nstatus: "+status+"\n ID: "+projectID+"\n timeline: "+timeline+ "\n project start date: "+startTime+
    "\n project deadline: "+endTime+"\n resources: "+resources+"\n customer: "+customer;
  }

}
