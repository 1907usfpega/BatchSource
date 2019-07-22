package com.revature.homework1;

public class Assignment3 {
	public static String reverseStringMethod(String word){

		   if (word.equals("")){
			return word ;
		   }
		   else
		   {

			return word.charAt(word.length()-1) + reverseStringMethod(word.substring(0, word.length() -1));
			
			
			}
	}
}
