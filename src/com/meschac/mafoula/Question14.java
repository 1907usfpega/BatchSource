package com.meschac.mafoula;
import java.time.LocalTime; //Used to print out time
import java.util.Arrays; //Used to print out array on 1 line
import java.lang.Math;
public class Question14 {
	public static String q14(int i) {
		switch(i) {
		/*
		 * Case 1: Find the square root of a number using the Math class method.
		 * Case 2: Display today’s date.
		 * Case 3: Split the following string and store it in a string array.
		 */
		/*
		 * Won't reach break statements because it'll return first
		 */
		case 1:
			System.out.println(Math.sqrt(4));
			return String.valueOf(Math.sqrt(4));
		case 2:
			System.out.println(LocalTime.now().withNano(0)); //No ms
			return LocalTime.now().withNano(0).toString();
		case 3:
			String str = "I am learning Core Java";
			String[] split = str.split("", str.length());
			System.out.println(Arrays.toString(split));
			return Arrays.toString(split);
		default:
			System.out.println("DefaultCase");
			return "DefaultCase";
		}
	}

}
