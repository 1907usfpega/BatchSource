package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Twelve {
	// Prints even number between 1 and n
	public String printEven(int n) {
		int[] a= new int[n];
		for (int i = 1; i <= n; i++) {
			a[i-1]=i;
		}
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i: a) {
			if(i%2==0) {
				b.add(i);
				System.out.print(i+" ");
			}
			
		}
		
		return Arrays.toString(b.toArray());
	}
}
