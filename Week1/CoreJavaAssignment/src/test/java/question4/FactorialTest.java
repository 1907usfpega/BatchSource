/**
 * 
 */
package question4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class FactorialTest {

	private Factorial fac = new Factorial();
	/**
	 * Test method for {@link question4.Factorial#factorial(int)}.
	 */
	@Test
	void testFactorial() {
		int n = 6;
		int expected = 720;
		assertEquals(expected, fac.factorial(n));
	}

}
