/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 13
 */
public class Triangle {
	
	public void makeTriangle() {
		int row = 1;
		int startingNum = 0;
		
		while(row < 5) {
			int num = startingNum;
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
			
			//need to look at below logic 
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

	public static void main(String [] args) {
		Triangle t = new Triangle();
		t.makeTriangle();
	}
}
