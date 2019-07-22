package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test12 {

	//Creates a small int Array with numbers 1-10
	int[] test = {1,2,3,4,5,6,7,8,9,10};
	int[] result = new int[5];
	int counter = 0;
	
	@Test
	void test() {
		
		//Uses a for loop to read Array and store all even numbers in a separate Array
		for(int data : test){
			if(data % 2 == 0) {
				result[counter] = data;
				counter++;
			}
		}
		
		//Tests to make sure only even made it into the int Array
		//Checks the first and last number
		assertEquals(2,result[0]);
		assertEquals(10,result[4]);
		
		
	}//end test()

}//end Test12
