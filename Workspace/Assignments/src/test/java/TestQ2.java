import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment2;

class TestQ2 {

	@Test
	void testFibMethod() {
		
		int[] fibNumber = new int[25];
		
		
		int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		assertArrayEquals(expected, Assignment2.fibMethod(fibNumber)) ;
	}
	
	

}
