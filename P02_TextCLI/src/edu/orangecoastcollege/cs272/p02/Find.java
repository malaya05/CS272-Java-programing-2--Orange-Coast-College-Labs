package edu.orangecoastcollege.cs272.p02;

import java.io.*;
import java.util.Scanner;

/**
 * Find
 * @author put your name here
 * @version put the date here
 * 
 * This program searches files and prints out 
 * all lines containing a keyword.
 */
public class Find
{
    public static void main(String[] args) throws FileNotFoundException
    { 
       if (args.length < 1)
       { 
          System.out.println("Usage: Find keyword sourcefile1 sourcefile2 . . .");
          return;
       }
       // TODO: Here are some hints. Complete the program.
               String keyword = args[0];
               String line;
               for (int i = 1; i < args.length; i++)
              { 
                 String filename = args[i];
                 try (Scanner fileScanner = new Scanner(new File(filename)))
                 {
                    while (fileScanner.hasNextLine())
                    	{
               	        // Read the line
               	        line = fileScanner.nextLine();
                        if(line.contains(keyword))
           	           	System.out.println(filename + ": " + line);  
               	       }         	         
               }
                 catch (IOException e)
                 {
                 	System.err.println("File "+ filename +" could not be found.\n");   
                 }
             }
    }
}