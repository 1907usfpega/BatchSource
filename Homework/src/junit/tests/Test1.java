package junit.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import homework1.Problem1;

class Test1 {

	int[] notSorted = {1,0,5,6,3,2,3,7,9,8,4};
	int[] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};

	@Test
	void test() {
		//Calls the method in Problem1 to sort the array
		int[] testMethod = Problem1.bubbleSort(notSorted);
		
		//Checks if the tested array is now the same as the sorted array
		Assert.assertArrayEquals(sorted, testMethod);
	
	}//end test()
	
}//end Test1 class