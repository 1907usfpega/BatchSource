/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 12
 */
public class EvenNumbers {

	public void printEven(int [] nums) {
		for (int i : nums) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String [] args ) {
		int[] nums = new int [100];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
		EvenNumbers e = new EvenNumbers();
		e.printEven(nums);
	}
}
