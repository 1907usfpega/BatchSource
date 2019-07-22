package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test5 {

	int index = 4;
	String full = "Swimming";
	String test = "";
	
	@Test
	void test() {
		//Uses same for loop found in Problem4 to test
		for(int i = 0; i < index; i++) {
			test += full.charAt(i);
		}
		
		//Creates a String using the actual substring method indexing to the same position
		String sub = full.substring(0, index);
		
		//Checks if the tested String is the same as the expected String
		assertEquals(sub, test);
		
	}//end test()

}//end Test5
