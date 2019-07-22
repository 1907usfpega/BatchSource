package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import homework1.Problem13;

class Test13 {

	@Test
	void test() {
		
		//Creates a String to test against the Problem13 method
		String test = "\n0 \n1 0 \n1 0 1 \n0 1 0 1 \n";
		String triangle = Problem13.triangle();
		
		//Checks if the tested String is the same as the expected String
		assertEquals(test,triangle);
		
	}//end test()

}//end Test13
