/**
 * 
 */
package question8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Palindromes {

	//checks if a specific string is a palindrome
	//helper method
	public boolean isPalindrome(String str) {
		int beginning = 0;
		int end = str.length() - 1;
		boolean isPalindrome = true;
		
		do {
			//if any beginning/end pair of characters as we approach the center does not match the word is not a palindrome
			if(str.charAt(beginning) != str.charAt(end))
				isPalindrome = false;
			beginning++;
			end--;
		} while(isPalindrome && beginning < end);
		
		return isPalindrome;
	}
	//saves all the palindromes from the param list returns that list
	public ArrayList<String> getPalindromes(ArrayList<String> list){
		ArrayList<String> palindromes = new ArrayList<String>();
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
}
