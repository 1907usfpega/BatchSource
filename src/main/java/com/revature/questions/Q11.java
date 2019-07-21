package com.revature.questions;

import com.revature.utils.MyFunctions;

/* Write a program that would access two float-variables from 
 * a class that exists in another package. Note, you will need
 * to create two packages to demonstrate the solution.
*/
 
public class Q11 {

	public static void accessVariable() {
		MyFunctions.float1 = 2;
		MyFunctions.float2 = 1.5f;
		
		System.out.print("float1 = "+ MyFunctions.float1);
		System.out.println(" | float2 = "+ MyFunctions.float2);
	}
}
