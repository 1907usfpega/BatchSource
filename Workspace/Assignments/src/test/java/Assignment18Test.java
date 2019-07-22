import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment18A;

class Assignment18Test {

	@Test
	void test() {
		Assignment18A obj18 = new Assignment18A();
		
		String s = "hey";
		assertEquals("HEY", obj18.convertToUpperCase(s));
	}

}
