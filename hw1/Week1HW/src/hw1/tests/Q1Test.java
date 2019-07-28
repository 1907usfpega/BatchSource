package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Q1Test {

	@Test
	void q1Test() {
		int [] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int [] data = {1,0,5,6,3,2,3,7,9,8,4};
		int [] actual = hw1.hollander.ben.Q1BubbleSort.q1(data);
		boolean result = Arrays.equals(expected, actual);
		assertEquals(result, true);
		
	}

}
