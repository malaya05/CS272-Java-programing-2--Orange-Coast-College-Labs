package edu.orangecoastcollege.cs272.finalexam.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.finalexam.model.DBModel;
import edu.orangecoastcollege.cs272.finalexam.model.Earthquake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

	private static Controller theOne;

	private static final String DB_NAME = "seismic.db";
		
	private static final String EARTHQUAKE_TABLE_NAME = "earthquake";
	private static final String[] EARTHQUAKE_FIELD_NAMES = { "_id", "area", "month", "day", "year", "hour", "minute", "magnitude"};
	private static final String[] EARTHQUAKE_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "INTEGER", "REAL"};
	private static final String EARTHQUAKE_DATA_FILE = "earthquakes.csv";

	private DBModel mEarthquakeDB;
	private ObservableList<Earthquake> mAllEarthquakesList;
	
	private Controller() {
	}

	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllEarthquakesList = FXCollections.observableArrayList();

			try {				
				theOne.mEarthquakeDB = new DBModel(DB_NAME, EARTHQUAKE_TABLE_NAME, EARTHQUAKE_FIELD_NAMES, EARTHQUAKE_FIELD_TYPES);
				theOne.initializeEarthquakeDBFromFile();
				ArrayList<ArrayList<String>> resultsList = theOne.mEarthquakeDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String area = values.get(1);
					int month = Integer.parseInt(values.get(2));
					int day = Integer.parseInt(values.get(3));
					int year = Integer.parseInt(values.get(4));
					int hour = Integer.parseInt(values.get(5));
					int minute = Integer.parseInt(values.get(6));
					double magnitude = Double.parseDouble(values.get(7));
					Earthquake eq = new Earthquake(id, area, month, day, year, hour, minute, magnitude);
					theOne.mAllEarthquakesList.add(eq);
				}							
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theOne;
	}
		
	public ObservableList<Earthquake> getAllEarthquakes() {
		return theOne.mAllEarthquakesList;
	}

	public ObservableList<String> getDistinctAreas() {
		ObservableList<String> areasList = FXCollections.observableArrayList();
		//TODO: Loop through the all earthquakes list, one earthquake at a time
		// If the areasList does not contain the earthquake's area (state or country), add it to the areasList
		// Sort the areasList after all have been added
		return areasList;
	}

	
	public boolean removeEarthquake(Earthquake eq) {		

		// TODO: Check to see if the earthquake is null.  If so, return false
		// Otherwise, remove the earthquake from the all earthquakes list
		// Also, delete the record from the earthquake database.
		// Return true if successful, or false if there is an SQLException

		return false;
	}
	

	public ObservableList<Earthquake> filter(String area, double magnitude) {
		ObservableList<Earthquake> filteredEarthquakesList = FXCollections.observableArrayList();

		// TODO: Loop through the all earthquakes list
		// If an earthquake's area matches the area specified AND is greater than or equal to (>=) the magnitude specified,
		// add it to the filteredEarthquakesList.
		
		return filteredEarthquakesList;
	}
	
	private int initializeEarthquakeDBFromFile() throws SQLException {
		int recordsCreated = 0;

		// If the result set contains results, database table already has
		// records, no need to populate from file (so return false)
		if (theOne.mEarthquakeDB.getRecordCount() > 0)
			return 0;

		try {
			// Otherwise, open the file (CSV file) and insert user data
			// into database
			Scanner fileScanner = new Scanner(new File(EARTHQUAKE_DATA_FILE));
			// First read is for headings:
			fileScanner.nextLine();
			// All subsequent reads are for user data
			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				// Length of values is one less than field names because values
				// does not have id (DB will assign one)
				String[] values = new String[EARTHQUAKE_FIELD_NAMES.length - 1];
				values[0] = data[11].replaceAll("'", "''");
				values[1] = data[10];
				values[2] = data[0];
				values[3] = data[15];
				values[4] = data[4];
				values[5] = data[9];
				values[6] = data[8];
				theOne.mEarthquakeDB.createRecord(Arrays.copyOfRange(EARTHQUAKE_FIELD_NAMES, 1, EARTHQUAKE_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			// All done with the CSV file, close the connection
			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}
	
}
