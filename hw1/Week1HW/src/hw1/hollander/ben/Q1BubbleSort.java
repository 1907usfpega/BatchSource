package hw1.hollander.ben;

public class Q1BubbleSort {
	public static int[] q1(int [] arr) {
		//int [] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int n = arr.length;
			for (int i=0; i<n-2; i++) {
				for (int j=0; j<n-i-1; j++) { //nested loop to make sure everything is sorted
					//don't sort extra n-i
					// i-1, stay in bounds
					if (arr[j] > arr[j+1]) {
						int temp = arr[j]; //store greater number in temp
						arr[j] = arr[j+1]; //move greater number to the right
						arr[j+1] = temp; //move lower number to the left
					}
					
				}
			}
		
		for(int i:arr) {
			System.out.print(i);
		}
		return arr;
	//COMPLETED
	}
}