package edu.orangecoastcollege.cs272.malaya.p01;

import java.util.*;

public class MotorVehicleDemo
{

public static MotorVehicle 
findFastestMotorVehicle(List<MotorVehicle> vehiclesList)
{
	MotorVehicle  highestSpeed = vehiclesList.get(0);
	
	for( MotorVehicle e : vehiclesList)
		if(e.mSpeed > highestSpeed.mSpeed)
			highestSpeed = e;
	return highestSpeed;
}
	
public static void main(String[] args)
{
    List< MotorVehicle> motors = new ArrayList<>();
    
    // super member variables
    int year;
    double speed;
    String make,vin;
    
    @SuppressWarnings("resource")
	Scanner cin = new Scanner(System.in);
    int option = 0;
    while(option != 4)
    	{
    	  System.out.println("**********WELCOME TO THE MotorVehicle Class**********");
          System.out.println();
          System.out.println("Please select from the following options: ");
          System.out.println("1) Build a MotorCycle \n2)Build a Car"
                     + "\n3) Build a Truck\n4) Exit.\n******************************************");
          option = cin.nextInt();
          System.out.println();
          System.out.println(">> "+ option);
          if(option == 1)
    		{
    			double wheelbase;
    			 
    			System.out.print("Enter the speed: ");
    			speed = cin.nextDouble();
    			
    			System.out.print("\nEnter the year: ");
    			year = cin.nextInt();
    			cin.nextLine();
    			
    			System.out.print("\nEnter the make: ");
    			make = cin.nextLine();
    			
    			System.out.println("Enter the VIN: ");
                vin = cin.nextLine();
                
                System.out.println("Enter the wheel base: ");
                wheelbase = cin.nextDouble();
                
                MotorCycle motorOrder = new MotorCycle(make, speed, vin, year, wheelbase);
                
                motors.add(motorOrder);
    		}
    		else if(option == 2)
    		{
    			int  passengers;
   			 
    			System.out.print("Enter the speed: ");
    			speed = cin.nextDouble();
    			
    			System.out.print("\nEnter the year: ");
    			year = cin.nextInt();
    			cin.nextLine();
    			
    			System.out.print("\nEnter the make: ");
    			make = cin.nextLine();
    			
    			System.out.println("Enter the VIN: ");
                vin = cin.nextLine();
                
                System.out.println("Enter passengers number: ");
                passengers = cin.nextInt();
                
                Car item = new Car(make, speed, vin, year, passengers);
                
                motors.add(item);
    		}
    		else if(option == 3)
    		{
    			int  payload;
      			 
    			System.out.print("Enter the speed: ");
    			speed = cin.nextDouble();
    			
    			System.out.print("\nEnter the year: ");
    			year = cin.nextInt();
    			cin.nextLine();
    			
    			System.out.print("\nEnter the make: ");
    			make = cin.nextLine();
    			
    			System.out.println("Enter the VIN: ");
                vin = cin.nextLine();
                
                System.out.println("Enter The Payload: ");
                payload = cin.nextInt();
                
                Truck motorOrder = new Truck(make, speed, vin, year, payload);
                
                motors.add(motorOrder);
    		}
    		else
    		{
    			System.out.println();
    			
    			System.out.println("The List contains the following items:");
    			for( MotorVehicle e : motors)
    				System.out.println(e);
    			
    			
    			System.out.println("\nThe Fastest Motor is:");
    			System.out.println(findFastestMotorVehicle(motors));
    			
    			System.out.println();
    			System.out.println("Thank You for using the Motor Class!");
    		}
    	}
    }

}
