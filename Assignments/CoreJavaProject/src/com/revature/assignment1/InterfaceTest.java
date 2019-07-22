package com.revature.assignment1;

/**
 * Assignment #1 Question 15
 *Write a program that defines an interface having the following methods: addition,
 *subtraction, multiplication, and division. Create a class that implements this interface and
 *provides appropriate functionality to carry out the required operations. Hard code two operands
 *in a test class having a main method that calls the implementing class.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class InterfaceTest implements MathInterface {

	/**
	 * 
	 */
	public InterfaceTest() {
		System.out.println("InterfaceTest Object Created!");
	}
	
	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) {
		return a / b;
	}
}
