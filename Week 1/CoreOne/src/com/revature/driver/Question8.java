package com.revature.driver;

import java.util.ArrayList;

public class Question8 {

	public void run() {
		System.out.println("Question 8:");
		ArrayList<String> arrList = new ArrayList<String>();
		String[] str = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" };
		for (String s : str) {
			arrList.add(s);
		}
		System.out.println("Solution: " + pali(arrList).toString());

	}

	// returns only the palis
	public static ArrayList<String> pali(ArrayList<String> in) {
		ArrayList<String> out = new ArrayList<String>();
		for (String s : in) {
			if (isPali(s)) {
				out.add(s);
			}
		}
		return out;
	}

	// checks if string is a pali
	private static boolean isPali(String in) {
		int len = in.length();
		for (int i = 0; i < len; i++) {
			if (in.charAt(i) != in.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
