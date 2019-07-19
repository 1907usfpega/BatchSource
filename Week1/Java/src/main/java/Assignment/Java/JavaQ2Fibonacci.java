package Assignment.Java;

import java.util.Arrays;

public class JavaQ2Fibonacci {
	public static void main(String[] args) {
		int length = 26;
	    long[] series = new long[length];
	    series[0] = 0;
	    series[1] = 1;
	    for (int i = 2; i < length; i++) {
	      series[i] = series[i - 1] + series[i - 2];
	    }
	    System.out.println("25th number is: " );
	    System.out.println(Arrays.toString(series));
	  }
	}
