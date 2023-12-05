package main;

import model.*;
import parser.ParserException;

import parser.XmlJsonParser;
import utils.MyFileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args) throws ParserException
  {
    ProjectList projects = new ProjectList();
    String[] projectArray = null;

    try
    {

      projectArray = MyFileHandler.readArrayFromTextFile("projects.txt");

      for(int i = 0; i<projectArray.length; i++)
      {
        String temp = projectArray[i];
        String[] tempArr = temp.split(",");

        String name =  tempArr[0].trim();
        int budget = Integer.parseInt(tempArr[1].trim());

        int day = Integer.parseInt(tempArr[2].trim());
        int month = Integer.parseInt(tempArr[3].trim());
        int year = Integer.parseInt(tempArr[4].trim());
        MyDate startTime = new MyDate(day,month,year);

        String status = tempArr[5];
        int projectID = Integer.parseInt(tempArr[6].trim());
        int timeline = Integer.parseInt(tempArr[7].trim());

        String firstName = tempArr[8].trim();
        String surname = tempArr[9].trim();
        int id = Integer.parseInt(tempArr[10].trim());
        Customer customer = new Customer(firstName,surname,id);

        int expectedManHours = Integer.parseInt(tempArr[11].trim());
        double materialExpenses = Double.parseDouble(tempArr[12].trim());
        int manHourUsed = Integer.parseInt(tempArr[13].trim());
        Resources resources = new Resources(expectedManHours,materialExpenses,manHourUsed);

        String type = tempArr[14].trim();

        if(type.equalsIgnoreCase("Commercial"))
        {
          int size = Integer.parseInt(tempArr[15].trim());
          short floors = Short.parseShort(tempArr[16].trim());
          String usage = tempArr[17].trim();
          projects.addProject( new CommercialProject(name,budget,startTime,status,projectID,timeline,customer,resources,size,floors,usage));
        }
        else if(type.equalsIgnoreCase("Industrial"))
        {
          int size = Integer.parseInt(tempArr[15].trim());
          String facilityType = tempArr[16].trim();
          projects.addProject( new IndustrialProjects(name,budget,startTime,status,projectID,timeline,customer,resources,size,facilityType));
        }
        else if(type.equalsIgnoreCase("Residential"))
        {
          int size = Integer.parseInt(tempArr[15].trim());
          int numberOfKitchens = Integer.parseInt(tempArr[16].trim());
          int numberOfBathrooms = Integer.parseInt(tempArr[17].trim());
          int roomsWithPlumbing = Integer.parseInt(tempArr[18].trim());
          String state = tempArr[19].trim();
          projects.addProject( new ResidentialProjects(name,budget,startTime,status,projectID,timeline,customer,resources,size,numberOfKitchens,numberOfBathrooms,roomsWithPlumbing,state));
        }
        else if(type.equalsIgnoreCase("RoadConstruction"))
        {
          int width = Integer.parseInt(tempArr[15].trim());
          int length = Integer.parseInt(tempArr[16].trim());
          int bridges = Integer.parseInt(tempArr[17].trim());
          int tunnels = Integer.parseInt(tempArr[18].trim());
          String environmentalChallenges = tempArr[19].trim();
          String geographicalChallenges = tempArr[20].trim();
          projects.addProject( new RoadConstruction(name,budget,startTime,status,projectID,timeline,customer,resources,width,length,bridges,tunnels,environmentalChallenges,geographicalChallenges));
        }
        else {
          System.out.println("Unknown project type: " + type);
        }
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

    try
    {
      MyFileHandler.writeToBinaryFile("projects.bin", projects);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Error opening file ");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }

    System.out.println("Done");

    XmlJsonParser parser = new XmlJsonParser();
    File file1 = parser.toJson(projects, "projectlist.json");

    File file2 = parser.toXml(projects, "projectlist.xml");
  }
}
