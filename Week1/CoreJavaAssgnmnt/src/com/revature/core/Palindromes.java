/**
 * 
 */
package com.revature.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author MajorKey
 *Question 8
 */
public class Palindromes {
	public boolean isPalindrome(String str) {
		int beginning = 0;
		int end = str.length() - 1;
		boolean isPalindrome = true;
		
		do {
			if(str.charAt(beginning) != str.charAt(end))
				isPalindrome = false;
			beginning++;
			end--;
		} while(isPalindrome && beginning < end);
		
		return isPalindrome;
	}
	public ArrayList<String> getPalindromes(ArrayList<String> list){
		ArrayList<String> palindromes = new ArrayList<>();
		Iterator<String> itr=list.iterator();
		while(itr.hasNext()) {
			String next = (String)itr.next();
			//System.out.println(next);
			if(isPalindrome(next)) {
				palindromes.add(next);
			}
		}
		return palindromes;
	}
	public static void main(String [] args) {
		Palindromes p = new Palindromes();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic","radar", "jimmy", "kayak", "john","refer", "billy", "did"));
		ArrayList<String> palindromes = p.getPalindromes(list);
		System.out.println(palindromes);
	}
}
