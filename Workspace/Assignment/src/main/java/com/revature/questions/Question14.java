package com.revature.questions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Question14 {
	public static int number = 27;
	public static String string = "I am learning Core Java";

	public static void doTask(int x) { 			//In different cases of x, different outputs are being created. I don't get the Date myself and refer to the documentation here.
		switch (x) {
		case (1):
			System.out.println("The square-root of " + number + " is " + getSqrt(number));
			break;
		case (2):
			System.out.println(getDate());
			break;
		case (3):
			System.out.println(
					"\"" + string + "\" was now split into \"" + splitString()[0] + "\" - and - \"" + splitString()[1]+ "\"");
		}
	}

	public static double getSqrt(int number) {
		return Math.sqrt(number);
	}

	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String[] splitString() {
		String[] halves = new String[] {string.substring(0, string.length() / 2), string.substring(string.length() / 2, string.length())};
		return halves;
	}
}
