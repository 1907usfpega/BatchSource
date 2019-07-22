package com.revature.hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class HW1Driver {
	/*
	 * Driver class for HW1 Questions.
	 * AUTHOR: redc
	 * 
	 */
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {


		//Q1 tester.
		int[] q1 = {0,1,5,6,3,2,3,7,9,8,4};
		int[] q1A = Q1.bubbleSort(q1);
		System.out.println("Q1 result: ");
		for (int i : q1A)
		{
			System.out.print(i + " ");
		}
		System.out.println("");


		//Q2 tester.
		ArrayList<Integer> fib = Q2.fibonacci();
		System.out.println("Q2: " + fib.toString());

		//Q3 tester.
		String sample = "Saban";
		System.out.println("Q3: Reverse of " + sample + 
				" is " + Q3.stringInvert(sample));
		
		//Q4 tester.
		int n = 7;
		System.out.println("Q4: n factorial of " + n + " is "
				+ Q4.nFactorial(n));

		//Q5 tester.
		String q5 = "Countries";
		String q5A = Q5.indexSubstring(q5, 5);
		System.out.println("Q5: " + q5 + "'s substring is " + q5A);

		//Q6 tester.
		int q6alpha = 88;
		int q6beta = 75;
		System.out.println("Q6: " + q6alpha + " is even = " + Q6.evenFlow(q6alpha));
		System.out.println("Q6: " + q6beta + " is even = " + Q6.evenFlow(q6beta));

		//Q7 tester.
		Employee employee1 = new Employee("John Lennon", "Bass Guitars",
				30);
		Employee employee2 = new Employee("Ringo Starr", "Drums", 65);
		employee1.compare(employee1, employee2);
		System.out.println("Q7: compares " + employee1.compare(employee1, employee2));
				

		//Q8 tester.
		String[] strings = {"karan", "madam", "tom", "civic", "radar", 
				"jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> palindromes = Q8.palinParse(strings);
		System.out.println("Q8: There are " + palindromes.size() + 
				" palindromes: " + palindromes.toString());

		//Q9 tester.
		Q9.primeParse();

		//Q10 tester.
		Q10 q10 = new Q10();
		int ternA = 45;
		int ternB = 56;
		int ternC = 67;
		System.out.println("Q10: The lesser value between " + ternA + " and " + ternB + " is " + q10.ternaryOp(ternA, ternB));
		System.out.println("Q10: The lesser value between " + ternC + " and " + ternB + " is " + q10.ternaryOp(ternC, ternB));

		//Q11 tester.
		System.out.println("Q11: ");
		Q11.main(args);

		//Q12 tester.
		System.out.println("");
		int[] evenArray = new int[101];
		for (int i = 0; i < evenArray.length; i++)
		{
			evenArray[i] = i;
		}
		System.out.print("Q12: ");
		Q12.enhancedLoopEvens(evenArray);

		//Q13 tester.
		System.out.println("");
		System.out.println("Q13: ");
		Q13.ioTriangle();
		
		//Q14 tester.
		System.out.println("Q14: ");
		Q14.switcher(1, 9);
		Q14.switcher(2, 12);
		Q14.switcher(3, 9);
		
		//Q15 tester.
		Q15 q15 = new Q15();
		System.out.println("Q15: ");
		Double obj0 = 4.2;
		Double obj1 = 69.69;
		System.out.println(obj0 + " + " + obj1 + " = " + q15.addition(obj0, obj1));
		System.out.println(obj0 + " - " + obj1 + " = " + q15.subtraction(obj0, obj1));
		System.out.println(obj0 + " * " + obj1 + " = " + q15.multiplication(obj0, obj1));
		System.out.println(obj0 + " / " + obj1 + " = " + q15.division(obj0, obj1));
		
		//Q16 tester. Uses args[] to determine variable.
		System.out.println("Q16: String used: " + args[0]);
		System.out.println("char count: " + Q16.charCounter(args[0]));
		
		//Q17 tester. Uses Scanner class to read in user input for
		//method.
		System.out.println("Q17: Give values for principal, ROI,"
				+ " and time in years. (1.0 = 1 year)");
		double principal = input.nextDouble();
		double roi = input.nextDouble();
		double time = input.nextDouble();
		System.out.println("Interest accrued will be $"
		+ Q17.getInterest(principal, roi, time));
		
		//Q18 tester.
		String q18a = "Bravo";
		String q18b = "charlie";
		String q18c = "999";
		Q18 test = new Q18();
		System.out.println("Q18: is " + q18a + " capitalized? " 
		+ test.capsChecker(q18a));
		System.out.println("Is " + q18b + " capitalized? " 
				+ test.capsChecker(q18b));
		System.out.println(q18b + " caps to " + test.capsConvert(q18b));
		test.intParsePlus10(q18c);
		
		//Q19 tester.
		System.out.println("Q19: ");
		Q19 q19 = new Q19();
		ArrayList<Integer> q19List = q19.addInts(10);
		System.out.println(q19.addEvens(q19List) + " is the sum of all evens.");
		System.out.println(q19.addOdds(q19List) + " is the sum of all odds.");
		ArrayList<Integer> primeFree = q19.removePrimes(q19List);
		System.out.println("The list without primes is as follows: ");
		for (int i = 0; i < primeFree.size(); i++)
		{
			System.out.print(primeFree.get(i) + " ");
		}

		
		//Q20 tester.
		System.out.println("");
		System.out.println("Q20: ");
		Q20 toonTest = new Q20();
		toonTest.readData();
	}

}
