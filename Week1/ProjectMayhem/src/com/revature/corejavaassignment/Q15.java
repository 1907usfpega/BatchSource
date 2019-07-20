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
		int i = 0;
		double correctAns[] = {11.3, -340.59999999999997, 
								2618.111829, 0.020442549736094193};
		double tempD = parseInput("5.0+6.3");
		Q15Test tester1 = new Q15Test(tempD, correctAns[i++]);
		System.out.println("5.0 + 6.3 = " + tempD);
		tempD = parseInput("5.6- 346.2");
		Q15Test tester2 = new Q15Test(tempD, correctAns[i++]);
		System.out.println("5.6 - 346.2 = " + tempD);
		tempD = parseInput("29.34445 *89.22");
		Q15Test tester3 = new Q15Test(tempD, correctAns[i++]);
		System.out.println("29.34445 * 89.22 = " + tempD);
		tempD = parseInput("5.035 / 246.3");
		Q15Test tester4 = new Q15Test(tempD, correctAns[i]);
		System.out.println("5.035 / 246.3 = " + tempD);
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
