package com.revature.questions;

import com.revature.utils.MyFunctions;

/* Write a program that would access two float-variables from 
 * a class that exists in another package. Note, you will need
 * to create two packages to demonstrate the solution.
*/

public class Q11 {

	public static float getfloat1() {
		return MyFunctions.float1;
	}

	public static float getfloat2() {
		return MyFunctions.float2;
	}


	public static String accessVariable() {
		setRemote();
		String s = "float1 = " + getfloat1()+ 
				" | float2 = " + getfloat2();
		System.out.println(s);
		return s;
	}

	private static void setRemote() {
		MyFunctions.float1 = 2;
		MyFunctions.float2 = 1.5f;
	}


}
