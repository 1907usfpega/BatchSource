package com.revature.questions;
/*Write a program that stores the following strings in an 
 * ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, 
“john”, “refer”, “billy”, “did”
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.utils.MyFunctions;

public class Q8 {
	private static List<String> palindromesList;
	
	public static String savePalindromes() {
		//create inicial list
		List<String> myArray = new ArrayList<String>();
		
		myArray.add("karan");
		myArray.add("madam");
		myArray.add("tom");
		myArray.add("civic");
		myArray.add("radar");
		myArray.add("jimmy");
		myArray.add("kayak");
		myArray.add("john");
		myArray.add("refer");
		myArray.add("billy");
		myArray.add("did");
		
		//iniciate second list
		palindromesList = new ArrayList<String>();
		
		System.out.print("\nPalindromes: ");
		Iterator<String> itr = myArray.iterator();
		
		//copy palindromes
		while (itr.hasNext()) {
			String element = itr.next();
			// CHECK Palindromes
			if (MyFunctions.isPalindrome(element)) {
				palindromesList.add(element);
			}
		}
		
		System.out.println(palindromesList);
		return palindromesList.toString();
	}

}
