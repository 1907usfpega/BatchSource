package com.java.core;

import java.util.Scanner;

//Q10. Find the minimum of two numbers using ternary operators.
public class Q__ten {
	
	
	public static	String z;
	public static String y;
	
	
	
public static  Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 boolean x = true;
 while(x) {
	System.out.println("enter the first number: ");
	 z= sc.nextLine();
	int resultA = Integer.parseInt(z);
	System.out.println("enter the second number: ");
	 y= sc.nextLine();
	int resultB = Integer.parseInt(y);
	int minValue = (resultA<resultB)?resultA:resultB;
	System.out.println("the minimum value of "+resultA+" and "+resultB+" is "+minValue);
	System.out.println("====================================================================33");
}
	}

}
