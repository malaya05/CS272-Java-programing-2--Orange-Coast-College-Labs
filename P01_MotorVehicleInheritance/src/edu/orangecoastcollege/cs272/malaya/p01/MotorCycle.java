package edu.orangecoastcollege.cs272.malaya.p01;

public class MotorCycle extends MotorVehicle
{
private double mWheelbase;

public MotorCycle(String mMake, double mSpeed, String mVIN, int mYear, double w)
{
    this.mMake = mMake;
    this.mSpeed = mSpeed;
    this.mVIN = mVIN;
    this.mYear = mYear;
    this.mWheelbase = w;
}

public MotorCycle(MotorCycle m)
{
    this.mMake = m.mMake;
    this.mSpeed = m.mSpeed;
    this.mVIN = m.mVIN;
    this.mYear = m.mYear;
}

@Override
public String toString()
{
    return "[Motorcycle: " + mVIN +", " + mYear +", " + mMake +", "+ mSpeed + "MPH, " + this.mWheelbase+  "\" Wheelbase]";
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(mWheelbase);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    MotorCycle other = (MotorCycle) obj;
    if (Double.doubleToLongBits(mWheelbase) != Double.doubleToLongBits(other.mWheelbase)) return false;
    return true;
}

public double getmWheelbase()
{
    return mWheelbase;
}

public void setmWheelbase(double mWheelbase)
{
    this.mWheelbase = mWheelbase;
}

@Override
public void accelerate()
{
    mSpeed += (mSpeed*0.3);

}

@Override
public void decelerate()
{
    mSpeed -= (mSpeed*0.3);

}
}
