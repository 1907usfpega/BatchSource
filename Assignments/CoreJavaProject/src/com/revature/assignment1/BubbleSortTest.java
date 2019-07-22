package com.revature.assignment1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class BubbleSortTest {

	BubbleSort bubbleSort = new BubbleSort();
	@BeforeAll
	static void beforeAllofem() {
		System.out.println("JUnit Test For BubbleSort");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+
	info.getDisplayName());
	}
	
	@Test
	void testSort() {
		int [] testArray = {  1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] sortedArray = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		int [] sortedTest = bubbleSort.Sort(testArray);
		assertArrayEquals(sortedArray, sortedTest);
	}
}
