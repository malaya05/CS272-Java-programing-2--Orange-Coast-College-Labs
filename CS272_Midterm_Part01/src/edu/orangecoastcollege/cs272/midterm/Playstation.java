package edu.orangecoastcollege.cs272.midterm;

public class Playstation extends GamingConsole
{
private String virtualReality;

public Playstation(String name, int gPU, int cores, double price, String vr)
{
super(name, gPU, cores, price);
virtualReality = vr;
}


@Override
public String toString()
{
return "Playstation [" + name + ", GPU=" + GPU + "MHz, cores=" + cores + ", price=$"
        + price + " VR Headset=" + virtualReality + ", TFLOPS="+ this.calculateTFlops()+
        ", Backward Compatible=No, Dockable=No]";
}

    @Override
    public double calculateTFlops()
    {
        return (double)(this.GPU * this.cores *2)/(1_000_000);
    }
    public String getVirtualReality()
    {
        return virtualReality;
    }
    public void setVirtualReality(String virtualReality)
    {
        this.virtualReality = virtualReality;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((virtualReality == null) ? 0 : virtualReality.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Playstation other = (Playstation) obj;
        if (virtualReality == null)
        {
            if (other.virtualReality != null) return false;
        }
        else if (!virtualReality.equals(other.virtualReality)) return false;
        return true;
    }
    @Override
    public boolean isBackwardCompatible()
    {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isDockable()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
