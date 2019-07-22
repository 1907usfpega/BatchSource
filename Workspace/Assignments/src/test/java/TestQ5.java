import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment5;
class TestQ5 {

	@Test
	void testEvenCheck() {
		String str = "abracadabra";
		int idx = 4;
		String expected = "abra";
	
		assertEquals(expected, Assignment5.substringMethod(str, idx));
	}

}