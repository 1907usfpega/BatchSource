/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 16
 */
public class CountCharacters {
//the method will have a param String [] args which will come from the main method that calls it
	
	public int count(String arg) {
		return arg.length();
	}
	
	public static void main(String [] args) {
		CountCharacters cha = new CountCharacters();
		//String [] arg = {"Deonta"};
		for (int i = 0; i < args.length; i++) {
			System.out.println(cha.count(args[i]));
		}
	}
}
