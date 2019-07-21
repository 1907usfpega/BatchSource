package com.revature.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Question20 {
	public static String myData = "Data.txt";

	// used from class notes
	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File(myData);
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int b;
		try {
			while ((b = is.read()) != -1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.toString();
	}

	// read from Data.txt
	// return String in format
	// Name: first last
	// Age: age
	// State: state
	public static String formatFile() {
		Question20 q20 = new Question20();
		String data = q20.readInputStreamContents();
		String[] split = data.split("\n|:");

		StringBuilder formated = new StringBuilder();
		int count = 0;
		for (String s : split) {
			if (count == 0) {
				formated.append("\nName: " + s + " ");
			} else if (count == 1) {
				formated.append(s + "\n");
			} else if (count == 2) {
				formated.append("Age: " + s + "\n");
			} else if (count == 3) {
				formated.append("State: " + s + "\n");
			}
			count++;
			if (count == 4) {
				count = 0;
			}
		}
		return formated.toString();
	}

	public static void prompt() {
		System.out.println("Question 20:\nSolution:");
	}
}
