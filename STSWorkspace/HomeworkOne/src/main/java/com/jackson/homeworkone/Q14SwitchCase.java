package com.jackson.homeworkone;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCase 
{
	public void switchExample(int choice)
	{
		switch(choice)
		{
			case 1:
				Scanner s = new Scanner(System.in);
				System.out.print("Enter a number: ");
				double d = s.nextDouble();
				s.close();
				System.out.println("Square Root: "+squareRoot(d));
				break;
			case 2:
				displayDate();
				break;
			case 3:
				splitString();
				break;
			default:
				System.out.println("That is not a valid input");
				break;	
		}
	}
	public static double squareRoot(double d)
	{
		return Math.sqrt(d);
	}
	
	public static void displayDate()
	{
		Date d = new Date();
		System.out.printf("%s %tB %<te, %<tY", "Current Date: ", d);
		//System.out.println("The current date is: "+current);
	}
	
	public static String[] splitString()
	{
		String str = "I am learning Core Java";
		String[] splitVer = str.split("");
		System.out.println(Arrays.toString(splitVer));
		return splitVer;
	}
}
