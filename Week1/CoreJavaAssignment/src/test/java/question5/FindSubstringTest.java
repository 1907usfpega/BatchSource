/**
 * 
 */
package question5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
/**
 * @author MajorKey
 *
 */
class FindSubstringTest {

	private FindSubstring find =new FindSubstring();
	/**
	 * Test method for {@link question5.FindSubstring#subString(java.lang.String, int)}.
	 */
	@Test
	void testSubString() {
		String str = "Deonta";
		int idx = 4;
		String expected = "Deon";
		assertEquals(expected, find.subString(str, idx));
	}
	@Test //(expected = StringIndexOutOfBoundsException.class)
	void testSubStringException() {
		String str = "Deonta";
		int idx = 9;
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			find.subString(str, idx);
		});
	}

}
