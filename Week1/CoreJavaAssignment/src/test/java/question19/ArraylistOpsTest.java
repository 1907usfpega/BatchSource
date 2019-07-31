/**
 * 
 */
package question19;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class ArraylistOpsTest {

	static ArrayList<Integer> list = new ArrayList<Integer> ();
	ArraylistOps op = new ArraylistOps();
	
	@BeforeAll
	static void init() {
		for (int i = 0; i < 10; i++) {
			list.add(new Integer(i+1));
		}
	}
	/**
	 * Test method for {@link question19.ArraylistOps#addEven(java.util.ArrayList)}.
	 */
	@Test
	void testAddEven() {
		int expected = 2 +4 +6 +8 +10;
		assertEquals(expected, op.addEven(list));
	}

	/**
	 * Test method for {@link question19.ArraylistOps#addOdd(java.util.ArrayList)}.
	 */
	@Test
	void testAddOdd() {
		int expected = 1 +3 +5 + 7 +9;
		assertEquals(expected, op.addOdd(list));
	}

}
