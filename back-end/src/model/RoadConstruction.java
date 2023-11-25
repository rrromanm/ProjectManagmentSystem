package model;

public class RoadConstruction extends Project
{
  private int width;
  private int length;
  private int bridges;
  private int tunnels;
  private String environmentalChallenges;
  private String geographicalChallenges;
  public RoadConstruction(int budget,
      MyDate startTime, MyDate endTime, String status, int projectID, int timeline, Customer customer, Resources resources, int width, int lenght, int bridges, int tunnels, String environmentalChallenges, String geographicalChallenges){
    super(budget,startTime,status,projectID,timeline, customer, resources);
    this.width = width;
    this.length = lenght;
    this.bridges = bridges;
    this.tunnels = tunnels;
    this.environmentalChallenges = environmentalChallenges;
    this.geographicalChallenges = geographicalChallenges;
    super.setEndTime(startTime.convertMonthsToDate(timeline));
  }
  public RoadConstruction(int budget, MyDate startTime, MyDate endTime, String status, int projectID, int timeline, Customer customer, Resources resources, int length, int width){
    super(budget,startTime,status,projectID,timeline, customer, resources);
    super.setTimeline(18);
    bridges = 0;
    tunnels = 0;
    environmentalChallenges = "none";
    geographicalChallenges = "none";
    super.setEndTime(startTime.convertMonthsToDate(timeline));
  }

  public int getWidth()
  {
    return width;
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public int getLength()
  {
    return length;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public int getBridges()
  {
    return bridges;
  }

  public void setBridges(int bridges)
  {
    this.bridges = bridges;
  }

  public void setTunnels(int tunnels)
  {
    this.tunnels = tunnels;
  }

  public int getTunnels()
  {
    return tunnels;
  }

  public String getEnvironmentalChallenges()
  {
    return environmentalChallenges;
  }

  public void setEnvironmentalChallenges(String environmentalChallenges)
  {
    this.environmentalChallenges = environmentalChallenges;
  }

  public String getGeographicalChallenges()
  {
    return geographicalChallenges;
  }

  public void setGeographicalChallenges(String geographicalChallenges)
  {
    this.geographicalChallenges = geographicalChallenges;
  }
  public boolean equals(Object obj){
    if(obj == null || getClass() != obj.getClass()){
      return false;
    }
    RoadConstruction other = (RoadConstruction) obj;
    return super.equals(other) && width == other.width && length == other.length
        && bridges == other.bridges && tunnels == other.tunnels
        && environmentalChallenges.equals(other.environmentalChallenges)
        && geographicalChallenges.equals(other.geographicalChallenges);
  }

  public String toString(){
    return super.toString() + " " + width + " " + length + " " + bridges + " " + tunnels
        + " " + environmentalChallenges + " " + geographicalChallenges;
  }
}
