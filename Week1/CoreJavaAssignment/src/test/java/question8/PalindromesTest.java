/**
 * 
 */
package question8;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class PalindromesTest {

	private Palindromes p = new Palindromes();
	private ArrayList<String> list = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic","radar", "jimmy", "kayak", "john","refer", "billy", "did"));
	/**
	 * Test method for {@link question8.Palindromes#isPalindrome(java.lang.String)}.
	 */
	@Test
	void testIsPalindrome() {
		String str = "rapar";
		boolean expected = true;
		assertEquals(expected, p.isPalindrome(str));
	}

	/**
	 * Test method for {@link question8.Palindromes#getPalindromes(java.util.ArrayList)}.
	 */
	@Test
	void testGetPalindromes() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		assertEquals(expected, p.getPalindromes(list));
	}

}
