package com.revature.hw1;

/*
 * Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */

public class Q15 implements Q15Interface {

	public Double addition(Double obj0, Double obj1) {
		return obj0 + obj1;
	}

	public Double subtraction(Double obj0, Double obj1) {
		return obj0 - obj1;
	}

	public Double multiplication(Double obj0, Double obj1) {
		return obj0 * obj1;
	}

	public Double division(Double obj0, Double obj1) {
		return obj0 / obj1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
