/**
 * 
 */
package question10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class TernaryOperatorsTest {

	private TernaryOperators t = new TernaryOperators();
	/**
	 * Test method for {@link question10.TernaryOperators#minValue(int, int)}.
	 */
	@Test
	void testMinValue() {
		int a,b;
		a= 50;
		b= 4;
		assertEquals(b, t.minValue(a, b));
	}

}
