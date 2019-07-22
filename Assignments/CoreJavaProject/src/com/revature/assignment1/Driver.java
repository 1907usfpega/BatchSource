package com.revature.assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.revature.outsidepackage.OutsideClass;

/**
 * Assignment #1
 * 
 * @author Kyle Kolstad
 *
 *         Driver class with main method
 */
public class Driver {

	private static final String file = "Data.txt";

	public static void main(String[] args) {

		/**
		 * Question #1 BubbleSort.java
		 */
		
		
		  int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 }; BubbleSort sort = new
		  BubbleSort(); sort.Sort(array); sort.displayArray(array);
		 
		 

		/**
		 * Question #2 FibonacciSequence.java
		 */
		
		
		/*
		 * FibonacciSequence fibonacci = new FibonacciSequence();
		 * fibonacci.calculateSequence(25); fibonacci.printArrayList();
		 */
		 
		 

		/**
		 * Question #3 ReverseString.java
		 */
		
		/* ReverseString rev = new ReverseString(); rev.reverse(); */
		 

		/**
		 * Question #4 NFactorial.java
		 */
		
		/*
		 * NFactorial nFac = new NFactorial();
		 * System.out.println(nFac.calculateNFactorial(10));
		 */
		 

		/**
		 * Question #5 SubString.java
		 * SubStringClass.java
		 */
		
		/*
		 * String str = "Made"; int idx = str.length(); SubStringClass sub = new
		 * SubStringClass(); System.out.println(sub.subString(str, idx));
		 */
		 
		
		/**
		 * Question #6 EvenInteger.java
		 */
		/* EvenInteger even = new EvenInteger(); even.isEven(2); */

		/**
		 * Question #7 Employee.java
		 */
		/*
		 * ArrayList<Employee> employeeList = new ArrayList<Employee>();
		 * employeeList.add(new Employee("Kyle", "Engineering", 29));
		 * employeeList.add(new Employee("Bob", "Management", 52));
		 * 
		 * System.out.println("Original List:"); for(int i = 0; i < employeeList.size();
		 * i++) { System.out.println(employeeList.get(i)); }
		 * 
		 * Collections.sort(employeeList, new SortByName());
		 * System.out.println("Sorted By Name:"); for(int i = 0; i <
		 * employeeList.size(); i++) { System.out.println(employeeList.get(i)); }
		 * 
		 * Collections.sort(employeeList, new SortByDepartment());
		 * System.out.println("Sorted By Department:"); for(int i = 0; i <
		 * employeeList.size(); i++) { System.out.println(employeeList.get(i)); }
		 * 
		 * Collections.sort(employeeList, new SortByAge());
		 * System.out.println("Sorted By Age:"); for(int i = 0; i < employeeList.size();
		 * i++) { System.out.println(employeeList.get(i)); }
		 */
		 
		/**
		 * Question #8 Palindromes.java
		 */
		
		/*
		 * Palindromes pal = new Palindromes(); pal.addString("karan");
		 * pal.addString("madam"); pal.addString("tom"); pal.addString("civic");
		 * pal.addString("radar"); pal.addString("jimmy"); pal.addString("kayak");
		 * pal.addString("john"); pal.addString("refer"); pal.addString("billy");
		 * pal.addString("did"); pal.checkForPalindromes(); pal.displayPalindromes();
		 */
		 

		/**
		 * Question #9 PrimeNumbers.java
		 */
		
		/*
		 * ArrayList<Integer> list = new ArrayList<Integer>(); PrimeNumbers prime = new
		 * PrimeNumbers(); for(int i = 1; i <= 100; i++) { list.add(i); } for(int i = 0;
		 * i < 100; i++) { prime.checkForPrime(i); }
		 */
		 

		/**
		 * Question #10 TernaryOperators.java
		 */
		
		/*
		 * TernaryOperators tOp = new TernaryOperators(); tOp.findMinimum(2, 7);
		 * tOp.findMinimum(20.8, 8.7);
		 */
		 

		/**
		 * Question #11 FloatVariables.java OutsideClass.java
		 */
		
		/*
		 * FloatVariables fVar = new FloatVariables(); OutsideClass outsideFloatVar =
		 * new OutsideClass(); fVar.getFloatValues(outsideFloatVar);
		 */
		 

