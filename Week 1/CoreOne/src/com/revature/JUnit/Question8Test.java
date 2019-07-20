package com.revature.JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question8;

class Question8Test {

	String[] check = {"madam", "civic", "radar", "kayak", "refer", "did"};
	String[] fill = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};

	ArrayList<String> fullList =new ArrayList<String>(Arrays.asList(fill));
	ArrayList<String> paliList =new ArrayList<String>(Arrays.asList(check));

			

	@Test
	void testPali() {
		assertFalse(fullList.equals(paliList));
		fullList = Question8.pali(fullList); 
		assertTrue(fullList.equals(paliList));
	}

}
