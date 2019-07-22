package com.java.core;
//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

import java.util.ArrayList;

public class Q__eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"karan","madam","tom","civic","radar","jimmy","kayak","john","refer","billy","did"};
		ArrayList<String>names= new ArrayList();
		ArrayList<String>palindromes= new ArrayList();
		for(int x = 0; x<strs.length;x++) {
			String word = strs[x];
			String wordReversed = new StringBuilder(word).reverse().toString();
			if(!word.equals(wordReversed)) {names.add(word);}
			else {palindromes.add(word);}
		}
		System.out.print("Names "+names);
		System.out.println();
		System.out.print("Palindromes "+palindromes);
		names.clear();
		palindromes.clear();
	}

}
