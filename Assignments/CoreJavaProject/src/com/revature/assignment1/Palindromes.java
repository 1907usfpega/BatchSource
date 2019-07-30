package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Assignment #1 Question 8
 * Write a program that stores the following strings in an ArrayList and saves all the
 * palindromes in another ArrayList.
 * �karan�, �madam�, �tom�, �civic�, �radar�, �jimmy�, �kayak�, �john�, �refer�, �billy�, �did�
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class Palindromes {
	
	private ArrayList<String> strings = new ArrayList<String>();
	private ArrayList<String> palindromes = new ArrayList<String>();
	
	public void checkForPalindromes() {
		StringBuilder reverse = new StringBuilder();
		for (int i = 0; i < strings.size(); i++) {
			reverse.append(strings.get(i));
			reverse.reverse();
			if (strings.get(i).equals(reverse.toString())) {
				palindromes.add(strings.get(i));
			} 
			reverse.delete(0, reverse.length());
		}
	}
		
	public void addString(String string) {
		strings.add(string);
	}
	
	public void displayPalindromes() {
		System.out.println("elements in the Palindrome ArrayList:");
		for (int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}
	}
}
