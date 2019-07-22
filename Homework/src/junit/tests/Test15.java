package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test15 {
	
	//Creates int variable to test mathematical expressions
	int num1 = 10;
	int num2 = 5;

	@Test
	void test() {
	
		//Tests addition, subtraction, division, and multiplication
		assertTrue(num1 + num2 == 15);
		assertTrue(num1 - num2 == 5);
		assertTrue(num1 * num2 == 50);
		assertTrue(num1 / num2 == 2);
		
	}//end test

}//end Test15
