package com.revature.driver;

import java.util.Arrays;

import com.revature.questions.*;

public class Driver {
	private static int[] question1Ints = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
	public static int[] question2Ints = { 10, 20 };
	public static int question4Int = 9;
	public static String question5String = "string";
	public static int question5Int = 5;
	public static int question6Int = 11283;
	public static float question11Float1 = 1322.2f;
	public static float question11Float2 = 192.32f;

	public static void main(String[] args) {

		Question1.doTask(question1Ints); // bubblesort //
		System.out.println(Arrays.toString(Question2.doTask())); // fibos //
		System.out.println(Question3.doTask("Opera")); // Stringreversal //
		System.out.println(Question4.doTask(question4Int)); // factorial //
		System.out.println(Question5.doTask(question5String, question5Int)); //
		System.out.println(Question6.doTask(question6Int)); // 
		Question7.doTask(); //
		System.out.println(Question8.doTask().toString()); //

		Question9.doTask();
		System.out.println(Question10.doTask(question2Ints[0], question2Ints[1])); // //min w/ ternary
		Question11.doTask();
		Question12.doTask();
		Question13.doTask();
		Question14.doTask(1);Question14.doTask(2);Question14.doTask(3);
		Question15 calculator = new Question15(); calculator.doTask();
		try{Question16.doTask(args[0]);}catch(ArrayIndexOutOfBoundsException e) {
			Question16.doTask("");
		}
		
	}
}
