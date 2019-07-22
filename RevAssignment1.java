package com.package1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;



public class RevAssignment1 {
	
	/***********************
	 * QUESTION 1
	 ***********************/
	public static void bubbleSort(int[] arr) {

		if (arr.length < 2) {
			return;
		}

		int tmp;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {  // swap adjacent values if the first one is bigger than the second
					tmp = arr[j];      // save first
					arr[j] = arr[j+1]; // store second in first
					arr[j+1] = tmp;    // put first in second
				}
			}

		}

	}

	/***********************
	 * QUESTION 2
	 ***********************/
	public static void printFib(int max) {
		int count = 0;
		System.out.print("Fibonacci numbers: ");
		while (count < max) {
			System.out.print(fib(count));

			if (count != max-1) System.out.print(", ");
			count++;
		}
	}

	public static int fib(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return fib(index - 2) + fib(index - 1);
		}
	}



	/***********************
	 * QUESTION 3
	 ***********************/
	public static void printReverse(String inputStr) {
		System.out.println("Original string: " + inputStr);
		System.out.print("Reversed string: ");
		for (int i = inputStr.length()-1; i >= 0; i--) {
			System.out.print(inputStr.charAt(i));
		}
	}


	/***********************

	 * QUESTION 4
	 ***********************/
	public static int factorial(int n) {
		if (n == 0 || n == 1) return 1;
		return factorial(n-1) * factorial(n);
	}

	/***********************
	 * QUESTION 5
	 ***********************/
	public static String mySubString(String original, int end) {
		char[] arr = original.toCharArray();
		StringBuilder sb = new StringBuilder(end+1);

		for (int i = 0; i < end; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();
	}


	/***********************
	 * QUESTION 6
	 ***********************/
	public static boolean isEven(int num) {
		if ((num & 1) == 0) { // bitwise AND
			return true;
		} else {
			return false;
		}
	}

	/***********************
	 * QUESTION 7
	 ***********************/




	/***********************
	 * QUESTION 8
	 ***********************/
	public static boolean isPalindrome(String str) {
		int front = 0;
		int back = str.length()-1;
		while (back > front) {
			char fChar = str.charAt(front++);
			char bChar = str.charAt(back++);
			if (fChar != bChar) return false;
		}
		return true;
	}

	public static ArrayList<String> getPalindromes(ArrayList<String> originalList) {
		ArrayList<String> newList = new ArrayList<String>();
		for(String s : originalList) {
			if (isPalindrome(s)) {
				newList.add(s);
			}		
		}
		return newList;
	}



	/***********************
	 * QUESTION 9
	 ***********************/

	public static boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}

		for(int i = 3; i*i <= n; i+=2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> primeChecker() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> newList = new ArrayList<Integer>();

		for (int i = 0; i <= 100; i++) {
			list.add(new Integer(i));
		}

		for (Integer ger : list) {
			if (isPrime(ger)) {
				newList.add(ger);
			}
		}

		return newList;
	}



	/***********************
	 * QUESTION 10
	 ***********************/
	public static int findMin(int a, int b) {
		return (a <= b) ? a : b;
	}


	/***********************
	 * QUESTION 12
	 ***********************/

	public static String returnEvens(int[] inputArray) {
		StringBuilder sb = new StringBuilder();
		for (int i : inputArray) {
			if ((i & 1) == 0) {
				sb.append(i);
			}
		}
		return sb.toString();
	}


	/***********************
	 * QUESTION 13
	 ***********************/



	public static String trianglePrinter() {
		StringBuilder sb = new StringBuilder();
		boolean isZero = true;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i ; i++) {
				sb.append( isZero ? 0 : 1 );
				sb.append(" ");
				isZero = !isZero;

			}
			sb.append("\n");
		}
		return sb.toString();

	}



	/***********************
	 * QUESTION 14
	 ***********************/

	public static void switchCase(int n) {
		switch (n) {
			case(1):
				// display square root of a number
				Random rand = new Random();
				int randomInt = rand.nextInt(1000);

				System.out.println("Here is a number: " + randomInt + "\nHere is it's square root: " + Math.sqrt( (double) randomInt));
				break;
			case(2):
				// display todays date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				System.out.print(sdf.format(new Date()));
				break;
			case(3):
				// split and store in string array "I am learning core java"
				String s = "I am learning Core Java";
				String[] strings = s.split(" ");
				break;
		}
	}


	/***********************
	 * QUESTION 15
	 ***********************/
	


	/***********************
	 * QUESTION 16
	 ***********************/
	public static int numCharactersInFirstArgument(String[] args) {
		return args[0].length();
	}

	/***********************
	 * QUESTION 17
	 ***********************/
	public static double calcInterest(double principal, double rate, int years) {
		return principal * rate * years;
	}

	/***********************
	 * QUESTION 18
	 ***********************/
	

	


	/***********************
	 * QUESTION 19
	 ***********************/
	public static void wtf() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		list.add(new Integer(8));
		list.add(new Integer(9));
		list.add(new Integer(10));

		int evens = 0;
		int odds = 0;
		for (Integer i : list) {
			if ((i.intValue() & 1) == 0) {
				evens += i.intValue();
			} else {
				odds += i.intValue();
			}
		}
		ArrayList<Integer> removeList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (isPrime(list.get(i).intValue())) {
				removeList.add(new Integer(i));
			}
		}
		for (int i = removeList.size()-1; i >= 0; i--) {
			list.remove(removeList.get(i));
		}

		System.out.println("Number of odds: " + odds);
		System.out.println("Number of evens: " + evens);
		System.out.println("Remaining non-primes: ");
		for (Integer i : list) {
			System.out.print(i);
		}
	}

	/***********************
	 * QUESTION 20
	 ***********************/
	

	public static ArrayList<Person> dataNames() {
		ArrayList<Person> list = new ArrayList<Person>();
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File("Data.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Data.txt not found.");
			System.exit(1);
		}
		while(inFile.hasNextLine() && inFile != null) {
			Scanner sc = new Scanner(inFile.nextLine());
			sc.useDelimiter(":");
			list.add(new Person(sc.next(), sc.next(), Integer.parseInt(sc.next()), sc.next()));
		}

		for (Person p : list) {
			System.out.println(p);
		}
		return list;
	}











	public static void main(String[] args) {
		// Q1
		int[] testArray = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Unsorted array: " + Arrays.toString(testArray));
		bubbleSort(testArray);
		System.out.println("BubbleSorted array: " + Arrays.toString(testArray));
		System.out.println();

		// Q2
		printFib(25);
		System.out.println();


		// Q3
		System.out.println();
		printReverse("This is a String!");

		//Q15
		MyInterfaceTester m = new MyInterfaceTester();
        System.out.println("Testing addition, expecting 10\nReceived: " + m.addition(6,4));
        System.out.println("Testing subtraction, expecting 2\nReceived: " + m.subtraction(6,4));

	}





}