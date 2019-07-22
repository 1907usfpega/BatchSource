package questions;

public class Q13 {
	public static void triangle(int rows) {
		int counter = 0;
		for (int i = 1; i < rows + 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(counter++ % 2 + " ");
			} // end for j
			System.out.println();
		} // end for i
	}// end triangle
}// end Q13
