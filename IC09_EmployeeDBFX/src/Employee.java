
public class Employee
{
private String mFirstName;
private String mLastName;
private String mRank;
private int mId;
private double mSalary;




    @Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mFirstName == null) ? 0 : mFirstName.hashCode());
    result = prime * result + mId;
    result = prime * result + ((mLastName == null) ? 0 : mLastName.hashCode());
    result = prime * result + ((mRank == null) ? 0 : mRank.hashCode());
    long temp;
    temp = Double.doubleToLongBits(mSalary);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Employee other = (Employee) obj;
    if (mFirstName == null)
    {
        if (other.mFirstName != null) return false;
    }
    else if (!mFirstName.equals(other.mFirstName)) return false;
    if (mId != other.mId) return false;
    if (mLastName == null)
    {
        if (other.mLastName != null) return false;
    }
    else if (!mLastName.equals(other.mLastName)) return false;
    if (mRank == null)
    {
        if (other.mRank != null) return false;
    }
    else if (!mRank.equals(other.mRank)) return false;
    if (Double.doubleToLongBits(mSalary) != Double.doubleToLongBits(other.mSalary)) return false;
    return true;
}

    public Employee(String mFirstName, String mLastName, String mRank, int mId, double mSalary)
{
    this.mFirstName = mFirstName;
    this.mLastName = mLastName;
    this.mRank = mRank;
    this.mId = mId;
    this.mSalary = mSalary;
}

    public String getmFirstName()
{
    return mFirstName;
}

public void setmFirstName(String mFirstName)
{
    this.mFirstName = mFirstName;
}

public String getmLastName()
{
    return mLastName;
}

public void setmLastName(String mLastName)
{
    this.mLastName = mLastName;
}

public String getmRank()
{
    return mRank;
}

public void setmRank(String mRank)
{
    this.mRank = mRank;
}

public int getmId()
{
    return mId;
}

public void setmId(int mId)
{
    this.mId = mId;
}

public double getmSalary()
{
    return mSalary;
}

public void setmSalary(double mSalary)
{
    this.mSalary = mSalary;
}

@Override
public String toString()
{
    return "EmployeeDBFX [mFirstName=" + mFirstName + ", mLastName=" + mLastName + ", mRank=" + mRank + ", mId=" + mId
            + ", mSalary=" + mSalary + "]";
}


}
