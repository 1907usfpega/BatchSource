package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test14 {

	@Test
	void test() {
		
		//Creates an int to test the switch case
		int test = 3;
		
		//Tests the switch so that only the correct case will cause a pass
		switch(test) {
		case 1:
			fail();
			break;
		case 2:
			fail();
			break;
		case 3:
			assertEquals(3, test);
			break;
		}
		
	}//end Test()

}//end Test14
