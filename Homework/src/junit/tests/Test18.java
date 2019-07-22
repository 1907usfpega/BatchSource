package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test18 {

	@Test
	void test() {
		//Tests the toUpperCase() method in TestAbstraction class
		String lower = "music";
		String upper = "MUSIC";
		
		//Checks if the changed String is the same as the already uppercase String
		assertEquals(upper, lower.toUpperCase());
		
	}//end test()

}//end Test18
