package com.java.core;
/*
 * Q15. Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. Create a class that 
 * implements this interface and provides appropriate functionality to carry 
 * out the required operations. Hard code two operands in a test class having 
 * a main method that calls the implementing class.
 * 
 * 
 */
interface Arithmatic{
	public int addition(int a, int b);
	public  int subtraction(int a, int b);
	public  int mult(int a,int b);
	public int division(int a,int b);
}

public class Q__fifteen implements Arithmatic {
	public int  addition(int a, int b) {
		int c = a+b;
		System.out.println(a+" + "+b+" = "+c);
		return c;
	}
	public int subtraction(int a,int b) {
		int c = a-b;
		System.out.println(a+" - "+b+" = "+c);
		return c;
	}
	public int mult(int a,int b) {
		int c = a*b;
		System.out.println(a+" x "+b+" = "+c);
		return c;
	}
	public int division(int a,int b) {
		int c = a/b;
		System.out.println(a+" / "+b+" = "+c);
		return c;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
