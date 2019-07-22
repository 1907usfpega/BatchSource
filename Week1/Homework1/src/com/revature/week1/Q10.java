package com.revature.week1;

public class Q10 {
	public static int minInt(int i, int o) {
		//Find the minimum of two numbers using ternary operators.

		// reference: idx = (idx < str.length()) ? idx : str.length(); 
		System.out.println(((i<o)?  i :  o));
		return (i<o)?  i :  o ;
		
	}
}
