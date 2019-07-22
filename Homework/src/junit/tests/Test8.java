package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Test8 {
	
	//Stores the original list into an ArrayList
	String[] full = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
	List<String> baseList =new ArrayList<String>(Arrays.asList(full));
	
	//Store the expected answer into an ArrayList
	String[] test = {"madam", "civic", "radar", "kayak", "refer", "did"};
	ArrayList<String> testList =new ArrayList<String>(Arrays.asList(test));
	
	//Creates a new list to store palindromes
	List<String> palindromes = new ArrayList<String>();
	
	@Test
	void test() {
		//Tests against original method 
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
	
		//Checks if the tested ArrayList is the same as the expected ArrayList
		assertEquals(testList, palindromes);
		
		
	}//end test()

}//end Test8
