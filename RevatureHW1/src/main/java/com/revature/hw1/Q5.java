package com.revature.hw1;

public class Q5 {

	//Q5: Substring that checks String up to int idx-1. No use of substring methods.
		//in String libraries. Maybe concat?
		public static String indexSubstring(String string, int idx)
		{
			CharSequence seq = string.subSequence(0, idx);
			String substring = seq.toString();
			return substring;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
