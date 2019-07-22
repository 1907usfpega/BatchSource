package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q1;

class TestQ1 {

	@Test
	void testBubbleSort() {
		int[] in = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] out = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(out,Q1.bubbleSort(in)); 
	}

}
