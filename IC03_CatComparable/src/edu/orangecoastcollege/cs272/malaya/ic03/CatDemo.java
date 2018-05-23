	package edu.orangecoastcollege.cs272.malaya.ic03;

import java.util.*;
import java.util.function.Predicate;

public class CatDemo
{
    public static List<Cat> filter(List<Cat> catsList, Predicate<Cat> tester)
    {
        List<Cat>filteredList = new ArrayList<>();
        for(Cat e : catsList)
            if(tester.test(e))
                filteredList.add(e);

        return filteredList;
    }


    public static void main(String[] args)
    {
       List<Cat> catList = new ArrayList<>();
       Cat catOne = new Cat("Meowth","Persian", 21);
       Cat catTwo = new Cat("Grumpy Cat","Mixed", 5);
       Cat catThree = new Cat("Grumpy Cat","Mixed", 7);
       Cat catFour = new Cat("Garfield","Ginger Tabby", 39);

      catList.add(catOne);
      catList.add(catTwo);
      catList.add(catThree);
      catList.add(catFour);

      System.out.println("~~~Unsorted List ~~~");
      // print all cas ( using Lambda espression
      catList.forEach(cat -> System.out.println(cat));

      // now sort using comparable
      Collections.sort(catList);
      System.out.println("\n***The sorted List is: ");
      catList.forEach(cat -> System.out.println(cat));

      // using the lambda function
      List<Cat> option =  filter(catList, p -> p.getAge() > 5 &&  p.getCatName().startsWith( "Grumpy"));
      System.out.println("********THE FILTERED LIST*******");

      option.forEach(cat -> System.out.println(cat));
    }

}
