package edu.orangecoastcollege.cs272.finalexam.model;

import java.text.DecimalFormat;

/**
 * The <code>Earthquake</code> represents primary information about a quake, including its id, area (state or country) in which it
 * occurred, as well as date, time and magnitude.  Magnitude typically ranges from -1 (very tiny) to 10 (incredibly powerful).
 * Data for the Earthquake are sourced from the USGS: http://earthquake.usgs.gov/earthquakes/
 *  
 * @author mpaulding
 *
 */
public class Earthquake {

	private int mId;
	private String mArea;
	private int mMonth;
	private int mDay;
	private int mYear;	
	private int mHour;
	private int mMinute;
	private double mMagnitude;	
	
	/**
	 * Creates a new <code>Earthquake</code> given the primary information about the quake.
	 * 
	 * @param id The unique identifier for the earthquake.
	 * @param area The closest estimated area (state or country).
	 * @param month The month in which the quake occurred.
	 * @param day The day in which the quake occurred.
	 * @param year The year in which the quake occurred.
	 * @param hour The hour in which the quake occurred.
	 * @param minute The minute in which the quake occurred.
	 * @param magnitude The earthquake's magnitude, which typically ranges from -1 (very tiny) to 10 (incredibly powerful).
	 */
	public Earthquake(int id, String area, int month, int day, int year, int hour, int minute, double magnitude) {
		super();
		mId = id;
		mArea = area;
		mMonth = month;
		mDay = day;
		mYear = year;
		mHour = hour;
		mMinute = minute;
		mMagnitude = magnitude;
	}

	/**
	 * Gets the closest area (state or country) in which the earthquake occurred.
	 * @return The closest area (state or country) in which the earthquake occurred.
	 */
	public String getArea() {
		return mArea;
	}

	/**
	 * Sets the closest area (state or country) in which the earthquake occurred.
	 * @param area The new area for the earthquake.
	 */
	public void setArea(String area) {
		mArea = area;
	}

	/**
	 * Gets the hour in which the earthquake occurred.
	 * @return The hour in which the earthquake occurred.
	 */
	public int getHour() {
		return mHour;
	}

	/**
	 * Sets the hour in which the earthquake occurred.
	 * @param hour The hour in which the earthquake occurred.
	 */
	public void setHour(int hour) {
		mHour = hour;
	}

	/**
	 * Gets the minute in which the earthquake occurred.
	 * @return The minute in which the earthquake occurred.
	 */	
	public int getMinute() {
		return mMinute;
	}

	/**
	 * Sets the minute in which the earthquake occurred.
	 * @param minute The minute in which the earthquake occurred.
	 */	
	public void setMinute(int minute) {
		mMinute = minute;
	}

	/**
	 * Gets the month in which the earthquake occurred.
	 * @return The month in which the earthquake occurred.
	 */	
	public int getMonth() {
		return mMonth;
	}

	/**
	 * Sets the month in which the earthquake occurred.
	 * @param month The month in which the earthquake occurred.
	 */	
	public void setMonth(int month) {
		mMonth = month;
	}

	/**
	 * Gets the day in which the earthquake occurred.
	 * @return The day in which the earthquake occurred.
	 */	
	public int getDay() {
		return mDay;
	}

	/**
	 * Sets the day in which the earthquake occurred.
	 * @param day The day in which the earthquake occurred.
	 */	
	public void setDay(int day) {
		mDay = day;
	}

	/**
	 * Gets the year in which the earthquake occurred.
	 * @return The year in which the earthquake occurred.
	 */	
	public int getYear() {
		return mYear;
	}

	/**
	 * Sets the year in which the earthquake occurred.
	 * @param year The year in which the earthquake occurred.
	 */	
	public void setYear(int year) {
		mYear = year;
	}

	/**
	 * Gets the magnitude of the earthquake.
	 * @return The magnitude of the earthquake, which typically ranges from -1 (very tiny) to 10 (incredibly powerful).
	 */
	public double getMagnitude() {
		return mMagnitude;
	}

	/**
	 * Sets the magnitude of the earthquake.
	 * @param magnitude The magnitude of the earthquake, which typically ranges from -1 (very tiny) to 10 (incredibly powerful).
	 */
	public void setMagnitude(double magnitude) {
		mMagnitude = magnitude;
	}

	/**
	 * Gets the closest area (state or country) in which the earthquake occurred.
	 * @return The closest area (state or country) in which the earthquake occurred.
	 */
	public int getId() {
		return mId;
	}


	/**
	 * @see Object.hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mDay;
		result = prime * result + mHour;
		result = prime * result + mId;
		long temp;
		temp = Double.doubleToLongBits(mMagnitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mMinute;
		result = prime * result + mMonth;
		result = prime * result + ((mArea == null) ? 0 : mArea.hashCode());
		result = prime * result + mYear;
		return result;
	}

	/**
	 * @see Object.equals()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Earthquake other = (Earthquake) obj;
		if (mDay != other.mDay)
			return false;
		if (mHour != other.mHour)
			return false;
		if (mId != other.mId)
			return false;
		if (Double.doubleToLongBits(mMagnitude) != Double.doubleToLongBits(other.mMagnitude))
			return false;
		if (mMinute != other.mMinute)
			return false;
		if (mMonth != other.mMonth)
			return false;
		if (mArea == null) {
			if (other.mArea != null)
				return false;
		} else if (!mArea.equals(other.mArea))
			return false;
		if (mYear != other.mYear)
			return false;
		return true;
	}

	/**
	 * @see Object.toString()
	 */
	@Override
	public String toString() {
		DecimalFormat twoDigits = new DecimalFormat("00");
		String meridiem = "PM";
		int hour12 = mHour;
		if (hour12 > 12)
			hour12 -= 12;
		else if (hour12 < 12)
			meridiem = "AM";
			
			
		return "Earthquake [Id=" + mId + ", Area=" + mArea + ", Date=" + twoDigits.format(mMonth) + "/" + twoDigits.format(mDay) + "/" + mYear +
				", Time=" + twoDigits.format(hour12) + ":" + twoDigits.format(mMinute) + " " + meridiem + ", Magnitude=" + mMagnitude + "]";
	}
		
}
