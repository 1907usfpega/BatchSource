package com.revature.hw1;

public class BubbleSort {

	public static String sort() {
		int [] numbers = {1,0,5,6,3,2,3,7,9,8,4};
		
		String output = "Array before sorting: ";

		for (int i = 0; i < numbers.length; i++) {
			output = output + numbers[i];
		}

		
		for (int i = 1; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		output = output + "\nArray after sorting: ";
		
		for(int i = 0; i < numbers.length; i++) {
			output = output + numbers[i];
		}

		return output;
		
	}

}
