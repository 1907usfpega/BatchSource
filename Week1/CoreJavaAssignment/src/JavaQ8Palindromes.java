package Assignment.Java;

import java.util.ArrayList;

public class JavaQ8Palindromes {

	public static void main(String[] args) {
		ArrayList arr1 = new ArrayList(); // All string
		ArrayList p_arr = new ArrayList(); // Palindrome strings
		// add all string in arr1
		arr1.add("karan");
		arr1.add("madam");
		arr1.add("tom");
		arr1.add("civic");
		arr1.add("radar");
		arr1.add("jimmy");
		arr1.add("kayak");
		arr1.add("john");
		arr1.add("refer");
		arr1.add("billy");
		arr1.add("did");
		// loop 
		for (int i = 0; i < arr1.size(); i++) {
		if (isPalindrome((String) arr1.get(i))) {
		// if palindrome
		p_arr.add((String) arr1.get(i)); 
		// add the string to p_arr list
		}
		}
		System.out.println("The Palindrome string are : " + p_arr);
		}

		public static boolean isPalindrome(String str) {
		String reverse = "";
		// reverse the string
		for (int i = str.length() - 1; i >= 0; i--) {
		reverse = reverse + str.charAt(i);
		}
		// check string matches to give string
		return str.equals(reverse);
		}
		
	}


