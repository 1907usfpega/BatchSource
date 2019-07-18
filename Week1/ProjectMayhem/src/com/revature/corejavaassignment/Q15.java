package com.revature.corejavaassignment;

public interface Q15 {
	public double parseInput(String inString); 
	public double add(double augend, double addend);
	public double subtract(double minuend, double subtrahend);
	public double multiply(double multiplicand, double multiplier);
	public double divide(double dividend, double divisor);
}
class Q15Class implements Q15{
	Q15Class() {
		System.out.println("********** Q15 **********\n");
		System.out.println("5.0 + 6.3 = " + parseInput("5.0+6.3"));
		System.out.println("5.6 - 346.2 = " + parseInput("5.6- 346.2"));
		System.out.println("29.34445 * 89.22 = " + parseInput("29.34445 *89.22"));
		System.out.println("5.035 / 246.3 = " + parseInput("5.035 / 246.3"));
		System.out.println("\n\n");
	}
	public double parseInput(String inString) {
		int a = 0;
		int b = 0;
		String firstString = "";
		String secondString = "";
		if(inString.indexOf("+") >= 0) {
			firstString = inString.substring(0, inString.indexOf("+"));
			secondString = inString.substring(inString.indexOf("+") + 1, inString.length());
			return add(Double.parseDouble(firstString.trim()),
						Double.parseDouble(secondString.trim()));
		}
		else if(inString.indexOf("-") >= 0) {
			firstString = inString.substring(0, inString.indexOf("-"));
			secondString = inString.substring(inString.indexOf("-") + 1, inString.length());
			return subtract(Double.parseDouble(firstString.trim()),
						Double.parseDouble(secondString.trim()));
		}
		else if(inString.indexOf("*") >= 0) {
			firstString = inString.substring(0, inString.indexOf("*"));
			secondString = inString.substring(inString.indexOf("*") + 1, inString.length());
			return multiply(Double.parseDouble(firstString.trim()),
						Double.parseDouble(secondString.trim()));
		}
		else if(inString.indexOf("/") >= 0) {
			firstString = inString.substring(0, inString.indexOf("/"));
			secondString = inString.substring(inString.indexOf("/") + 1, inString.length());
			return divide(Double.parseDouble(firstString.trim()),
						Double.parseDouble(secondString.trim()));
		}
		else return 0.0000;
	}
	public double add(double augend, double addend) {
		return (augend + addend);
	}
	public double subtract(double minuend, double subtrahend) {
		return (minuend - subtrahend);
	}
	public double multiply(double multiplicand, double multiplier) {
		return (multiplicand * multiplier);
	}
	public double divide(double dividend, double divisor) {
		return (dividend / divisor);
	}
	
}
