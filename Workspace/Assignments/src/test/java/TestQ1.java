import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.revature.homework1.Assignment1;
class TestQ1 {

	@Test
	void testMyMethod() {
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(expected, Assignment1.myMethod(arr));
		
	}
	
	

}
