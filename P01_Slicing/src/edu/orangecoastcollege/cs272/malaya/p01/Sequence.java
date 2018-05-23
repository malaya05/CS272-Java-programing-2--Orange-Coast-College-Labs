/**
 * CS 272 - Spring 2017
 * Project #01-Sequence.java
 */
package edu.orangecoastcollege.cs272.malaya.p01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author  malaya
 * @version p01
 */
public class Sequence
{

    private int[] mArray;
    
    /**
     * Constructs a sequence of integers.
     * @param array the array to initialize the sequence.
     */
    public Sequence(int[] array)
    {
        mArray = array.clone();
    }
    
    
    
    // Complete: Write the three versions of slice() here
    
    // one param
    int[] slice(int start)
    {
    	int xIndex = 0;
    	if(start < 0)
    	{
    		int newSize = -1*start;
    		int x[] = new int[newSize];
    		
    		for (int i =  mArray.length - newSize; i <  mArray.length; i++)
    		{
    			x[xIndex++] = mArray[i];
    		}
    		return x;
    	}
    	else
    	{		
    		int x[] = new int[mArray.length - start];
    		for (int i = start; i <  mArray.length; i++)
    		{
    			x[xIndex++] = mArray[i];
    		}
    		return x;
    	}
    	
    }
    
    // two param
    int[] slice(int start, int end)
    {
    	if(mArray.length < end || end < 0) 
			throw new IllegalArgumentException("The end point is bigger "
					+ "than the size of the Array, reconsider your sliceing!");
    	
    	int xIndex = 0;
    	if(start < 0)
    	{
    		int newStart = mArray.length - Math.abs(start);
    		if(newStart > end) 
    			throw new IllegalArgumentException("Start index passed End");
    		int newSize =  Math.abs(newStart - end);
    		
    		int x[] = new int[newSize];
    		for (int i = newStart; i < end; i++)
    		{
    			x[xIndex++] = mArray[i];
    		}
    		return x;
    	}
    	else
    	{		
    		int x[] = new int[end - start];
    		for (int i = start; i < end; i++)
    		{
    			x[xIndex++] = mArray[i];
    		}
    		return x;
    	}
    }

	ArrayList slice(int start, int end, int step)
  	{
		if(mArray.length < end || end < 5) 
			throw new IllegalArgumentException("The end point is bigger "
					+ "than the size of the Array, reconsider your sliceing!");
    
    	if(start < 0)
    	{
    		int newStart = mArray.length - Math.abs(start);
    		if(newStart > end) 
    			throw new IllegalArgumentException("Start index passed End");
    		
    		ArrayList x = new ArrayList<>();
    		for (int i = newStart; i < end; i += step)
    		{
    			x.add( mArray[i]);
    		}
    		return x;
    	}
    	else
    	{	
    		ArrayList x = new ArrayList<>();
    		for (int i = start; i < end; i += step)
    		{
    			x.add(mArray[i]);
    		}
    		return x;
    	}
    }
    
    
    
    
    
    @Override
    public String toString()
    {
        String result = "{";
        if (mArray.length > 0)
        {
          //  result += mArray[0];
            for (int i = 0; i < mArray.length; i++)
            {
               System.out.println( ", " + mArray[i]);
            }
        }
        return result + "}";
    }
    
    public static void main(String[] args)
    {
        Sequence a = new Sequence(new int[]{1, 2, 3, 4, 5});
        // some informal testing
        System.out.println("a.slice(0)-> " + Arrays.toString(a.slice(0)));
        System.out.println("a.slice(1)->" +  Arrays.toString(a.slice(1)));
        System.out.println("a.slice(-1)->" + Arrays.toString(a.slice(-1)));
        System.out.println("a.slice(-2)->" + Arrays.toString(a.slice(-2)));
        System.out.println("a.slice(5)->" +  Arrays.toString(a.slice(5)));
        System.out.println("a.slice(-5)->" + Arrays.toString(a.slice(-5)));
        
        System.out.println("\n");
        
        System.out.println("a.slice(-5, 3)->" + Arrays.toString(a.slice(-5, 5)));
        System.out.println("a.slice(-1, 4)->" + Arrays.toString(a.slice(-3, 4)));
        System.out.println("a.slice(1, 3)->" + Arrays.toString(a.slice(1, 3)));
        System.out.println("a.slice(-2,2 )->" + Arrays.toString(a.slice(-2, 5)));
        
        
        System.out.println("\n");

        
        System.out.println("a.slice(0, 5, 2)->" + a.slice(0, 5, 2));
        System.out.println("a.slice(1, 5, 2)->" + a.slice(1, 5, 2));
        System.out.println("a.slice(1, 5, 3)->" + a.slice(1, 5, 3));
        System.out.println("a.slice(2, 5, 3)->" + a.slice(2, 5, 3));
        System.out.println("a.slice(-1, 6, -1)->" + a.slice(-1, 5, 5));
        
    }
}