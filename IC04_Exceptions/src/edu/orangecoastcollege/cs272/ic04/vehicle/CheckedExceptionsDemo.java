package edu.orangecoastcollege.cs272.ic04.vehicle;

/**
 * Demo to test the <code>Vehicle</code> class after adding checked exceptions.
 * 
 * @author Michael Paulding
 * @version 1.0
 */
public class CheckedExceptionsDemo {

	/**
	 * Entry point for the checked exceptions demo.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		
		// Surround with single try/catch block.
		Vehicle car = new Vehicle("Sedan", 4);
		System.out.println(car);
		
		Vehicle bustedCar = new Vehicle("Junkyard", 3);
		System.out.println(bustedCar);

	}

}
