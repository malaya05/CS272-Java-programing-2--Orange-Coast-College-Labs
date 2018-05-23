package edu.orangecoastcollege.cs272.ic07;
/*
 * JAVA Generics (templet class in c++)
 * param that can be anytype
 * List<Strings> nameList = new List<String>()
 * List<Integer> numList = new List<>()
 */
public class HoorayList<E>
{
private E[] mData;
private int mSize;
private int mCap;
private static final int DEFAULT_CAP = 10;

@SuppressWarnings("unchecked")
public HoorayList(int initalCap)
{
    // prevent illegal arg
    if(initalCap < 0)
        throw new IllegalArgumentException("Capcaity must be at least zero.");
 mSize = 0;
 mCap = initalCap;
 mData = (E[]) new Object[mCap];
}

public HoorayList()
{
  // Code reuse calling overloaded constructor in defult
  this(DEFAULT_CAP);
 //mSize = 0;
 //mCap = DEFAULT_CAP;
 //mData = (E[]) new Object[mCap];
}

public E get(int index)
{
    if(index <0 || index >= mSize)
        throw new IndexOutOfBoundsException("Index must be between 0 and " + (mSize-1));
    return mData[index];
}

public E set(int index, E elem)
{
    if(index <0 || index >= mSize)
            throw new IndexOutOfBoundsException();
    E old = mData[index];
    mData[index] = elem;
    return old;
}

public void ensureCapacity(int minCapacity)
{
   if(mCap < minCapacity)
   {
       @SuppressWarnings("unchecked")
       E[] temp = (E[]) new Object[minCapacity];
       for(int i = 0; i < mSize; i++)
           temp[i] = mData[i];
       mCap =  minCapacity;
       mData = temp;
    }
}

public int indexOf(Object o)
{
    for(int i = 0; i < mSize; i++)
    {
        if(o.equals(mData[i]))
            return i;
    }
    return -1;
}

public boolean contains(Object o)
{
      return (indexOf(o) != -1);
}

public boolean add(int index, E element)
{
    if(index < 0 || index > mSize)
        throw new IndexOutOfBoundsException("Index must be between 0 and " + (mSize));
    else if(mSize >= mCap)
    {
        ensureCapacity(2 * mCap);
    }
    for(int i = mSize-1; i >= index; i--)
        mData[i+1] = mData[i];
     mData[index] = element;
     mSize++;
     return true;
}

public boolean add(E elem)
{
    return add(mSize, elem);
}

public E remove(int index)
{
    if(index < 0 || index > mSize)
    throw new IndexOutOfBoundsException("Index must be between 0 and " + (mSize));
E elemRemoved = mData[index];
    for(int i = index; i < mSize; i++)
        mData[i] = mData[i+1];
    mSize--;
    return elemRemoved;
}

public boolean remove(Object o)
{
    int index = indexOf(o);
    if(index != -1)
    {
        remove(index);
        return true;
    }
return false;
}
public void clear()
{
    for(int i = 0; i < mSize; i++)
       mData[i] = null;
    mSize = 0;
}

public int size()
{
    return mSize;
}

public String toString()
{
    System.out.println(mCap);

    StringBuilder str = new StringBuilder("[");
    for(int i = 0; i < mSize; i++)
        if(mData[i] != null)
        str.append(mData[i]).append(", ");
    str.append("Hooray!]");
    return str.toString();
}

}
