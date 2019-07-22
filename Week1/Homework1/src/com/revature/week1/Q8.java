package com.revature.week1;

import java.util.ArrayList;

//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

public class Q8 {

	public static ArrayList<String> perform(){
		ArrayList<String> aBunchOfNames = new ArrayList<String>();
		ArrayList<String> backwardNames = new ArrayList<String>();
		
	
//	palindrome
		for(int i=aBunchOfNames.size(); i--) {
			backwardNames += aBunchOfNames.charAt(i);
		}
		
		
//		aBunchOfNames.addAll(0, aBunchOfNames);{
//			karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		}
	
	
	
}
