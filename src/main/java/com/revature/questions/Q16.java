package com.revature.questions;
/*Q16. Write a program to display the number of characters 
 * for a string input. The string should be entered as a command 
 * line argument using (String [ ] args).
 * */
 
public class Q16 {

	public static int countInput(String[] args) {
		
		int count = 0;
		for(String i : args) {
			count = count+ i.length();
		}
		System.out.println(count);
		return count;
	}

}
