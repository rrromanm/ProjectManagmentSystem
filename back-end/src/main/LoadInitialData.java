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

        int budget = Integer.parseInt(tempArr[0].trim());

        int day = Integer.parseInt(tempArr[1].trim());
        int month = Integer.parseInt(tempArr[2].trim());
        int year = Integer.parseInt(tempArr[3].trim());
        MyDate startTime = new MyDate(day,month,year);

        String status = tempArr[4];
        int projectID = Integer.parseInt(tempArr[5].trim());
        int timeline = Integer.parseInt(tempArr[6].trim());

        String firstName = tempArr[7].trim();
        String surname = tempArr[8].trim();
        int id = Integer.parseInt(tempArr[9].trim());
        Customer customer = new Customer(firstName,surname,id);

        int expectedManHours = Integer.parseInt(tempArr[10].trim());
        double materialExpenses = Double.parseDouble(tempArr[11].trim());
        int manHourUsed = Integer.parseInt(tempArr[12].trim());
        Resources resources = new Resources(expectedManHours,materialExpenses,manHourUsed);

        String type = tempArr[13].trim();

        if(type.equalsIgnoreCase("Commercial"))
        {
          int size = Integer.parseInt(tempArr[14].trim());
          short floors = Short.parseShort(tempArr[15].trim());
          String usage = tempArr[16].trim();
          projects.addProject( new CommercialProject(budget,startTime,status,projectID,timeline,customer,resources,size,floors,usage));
        }
        else if(type.equalsIgnoreCase("Industrial"))
        {
          int size = Integer.parseInt(tempArr[14].trim());
          String facilityType = tempArr[15].trim();
          projects.addProject( new IndustrialProjects(budget,startTime,status,projectID,timeline,customer,resources,size,facilityType));
        }
        else if(type.equalsIgnoreCase("Residential"))
        {
          int size = Integer.parseInt(tempArr[14].trim());
          int numberOfKitchens = Integer.parseInt(tempArr[15].trim());
          int numberOfBathrooms = Integer.parseInt(tempArr[16].trim());
          int roomsWithPlumbing = Integer.parseInt(tempArr[17].trim());
          String state = tempArr[18].trim();
          projects.addProject( new ResidentialProjects(budget,startTime,status,projectID,timeline,customer,resources,size,numberOfKitchens,numberOfBathrooms,roomsWithPlumbing,state));
        }
        else if(type.equalsIgnoreCase("RoadConstruction"))
        {
          int width = Integer.parseInt(tempArr[14].trim());
          int length = Integer.parseInt(tempArr[15].trim());
          int bridges = Integer.parseInt(tempArr[16].trim());
          int tunnels = Integer.parseInt(tempArr[17].trim());
          String environmentalChallenges = tempArr[18].trim();
          String geographicalChallenges = tempArr[19].trim();
          projects.addProject( new RoadConstruction(budget,startTime,status,projectID,timeline,customer,resources,width,length,bridges,tunnels,environmentalChallenges,geographicalChallenges));
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
