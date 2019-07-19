package com.revature.driver;

public class Question15 implements InterfaceForQ15{

	@Override
	public double addition(double one, double two) {
		
		return one + two;
	}

	@Override
	public double subtraction(double one, double two) {
		
		return one - two;
	}

	@Override
	public double multiplication(double one, double two) {
		
		return one * two;
	}

	@Override
	public double division(double one, double two) {
		
		return one / two;
	}
	
	protected static boolean validInput(String s) {
		try {
			Double.parseDouble(s);
			return true;
			
		} catch (NumberFormatException e) {
			System.out.println("Input is not valid. Returning -1");
		}
		return false;
	}
	protected void prompt() {
		System.out.println("Question 15:");
		System.out.println("Solution: ");
	}

}
