package com.revature.questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {

	public static ArrayList<String> doTask() {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palis = new ArrayList<String>();
		strings.addAll(Arrays.asList(new String[] { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",
				"refer", "billy", "did" }));
		for (String string : strings) {
			if (isPali(string)) {						//palis get added to palis
				palis.add(string);
			}
		}
		return palis;
	}

	public static boolean isPali(String s) {							//if the char, x steps away from one side, does not equal the one x steps away from the other, it is not a palindrom!	
		for (int i = 0; i < s.toCharArray().length; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {			
				System.out.println("The string "+ s + " is not a palindrom, since " + s.charAt(i) + " != " + s.charAt(s.length()-i-1));
				return false;
			}
		}
		return true;
	}
}
