package com.revature.hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String [] args) {
		
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Running Bubble Sort Problem...");
	String output = BubbleSort.sort();
	System.out.println(output);
	
	System.out.println("\n\nRunning First 25 Fibonacci Numbers Problem...");
	output = Fibonacci25.fib();
	System.out.println(output);
	
	System.out.print("\n\nEnter a string to be reversed: ");
	String initString = sc.nextLine();
	output = ReverseString.rev(initString);
	System.out.println("String before reversal: " + initString);
	System.out.println("String after reversal: " + output);
	
	System.out.println("\nEnter a positive numerical value to be factorialized");
	String input;
	int i = 0;
	while (i == 0) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i == 0 || i < 0) {
			System.out.print("\nValue must be greater than 0.\nEnter a whole number value: ");
			i = 0;
		}
	}
	int outputInt = NFactorial.factorialize(i);
	System.out.println(outputInt);
	
	System.out.println("\n\nEnter a String to be Substringed");
	initString = sc.nextLine();
	System.out.println("\n Enter the index for the Substring to end on");
	i = -1;
	while (i == -1) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i < 0) {
			System.out.print("\nValue must be greater than 0.\nEnter a whole number value: ");
			i = -1;
		}
	}
	String substr = Substring.substr(initString, i);
	System.out.println("Substring: " + substr);
	
	System.out.println("\nEnter a number other than 0 to check if it is even: ");
	i = 0;
	while (i == 0) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i == 0) {
			System.out.print("\n0 is even and is being used to check that the input is good, please enter something else.\nEnter a whole number value: ");
		}
	}
	Boolean isEven = IsEven.isEven(i);
	if(isEven) {
		System.out.println(i + " is even");
	} else {
		System.out.println(i + " is odd");
	}
	
	Employee b = new Employee("John", "Computer Science", 32);
	Employee a = new Employee("Stewart", "Business", 44);
	
	System.out.println("Sorting two employees...");
	System.out.println("Based on Name: ");
	SortEmployeesByName byName = new SortEmployeesByName();
	int result = byName.compare(a, b);
	if (result > 0) {
		System.out.println(a.toString());
		System.out.println(b.toString());
	} else {
		System.out.println(b.toString());
		System.out.println(a.toString());
	}
	
	
	System.out.println("\nBased on Department: ");
	SortEmployeesByDepartment byDept = new SortEmployeesByDepartment();
	result = byDept.compare(a, b);
	if (result > 0) {
		System.out.println(a.toString());
		System.out.println(b.toString());
	} else {
		System.out.println(b.toString());
		System.out.println(a.toString());
	}
	
	System.out.println("\nBased on Age: ");
	SortEmployeesByAge byAge = new SortEmployeesByAge();
	result = byAge.compare(a, b);
	if (result < 0) {
		System.out.println(a.toString());
		System.out.println(b.toString());
	} else {
		System.out.println(b.toString());
		System.out.println(a.toString());
	}
	
	ArrayList<String> al1 = new ArrayList<String>();
	al1.add("karan");
	al1.add("madam");
	al1.add("tom");
	al1.add("civic");
	al1.add("radar");
	al1.add("jimmy");
	al1.add("kayak");
	al1.add("john");
	al1.add("refer");
	al1.add("billy");
	al1.add("did");
	
	System.out.println("\nPreparing to store palindromes from ArrayList in another ArrayList...");
	System.out.println("Initial ArrayList: " + al1.toString());
	ArrayList<String> al2 = Palindromes.palindromes(al1);
	System.out.println("Palindrome ArrayList: " + al2.toString());
	
	System.out.println("\nPreparing to get Prime Numbers between 1 and 100...");
	output = Primes.primesOneToOneHundred();
	System.out.println(output);
	
	
	System.out.println("\nEnter a whole number value other than 0: ");
	i = 0;
	while (i == 0) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i == 0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	System.out.println("\nEnter another whole number value other than 0: ");
	int j = 0;
	while (j == 0) {
		try {
			input = sc.nextLine();
			j = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(j == 0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	
	int k = Minimum.minimum(i, j);
	if (k == i) {
		System.out.println(i + " is smaller than " + j);
	} else {
		System.out.println(j + " is smaller than " + i);
	}
	
	System.out.println("\nGetting ready to preform that voodoo magic!");
	output = VoodooAccess.voodoo();
	System.out.println(output);
	
	System.out.println("\nPreparing to find even numbers from 1 to 100 in an ArrayList...");
	output = Evens.evens();
	System.out.println(output);
	
	System.out.println("\nPreparing to make the alternating 0s and 1s triangle thingy...");
	output = PrintZeroesAndOnes.print();
	System.out.println(output);
	
	System.out.print("\nEnter a non-negative number to find its square root: ");
	i = -1;
	while (i == -1) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i < 0) {
			System.out.print("\nPlease enter a positive number.\nEnter a whole number value: ");
		}
	}
	double squareroot = SwitchCase.switchCase(1, i);
	System.out.println(squareroot);
	System.out.print("\nToday's Date is: ");
	SwitchCase.switchCase(2, 0);
	System.out.println("\nSplitting String and storing substrings into a String Array");
	SwitchCase.switchCase(3, 0);
	
	System.out.println("\nEnter a whole number value other than 0: ");
	i = 0;
	while (i == 0) {
		try {
			input = sc.nextLine();
			i = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(i == 0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	System.out.println("\nEnter another whole number value other than 0: ");
	j = 0;
	while (j == 0) {
		try {
			input = sc.nextLine();
			j = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(j == 0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	
	MathImplementation mi = new MathImplementation();
	k = mi.addition(i, j);
	System.out.println(i + "+" + j + "=" + k);
	k = mi.subtraction(i, j);
	System.out.println(i + "-" + j + "=" + k);
	k = mi.multiplication(i, j);
	System.out.println(i + "*" + j + "=" + k);
	k = mi.division(i, j);
	System.out.println(i + "/" + j + "=" + k);
	
	System.out.println("Preparing to determine the length of the String received from the CLI...");
	i = CountChars.count(args[0]);
	System.out.println(i);
	
	System.out.println("\nEnter a positive double value to represent principal: ");
	double d1 = -1.0;
	while (d1 < 0.0) {
		try {
			input = sc.nextLine();
			d1 = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be positive.\nEnter a whole number value: ");
		}
		if(d1 < 0.0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	System.out.println("\nEnter another positive double value to represent rate: ");
	double d2 = -1.0;
	while (d2 < 0.0) {
		try {
			input = sc.nextLine();
			d2 = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(d2 < 0.0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	System.out.print("\nEnter a third positive double value to represent time: ");
	double d3 = -1.0;
	while (d3 < 0.0) {
		try {
			input = sc.nextLine();
			d3 = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.print("\nValue must be a whole number.\nEnter a whole number value: ");
		}
		if(d3 < 0.0) {
			System.out.print("\nPlease enter something else.\nEnter a whole number value: ");
		}
	}
	
	System.out.println("\nPreparing to calculate Interest...");
	System.out.println(Interest.calculateInterest(d1, d2, d3));
	
	System.out.print("\nEnter a String to be checked for capital letters: ");
	ConcreteChild cc = new ConcreteChild();
	input = sc.nextLine();
	boolean hasUpperCase = cc.checkForUppercase(input);
	if(hasUpperCase) {
		System.out.println("Your String has uppercase letters!");
	} else {
		System.out.println("Your String does not have uppercase letters!");
	}
	
	System.out.print("\nEnter a String to be converted to all uppercase letters: ");
	input = sc.nextLine();
	String uppercase = cc.toUppercase(input);
	System.out.println(uppercase);
	
	System.out.print("\nEnter a String to be converted to an int: ");
	input = sc.nextLine();
	i = cc.toInt(input);
	
	System.out.println("\nPreparing to run ArrayListFun...");
	output = ArrayListFun.funWithArrayList();
	System.out.println(output);
	
	System.out.println("\nPreparing to read from Data.txt and print the formatted results...");
	output = ReadTextFile.read();
	System.out.println(output);
	
	
	sc.close();
	}

}
