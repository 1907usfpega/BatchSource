package com.revature.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question1;

class Question1Test {
	public int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
	public int[] sorted = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8 };

	@Test
	void testNotSorted() {
		Question1 q1 = new Question1();
		for(int i = 0; i < arr.length - 1; i++) {
			assertEquals(arr[i], q1.arr[i]);
		}
	}
	
	@Test
	void testSorted() {
		arr = Question1.bubbleSort(arr);
		for(int i = 0; i < arr.length - 1; i++) {
			assertEquals(sorted[i], arr[i]);
		}
	}

}
