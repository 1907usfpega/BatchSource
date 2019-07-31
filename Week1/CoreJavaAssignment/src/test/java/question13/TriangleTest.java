/**
 * 
 */
package question13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author MajorKey
 *
 */
class TriangleTest {

	@Test
	void testFirstRow() {
		int row = 1;
		int startingNum = 0;
		
		while(row < 5) {
			int num = startingNum;
			if(row == 1)
				assertEquals(0,num);
			for (int i = 0; i < row; i++) {
				System.out.print(num);
				switch(num) {
				case 0: 
					num = 1;
					break;
				case 1:
					num = 0;
					break;
				}
			}
			System.out.println();
			
			row++;
			
			//need to look at below logic but it works
			if(row % 2 == 1) {
				switch(num) {
			  	case 0: 
			  		num = 0; 
			  		break; 
			  	case 1: 
			  		num = 1; 
			  		break;
			  	}
				
				startingNum = num;
			}
			else {
				
				startingNum = num;
			}
		} 
	
	}
	
	@Test
	void testSecondRow() {
		int row = 1;
		int startingNum = 0;
		
		while(row < 5) {
			int num = startingNum;
			if(row == 2)
				assertEquals(1,num);
			for (int i = 0; i < row; i++) {
				System.out.print(num);
				switch(num) {
				case 0: 
					num = 1;
					break;
				case 1:
					num = 0;
					break;
				}
			}
			System.out.println();
			
			row++;
			
			//need to look at below logic but it works
			if(row % 2 == 1) {
				switch(num) {
			  	case 0: 
			  		num = 0; 
			  		break; 
			  	case 1: 
			  		num = 1; 
			  		break;
			  	}
				
				startingNum = num;
			}
			else {
				
				startingNum = num;
			}
		} 
	
	}
	
	@Test
	void testThirdRow() {
		int row = 1;
		int startingNum = 0;
		
		while(row < 5) {
			int num = startingNum;
			if(row == 3)
				assertEquals(1,num);
			for (int i = 0; i < row; i++) {
				System.out.print(num);
				switch(num) {
				case 0: 
					num = 1;
					break;
				case 1:
					num = 0;
					break;
				}
			}
			System.out.println();
			
			row++;
			
			//need to look at below logic but it works
			if(row % 2 == 1) {
				switch(num) {
			  	case 0: 
			  		num = 0; 
			  		break; 
			  	case 1: 
			  		num = 1; 
			  		break;
			  	}
				
				startingNum = num;
			}
			else {
				
				startingNum = num;
			}
		} 
	
	}
	
	@Test
	void testFourthRow() {
		int row = 1;
		int startingNum = 0;
		
		while(row < 5) {
			int num = startingNum;
			if(row == 4)
				assertEquals(0,num);
			for (int i = 0; i < row; i++) {
				System.out.print(num);
				switch(num) {
				case 0: 
					num = 1;
					break;
				case 1:
					num = 0;
					break;
				}
			}
			System.out.println();
			
			row++;
			
			//need to look at below logic but it works
			if(row % 2 == 1) {
				switch(num) {
			  	case 0: 
			  		num = 0; 
			  		break; 
			  	case 1: 
			  		num = 1; 
			  		break;
			  	}
				
				startingNum = num;
			}
			else {
				
				startingNum = num;
			}
		} 
	
	}
}
