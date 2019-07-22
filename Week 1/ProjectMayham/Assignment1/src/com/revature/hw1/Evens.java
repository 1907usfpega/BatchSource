package com.revature.hw1;

public class Evens {

	public static String evens() {
		String output = "";
		int [] numbers = new int [100];
		for (int i = 0; i < 100; i++) {
			numbers[i] = i+1;
		}
		for(int i : numbers) {
			if (IsEven.isEven(i)) {
				output = output + i + ",";
//				System.out.println(i);
			}
		}
	
		output = Substring.substr(output, output.length()-1);
		return output;
	}
	
}
