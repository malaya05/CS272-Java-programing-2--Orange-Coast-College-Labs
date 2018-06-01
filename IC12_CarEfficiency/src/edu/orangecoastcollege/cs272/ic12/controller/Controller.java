package edu.orangecoastcollege.cs272.ic12.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

import edu.orangecoastcollege.cs272.ic12.model.Car;
import edu.orangecoastcollege.cs272.ic12.model.DBModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This <code>Controller</code> connects the DB to the JavaFX user interface.
 * The Controller is a singleton which serves as the one intermediary between
 * the back-end and front-end of the application.
 *
 * @author
 * @version 1.0
 */
public final class Controller implements AutoCloseable {

	private static Controller theOne;

	private static final String DB_NAME = "cs272.db";
	private static final String TABLE_NAME = "cars";
	private static final String[] FIELD_NAMES = { "_id", "make", "description", "horsepower", "fuelType", "cityMPG",
			"hwyMPG", "hybrid" };
	private static final String[] FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "INTEGER",
			"INTEGER", "INTEGER" };
	private static final String DATA_FILE = "cars.csv";

	private ObservableList<Car> mAllCarsList;
	private DBModel mDB;

	private Controller() {
	}

	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllCarsList = FXCollections.observableArrayList();

			try {
				theOne.mDB = new DBModel(DB_NAME, TABLE_NAME, FIELD_NAMES, FIELD_TYPES);
				theOne.initializeDBFromFile();

				ResultSet rs = theOne.mDB.getAllRecords();
				if (rs != null) {
					while (rs.next()) {
						int id = rs.getInt(FIELD_NAMES[0]);
						String make = rs.getString(FIELD_NAMES[1]);
						String description = rs.getString(FIELD_NAMES[2]);
						int horsepower = rs.getInt(FIELD_NAMES[3]);
						String fuelType = rs.getString(FIELD_NAMES[4]);
						int cityMPG = rs.getInt(FIELD_NAMES[5]);
						int hwyMPG = rs.getInt(FIELD_NAMES[6]);
						boolean hybrid = rs.getBoolean(FIELD_NAMES[7]);

						theOne.mAllCarsList
								.add(new Car(id, make, description, horsepower, fuelType, cityMPG, hwyMPG, hybrid));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theOne;
	}

	public ObservableList<Car> getAllCars() {
		return theOne.mAllCarsList;
	}

	public ObservableList<String> getDistinctMakes() {
		ObservableList<String> makes = FXCollections.observableArrayList();
		makes.add(" ");
		for (Car c : theOne.mAllCarsList)
			if (!makes.contains(c.getMake()))
				makes.add(c.getMake());
		FXCollections.sort(makes);
		return makes;
	}

	public ObservableList<String> getDistinctFuelTypes() {
		ObservableList<String> fuelTypes = FXCollections.observableArrayList();

		for (Car c : theOne.mAllCarsList)
			if (!fuelTypes.contains(c.getFuelType()))
				fuelTypes.add(c.getFuelType());
		FXCollections.sort(fuelTypes);
		return fuelTypes;
	}

	public ObservableList<Car> filter(Predicate<Car> criteria) {
		ObservableList<Car> filteredCarsList = FXCollections.observableArrayList();
		for (Car c : theOne.mAllCarsList)
			if (criteria.test(c))
				filteredCarsList.add(c);
		return filteredCarsList;
	}

	private int initializeDBFromFile() throws SQLException {
		int recordsCreated = 0;

		if (theOne.mDB.getRecordCount() > 0)
			return recordsCreated;

		try {
			Scanner fileScanner = new Scanner(new File(DATA_FILE));
			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[FIELD_NAMES.length - 1];
				values[0] = data[11].replaceAll("'", "''");
				values[1] = data[9];
				values[2] = data[7];
				values[3] = data[4];
				values[4] = data[0];
				values[5] = data[6];
				values[6] = (data[8].equalsIgnoreCase("true") ? "1" : "0");

				theOne.mDB.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return recordsCreated;
	}

	public boolean addCar(String make, String description, int horsepower, String fuelType, int cityMPG, int hwyMPG,
			boolean hybrid) {
		// use this info to insert a record in the database
	    // use mDB
	    // fields = predefined
	    // construct a values array:
	    String[] values = {make,description,String.valueOf(horsepower), fuelType,String.valueOf(cityMPG),String.valueOf(hwyMPG),(hybrid)?"1":"0"};

	    // Arrays.copyOfRange(arrayname,range)
	    try
        {
            int id  = mDB.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1,FIELD_NAMES.length), values);
            Car newCar = new Car(id, make, description, horsepower, fuelType, cityMPG, hwyMPG,hybrid);
            theOne.mAllCarsList.add(newCar);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

		return true;
	}

	public boolean deleteCar(Car c) {
		if (c == null)
			return false;

		theOne.mAllCarsList.remove(c);

		try {
			theOne.mDB.deleteRecord(String.valueOf(c.getID()));
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public void close() throws Exception {
		mDB.close();

	}
}