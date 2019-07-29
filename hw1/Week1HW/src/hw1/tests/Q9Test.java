package hw1.tests;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Q9Test {

	@Test
	void q9Test() {
		/*2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 
		* 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,97
		*/
		int [] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,97};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		for(int i:primes) {expected.add(i);} //build expected ArrayList
		ArrayList<Integer> actual = hw1.hollander.ben.Q9Primes.q9(100);
		
		boolean check = expected.equals(actual);
		assertEquals(true, check);
	}
}
