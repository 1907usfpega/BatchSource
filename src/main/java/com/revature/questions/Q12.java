package com.revature.questions;

import com.revature.utils.MyFunctions;

/*Q12. Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers
*/
public class Q12 {
	static int array[];
	
	private static void loadArray() {
		//define array size
		array= new int[100];
		//load array
		for (int i = 0; i < 100; i++) {
			array[i] = i+1;
		}
	}
	
	public static String printEven() {
		loadArray();
		String s = "";
		//using foreach loop to print even #s
		for(int i : array) {
			if(MyFunctions.isEven(i)) {
				s += i + " ";
			}
		}
		System.out.println(s);
		return s;
	}

}
