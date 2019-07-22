package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test19 {

	@Test
	void test() {
		
		//Creates an int Array with numbers 1-10
		//Creates variables to store the sum of the even numbers and the odd numbers
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int evenSum = 0;
		int oddSum = 0;

		//Uses an enhanced for loop to cycle through the Array
		//Separately sums the even and odd numbers using modulus
		for(int y : nums) {
			if(y % 2 == 0) {
				evenSum += y;
			}else {
				oddSum += y;
			}
		}
		
		//Checks if the tested sums are the same as the expected sums
		assertTrue(evenSum == 30);
		assertTrue(oddSum == 25);
		
	}//end test()

}//end Test19
