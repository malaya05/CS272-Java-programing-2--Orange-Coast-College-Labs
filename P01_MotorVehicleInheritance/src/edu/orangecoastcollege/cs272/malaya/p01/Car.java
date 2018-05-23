package edu.orangecoastcollege.cs272.malaya.p01;

public class Car extends MotorVehicle
{
private int mPassengers;

public Car(String mMake, double mSpeed, String mVIN, int mYear, int pass)
{
    this.mMake = mMake;
    this.mSpeed = mSpeed;
    this.mVIN = mVIN;
    this.mYear = mYear;
    this.mPassengers = pass;
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + mPassengers;
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Car other = (Car) obj;
    if (mPassengers != other.mPassengers) return false;
    return true;
}

public Car(Car m)
{
    this.mMake = m.mMake;
    this.mSpeed = m.mSpeed;
    this.mVIN = m.mVIN;
    this.mYear = m.mYear;
    this.mPassengers = m.mPassengers;
}


public int getmPassengers()
{
    return mPassengers;
}

public void setmPassengers(int mPassengers)
{
    this.mPassengers = mPassengers;
}

@Override
public void accelerate()
{
    mSpeed += (mSpeed*0.2);

}

@Override
public void decelerate()
{
    mSpeed -= (mSpeed*0.2);

}

@Override
public String toString()
{
    return "[Car: " + mVIN +", " + mYear +", " + mMake +", "+ mSpeed + "MPH, " + this.mPassengers+  "Passengers]";
}



}
