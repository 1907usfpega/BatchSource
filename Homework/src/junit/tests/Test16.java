package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test16 {

	@Test
	void test() {
		
		//Tests the .length() functionality in Problem16 method
		String s1 = "Cookies";
		String s2 = "Yum";
		
		//Checks if the tested Strings have the expected length
		assertTrue(s1.length() == 7);
		assertTrue(s2.length() == 3);
		
	}//end test()

}//end Test16
