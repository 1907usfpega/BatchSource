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
	public static String question18String = "somestRring"; // note, that the number-string is given in the Questions18
															// file

	public static void main(String[] args) {

		System.out.println("Did you know, just writing \"syso\" has the same result as \"sysout\"? I just saved you a quarter of a second for every syso! \nQuestion1, bubblesort, starts here: ");
		  Question1.doTask(question1Ints); // bubblesort // 
		  System.out.println("Question2, fibos, from here:");
		  Question2.doTask(); //fibos // 

		  System.out.println("Question3, String-reversal, from here:");
		  System.out.println(Question3.doTask("Opera")); // Stringreversal //
		  System.out.println("Question4, factorial, from here:");
		  System.out.println(Question4.doTask(question4Int)); // factorial //
		  System.out.println("Question5, substringless substrings, from here:");
		  System.out.println(Question5.doTask(question5String, question5Int)); //
		  System.out.println("Question6, evenNumberChecker, next line:");
		  System.out.println(question6Int+"'s evenness is "+Question6.doTask(question6Int)); // 
		  System.out.println("Question7, employeesorting, next line:");
		  Question7.doTask(); //
		  System.out.println("Question8, paliFinder, next line:");
		  System.out.println(Question8.doTask().toString()); //
		  System.out.println("Behold the sight of great question 9, primeNumberFinder");
		  Question9.doTask(); 
		  System.out.println("Here is Question10 for you, returning the smalled of 2 ints, with the ternary operator.");
		  System.out.println(Question10.doTask(question2Ints[0],
		  question2Ints[1])); // //min w/ ternary 
		  System.out.println("Accessing variables from different classes is Question11's speciality! Here you go:");
		  Question11.doTask();
		  System.out.println("Question12, enhanced For-loop to print out all even numbers ahead:");
		  Question12.doTask(); 
		  System.out.println("010101010101 pyramid is Question13:");
		  Question13.doTask();
		  System.out.println("Question14 will operate 3 times, based on a value in a switch: This is time one");
		  Question14.doTask(1);
		  System.out.println("Q14 take two");
		  Question14.doTask(2);
		  System.out.println("Take three of Q14:");
		  Question14.doTask(3); 
		  System.out.println("Question15, calculating two ints two times below:");
		  Question15 calculator = new Question15(); calculator.doTask();
		  System.out.println("Giving you either the length of your inserted String, or 0 if you did not enter one");
		  try{Question16.doTask(args[0]);}catch(ArrayIndexOutOfBoundsException e) {
		  Question16.doTask(""); }
		  System.out.println("Follow the commands for Question17:");
		  Question17.doTask();
		  System.out.println("Question 18 gives out if a given String contains uppercase, prints out that string converted to Lowercase & casts another String to an int");
		  Question18 stringFun = new Question18();
		  System.out.println(stringFun.containsUppercase(question18String));
		  System.out.println(stringFun.convertLowercase(question18String));
		  try{System.out.println(stringFun.toInt("123213"));}catch(
		  NumberFormatException e) {System.out.println("nonono, enter numbers!");}
		  System.out.println("Question19, having a good prime algorythm included, gives you a few information on an Array from 1 to 10");
		  Question19.doTask(); 
		  System.out.println("Question20 reads a File and prints out the information in that File to the console. Right ahead:");
		  Question20.doTask();
		  }
}
