import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment17;

class Assignment17Test {

	@Test
	void test() {
		double p = 1000;
		double t = 10;
		double r = 1;
		double expected = 100.0;
				
		assertEquals(expected, Assignment17.calculateInterest(p, t, r));
	}

}
