package edu.orangecoastcollege.cs272.yourusername.ic03;

public abstract class Security implements Comparable<Security>, Valuation
{
protected String ISIN;
protected String issuer;


public String getISIN()
{
    return ISIN;
}

public String getIssuer()
{
    return issuer;
}
public void setIssuer(String issuer)
{
    this.issuer = issuer;
}
@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ISIN == null) ? 0 : ISIN.hashCode());
    result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
    return result;
}
@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Security other = (Security) obj;
    if (ISIN == null)
    {
        if (other.ISIN != null) return false;
    }
    else if (!ISIN.equals(other.ISIN)) return false;
    if (issuer == null)
    {
        if (other.issuer != null) return false;
    }
    else if (!issuer.equals(other.issuer)) return false;
    return true;
}
/**
 * based on ISIN, issuer.
 */
public int compareTo(Security obj)
{
    int compISIN = this.ISIN.compareTo(obj.ISIN);
    if( compISIN !=0)
        return compISIN;

int compIssuer = this.issuer.compareTo(obj.issuer);
    if( compIssuer !=0)
        return compIssuer;

    return 0;
}


}
