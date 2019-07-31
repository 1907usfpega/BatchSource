/**
 * 
 */
package question2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class FibonacciNumbersTest {

	private FibonacciNumbers fib = new FibonacciNumbers();
	/**
	 * Test method for {@link question2.FibonacciNumbers#getFibSeq()}.
	 */
	@Test
	void testGetFibSeq() {
		int [] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		assertArrayEquals(expected, fib.getFibSeq());
	}

	/**
	 * Test method for {@link question2.FibonacciNumbers#fibSeq(int[], int)}.
	 */
	@Test
	void testFibSeq() {
		int expected = 1;
		int [] arr = {0,1};
		assertEquals(expected,fib.fibSeq(arr, 2));
	}

	/**
	 * Test method for {@link question2.FibonacciNumbers#printFib(int[])}.
	 */
	@Test
	void testPrintFib() {
		String expected = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368]";
		int [] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		assertEquals(expected, Arrays.toString(arr));
	}

}
