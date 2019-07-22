package questions;

public class Q12 {

	public static void q12(int n) {
		int[] myArray = new int[n];
		// populate the array
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i + 1;
		} // end for
		for (int x : myArray) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
			/*
			 * if(x%20 == 0) { System.out.println(); }//end if
			 */
		} // end foreach
		System.out.println();
	}// end q12
}// end Q12
