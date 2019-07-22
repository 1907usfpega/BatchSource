package com.revature.hw1;

/*Write a program having a concrete ;subclass that inherits three 
 * abstract methods from a superclass.  Provide the following three 
 * implementations in the subclass corresponding to the abstract 
 * methods in the superclass:
 * 1. Check for uppercase characters in a string, and return ‘true’ 
 * or ‘false’ depending if any are found.
 * 2. Convert all of the lower case characters to uppercase in the 
 * input string, and return the result.
 * 3. Convert the input string to integer and add 10, output the 
 * result to the console.
 * Create an appropriate class having a main method to test the 
 * above setup.
*/

public class Q18 extends Q18Abstract {

	

	@Override
	public boolean capsChecker(String a) {
		for (int i = 0; i < a.length(); i++)
		{
			Character c = a.charAt(i);
			if(Character.isUpperCase(c))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String capsConvert(String a) {
		return a.toUpperCase();
	}

	@Override
	public void intParsePlus10(String a) {
		int val = Integer.parseInt(a) + 10;
		System.out.println("Value for " + a + " has been " +
		"adjusted to " + val);
	}
	
	public static void main(String[] args) {

	}

}
