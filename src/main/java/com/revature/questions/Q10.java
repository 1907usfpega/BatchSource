package com.revature.questions;
/*Find the minimum of two numbers using ternary operators.
*/
public class Q10 {
	
	public static double findMin(double num1, double num2) {
		double min = (num1<num2)? num1 : num2;
		System.out.println(min);
		return min;
	}
}
