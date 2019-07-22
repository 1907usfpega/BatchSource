package com.revature.assignment1;

import com.revature.outsidepackage.OutsideClass;

/**
 * Assignment #1 Question 11
 *Write a program that would access two float-variables from a class that exists in another
 *package. Note, you will need to create two packages to demonstrate the solution.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class FloatVariables {

	/**
	 * 
	 */
	public FloatVariables() {
		System.out.println("FloatVariables Object Created!");
	}
	/**
	 * 
	 * @param object
	 */
	public void getFloatValues(OutsideClass object) {
		System.out.println("OutsideClass float 1 value: " + object.getF1());
		System.out.println("OutsideClass float 2 value: " + object.getF2());
	}
}
