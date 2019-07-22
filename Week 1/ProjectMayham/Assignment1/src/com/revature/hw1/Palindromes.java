package com.revature.hw1;

import java.util.ArrayList;

public class Palindromes {

	public static ArrayList<String> palindromes(ArrayList<String> input) {
		ArrayList<String> output = new ArrayList<String>();
		boolean palindrome = true;
		
		for (String word : input) {
			if (IsEven.isEven(word.length())) {
				int j = 1;
				for (int i = 0; i < word.length() / 2; i++) {
					if (word.charAt(i) != word.charAt(word.length() - j)) {
						palindrome = false;
						break;
					}
					j++;
				}
				if(palindrome) {
					output.add(word);
				}
			} else {
				int j = 1;
				for (int i = 0; i < word.length() / 2 + 1; i++) {
					if (word.charAt(i) != word.charAt(word.length() - j)) {
						palindrome = false;
						break;
					}
					j++;
				}
				if (palindrome) {
					output.add(word);
				}
			}
			palindrome = true;
		}

		return output;
	}

//	public static void main(String[] args) {
//		ArrayList<String> al1 = new ArrayList<String>();
////		“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
//		al1.add("karan");
//		al1.add("madam");
//		al1.add("tom");
//		al1.add("civic");
//		al1.add("radar");
//		al1.add("jimmy");
//		al1.add("kayak");
//		al1.add("john");
//		al1.add("refer");
//		al1.add("billy");
//		al1.add("did");
//		
//		ArrayList<String> al2 = palindromes(al1);
//	
//		for(String word:al2) {
//			System.out.println(word);
//		}
//		
//	}

}
