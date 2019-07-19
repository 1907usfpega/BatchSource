package com.revature.questions;

import java.util.Map;

public class Question3 {

	public static String doTask(String str) {

		for (int i = 0; i < str.toCharArray().length - i; i++) {
			System.out.println(i + "  " + str);
			str += str.toCharArray()[str.toCharArray().length - i*2 - 1];
		}
		
		return str.substring(str.toCharArray().length / 2);
	}
}
