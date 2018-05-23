package edu.orangecoastcollege.cs272.ic05;

public final class Word
{
final private String mBase;
final private String mPlural;
final private Category mCategory;

public Word(String base, String plural, Category cat)
{
    mBase = base;
    mPlural = plural;
    mCategory = cat;
}

@Override
public String toString()
{
    return "Word [mBase=" + mBase + ", mPlural=" + mPlural + ", mCategory=" + mCategory + "]";
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mBase == null) ? 0 : mBase.hashCode());
    result = prime * result + ((mCategory == null) ? 0 : mCategory.hashCode());
    result = prime * result + ((mPlural == null) ? 0 : mPlural.hashCode());
    return result;
}
@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Word other = (Word) obj;
    if (mBase == null)
    {
        if (other.mBase != null) return false;
    }
    else if (!mBase.equals(other.mBase)) return false;
    if (mCategory != other.mCategory) return false;
    if (mPlural == null)
    {
        if (other.mPlural != null) return false;
    }
    else if (!mPlural.equals(other.mPlural)) return false;
    return true;
}

public String getBase()
{
    return mBase;
}

public String getPlural()
{
    return mPlural;
}

public Category getCategory()
{
    return mCategory;
}

}
