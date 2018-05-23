package edu.orangecoastcollege.cs272.malaya.p01;

public class RoachPopulationDemo
{

    public static void main(String[] args)
    {
        RoachPopulation demo = new RoachPopulation(10);
        for(int i= 0; i < 3; i++)
        {
        demo.breed();
        demo.spray();
        
        System.out.print("The Roach Population is: ");
        System.out.printf("%.3f",demo.getPopulation());
        System.out.println();
        }
    }

}
