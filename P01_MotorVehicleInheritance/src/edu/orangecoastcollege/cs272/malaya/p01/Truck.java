package edu.orangecoastcollege.cs272.malaya.p01;

public class Truck extends MotorVehicle
{
private int mPayload;

public Truck(String mMake, double mSpeed, String mVIN, int mYear, int payLoad)
{
    this.mMake = mMake;
    this.mSpeed = mSpeed;
    this.mVIN = mVIN;
    this.mYear = mYear;
    this.mPayload = payLoad;
}

public Truck(Car m)
{
    this.mMake = m.mMake;
    this.mSpeed = m.mSpeed;
    this.mVIN = m.mVIN;
    this.mYear = m.mYear;
}




@Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + mPayload;
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Truck other = (Truck) obj;
    if (mPayload != other.mPayload) return false;
    return true;
}

public int getmPayload()
{
    return mPayload;
}

public void setmPayload(int mPayload)
{
    this.mPayload = mPayload;
}

@Override
public void accelerate()
{
    mSpeed += (mSpeed*0.1);

}

@Override
public void decelerate()
{
    mSpeed -= (mSpeed*0.1);

}

@Override
public String toString()
{
    return "[Truck: " + mVIN +"," + mYear +"," + mMake +","+ mSpeed + " MHP, " + this.mPayload+  " lb payload]";
}

}
