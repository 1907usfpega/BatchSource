package homework1;

import java.util.List;
import java.util.ArrayList;

public class Problem8 {

	static void palindromes() {
		
		//Creates an ArrayLists to store starter values and the palindromes
		List<String> baseList = new ArrayList<String>();
		List<String> palindromes = new ArrayList<String>();
		
		//Add elements to the starter list
		baseList.add("karan");
		baseList.add("madam");
		baseList.add("tom");
		baseList.add("civic");
		baseList.add("radar");
		baseList.add("jimmy");
		baseList.add("kayak");
		baseList.add("john");
		baseList.add("refer");
		baseList.add("billy");
		baseList.add("did");
		
		//Creates a StringBuilder for palindrome comparison
		StringBuilder reverse = new StringBuilder();
		
		//Uses a for loop to iterate through the starter list
		for(int i = 0; i < baseList.size(); i++ ) {
			reverse.setLength(0); //<--Resets the value of the StringBuiler
			
			//Reverses the current word and compares it to the original
			//If they read the same, then the word is palindrome and is stored into a separate ArrayList
			if(baseList.get(i).equals(reverse.append(baseList.get(i)).reverse().toString())){ 
				palindromes.add(baseList.get(i));
			}
		}
	
		//Prints out the ArrayList with only palindromes
		System.out.print("Q8.) Here are all the palindromes from the base list:  ");
		for(int x = 0; x < palindromes.size(); x++ ) {
			System.out.print(palindromes.get(x) + "  ");
		}
		
	}//end palindromes()
	
}//end Problem8 class
