package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import question11.TwoFloats;

class Test11 {

	//Imports a float from a different package and class
	float test = TwoFloats.float1();
	
	@Test
	void test() {
		//Tests if the imported float has the same expected value
		assertEquals(38, test);
		
	}//end test()

}//end Test11
