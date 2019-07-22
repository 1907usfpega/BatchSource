import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment9;

class Assignment9Test {

	@Test
	void test() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
		assertEquals(expected , Assignment9.primeNumberCheck());
	}

}
