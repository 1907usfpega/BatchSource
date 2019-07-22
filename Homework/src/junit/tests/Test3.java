package junit.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Test3 {

	//Creates Strings to test the method
	String reverseTest = "hello";
	String successReverse = "olleh";
	String result = "";
	
	@Test
	void test() {
		//Uses the same for loop found in Problem3
		for(int i = reverseTest.length()-1; i >= 0; i--) {
			result += reverseTest.charAt(i);
		}
		
		//Checks if the reverse String is the same as the expected reversed String
		Assert.assertEquals(successReverse, result);
		
	}//end test()

}//end Test3 class
