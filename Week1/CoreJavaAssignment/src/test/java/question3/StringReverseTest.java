/**
 * 
 */
package question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class StringReverseTest {

	private StringReverse reverse = new StringReverse();
	/**
	 * Test method for {@link question3.StringReverse#reverseStr(java.lang.String)}.
	 */
	@Test
	void testReverseStr() {
		String name = "Deonta";
		String expected = "atnoeD";
		assertEquals(expected, reverse.reverseStr(name));
	}

}
