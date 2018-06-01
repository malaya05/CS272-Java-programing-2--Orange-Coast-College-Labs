package edu.orangecoastcollege.cs272.midterm;

public class XBox extends GamingConsole
{
private String physicalMedia;

public XBox(String name, int gPU, int cores, double price, String str)
    {
        super(name, gPU, cores, price);
        physicalMedia = str;
    }

@Override
public double calculateTFlops()
{
    return (double)(this.GPU * this.cores *2)/(1_000_000);
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((physicalMedia == null) ? 0 : physicalMedia.hashCode());
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    XBox other = (XBox) obj;
    if (physicalMedia == null)
    {
        if (other.physicalMedia != null) return false;
    }
    else if (!physicalMedia.equals(other.physicalMedia)) return false;
    return true;
}

public String getPhysicalMedia()
{
    return physicalMedia;
}

public void setPhysicalMedia(String physicalMedia)
{
    this.physicalMedia = physicalMedia;
}

@Override
public boolean isBackwardCompatible()
{
    // TODO Auto-generated method stub
    return true;
}

@Override
public boolean isDockable()
{
    // TODO Auto-generated method stub
    return false;
}

@Override
public String toString()
{
return "XBox [" + name + ", GPU=" + GPU + "MHz, cores=" + cores + ", price=$"
        + price + " Physical Media=" + physicalMedia + ", TFLOPS="+ this.calculateTFlops()+
        ", Backward Compatible=Yes, Dockable=No]";
}


}
