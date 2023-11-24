package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class responsible for reading and writing text files and binary files.
 * @author Allan Henriksen
 * @version 1.0
 */
public class MyFileHandler
{
   /**
    * Writes the given string to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param str the text string to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public static void writeToTextFile(String fileName, String str) throws FileNotFoundException
   {
      writeText(fileName, str, false);
   }

   /**
    * Appends the given string to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param str the text string to append to the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public static void appendToTextFile(String fileName, String str) throws FileNotFoundException
   {
      writeText(fileName, str, true);
   }

   /*
    * writeToTextFile and appendToTextFile are almost identical - only the boolean in
    * the constructor of the FileOutputStream differs. So this private method
    * is called by both those methods
    */
   private static void writeText(String fileName, String str, boolean append) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
         writeToFile = new PrintWriter(fileOutStream);
         writeToFile.println(str);
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }

   /**
    * Writes the strings in the given array to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param strs the String array to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public static void writeArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException
   {
      writeText(fileName, strs, false);
   }

   /**
    * Appends the strings in the given array to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param strs the String array to append to the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public static void appendArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException
   {
      writeText(fileName, strs, true);
   }

   /*
    * Again, the writeArrayToTextFile and appendArrayToTextFile methods are almost identical.
    * So this private method is called by both those methods
    */
   private static void writeText(String fileName, String[] strs, boolean append) throws FileNotFoundException
   {
      PrintWriter writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
         writeToFile = new PrintWriter(fileOutStream);

         for (int i = 0; i < strs.length; i++)
         {
            writeToFile.println(strs[i]);
         }
      }
      finally
      {
         if (writeToFile != null)
         {
            writeToFile.close();
         }
      }
   }

   /**
    * Reads the first line from the file with the given file name.
    * @param fileName the name and path of the file that is read
    * @return a String containing the line read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public String readFromTextFile(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      String str = "";

      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);
         str = readFromFile.nextLine();
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }
      return str;
   }

   /**
    * Reads all lines from the file with the given file name.
    * @param fileName the name and path of the file that is read
    * @return a String array containing all lines read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    */
   public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      ArrayList<String> strs = new ArrayList<String>();

      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);

         while (readFromFile.hasNext())
         {
            strs.add(readFromFile.nextLine());
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }

      String[] strsArray = new String[strs.size()];
      return strs.toArray(strsArray);
   }

   /**
    * Writes the given object to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param obj the object to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error writing to the file
    */
   public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutStream);

         writeToFile.writeObject(obj);
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }

   /**
    * Writes the objects in the given array to a file with the given file name.
    * @param fileName the name and path of the file to write to
    * @param objs the Object array to write to the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error writing to the file
    */
   public static void writeArrayToBinaryFile(String fileName, Object[] objs) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutStream);

         for (int i = 0; i < objs.length; i++)
         {
            writeToFile.writeObject(objs[i]);
         }
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }

   /**
    * Reads the first object from the file with the given file name and returns it.
    * Whoever calls the method will need to cast it from type Object to its real type
    * @param fileName the name and path of the file that is read
    * @return the Object read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error reading the file
    * @throws ClassNotFoundException if the class of the serialized object cannot be found
    */
   public static Object readFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Object obj = null;
      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         try
         {
            obj = readFromFile.readObject();
         }
         catch (EOFException eof)
         {
           //Done reading
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }

      return obj;
   }

   /**
    * Reads all objects from the file with the given file name and returns it as an Object array.
    * Whoever calls the method will need to cast the Objects to their real type.
    * @param fileName the name and path of the file that is read
    * @return and Object array with all the objects read from the file
    * @throws FileNotFoundException if the file with fileName is not found
    * @throws IOException if there is an error reading the file
    * @throws ClassNotFoundException if the class of the serialized object cannot be found
    */
   public static Object[] readArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      ArrayList<Object> objs = new ArrayList<Object>();

      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         while (true)
         {
            try
            {
               objs.add(readFromFile.readObject());
            }
            catch (EOFException eof)
            {
              //Done reading
               break;
            }
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }

      return objs.toArray();
   }
 }
