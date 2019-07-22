package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test6 {

	int num = 4;
	int evenNum;

	boolean numTest;
	boolean modTest;
	
	@Test
	void eventest() {
		//Checks if a number is even comparing it against the modulus test
		evenNum /= 2;
		if((int)evenNum == evenNum) {
			numTest = true;
		}
		
		if(evenNum % 2 == 0) {
			modTest = true;
		}
		//Checks if the tested boolean is the same as the expected boolean
		assertSame(modTest, numTest);
		
	}//end evenTest()

}//end Test6
