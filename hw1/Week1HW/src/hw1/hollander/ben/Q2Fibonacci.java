package hw1.hollander.ben;

import java.util.ArrayList;

public class Q2Fibonacci{
	public static ArrayList<Integer> q2(int n) {
		int count = 0;
		int a = 0;
		int b = 1;
		int c; //Temporary variable to shift values to a & b
		ArrayList<Integer> fib = new ArrayList<Integer>();
		while (count < n) {
			System.out.println(a);
			fib.add(a);
			c = a + b;
			a = b;
			b = c; 
			count += 1;
		}
		
		return fib;
	}
}
//COMPLETED