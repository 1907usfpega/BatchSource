package com.revature.questions;
/*Q13. Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.  
	0 
	1 0
	1 0 1
	0 1 0 1

 * */
public class Q13 {
	static int x = 1;

	public static void printTriagle() {

		int lanes = 1;
		while (lanes <= 4) { //loop through the lanes
			for (int i = 0; i < lanes; i++) {//print incrementaly on the same lane
				System.out.print(printNext());
			}
			lanes++;
			System.out.println();
		}

	}

	//decide the next character to print
	static int printNext() {
		if (x == 0) {
			x = 1;
			return 1;
		} else {
			x = 0;
			return 0;
		}
	}
}
