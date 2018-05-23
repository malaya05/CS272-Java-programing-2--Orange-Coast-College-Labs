package edu.orangecoastcollege.cs272.malaya.ic03;

public class Cat implements Comparable<Cat>
{
private String mName;
private String mBreed;
private int mAge;

/**
 * 
 * @param string Name
 * @param string Breed
 * @param int age
 */
public Cat(String x, String b, int age)
{
    mName = x;
    mBreed = b;
     mAge = age;

}
/**
 * 
 * @param object to copy
 */
public Cat(Cat obj)
{
    mName = obj.mName;
    mBreed = obj.mBreed;
     mAge = obj.mAge;
}

/**
 * 
 * @return the age in human years
 */
public int ageInHumanYears()
{
    int result;
    if(mAge == 0)
        result = 0;
    else if(this.mAge == 1)
        result = 15;
    else
    {
        result = 24 + (mAge -2) * 4;
    }
    return result;
}
@Override
public String toString()
{
    return "Cat [catName=" + mName + ", breed=" + mBreed + ", age=" + mAge + ", Human Age="+ ageInHumanYears() +"]";
}
@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + mAge;
    result = prime * result + ((mBreed == null) ? 0 : mBreed.hashCode());
    result = prime * result + ((mName == null) ? 0 : mName.hashCode());
    return result;
}
@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Cat other = (Cat) obj;
    if (mAge != other.mAge) return false;
    if (mBreed == null)
    {
        if (other.mBreed != null) return false;
    }
    else if (!mBreed.equals(other.mBreed)) return false;
    if (mName == null)
    {
        if (other.mName != null) return false;
    }
    else if (!mName.equals(other.mName)) return false;
    return true;
}
public String getCatName()
{
    return mName;
}
public void setCatName(String catName)
{
    this.mName = catName;
}
public String getBreed()
{
    return mBreed;
}
public void setBreed(String breed)
{
    this.mBreed = breed;
}
public int getAge()
{
    return mAge;
}
public void setAge(int age)
{
    this.mAge = age;
}
@Override
/**
 * based on age then Breed then Name
 */
public int compareTo(Cat obj)
{
// to compare cat first age, breed, name
    int compAge = mAge - obj.mAge;
    if(compAge != 0)
        return compAge;

        int compBreed = mBreed.compareTo(obj.mBreed);
        if(compBreed != 0)
            return compBreed;

            int compName = mName.compareTo(obj.mName);
            if(compName != 0)
                return compName;

     // if made it through all the checks they  are the same return 0
            return 0;
}
}
