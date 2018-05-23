package edu.orangecoastcollege.cs272.malaya.ic01;

import java.util.*;
import java.util.Random;

public class JavaArrays
{
    public static void main(String[] args)
    {
     /*int[] array = new int[100];
     Random x = new Random();
     for(int i = 0; i < 100; i++)
         array[i] = x.nextInt(51) + 25;
     for(int i = 0; i < 100; i++)
       {
         if(i % 20 == 0 && i != 0)
             System.out.println();
         System.out.print(array[i] + " ");
        }*/
    	
    	// Finding largest prime factor of an int
    	/*
    	 long findFactor = 600851475143L;
    	List<Long> primes = new ArrayList<>();
    	int divider = 2;
    	while(divider < findFactor)
    	{
    	  
    	  if(findFactor % divider == 0)
    	  {
    		  findFactor /= divider;
    		  primes.add(findFactor);
    		  divider--;
    	  }
    	  else
    		  divider++;
    	}
    	System.out.println(divider +"\n");
    	primes.forEach(e -> System.out.println(e));
    */
    	/*int _3digit = 999;
    	while(_3digit > 100)
    	{
    		int _3d = 999;
    		while(_3d > 100)
    		{
    			int result = _3digit * _3d;
    			_3d--;
    			if( result > 888888 && isPandlom(result))  
    				{
    				System.out.print(_3digit +" " + _3d + "->");
    				System.out.println(result);
    				}
    		}
    			_3digit--;
    	}*/
    	
    	/*int smallestInt = 232_792_560;
    	boolean done = false;
    	while(!done)
    	{
    		int count = 0;
    		for(int i = 1; i <=20; i++)
    		{
    			if(smallestInt % i == 0)
    				count++;
    			else
    				smallestInt++;
    		}
    		if(count == 20)
    			done = true;
    		System.out.println(smallestInt);
   		}*/
    

    /*	
    }
   public static boolean DivisibleBy20 (long num)
    {
    	for (int i = 2; i <= 20; i++)
    	{
    		if (!(num % i == 0))
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
    
   public static boolean isPandlom(int num)
	{
	   String str = String.valueOf(num);
	   Stack<Character> s = new Stack<>();
	   for (int i = 0; i < str.length(); i++)
		{
			s.add(str.charAt(i));
		}
	   String reverse = "";
		while(!s.isEmpty())
		{
			reverse += String.valueOf(s.peek());
			s.pop();
		}
		if(reverse.equals(str)) {
		//	System.out.println(str);
			return true;
		}
		return false;
	
   */
    	int x =0;
        while(x++<10)
        {
        	System.out.println(x);
        }
    }	
}