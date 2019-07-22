package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Assignment8 {
	
	public static ArrayList<String> sortArrays(){
		ArrayList<String> arr1 = new ArrayList<String>();
		arr1.addAll(Arrays.asList(new String[] {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" }));
		
		ArrayList<String> listPalindromes = new ArrayList<String>();
		
		for (String palcheck: arr1){
			if (isPalindrome(palcheck)){
				listPalindromes.add(palcheck);
			}
		}
		
		return listPalindromes;
	
	}
	public static boolean isPalindrome(String s) {
		int low = 0;
		int high = s.length() - 1;
		boolean isPalindrome = true;
		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				isPalindrome = false;
				break;
			}
			low++;
			high--;
		}
		if (isPalindrome) {
			return true;
		} else {
			return false;
		}

	}
}