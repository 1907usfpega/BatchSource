package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test10 {

	//Uses ternary operator to find the lowest value
	@SuppressWarnings("unused")
	double min = (5 < 6) ? 5 : 6;
	
	//Tests to make sure min equals the lowest of the two numbers
	@Test
	void test() {
		assertEquals(5, min);
		
	}//end test()

}//end Test10 class
