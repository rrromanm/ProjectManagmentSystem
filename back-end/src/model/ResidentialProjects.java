package model;

public class ResidentialProjects extends Project
{
  private int size;
  private int numberOfKitchens;
  private int numberOfBathrooms;
  private int roomsWithPlumbing;

  public ResidentialProjects(int size, int numberOfKitchens, int numberOfBathrooms, int roomsWithPlumbing,int budget,
      MyDate startTime, MyDate endTime, String status, int projectID, int timeline, Customer customer, Resources resources)
  {
    super(budget,startTime,endTime,status,projectID,timeline, customer, resources);
    this.size = size;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.roomsWithPlumbing = roomsWithPlumbing;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public int getSize()
  {
    return size;
  }

  public void setNumberOfKitchens(int numberOfKitchens)
  {
    this.numberOfKitchens = numberOfKitchens;
  }

  public int getNumberOfBathrooms()
  {
    return numberOfBathrooms;
  }

  public void setNumberOfBathrooms(int numberOfBathrooms)
  {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  public int getNumberOfKitchens()
  {
    return numberOfKitchens;
  }

  public void setRoomsWithPlumbing(int roomsWithPlumbing)
  {
    this.roomsWithPlumbing = roomsWithPlumbing;
  }

  public int getRoomsWithPlumbing()
  {
    return roomsWithPlumbing;
  }
  public boolean equals(Object obj)
  {
    if(obj==null || getClass()!=obj.getClass())
    {
      return false;
    }
    ResidentialProjects other = (ResidentialProjects) obj;
    return super.equals(other) && size==other.size && numberOfKitchens==other.numberOfKitchens &&
        numberOfBathrooms==other.numberOfBathrooms && roomsWithPlumbing==other.roomsWithPlumbing;
  }
  public String toString()
  {
    return super.toString() + " " + size + " " + numberOfKitchens + " " + numberOfBathrooms + " " + roomsWithPlumbing;
  }
}
