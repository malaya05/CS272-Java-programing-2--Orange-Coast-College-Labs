package edu.orangecoastcollege.cs272.ic04.vehicle;

/**
 * Describes a vehicle with a self-contained propulsion unit.  
 * Keeps track of the vehicle type and wheel count.
 * 
 * @author Michael Paulding
 * @version 1.0
 */
public class Vehicle
{
    private String mType;
    private int mWheelCount;

    /**
     * Constructs a <code>Vehicle</code> given its type and wheel count.
     * 
     * @param type the type of the vehicle
     * @param wheelCount the number of wheels on this vehicle
     */
    public Vehicle(String type, int wheelCount)
    {
        if (type.equalsIgnoreCase("motorcycle"))
        {
            if (wheelCount != 2){
                //throw new IllegalNumberOfWheelsException("Motorcycles need two wheels");
            }
        }
        else if (wheelCount < 4)
        {
            //throw new IllegalNumberOfWheelsException();
        }
        mType = type;
        mWheelCount = wheelCount;
    }

	/**
	 * Gets the type of the <code>Vehicle</code>.
	 * @return the type
	 */
	public String getType() {
		return mType;
	}

	/**
	 * Sets the type of the <code>Vehicle</code>.
	 * @param type the type to set
	 */
	public void setType(String type) {
		mType = type;
	}

	/**
	 * Gets the count of wheels for the <code>Vehicle</code>.
	 * @return the wheelCount
	 */
	public int getWheelCount() {
		return mWheelCount;
	}

	/**
	 * Sets the count of wheels for the <code>Vehicle</code>.
	 * @param wheelCount the wheelCount to set
	 */
	public void setWheelCount(int wheelCount) {
		mWheelCount = wheelCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mType == null) ? 0 : mType.hashCode());
		result = prime * result + mWheelCount;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (mType == null) {
			if (other.mType != null)
				return false;
		} else if (!mType.equals(other.mType))
			return false;
		if (mWheelCount != other.mWheelCount)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [Type=" + mType + ", Wheel Count=" + mWheelCount + "]";
	}

}