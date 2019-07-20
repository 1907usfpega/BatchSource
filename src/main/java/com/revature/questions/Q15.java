package com.revature.questions;

import com.revature.utils.Calculator;

public class Q15 implements Calculator{

	@Override
	public double sum(double x, double y) {
		
		return x+y;
	}

	@Override
	public double multiply(double x, double y) {
		
		return x*y;
	}

	@Override
	public double divide(double x, double y) {
		
		return x/y;
	}

	@Override
	public double substract(double x, double y) {
		
		return x-y;
	}
	
	
	
	public void printAddition(double x, double y) {		
		System.out.println(sum(x, y));		
	}

	
	public void printMultiplication(double x, double y) {
		
		System.out.println(multiply(x, y));	
	}

	
	public void printDivision(double x, double y) {
		
		System.out.println(divide(x, y));	
	}

	
	public void printSubtraction(double x, double y) {
		
		System.out.println(substract(x, y));	
	}
}
