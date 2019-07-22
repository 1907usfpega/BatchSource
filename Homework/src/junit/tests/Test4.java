package junit.tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Test4 {
	
	double factorial = 5;
	double answer = 120.0;
	double result = 1;

	@Test
	void test() {
		//Uses same for loop found in Problem4 to test
		for(int i=1; i<=factorial; i++) {
			result *= i;
		}
	
		//Checks if the for loop result is the same as the expected answer
		assertTrue(answer == result);
		
	}//end Test()

}//end Test4
