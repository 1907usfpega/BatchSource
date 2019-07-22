package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Question2Test {

	@Test
	void test() {
	
			ArrayList<Integer> expected = new ArrayList<Integer>();
			ArrayList<Integer> actual = new ArrayList<Integer>();
			
			expected.add(0); //Add fib1
			expected.add(1); //Add fib2
			expected.add(1); //Add fib3
			expected.add(2); //Add fib4
			expected.add(3); //Add fib5
			expected.add(5); //Add fib6
			expected.add(8); //Add fib7
			
			actual =com.meschac.mafoula.Question2.q2(7);
			assertEquals(expected, actual);
	}

}
