//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.revature.homework1.Assignment6;

class TestQ6 {

	@Test
	void testAssign6() {
		int num1 = 123;
		String expected = "ODD";
		assertEquals(expected, Assignment6.evenCheck(num1));
	}

}
