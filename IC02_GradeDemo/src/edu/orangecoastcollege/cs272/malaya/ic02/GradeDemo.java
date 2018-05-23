package edu.orangecoastcollege.cs272.malaya.ic02;

import java.util.*;

public class GradeDemo{
	
public static double letterToNumber(String grade){
	 char values[] = new char[] {'F', 'D', 'C', 'B', 'A'};
	 double result = -1;
	 
	 for(int i = 0; i < 5;i++)
		 if(grade.charAt(0) == values[i])
			 result = i;
	 
	 if(grade.length() > 1 && result >=1)
	 {
		 if(grade.charAt(1) == '+' && result < 4)
			 result += 0.3;
		 else if(grade.charAt(1) == '-')
			 result -= 0.3;
	 }
	 return result;}  
 public static void main(String[] args) {
	 System.out.print("Enter a letter grade: ");
	 Scanner cin = new Scanner(System.in);
	 String grade = cin.nextLine();
	System.out.print("Numeric value: " + letterToNumber(grade));
	 cin.close();
	 

	
	 
 }
}