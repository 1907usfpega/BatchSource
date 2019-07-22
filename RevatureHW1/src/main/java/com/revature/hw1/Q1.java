package com.revature.hw1;

public class Q1 {
	/*
	 * This bubblesort method recursively checks for whether the first value is greater than the second value,
	 * and swaps them out if so. When there are no swaps, it completes the sort.
	 * AUTHOR: redc
	 */

	public static int[] bubbleSort(int[] a)
	{
		int[] result = a;
		for (int i : a)
		{
			int first = a[i];
			int second = a[i+1];
			if (first <= second)
			{
				result[i] = first;
				result[i+1] = second;
			//	System.out.println(result[i] + " < " + result[i+1]);
			}
			else
			{
				result[i] = second;
				result[i+1] = first;
			//	System.out.println(result[i] + " > " + result[i+1]);

				bubbleSort(result);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
