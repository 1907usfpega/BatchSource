/**
 * 
 */
package question15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class OperandsTest {

	private Operands op = new Operands();
	/**
	 * Test method for {@link question15.Operands#addition(int, int)}.
	 */
	@Test
	void testAddition() {
		int a,b;
		a = 5;
		b = 3;
		assertEquals((a+b),op.addition(a, b));
	}

	/**
	 * Test method for {@link question15.Operands#subtraction(int, int)}.
	 */
	@Test
	void testSubtraction() {
		int a,b;
		a = 5;
		b = 3;
		assertEquals((a-b),op.subtraction(a, b));
	}

	/**
	 * Test method for {@link question15.Operands#multiplication(int, int)}.
	 */
	@Test
	void testMultiplication() {
		int a,b;
		a = 5;
		b = 3;
		assertEquals((a*b),op.multiplication(a, b));
	}

	/**
	 * Test method for {@link question15.Operands#division(int, int)}.
	 */
	@Test
	void testDivision() {
		int a,b;
		a = 5;
		b = 3;
		assertEquals((a/b),op.division(a, b));
	}

}
