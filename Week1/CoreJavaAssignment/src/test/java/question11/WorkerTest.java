/**
 * 
 */
package question11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import question11.helper.Register;

/**
 * @author MajorKey
 *
 */
class WorkerTest {

	private Register access = new Register();
	/**
	 * Test method for {@link question11.Worker#takeFromRegister(float)}.
	 */
	@Test
	void testTakeFromRegister() {
		float amount = 30.0f;
		access.setChangeNeeded(amount);
		float expected = 70.0f;
		float actual = access.getInRegister() - access.getChangeNeeded();
		assertEquals(expected, actual);
	}

}
