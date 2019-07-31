/**
 * 
 */
package question12;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class EvenNumbersTest {

	static int[] nums = new int [100];
	
	@BeforeAll
	static void init() {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
	}
	/**
	 * Test method for {@link question12.EvenNumbersTest#printEven(int[])}.
	 */
	@Test
	void testPrintEven() {
		int [] evens = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100};
		//ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(evens));
		//ArrayList<Integer> actual = new ArrayList<Integer>();
		int [] actual = new int[evens.length];
		
		int j = 0;
		for (int i= 0; i < nums.length; i++) {
			if(nums[i] % 2 == 0) {
				actual[j] = nums[i];
				j++;
			}
		}
		
		assertArrayEquals(evens,actual);
		
	}

}
