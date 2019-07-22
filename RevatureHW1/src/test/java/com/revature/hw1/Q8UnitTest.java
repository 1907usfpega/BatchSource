package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Q8UnitTest {
	
	private String[] strings = {"karan", "madam", "tom", "civic", "radar", 
			"jimmy", "kayak", "john", "refer", "billy", "did"};

	@Test
	void testPalinParse() {
		
		ArrayList<String> palindromes = Q8.palinParse(strings);
		System.out.println("Q8: There are " + palindromes.size() + 
				" palindromes: " + palindromes.toString());	
		if (palindromes.size() != 6)
		{
			fail("You mighta missed a couple there, pardner.");
		}
		
	}
	

}
