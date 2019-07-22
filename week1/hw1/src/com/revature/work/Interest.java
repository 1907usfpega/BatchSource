package com.revature.work;

import java.util.Scanner;

public class Interest {
	public static float simpleInterest(int a,float b, int c) {
		//takes actual parameters for testing purposes
		return a*b*c;
	}
	
	
	public static float simpleInterest() {
		//accepts input for driver
		Scanner sc=new Scanner (System.in);
		System.out.println("input principle");
		String s= sc.nextLine();
		int principle=Integer.parseInt(s);
		System.out.println("input rate");
		s=sc.nextLine();
		float rate=Float.parseFloat(s);
		System.out.println("input years");
		s=sc.nextLine();
		int time=Integer.parseInt(s);
		sc.close();
		float si=simpleInterest(principle,rate,time);
		System.out.println("Simple interest is: ");
		return si;
	}
	
	

}
