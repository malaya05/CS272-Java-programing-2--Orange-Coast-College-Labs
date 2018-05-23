package edu.orangecoastcollege.cs272.yourusername.ic03;

import java.text.DecimalFormat;

public class CommonStock extends Security implements Comparable<Security>
{

    private int shares;
    private double purchasePrice;
    private double currentPrice;

    @Override
    public String toString()
    {
        return "CommonStock [" + this.ISIN + this.issuer + ", Purchase: $" + purchasePrice + ", current: $" + currentPrice
                + ", shares: " + shares + ", Total Return: $" + totalReturn() + ", Percent Return: "+
                percentReturn()+ "%]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(currentPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(purchasePrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + shares;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        CommonStock other = (CommonStock) obj;
        if (Double.doubleToLongBits(currentPrice) != Double.doubleToLongBits(other.currentPrice)) return false;
        if (Double.doubleToLongBits(purchasePrice) != Double.doubleToLongBits(other.purchasePrice)) return false;
        if (shares != other.shares) return false;
        return true;
    }
/**
 * 
 * @param String ISIN
 * @param String Issuer
 * @param int the shares
 * @param double purchasePrice
 * @param double currentPrice
 */
    public CommonStock(String isin, String issuer, int shares, double purchasePrice, double currentPrice)
    {
       this.ISIN = isin;
       this.issuer = issuer;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    @Override
    /**
     * supper then shares, purchase, and current
     */
    public int compareTo(Security obj)
    {

        int securityComp = super.compareTo(obj);
        if (securityComp != 0)
            return securityComp;

        // check if obj is type of Common Stock
        if(obj instanceof CommonStock)
        {
          // convert ( cast ) obj to common stock
            CommonStock otherStock = (CommonStock) obj;
           int compShares = this.shares - otherStock.shares;
            if(compShares != 0)
                return compShares;

            // double are specials
            int compPurchasePrice = Double.compare(purchasePrice, otherStock.purchasePrice);
            if(compPurchasePrice != 0)
                return compPurchasePrice;

            int compCurrentPrice = Double.compare(currentPrice, otherStock.currentPrice);
            if(compCurrentPrice != 0)
                return compCurrentPrice;
        }

        return 0;
    }

    public int getShares()
    {
        return shares;
    }

    public void setShares(int shares)
    {
        this.shares = shares;
    }

    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice)
    {
        this.currentPrice = currentPrice;
    }

    DecimalFormat twoDForm = new DecimalFormat("0.00");
    // interface methods
    @Override
    /**
     * @return the percent 
     */
    public double percentReturn()
    {

        return Double.valueOf(twoDForm.format((totalReturn() / (shares * purchasePrice)) *100));
    }

    @Override
    /**
     * currentPrice - purchasePrice times number of shares.
     */
    public double totalReturn()
    {

        return Double.valueOf(twoDForm.format((currentPrice - purchasePrice) * shares));
    }

}
