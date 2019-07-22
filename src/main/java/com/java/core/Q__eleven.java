package com.java.core;
import com.java.coreII.*;
//Q11. Write a program that would access two float-variables from a class that exists in another package. 
//Note, you will need to create two packages to demonstrate the solution.	

public class Q__eleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q__elevenAccessible meh = new Q__elevenAccessible();
		meh.floatOne=4.5f;
		meh.floatTwo=7.8f;
		
System.out.println("imported "+meh.floatOne+" from another class.");
System.out.println("imported "+meh.floatTwo+" from another class.");
	}

}
