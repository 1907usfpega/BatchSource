/**
 * 
 */
package question9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class PrimeNumbersTest {

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private PrimeNumbers p = new PrimeNumbers();

	@BeforeAll
	static void init() {
		for (int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
		// System.out.println("Before all");
	}

	/**
	 * Test method for
	 * {@link question9.PrimeNumbers#primeNums(java.util.ArrayList)}.
	 */
	@Test
	void testPrimeNums() {
		Integer[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97 };
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(arr));

		assertEquals(expected, p.primeNums(list));
	}

}
