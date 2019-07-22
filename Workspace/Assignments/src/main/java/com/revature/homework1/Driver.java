package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import packA1.FloatNumber;


public class Driver {

	public static void main(String[] args) {
		//Assignment1
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		System.out.println(Arrays.toString( Assignment1.myMethod(arr)));
		
		//Assignment 2
		
		int[] fibNumber = new int[25];
		Assignment2.fibMethod(fibNumber);
		
		//Assignment3
		String word = "word";
		
		System.out.println(Assignment3.reverseStringMethod(word));
		
		//Assignment4
		System.out.println(Assignment4.factorialCheck(5));
		
		//Assignment5
		String str = "abracadabra";
		int idx = 4;
		System.out.println(Assignment5.substringMethod(str, idx));
		
		//Assignment 6
		int num1 = 123;
		Assignment6.evenCheck(num1);
		
		//Assignment 7
		Assignment7.myNewMethod();
		
		//Assignment8
		System.out.println(Assignment8.sortArrays());
		
		//Assignment9
		System.out.println(Assignment9.primeNumberCheck());
		
		//Assignment10
		int i = 100;
		int j = 1;
		System.out.println( Assignment10.minCheck(i,j));
		
		//Assignment11
		FloatNumber f1 = new FloatNumber();
		
		System.out.println("Number is" + f1.num1);
		
		System.out.println("Number is" + f1.num2);

		//Assignment12
		System.out.println("Assignment 12***************");
		int[] myArray = new int[100];
		
		
		Assignment12.arrayNumberCheck(myArray);
		
		
		//Asignment13***************************************
		System.out.println("Assignment 13***************");
		Assignment13.makeTriangle();
		
		
		//************************************************
		
		//Assignment14
		Scanner input = new Scanner(System.in);
		System.out.println("Which task do you want to perform (1 , 2,or 3)? ");
		int taskNum = input.nextInt();
		while (taskNum < 1 || taskNum > 3){
			System.out.println("Incorrect choice: Which task do you want to perform (1 , 2,or 3)? )");
			taskNum = input.nextInt();
		}
		
		Assignment14.doTask(taskNum);
		
		//Asignment15
		Assignment15 obj1 = new Assignment15();		
		double num11 = 40;
		double num21 = 2;
		
		System.out.println("Operands are: " + num11 + " and " + num21);
		
		System.out.println("Addition "+ obj1.add(num11, num21));
		System.out.println("Subtraction " + obj1.subtract(num11, num21));
		System.out.println("Multiplication " + obj1.multiply(num11, num21));
		System.out.println("Division " + obj1.divide(num11, num21));
		
		//Assignment16
		
		Assignment16 obj16 = new Assignment16();
		String s;
		try {
			s = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			s = "";
		}
		//

		System.out.println("String char count is: " + obj16.stringMethod(s));
		
		
		
		//********************************
		
		//Assignment17
		double principal;
		double rate;
		double time;
		double interestRate;
		//Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Darrell's Awesome Simple Interest Calculator");
		
		System.out.println("Please enter principal :");
		principal = input.nextDouble();
		
		System.out.println("Please enter interest rate :");
		rate = input.nextDouble();
		
		System.out.println("Please enter time in years:");
		time = input.nextDouble();
		
		interestRate = Assignment17.calculateInterest(principal, time, rate);
		
		System.out.println("Interest equals: " + interestRate + " dollars");
		
		//Assignment 18
		
		Assignment18A obj100 = new Assignment18A();
		String test = "thats what she said";
		String test2 = "120";
		
		System.out.println("Convert to uppercase: " + obj100.convertToUpperCase(test));
		System.out.println("Test for upper case: " + obj100.testAllUpperCase(test));
		
		System.out.println("Return an integer plus 10: " + obj100.returnAnInt(test2));
		//Assignment 19
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Assignment9 obj9 = new Assignment9();

		for (int y = 0; y < 10; y++) {
			myList.add(y + 1);
		}

		System.out.println("My Array List " + myList);
		System.out.println("add evens " + Assignment19.addEvens(myList));
		System.out.println("add odds "+ Assignment19.addOdds(myList));
		
		
		//********************************************
		
		
		//Assignment 20
		Assignment20File file1 = new Assignment20File();
		
		System.out.println(file1.readMyFile());
			
		
		
		
		
	}
		
		
	}
		
	


