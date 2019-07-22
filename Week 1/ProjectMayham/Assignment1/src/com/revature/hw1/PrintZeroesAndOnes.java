package com.revature.hw1;

public class PrintZeroesAndOnes {

	public static String print() {
		String output = "";
		String finalOutput = "";
		for (int i = 0; i < 4; i++) {
			if (i % 3 == 0) {
				output = "0 " + output;
			} else if (i % 3 == 1) {
				output = "1 " + output;
			} else if (i % 3 == 2) {
				output = output + "1";
			}
			if (i == 0) {
				finalOutput = output;
			} else {
				finalOutput = finalOutput + "\n" + output;
			}
//			System.out.println(output);
		}
		return finalOutput;
	}
}
