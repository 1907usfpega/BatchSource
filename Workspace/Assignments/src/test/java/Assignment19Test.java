import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.homework1.Assignment19;
import com.revature.homework1.Assignment9;

class Assignment19Test {
	ArrayList<Integer> myList = new ArrayList<Integer>();
	Assignment9 obj9 = new Assignment9();


	@Test
	void test() {
		
		for (int i = 0; i < 10; i++) {
			myList.add(i + 1);
		}
		int expected = 30;
		assertEquals(expected, Assignment19.addEvens(myList));
	}
	
	void test2() {
		for (int i = 0; i < 10; i++) {
			myList.add(i + 1);
		}
		int expected = 25;
		assertEquals(expected, Assignment19.addOdds(myList));
	}
	

}
