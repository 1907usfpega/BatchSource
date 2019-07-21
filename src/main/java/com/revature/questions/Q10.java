package com.revature.questions;
/*Find the minimum of two numbers using ternary operators.
*/
public class Q10 {
	
	public static double findMin(double num1, double num2) {
		return (num1<num2)? num1 : num2;
	}
	
	public static void printMin(double num1, double num2) {
		System.out.println(findMin(num1,num2));
	}

}
