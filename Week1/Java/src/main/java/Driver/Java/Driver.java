package Driver.Java;


import Assignment.Java.JavaQ2Fibonacci;
import Assignment.Java.JavaQ1BubbleSort;

public class Driver {

	static void printArray(int arr[], int size)
	{
		int i;
		for (i=0; i< size; i++)
			System.out.println(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[]= {0,1,2,1,6};
		JavaQ1BubbleSort s = new JavaQ1BubbleSort();
		s.bubbleSort(arr);
		System.out.println("After Sort");
		for(int i = 0; i <arr.length; i++ ) {
			System.out.println(arr[i] + " ");
		}
	}

}
