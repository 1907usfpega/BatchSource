package hw1.hollander.ben;

import java.util.ArrayList;

public class Q12 {
	public static ArrayList<Integer> q12() {
		int[] arr = new int[100]; //set array size to 100
		ArrayList<Integer> returnValues = new ArrayList<Integer>();
		for (int i=1; i<=100; i++) {
			arr[i-1] = i;
		}
		for (int i:arr) {
			if (i%2==0) {
				System.out.println(i);
				returnValues.add(i);
			}
		}
		return returnValues;
		}
}
//COMPLETED
//How do i redirect the output stream for JUnit