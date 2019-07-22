package com.revature.homework1;

public class Assignment1 {
	public static int[] myMethod(int[] newArr) {
		int temp = 0;
		for (int i = 0; i < newArr.length - 1; i++) {
			for (int j = 0; j < newArr.length - i - 1; j++) {
				if (newArr[j] > newArr[j + 1]) {
					temp = newArr[j];
					newArr[j] = newArr[j + 1];
					newArr[j + 1] = temp;
				}

			}

		}
		return newArr;
	}

}
