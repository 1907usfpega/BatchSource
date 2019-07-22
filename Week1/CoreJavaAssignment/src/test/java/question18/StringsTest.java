/**
 * 
 */
package question18;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class StringsTest {

	private Strings test = new Strings();
	/**
	 * Test method for {@link question18.StringsTest#anyUppercase(java.lang.String)}.
	 */
	@Test
	void testAnyUppercase() {
		String name = "DeOntA";
		
		assertEquals(true, test.anyUppercase(name));
	}

	/**
	 * Test method for {@link question18.StringsTest#toUppercase(java.lang.String)}.
	 */
	@Test
	void testToUppercase() {
		String name = "deonta";
		String expected = "DEONTA";
		
		assertEquals(expected, test.toUppercase(name));
	}

	/**
	 * Test method for {@link question18.StringsTest#addTen(java.lang.String)}.
	 */
	@Test
	void testAddTen() {
		String num = "56";
		int nums = 56;
		
		assertEquals((nums+10), (Integer.parseInt(num) + 10));
	}

}
