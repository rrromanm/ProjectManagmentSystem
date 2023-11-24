package model;

import java.util.ArrayList;

public class ProjectList
{
  private ArrayList<Project> projects;
  public ProjectList(){
    projects = new ArrayList<Project>();
  }
  public void addProject(Project project){
    projects.add(project);
  }
  public void removeProject(Project project){
    projects.remove(project);
  }
  public String toString()
  {
    String returnStr = "";

    for(int i = 0; i<projects.size(); i++)
    {
      Project temp = projects.get(i);

      returnStr += temp +"\n";
    }
    return returnStr;
  }
}
