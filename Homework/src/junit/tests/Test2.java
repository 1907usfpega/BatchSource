package junit.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import homework1.Problem2;

class Test2 {

	String fibResult = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 ";
	
	@Test
	void test() {
		//Calls the method in Problem2 to create a string with first 25 numbers of the fibonacci sequence
		String testMethod = Problem2.fibonacci();
		
		//Checks if the tested String is the same as the expected String
		Assert.assertEquals(fibResult, testMethod);
		
	}//end test()

}//end Test2 class
