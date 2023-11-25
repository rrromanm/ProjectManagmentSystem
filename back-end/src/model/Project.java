package model;

public abstract class Project
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

  public Project(int budget, MyDate startTime, String status, int projectID, int timeline, Customer customer, Resources resources){
    this.budget = budget;
    this.status = status;
    this.projectID = projectID;
    this.timeline = timeline;
    this.startTime = startTime;
    this.timeline = timeline;
    this.customer = customer;
    this.resources = resources;
    endTime = endTime.convertMonthsToDate(timeline);
    
  }
  public void setBudget(int budget)
  {
    this.budget = budget;
  }
  /**
   * @param customer the customer to set
   */
  public void setCustomer(Customer customer) {
      this.customer = customer;
  }
  /**
   * @param endTime the endTime to set
   */
  public void setEndTime(MyDate endTime) {
      this.endTime = endTime;
  }
  /**
   * @param resources the resources to set
   */
  public void setResources(Resources resources) {
      this.resources = resources;
  }
  /**
   * @param startTime the startTime to set
   */
  public void setStartTime(MyDate startTime) {
      this.startTime = startTime;
  }
  /**
   * @return the customer
   */
  public Customer getCustomer() {
      return customer;
  }
  /**
   * @return the endTime
   */
  public MyDate getEndTime() {
      return endTime;
  }
  /**
   * @return the resources
   */
  public Resources getResources() {
      return resources;
  }
  /**
   * @return the startTime
   */
  public MyDate getStartTime() {
      return startTime;
  }
  /**
   * @return the budget
   */
  public int getBudget() {
      return budget;
  }
  /**
   * @return the projectID
   */
  public int getProjectID() {
      return projectID;
  }
  /**
   * @return the status
   */
  public String getStatus() {
      return status;
  }
  /**
   * @return the timeline
   */
  public int getTimeline() {
      return timeline;
  }
  /**
   * @param projectID the projectID to set
   */
  public void setProjectID(int projectID) {
      this.projectID = projectID;
  }
  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
      this.status = status;
  }
  /**
   * @param timeline the timeline to set
   */
  public void setTimeline(int timeline) {
      this.timeline = timeline;
  }
  /**
   * @return the type
   */
  public String getType() {
      return type;
  }
  /**
   * @param type the type to set
   */
  public void setType(String type) {
      this.type = type;
  }

  public boolean equals(Object obj){
    if(obj == null || getClass() != obj.getClass()){
      return false;
    }
    Project other = (Project) obj;
    return budget == other.budget && status.equals(other.status) && projectID == other.projectID && timeline == other.timeline &&
    startTime == other.startTime && endTime == other.endTime && resources == other.resources && customer == other.customer &&
    type.equals(other.type);
  }

  public String toString(){
    return "project type: "+type+"\nbudget: "+budget+"\nstatus: "+status+"\n ID: "+projectID+"\n timeline: "+timeline+ "\n project start date: "+startTime+
    "\n project deadline: "+endTime+"\n resources: "+resources+"\n customer: "+customer;
  }

}
