/**
 * 
 */
package question1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class BubbleSortTest {
	private BubbleSort bubble = new BubbleSort();

	/**
	 * Test method for {@link question1.BubbleSortTest#sort(int[])}.
	 */
	@Test
	void testSort() {
		int [] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int [] actual = bubble.sort(arr);
		Assertions.assertArrayEquals(sorted, actual);
	}

	/**
	 * Test method for {@link question1.BubbleSortTest#printArray(int[])}.
	 */
	@Test
	void testPrintArray() {
		int [] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		String expected = "[0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9]";
		
		assertEquals(expected, Arrays.toString(sorted));
	}

}
