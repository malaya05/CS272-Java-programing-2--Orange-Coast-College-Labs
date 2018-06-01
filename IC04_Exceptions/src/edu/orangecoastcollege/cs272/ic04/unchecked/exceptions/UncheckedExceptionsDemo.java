package edu.orangecoastcollege.cs272.ic04.unchecked.exceptions;

import java.util.Scanner;

/** 
 * CS 272 - Java Programming 2 - Unchecked Exceptions
 *
 *  Put the array code in a try block and
 *  catches the array index out of bounds exception
 *  if it occurs -OR- the number format exception if it occurs.
 */
public class UncheckedExceptionsDemo
{
	/**
	 * Entry point for the unchecked exceptions demo.
	 * @param args Command line arguments.
	 */
    public static void main(String [] args)
    {
    	int [] array = {5, 6, 7};
    	Scanner consoleScanner = new Scanner(System.in);
        
    	System.out.println("int[] array = {5, 6, 7};");
        System.out.print("What index do you want to retrieve? ");
        
        int index = consoleScanner.nextInt();

        int element = array[index];
        System.out.println("array[" + index + "] = " + element);
        
        consoleScanner.close();
    }
}
