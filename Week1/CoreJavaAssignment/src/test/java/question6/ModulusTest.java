/**
 * 
 */
package question6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class ModulusTest {

	private Modulus mod = new Modulus();
	/**
	 * Test method for {@link question6.Modulus#isEven(int)}.
	 */
	@Test
	void testIsEven() {
		int num = 9;
		boolean expected = false;
		assertEquals(expected, mod.isEven(num));
	}

}
