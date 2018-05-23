package edu.orangecoastcollege.cs272.malaya.p01;

public class RoachPopulation
{
    private double mPopulation;

    public RoachPopulation(double initial)
    {
        mPopulation = initial;
    }

    public void breed()
    {
        mPopulation *=2;
    }

    public void spray()
    {
        mPopulation *= 0.1;
    }

    public double getPopulation()
    {return mPopulation;}

    @Override
    public String toString()
    {
        return "RoachPopulation [mPopulation=" + mPopulation + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + mPopulation);
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        RoachPopulation other = (RoachPopulation) obj;
        if (mPopulation != other.mPopulation) return false;
        return true;
    }


}
