/**
 * 
 */
package question14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class SwitchStatementsTest {

	/**
	 * Test method for {@link question14.SwitchStatements#trySwitch(int)}.
	 */
	@Test
	void testFirstTrySwitch() {
		int num = 144;
		
		assertEquals(12.0, Math.sqrt(num));
	}
	@Test
	void testThirdTrySwitch() {
		String str = "I am learning Core Java";
		String [] arrOfStr = str.split(" ");
		String[] expected = {"I","am","learning","Core","Java"};
		
		assertArrayEquals(expected, arrOfStr);
	}

}
