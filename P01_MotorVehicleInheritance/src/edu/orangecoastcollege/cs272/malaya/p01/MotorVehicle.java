package edu.orangecoastcollege.cs272.malaya.p01;

public abstract class MotorVehicle
{
protected String mMake;
protected double mSpeed;
protected String mVIN;
protected int mYear;
@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mMake == null) ? 0 : mMake.hashCode());
    long temp;
    temp = Double.doubleToLongBits(mSpeed);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((mVIN == null) ? 0 : mVIN.hashCode());
    result = prime * result + mYear;
    return result;
}
@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    MotorVehicle other = (MotorVehicle) obj;
    if (mMake == null)
    {
        if (other.mMake != null) return false;
    }
    else if (!mMake.equals(other.mMake)) return false;
    if (Double.doubleToLongBits(mSpeed) != Double.doubleToLongBits(other.mSpeed)) return false;
    if (mVIN == null)
    {
        if (other.mVIN != null) return false;
    }
    else if (!mVIN.equals(other.mVIN)) return false;
    if (mYear != other.mYear) return false;
    return true;
}


public abstract void accelerate ();
public abstract void decelerate();

public String getVIN()
{ return mVIN;}

public String getmMake()
{
    return mMake;
}
public void setmMake(String mMake)
{
    this.mMake = mMake;
}
public double getmSpeed()
{
    return mSpeed;
}
public void setmSpeed(double mSpeed)
{
    this.mSpeed = mSpeed;
}
public int getmYear()
{
    return mYear;
}
public void setmYear(int mYear)
{
    this.mYear = mYear;
}


}
