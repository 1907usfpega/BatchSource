//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment15;

class Assignment15Test {

	@Test
	void test() {
		Assignment15 obj1 = new Assignment15();		
		double num11 = 40;
		double num21 = 2;
		
		assertEquals(42, obj1.add(num11, num21));
	}

}
