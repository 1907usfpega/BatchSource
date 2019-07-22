package com.revature.questions;

public class Question12 {

	public static int[] ints = new int[100];
	public static int[] wholeInts = new int[50];
// Fills ints and wholeInts, prints and returns wholeInts
	public static int[] doTask() {
		for (int i = 0; i < ints.length; i++) {
			ints[i] = i + 1;
		}
		for (int i : ints) {
			if (i % 2 == 0) {
				wholeInts[(i - 1) / 2] = i;
			}
		}
		for (int i : wholeInts) {
			System.out.println("whole number: " + i);
			
		}
		return wholeInts;
	}
}
