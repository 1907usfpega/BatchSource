package junit.tests;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Test9 {

	//Creates an ArrayLists to store numbers
	List<Integer> test = new ArrayList<Integer>();

	@Test
	void test() {
		//Adds the numbers 1-100 to the list
		for(int i = 1; i <= 100; i++ ) {
			test.add(i);
		}
		
		//Tests to see if first number is 1 and last number is 100
		//Makes sure all numbers were loaded into the ArrayList
		assertSame(1,test.get(0));
		assertSame(100,test.get(99));

	}//end test()

}//end Test9 class