		/**
		 * Question #12 EnhancedForLoop.java
		 */
		
		/*
		 * EnhancedForLoop enhanced = new EnhancedForLoop(); enhanced.createArray(1,
		 * 100); enhanced.printEvenNumbers();
		 */
		 

		/**
		 * Question #13
		 * Triangle.java
		 */
		
		/* Triangle triangle = new Triangle(); triangle.displayTriangle(4); */
		 
		
		/**
		 * Question #14
		 * SwitchCase.java
		 */
		/*
		 * int squareRoot = 1, todaysDate = 2, splitString = 3; String [] array;
		 * SwitchCase sCase = new SwitchCase();
		 * System.out.println("Calculate Square Root"); sCase.determineCase(squareRoot);
		 * System.out.println(); System.out.println("Calculate Today's Date");
		 * sCase.determineCase(todaysDate); System.out.println();
		 * System.out.println("Split the String"); sCase.determineCase(splitString);
		 * System.out.println("Array Contents After Split:"); array = sCase.getArray();
		 * for(int i = 0; i < array.length; i++) { System.out.println("array[" + i +
		 * "] = " + array[i]); }
		 */

		/**
		 * Question #15 InterfaceTest.java MathInterface.java
		 */
		
		/*
		 * InterfaceTest iTest = new InterfaceTest();
		 * System.out.println(iTest.addition(5, 3));
		 * System.out.println(iTest.division(5, 3));
		 * System.out.println(iTest.multiplication(5, 3));
		 * System.out.println(iTest.subtraction(5, 3));
		 */
		 

		/**
		 * Question #16 StringInput.java
		 */
		
		/*
		 * StringInput strInput = new StringInput(); System.out.println(args[0]);
		 * strInput.displayNumberOfChar(args[0]);
		 */
		 

		/**
		 * Question #17 SimpleInterest.java
		 */
		
		/*
		 * SimpleInterest simple = new SimpleInterest(); Scanner sc = new
		 * Scanner(System.in); double principle, rate, time;
		 * 
		 * System.out.println("Enter The Principle"); principle = sc.nextDouble();
		 * System.out.println("Enter The rate (%)"); rate = sc.nextDouble();
		 * System.out.println("enter the time (years)"); time = sc.nextDouble();
		 * 
		 * simple.calculateSimpleInterest(principle, rate, time);
		 */
		 

		/**
		 * Question #18 Concrete.java ConcreteSuperclass.java
		 */
		
		/*
		 * Concrete concrete = new Concrete();
		 * System.out.println(concrete.checkForUppercase("happy"));
		 * System.out.println(concrete.changeToUpperCase("happy"));
		 * concrete.stringToInteger("15");
		 */
		 

		/**
		 * Question #19 IntegerArrayList.java
		 */
		
		/*
		 * IntegerArrayList intArrayList = new IntegerArrayList(); ArrayList<Integer>
		 * arrayList = new ArrayList<Integer>(); arrayList.add(1); arrayList.add(2);
		 * arrayList.add(3); arrayList.add(4); arrayList.add(5); arrayList.add(6);
		 * arrayList.add(7); arrayList.add(8); arrayList.add(9); arrayList.add(10);
		 * 
		 * System.out.println("ArrayList Contents:");
		 * intArrayList.displayArrayList(arrayList);
		 * 
		 * System.out.println("Even Numbers:"); intArrayList.addEvenNumbers(arrayList);
		 * 
		 * System.out.println("Odd Numbers:"); intArrayList.addOddNumbers(arrayList);
		 * 
		 * arrayList = intArrayList.removePrimeNumbers(arrayList);
		 * System.out.println("ArrayList after removing prime numbers:");
		 * intArrayList.displayArrayList(arrayList);
		 */
		 

		/**
		 * Question #20 IOReadAndPrint.java
		 */
		
		/*
		 * IOReadAndPrint readAndPrint = new IOReadAndPrint(); Scanner sc; try { sc =
		 * new Scanner(new FileReader(file)); sc.useDelimiter(":|\\n"); while
		 * (sc.hasNext()) { readAndPrint.readTextFile(sc.next(), sc.next(),
		 * sc.nextInt(), sc.next()); } readAndPrint.printContents(); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		 
	}

}
