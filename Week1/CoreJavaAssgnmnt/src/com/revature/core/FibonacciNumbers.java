/**
 * formula:
 *  fib[n] = fib[n-1] + fib[n-2]
 */
package com.revature.core;

import java.util.Arrays;

/**
 * @author MajorKey
 *Question 2
 */
public class FibonacciNumbers {

	public int [] getFibSeq() {
		int [] arr = new int[25];
		
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = fibSeq(arr, i);
		}
		
		return arr;
	}
	
	public int fibSeq (int [] arr, int index) {
		if(index == 0) {
			return 0;
		}
		else if(index == 1) {
			return 1;
		}
		else {
			return (arr[index - 1] + arr[index - 2]);
		}
	}
	public void printFib(int [] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
