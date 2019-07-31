/**
 * 
 */
package question16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import question16.CountCharacters;

/**
 * @author MajorKey
 *
 */
class CountCharactersTest {

	private CountCharacters cha = new CountCharacters();
	/**
	 * Test method for {@link question16.CountCharacters#count(java.lang.String)}.
	 */
	@Test
	void testCount() {
		String name = "Deonta";
		assertEquals(6, cha.count(name));
	}

}
