package edu.orangecoastcollege.cs272.midterm;

import java.util.*;
import java.util.function.Predicate;

public class GamingDemo {

public static List<GamingConsole> filter(List<GamingConsole>
    allConsolesList, Predicate<GamingConsole> predicate)
{
    List<GamingConsole> filteredList = new ArrayList<>();

    for(GamingConsole e :allConsolesList )
        if(predicate.test(e))
            filteredList.add(e);

    return filteredList;
}

public static Predicate<GamingConsole> consolesLessThan(double price)
{
    return (e-> e.price < price);

}

public static Predicate< GamingConsole> backwardCompatibleConsoles()
{
    return e-> e.isBackwardCompatible() == true;
}

public static Predicate< GamingConsole> minimumTFLOPS(double value)
{
    return e -> (e.calculateTFlops() >= value);
}

	public static void main(String[] args) {

		//Uncomment code after all classes have been built
		Nintendo Switch = new Nintendo("Switch", 768, 256, 299.0, 2.5);
		Nintendo wiiU = new Nintendo("Wii U", 550, 320, 299.0, 0);

		Playstation four = new Playstation("4", 800, 1152, 399.0, "PlayStation VR");
		Playstation three = new Playstation("3", 500, 400, 499.0, "N/A");

		XBox one = new XBox("One", 853, 768, 499.0, "BlueRay");
		XBox $360 = new XBox("360", 500, 240, 399.0, "N/A");

		List<GamingConsole> gamesList =  new ArrayList<>();
		gamesList.add(Switch);
		gamesList.add(wiiU);

		gamesList.add(four);
		gamesList.add(three);

		gamesList.add(one);
		gamesList.add($360);

		Scanner cin = new Scanner(System.in);
		int x = 0;
		while(x != 4)
		{
		    System.out.println("Choose from the following: \n1) Nintendo\n2)PlayStation"
		            + "\n3) XBox\n4) exit");
		    x = cin.nextInt();
		    if(x == 1)
		    {
		        System.out.println("Enter the name:  ");
		        String name = cin.next();

		        System.out.println("Enter the GPU:  ");
                int gpu = cin.nextInt();

                System.out.println("Enter the Cores:  ");
                int core = cin.nextInt();

                System.out.println("Enter the price:  ");
                double price = cin.nextDouble();

                System.out.println("Enter the Battry life:  ");
                double bl = cin.nextDouble();

                Nintendo userOne = new Nintendo(name, gpu, core, price, bl);
                gamesList.add(userOne);
		    }
		    else if(x == 2)
		    {
		        System.out.println("Enter the name:  ");
                String name = cin.next();

                System.out.println("Enter the GPU:  ");
                int gpu = cin.nextInt();

                System.out.println("Enter the Cores:  ");
                int core = cin.nextInt();

                System.out.println("Enter the price:  ");
                double price = cin.nextDouble();

                System.out.println("Enter the VR:  ");
                String vr = cin.next();

                Playstation userOne = new Playstation(name, gpu, core, price, vr);
                gamesList.add(userOne);
		    }
		    else if(x == 3)
		    {
		        System.out.println("Enter the name:  ");
                String name = cin.next();

                System.out.println("Enter the GPU:  ");
                int gpu = cin.nextInt();

                System.out.println("Enter the Cores:  ");
                int core = cin.nextInt();

                System.out.println("Enter the price:  ");
                double price = cin.nextDouble();

                System.out.println("Enter the PhysicalMedia:  ");
                String pm = cin.next();

                Playstation userOne = new Playstation(name, gpu, core, price, pm);
                gamesList.add(userOne);
		    }
		    else // after chosing 4
		    {
		        System.out.println("~~~~~~~~~All Gaming Consoles~~~~~~~~~");
		        for(GamingConsole e :gamesList)
		            System.out.println(e);

		        System.out.println();
		        /// use lambda
		        System.out.println("~~~~~~~~~Gaming Consoles Less than $300~~~~~~~~~");
		        List<GamingConsole> priceList = filter(gamesList, consolesLessThan(300));
                for(GamingConsole e :priceList)
                    System.out.println(e);

                System.out.println();

                System.out.println("~~~~~~~~~Backward Compatible Consoles~~~~~~~~~");
                List<GamingConsole> Compatible = filter(gamesList, backwardCompatibleConsoles());
                for(GamingConsole e :Compatible)
                    System.out.println(e);


                System.out.println();

                System.out.println("~~~~~~~~~Consoles with at least 1 TFLOP ~~~~~~~~~");
                List<GamingConsole> minTFLOPS = filter(gamesList, minimumTFLOPS(1.0));
                for(GamingConsole e :minTFLOPS)
                    System.out.println(e);
		    }
		}

	}

}
