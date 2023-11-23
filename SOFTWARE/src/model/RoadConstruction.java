package model;

public class RoadConstruction extends Project
{
  private int width;
  private int lenght;
  private int bridges;
  private int tunnels;
  private String environmentalChallenges;
  private String geographicalChallenges;
  public RoadConstruction(int budget, Date deadline, String status, int projectID, int width, int lenght, int bridges, int tunnels, String environmentalChallenges, String geographicalChallenges){
    super(budget, deadline, status, projectID);
    this.width = width;
    this.lenght = lenght;
    this.bridges = bridges;
    this.tunnels = tunnels;
    this.environmentalChallenges = environmentalChallenges;
    this.geographicalChallenges = geographicalChallenges;
  }
  public RoadConstruction(int budget, int lenght, int width, Date deadline, String status, int projectID){
    super(budget, deadline, status, projectID);
    super.setTimeline(18);
    bridges = 0;
    tunnels = 0;
    environmentalChallenges = "none";
    geographicalChallenges = "none";
  }

  public int getWidth()
  {
    return width;
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public int getLenght()
  {
    return lenght;
  }

  public void setLenght(int lenght)
  {
    this.lenght = lenght;
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
    return super.equals(other) && width == other.width && lenght == other.lenght
        && bridges == other.bridges && tunnels == other.tunnels
        && environmentalChallenges.equals(other.environmentalChallenges)
        && geographicalChallenges.equals(other.geographicalChallenges);
  }

  public String toString(){
    return super.toString() + " " + width + " " + lenght + " " + bridges + " " + tunnels
        + " " + environmentalChallenges + " " + geographicalChallenges;
  }
}
