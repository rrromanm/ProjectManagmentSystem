package model;

public class Resources
{
  private int manHoursUsed;
  private int materials;
  private double materialsPrice;
  private int expectedManHours;
  public Resources(int expectedManHours, int materials, int materialsPrice){
    manHoursUsed = 0;
    this.expectedManHours = expectedManHours;
    this.materials = materials;
    this.materialsPrice = materialsPrice;
  }
  public void setExpectedManHours(int expectedManHours){
    this.expectedManHours = expectedManHours;
  }
  public void setMaterials(int materials){
    this.materials = materials;
  }
  public int getExpectedManHours(){
    return expectedManHours;
  }
  public int getMaterials(){
    return materials;
  }
  public double getMaterialsPrice(){
    return materialsPrice;
  }
  public void setMaterialsPrice(double materialsPrice){
    this.materialsPrice = materialsPrice;
  }

  public int getManHoursUsed()
  {
    return manHoursUsed;
  }

  public void setManHoursUsed(int manHoursUsed)
  {
    this.manHoursUsed = manHoursUsed;
  }
  
}
