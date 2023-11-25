package model;

public class IndustrialProjects extends Project
{
  private int size;
  private String type;
  public IndustrialProjects(int size, String type, int budget, MyDate startTime,
      MyDate endTime, String status, int projectID, int timeline, Customer customer, Resources resources)
  {
    super(budget,startTime,endTime,status,projectID,timeline, customer, resources);
    this.size=size;
    this.type=type;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getType()
  {
    return type;
  }

  public int getSize()
  {
    return size;
  }
  public boolean equals(Object obj)
  {
    if(obj==null || getClass()!=obj.getClass())
    {
      return false;
    }
    IndustrialProjects other = (IndustrialProjects) obj;
    return super.equals(other) && size==other.size && type.equals(other.type);
  }
  public String toString()
  {
    return super.toString() + " " + size + " " + type;
  }
}
