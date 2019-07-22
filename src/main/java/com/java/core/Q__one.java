package com.java.core;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q__one {
//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7,9,8,4 };
		System.out.print("Bubble sorting : ");
		displayArray(arr);
		bubbleSort(arr);
		}
		public static void displayArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
		  System.out.print(arr[i] + " ");
		}
		System.out.println();
		}
		static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
		  for (int j = 0; j < arr.length - i - 1; j++) {
		    if (arr[j] > arr[j + 1]) {
		      int temp = arr[j];
		      arr[j] = arr[j + 1];
		      arr[j + 1] = temp;
		    }
		  }
		  System.out.print("After pass " + i + ": ");
		
		  displayArray(arr);
		}
		}
}

