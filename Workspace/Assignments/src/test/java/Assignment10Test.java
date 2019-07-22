import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment10;

class Assignment10Test {

	@Test
	void test() {
		int i = 2;
		int j= 300000;
		assertEquals(2, Assignment10.minCheck(i,j));
	}

}
