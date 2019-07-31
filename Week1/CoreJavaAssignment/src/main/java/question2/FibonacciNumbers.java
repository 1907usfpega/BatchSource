/**
 * 
 */
package question2;

import java.util.Arrays;

/**
 * @author Deonta Kilpatrick
 *
 */
public class FibonacciNumbers {

	//stores each fibonacci number in the array
	public int [] getFibSeq() {
		int [] arr = new int[25];
		
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = fibSeq(arr, i);
		}
		
		return arr;
	}
	
	//fib equation is fib[index] = fib[index-1] + fib[index-2]
	//this is a recursive solution to find the next fibonacci number
	//given two base cases index = 0/1
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
