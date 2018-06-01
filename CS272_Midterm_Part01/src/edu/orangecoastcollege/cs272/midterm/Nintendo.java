package edu.orangecoastcollege.cs272.midterm;

import java.text.NumberFormat;

public class Nintendo extends GamingConsole
{
private double batteryLife;

public Nintendo(String name, int gPU, int cores, double price, double bLife)
{
    super(name, gPU, cores, price);
    batteryLife = bLife;
}

    @Override
public String toString()
{
    return "Nintendo [" + name + ", GPU=" + GPU + "MHz, cores=" + cores + ", price=$"
            + price + " Battery Life=" + batteryLife + "hrs, TFLOPS="+ this.calculateTFlops()+
            ", Backward Compatible=No, Dockable=Yes]";
}

    @Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(batteryLife);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Nintendo other = (Nintendo) obj;
    if (Double.doubleToLongBits(batteryLife) != Double.doubleToLongBits(other.batteryLife)) return false;
    return true;
}

    @Override
    public double calculateTFlops()
    {
        // TODO Auto-generated method stub
        return (double)(this.GPU * this.cores *2)/(1_000_000);
    }

    @Override
    public boolean isBackwardCompatible()
    {return false;}

    @Override
    public boolean isDockable()
    {return true;}

    public double getBatteryLife()
    {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife)
    {
        this.batteryLife = batteryLife;
    }


}
