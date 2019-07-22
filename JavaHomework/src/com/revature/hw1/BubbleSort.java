package com.revature.hw1;

//public class BubbleSort {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

//}
//Bubble sort
//import java.util.*;

public class BubbleSort {

public static void main(String[] args) {
 // Initialize arr
 int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7,9,8,4 };
 System.out.print("Initial Array : ");
 printArray(arr);
 bubbleSort(arr);
}
public static void printArray(int[] arr) {
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

   System.out.print("After pass " + i + "  : ");
   //Printing array after pass
   printArray(arr);
 }
}
}