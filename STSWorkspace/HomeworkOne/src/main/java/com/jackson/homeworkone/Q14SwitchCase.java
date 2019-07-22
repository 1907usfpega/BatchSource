package com.jackson.homeworkone;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCase
{
	public void switchExample(int choice)
	{
		//choose which case based on the int choice
		switch(choice)
		{
			case 1:
				//enter our input
				Scanner s = new Scanner(System.in);
				//prompt our user
				System.out.print("Enter a number: ");
				double d = s.nextDouble();
				//s.close();
				//printout the results of squareRoot()
				System.out.println("Square Root: "+squareRoot(d));
				break;
			case 2:
				//run displayDate()
				displayDate();
				break;
			case 3:
				//run splutString()
				splitString();
				break;
			default:
				System.out.println("That is not a valid input");
				break;	
		}
	}
	public static double squareRoot(double d)
	{
		//return the square root of the double d
		return Math.sqrt(d);
	}
	
	public static void displayDate()
	{
		//print the Date object d, which when created through the default constructor, holds the current date
		Date d = new Date();
		System.out.printf("%s %tB %<te, %<tY", "Current Date: ", d);
		//new line
		System.out.println();
	}
	
	public static String[] splitString()
	{
		//String str is declared
		String str = "I am learning Core Java";
		//split the string using split method
		String[] splitVer = str.split("");
		//printout the tostring of the resulting array
		System.out.println(Arrays.toString(splitVer));
		return splitVer;
	}
}
