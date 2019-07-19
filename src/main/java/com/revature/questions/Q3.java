package com.revature.questions;
/**Q3. Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer or the StringBuilder
 * APIs.
 * @param args
 */


public class Q3 {

	public static void main(String[] args) {
		String x = "Dayana";
		
		//navigate the string backwards
		for (int i = x.length()-1; i >= 0; i--) {
			System.out.print(x.charAt(i));
		}

	}

}
