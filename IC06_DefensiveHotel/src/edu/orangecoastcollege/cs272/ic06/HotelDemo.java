package edu.orangecoastcollege.cs272.ic06;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The <code>HotelDemo</code> class allows a hotel employee to see available rooms, occupied rooms, book a hotel room
 * and display hotel statistics such as number of guests, number of rooms available, number of rooms occupied,
 * and occupancy rate.
 *
 * @author Michael Paulding
 * @version 1.0
 *
 */
public class HotelDemo {

	/**
	 * Main method is the entry point to the HotelDemo.
	 *
	 * @param args Command line arguments (not used in this application)
	 */
	public static void main(String[] args) {

		// Uncomment when done creating classes

		List<Room> sampleRooms = new ArrayList<>();
		// 5 rooms with two double beds (max occupancy 2)
		sampleRooms.add(new Room(101, 2, RoomType.TWO_DOUBLE_BEDS));
		sampleRooms.add(new Room(102, 2, RoomType.TWO_DOUBLE_BEDS));
		sampleRooms.add(new Room(103, 2, RoomType.TWO_DOUBLE_BEDS));
		sampleRooms.add(new Room(104, 2, RoomType.TWO_DOUBLE_BEDS));
		sampleRooms.add(new Room(105, 2, RoomType.TWO_DOUBLE_BEDS));
		// 5 rooms with two queen beds (max occupancy 4)
		sampleRooms.add(new Room(106, 4, RoomType.TWO_QUEEN_BEDS));
		sampleRooms.add(new Room(107, 4, RoomType.TWO_QUEEN_BEDS));
		sampleRooms.add(new Room(108, 4, RoomType.TWO_QUEEN_BEDS));
		sampleRooms.add(new Room(109, 4, RoomType.TWO_QUEEN_BEDS));
		sampleRooms.add(new Room(110, 4, RoomType.TWO_QUEEN_BEDS));
		// 5 rooms with a king bed (max occupancy 2)
		sampleRooms.add(new Room(111, 2, RoomType.KING_BED));
		sampleRooms.add(new Room(112, 2, RoomType.KING_BED));
		sampleRooms.add(new Room(113, 2, RoomType.KING_BED));
		sampleRooms.add(new Room(114, 2, RoomType.KING_BED));
		sampleRooms.add(new Room(115, 2, RoomType.KING_BED));

		// Build a new hotel!
		Hotel myHotel = new Hotel("Orange Coast Cottages", sampleRooms);
		String welcomeMessage = "\nWelcome to " + myHotel.getName() + ".  Please select an option:\n"
				+ "(1) List Available Rooms\n" + "(2) List Occupied Rooms\n" + "(3) Book Room\n"
				+ "(4) Display Hotel Stats\n" + "(5) Quit\n" + ">> ";

		String roomTypeMessage = "\nWhat type of room would you like to book:\n"
				+ "(1) Two Double Beds (max 2 people)\n" + "(2) Two Queen Beds (max 4 people)\n"
				+ "(3) King Bed (max 2 people)\n" + "(4) Cancel\n" + ">> ";
		Scanner consoleScanner = new Scanner(System.in);
		int option, roomChoice;
		@SuppressWarnings("unused")
        RoomType roomType;

		do{
		    option = validateInput(consoleScanner, welcomeMessage,1,5);
		    switch(option)
		    {
		        case 1:
		            System.out.println("~~~Available Rooms~~~");
		            myHotel.getAvailableRoomsList().forEach(r -> System.out.println(r));
		            // or myHotel.getAvailableRoomsList().forEach(System.out::println);
		            break;
		        case 2:
		            System.out.println("~~~Occupied  Rooms~~~");
	                  myHotel.getOccupiedRoomsList().forEach(r -> System.out.println(r));
	                  break;
		        case 3:
		            roomChoice = validateInput(consoleScanner, roomTypeMessage, 1, 4);
		            switch(roomChoice)
		            {
		                case 1:
		                    myHotel.bookRoom(RoomType.TWO_DOUBLE_BEDS);
		                    break;

		                case 2:
                            myHotel.bookRoom(RoomType.TWO_QUEEN_BEDS);
                            break;

		                case 3:
                            myHotel.bookRoom(RoomType.KING_BED);
                            break;
		            }
		            break;
		        case 4:
		            System.out.println(myHotel);
		            break;
		        case 5:
		            System.out.println("Thank you for visiting " + myHotel.getName() + "!");
		    }
		}while(option !=5);

	}

	/**
	 * Prompts for and validates user input from the console, which must fall into a range between the min and max.
	 * Repeats prompt until user enters valid input.
	 *
	 * @param consoleScanner Scanner used to read input from console.
	 * @param message The message to be displayed in the prompt.
	 * @param min The minimum value allowed in the range.
	 * @param max The maximum value allowed in the range.
	 * @return The validated user input.
	 */
	private static int validateInput(Scanner consoleScanner, String message, int min, int max) {
		int input = 0;
		boolean isInvalidInput = false;
		do {
			try {
				System.out.print(message);
				input = consoleScanner.nextInt();
				isInvalidInput = (input < min || input > max);
			} catch (InputMismatchException e) {
				isInvalidInput = true;
				consoleScanner.nextLine();
			}
			if (isInvalidInput)
				System.err.println("Please enter choice between " + min + " and " + max + ".\n");

		} while (isInvalidInput);
		return input;
	}

}
