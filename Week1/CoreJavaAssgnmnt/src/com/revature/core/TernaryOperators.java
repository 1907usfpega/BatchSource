/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 10
 */
public class TernaryOperators {

	public int minValue(int a, int b) {
		return ((a < b) ? a : b);
	}
	
	public static void main(String [] args) {
		TernaryOperators t = new TernaryOperators();
		int a,b,c;
		a= 50;
		b= 4;
		c= t.minValue(a, b);
		System.out.println(c);
	}
}
