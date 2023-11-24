package model;

public abstract class Project
{
  private int budget;
  private MyDate deadline;
  private String status;
  private int projectID;
  private int timeline;

  public Project(int budget, MyDate deadline, String status, int projectID, int timeline){
    this.budget = budget;
    this.status = status;
    this.projectID = projectID;
    this.deadline = deadline;
    this.timeline = timeline;
  }
  public void setBudget(int budget)
  {
    this.budget = budget;
  }

  public void setTimeline(int timeline)
  {
    this.timeline = timeline;
  }

  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public void setProjectID(int projectID)
  {
    this.projectID = projectID;
  }

  public int getBudget()
  {
    return budget;
  }

  public int getTimeline()
  {
    return timeline;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public String getStatus()
  {
    return status;
  }

  public int getProjectID()
  {
    return projectID;
  }

  public boolean equals(Object obj){
    if(obj == null || getClass() != obj.getClass()){
      return false;
    }
    Project other = (Project) obj;
    return budget == other.budget && deadline == other.deadline
        && status.equals(other.status) && projectID == other.projectID;
  }

  public String toString(){
    return budget + " " + deadline + " " + status + " " + projectID;
  }

}
