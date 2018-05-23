package edu.orangecoastcollege.cs272.malaya.ic02;

import java.text.DecimalFormat;
import java.util.Scanner;;
public class IceCreamCone
{
    private double mHeight;
    private double mRadius;

    /**
     * This is the constructor.
     * @param height the height of the cone
     * @param radiu  the radius of the cone
     */
    public IceCreamCone(double height, double radiu)
    {
        mHeight = height;
        mRadius = radiu;
    }
    /**
     * @return the height
     */
    public double getHeight()
    {
        return mHeight;
    }

    /**
     * @return the radiu
     */
    public double getRadiu()
    {
        return mRadius;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        DecimalFormat twoD = new DecimalFormat("0.00");

        return "IceCreamCone [Radius="+ mRadius+ ", Height="+ mHeight +", Surface Area="+
    twoD.format(calculateSurfaceArea())+" sq. units, Volume="+ twoD.format(calculateVolume())+" cu. units]";
    }



    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(mHeight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mRadius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        IceCreamCone other = (IceCreamCone) obj;
        if (Double.doubleToLongBits(mHeight) != Double.doubleToLongBits(other.mHeight)) return false;
        if (Double.doubleToLongBits(mRadius) != Double.doubleToLongBits(other.mRadius)) return false;
        return true;
    }



    /**
     * @param height the height to set
     */
    public void setHeight(double height)
    {
        mHeight = height;
    }

    /**
     * @param radiu the radiu to set
     */
    public void setRadiu(double radiu)
    {
        mRadius = radiu;
    }


    /**
     * Surface Area
     */
    public double calculateSurfaceArea()
    {
        return Math.PI * mRadius*(mRadius + Math.sqrt(Math.pow(this.mRadius, 2.0) +Math.pow(this.mHeight, 2.0) ));
    }

    /**
     * for the volume
     */
    public double calculateVolume()
    {
        return (Math.PI * Math.pow(mRadius, 2)* (mHeight / 3));
    }



    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter radius of the ice cream cone: ");
        double radii = cin.nextDouble();
        System.out.println("Enter height of the ice cream cone: ");
        double h = cin.nextDouble();

        IceCreamCone x = new IceCreamCone(h,radii);
      //  x.setHeight(h);
       // x.setRadiu(radii);

        System.out.println("\nHere are the specifications of your ice cream cone: \n");
        System.out.println(x.toString());
        cin.close();
    }


}
