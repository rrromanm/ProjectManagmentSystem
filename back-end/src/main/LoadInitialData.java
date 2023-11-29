package main;

import model.*;
import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{
  public static void main(String[] args)
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

        int budget = Integer.parseInt(tempArr[0]);

        int day = Integer.parseInt(tempArr[1]);
        int month = Integer.parseInt(tempArr[2]);
        int year = Integer.parseInt(tempArr[3]);
        MyDate startTime = new MyDate(day,month,year);

        String status = tempArr[4];
        int projectID = Integer.parseInt(tempArr[5]);
        int timeline = Integer.parseInt(tempArr[6]);

        String firstName = tempArr[7];
        String surname = tempArr[8];
        int id = Integer.parseInt(tempArr[9]);
        int phoneNumber = Integer.parseInt(tempArr[10]);
        String email = tempArr[11];
        String address = tempArr[12];
        Customer customer = new Customer(firstName,surname,id,phoneNumber,email,address);

        int expectedManHours = Integer.parseInt(tempArr[13]);
        int materialExpenses = Integer.parseInt(tempArr[14]);
        Resources resources = new Resources(expectedManHours,materialExpenses);

        if(tempArr[15].equals("Commercial"))
        {
          int size = Integer.parseInt(tempArr[16]);
          short floors = Short.parseShort(tempArr[17]);
          String usage = tempArr[18];
          projects.addProject( new CommercialProject(budget,startTime,status,projectID,timeline,customer,resources,size,floors,usage));
        }
        else if(tempArr[15].equals("Industrial"))
        {
          int size = Integer.parseInt(tempArr[16]);
          String facilityType = tempArr[17];
          projects.addProject( new IndustrialProjects(budget,startTime,status,projectID,timeline,customer,resources,size,facilityType));
        }
        else if(tempArr[15].equals("Residential"))
        {
          int size = Integer.parseInt(tempArr[16]);
          int numberOfKitchens = Integer.parseInt(tempArr[17]);
          int numberOfBathrooms = Integer.parseInt(tempArr[18]);
          int roomsWithPlumbing = Integer.parseInt(tempArr[19]);
          String state = tempArr[20];
          projects.addProject( new ResidentialProjects(budget,startTime,status,projectID,timeline,customer,resources,size,numberOfKitchens,numberOfBathrooms,roomsWithPlumbing,state));
        }
        else if(tempArr[15].equals("RoadConstruction"))
        {
          int width = Integer.parseInt(tempArr[16]);
          int length = Integer.parseInt(tempArr[17]);
          int bridges = Integer.parseInt(tempArr[18]);
          int tunnels = Integer.parseInt(tempArr[19]);
          String environmentalChallenges = tempArr[20];
          String geographicalChallenges = tempArr[21];
          projects.addProject( new RoadConstruction(budget,startTime,status,projectID,timeline,customer,resources,width,length,bridges,tunnels,environmentalChallenges,geographicalChallenges));
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
  }
}
