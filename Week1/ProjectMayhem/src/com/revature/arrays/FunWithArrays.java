package com.revature.arrays;

public class FunWithArrays {

	public FunWithArrays() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String []args) {
		int s = 7;
		int []myArray = new int[s];
		int []chaos = {23,354,342152,14541,4513};
		System.out.println(myArray[1]);
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 5;
			System.out.println(myArray[i]);
		}
	}

}
