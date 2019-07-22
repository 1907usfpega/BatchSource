package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q8Palindromes;


class Q8Test 
{
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	void testSavePalindromes() 
	{
		Q8Palindromes q8 = new Q8Palindromes();
		String[] expectedResult = {"madam", "civic", "radar", "kayak", "refer", "did"};
		ArrayList<String> s = q8.savePalindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		String[] actualResult = new String[s.size()];
		s.toArray(actualResult);
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	void testIsPalindrome() 
	{
		assertEquals(false, Q8Palindromes.isPalindrome("max"));
	}

}
