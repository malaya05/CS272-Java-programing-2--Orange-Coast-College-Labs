package edu.orangecoastcollege.cs272.midterm;

public abstract class GamingConsole implements PerformanceInfo
{
protected String name;
protected int GPU;
protected int cores;
protected double price;

protected GamingConsole(String name, int gPU, int cores, double price)
{
    this.name = name;
    GPU = gPU;
    this.cores = cores;
    this.price = price;
}

public String getName()
{
    return name;
}

public void setName(String name)
{
    this.name = name;
}

public double getPrice()
{
    return price;
}

public void setPrice(double price)
{
    this.price = price;
}

public int getGPU()
{
    return GPU;
}

public int getCores()
{
    return cores;
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + GPU;
    result = prime * result + cores;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    GamingConsole other = (GamingConsole) obj;
    if (GPU != other.GPU) return false;
    if (cores != other.cores) return false;
    if (name == null)
    {
        if (other.name != null) return false;
    }
    else if (!name.equals(other.name)) return false;
    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) return false;
    return true;
}


}
