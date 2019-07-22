/**
 * 
 */
package question17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class InterestTest {

	/**
	 * Test method for {@link question17.Interest#calculateInterest()}.
	 */
	@Test
	void testCalculateInterest() {
		double principle = 5100;
		double rate= 6.7 / 100;
		int time = 5;
		double interest = (principle * rate * time);
		
		assertEquals((principle * rate * time), interest);
	}
	
	@Test
	void testParser() {
		String rate = "6.7";
		double actual = Double.parseDouble(rate);
		assertEquals(6.7, actual);
	}

}
