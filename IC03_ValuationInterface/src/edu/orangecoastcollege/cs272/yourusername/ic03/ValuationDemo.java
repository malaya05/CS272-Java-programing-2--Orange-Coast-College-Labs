package edu.orangecoastcollege.cs272.yourusername.ic03;

import java.util.*;
public class ValuationDemo {

	public static void main(String[] args) {
		List<Security> sList = new ArrayList<>();
		
		CommonStock a = new CommonStock("1234566, ","Amazon, Inc.",50,1100, 1116.50);
		CommonStock b = new CommonStock("1234567, ","Apple, Inc.",100,100, 134.89);
		CommonStock c = new CommonStock("1234567, ","Apple, Inc.",25,135, 134.89);
		
		Bond aBond = new Bond("7654321","U.S. Govt. 2 Year,",10_000.00,1.13,2);
		Bond bBond = new Bond("7654321","U.S. Govt. 2 Year,",10_000.00,1.10,1);
		Bond cBond = new Bond("7654320","U.S. Govt. 5 Year,",5_000.00,2.20,4);
		
		sList.add(a);
		sList.add(aBond);
		sList.add(b);
		sList.add(bBond);
		sList.add(c);
		sList.add(cBond);
		
		System.out.println("~~~Unsorted List~~~");
		for(Security e : sList)
			System.out.println(e);
		
		Collections.sort(sList);
		System.out.println("\n\n~~~ sorted List~~~ ");
		sList.forEach(e -> System.out.println(e));

	}

}
