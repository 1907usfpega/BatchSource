package com.revature.questions;

public class Question5 {
	public static String doTask(String str, int id) {		
		char[] chars = str.toCharArray();
		str = "";
		id = (id < chars.length) ? id : chars.length;		//if the given id is bigger than the inserted string length, it will just give out the string. Else the string up until the index id
		for (int i = 0; i < id; i++) {
			str += "" + chars[i];
		}
		System.out.println(str);
		return str;
	}
}
