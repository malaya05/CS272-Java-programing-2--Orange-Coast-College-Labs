package edu.orangecoastcollege.cs272.yourusername.ic03;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Bond extends Security implements Comparable<Security>, Valuation
{
private double principal;
private double couponRate;
private double holdingPeriod;

/**
 * 
 * @param String ISIN
 * @param String Issuer
 * @param double principal
 * @param double the rate
 * @param double years
 */
public Bond(String isin, String issuer, double principal, double couponRate, double holdingPeriod)
{
   this.ISIN = isin;
   this.issuer = issuer;
    this.principal = principal;
    this.couponRate = couponRate;
    this.holdingPeriod = holdingPeriod;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	long temp;
	temp = Double.doubleToLongBits(couponRate);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(holdingPeriod);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(principal);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Bond other = (Bond) obj;
	if (Double.doubleToLongBits(couponRate) != Double.doubleToLongBits(other.couponRate))
		return false;
	if (Double.doubleToLongBits(holdingPeriod) != Double.doubleToLongBits(other.holdingPeriod))
		return false;
	if (Double.doubleToLongBits(principal) != Double.doubleToLongBits(other.principal))
		return false;
	return true;
}



@Override
/**
 *  return the % on the investment
 */
public double percentReturn() {
	
	DecimalFormat twoDForm = new DecimalFormat("0.00");
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	twoDForm.setGroupingUsed(true);
	twoDForm.setGroupingSize(3);
	dfs.setGroupingSeparator(',');
	twoDForm.setDecimalFormatSymbols(dfs);
	
	return Double.valueOf(twoDForm.format((totalReturn() / principal) * 100));
}

public double getPrincipal() {
	return principal;
}

public void setPrincipal(double principal) {
	this.principal = principal;
}

public double getCouponRate() {
	return couponRate;
}

public void setCouponRate(double couponRate) {
	this.couponRate = couponRate;
}

public double getHoldingPeriod() {
	return holdingPeriod;
}

public void setHoldingPeriod(double holdingPeriod) {
	this.holdingPeriod = holdingPeriod;
}

@Override
public double totalReturn() {
	
	DecimalFormat twoDForm = new DecimalFormat("0.00");
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	twoDForm.setGroupingUsed(true);
	twoDForm.setGroupingSize(3);
	dfs.setGroupingSeparator(',');
	twoDForm.setDecimalFormatSymbols(dfs);
	
	return Double.valueOf(twoDForm.format((principal*(couponRate)/100) * holdingPeriod));
}

@Override
/**
 *  Based on super then principle, rate, yaers
 */
public int compareTo(Security obj)
{

    int securityComp = super.compareTo(obj);
    if (securityComp != 0)
        return securityComp;

    // check if obj is type of Common Stock
    if(obj instanceof Bond)
    {
      // convert ( cast ) obj to common stock
    	Bond otherBond = (Bond) obj;
       int compPrinciple = Double.compare(this.principal, otherBond.principal);
        if(compPrinciple != 0)
            return compPrinciple;

        // double are specials
        int compcouponRate = Double.compare(couponRate, otherBond.couponRate);
        if(compcouponRate != 0)
            return compcouponRate;

        int compholdingPeriod = Double.compare(holdingPeriod, otherBond.holdingPeriod);
        if(compholdingPeriod != 0)
            return compholdingPeriod;
    }
    return 0;
}
@Override
public String toString()
{
    return "Bond [" + ISIN + ", "+ issuer + " Principal: $" + principal + ", Coupon: " + couponRate
            + "%, Holding: " + holdingPeriod + " Years, Total Return: $" + totalReturn() + ", Percent Return: "+
            percentReturn()+ "%]";
}

}