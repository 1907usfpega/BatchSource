package com.jackson.homeworkone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Driver 
{
	
	public static void main(String[] args) 
	{
		Q1BubbleSort q1 = new Q1BubbleSort();
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		Q2Fibonacci q2 = new Q2Fibonacci();
		Q3ReverseString q3 = new Q3ReverseString();
		Q4Factorial q4 = new Q4Factorial();
		Q5Substring q5 = new Q5Substring();
		Q6EvenNum q6 = new Q6EvenNum();
		Q7CompareEmployees q7 = new Q7CompareEmployees();
		Employee e1 = new Employee("John Doe", "Accounting", 23);
		Employee e2 = new Employee("Bill Murray", "Marketing", 45);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);		
		Q8Palindromes q8 = new Q8Palindromes();
		Q9PrimeNums q9 = new Q9PrimeNums();
		Q10Ternary q10 = new Q10Ternary();
		Q11AccessFloats q11 = new Q11AccessFloats();
		Q12EvenNums q12 = new Q12EvenNums();
		Q13ConsoleTriangle q13 = new Q13ConsoleTriangle();
		Q14SwitchCase q14 = new Q14SwitchCase();
		Q15Calculator q15 = new Q15Calculator();
		Q16StringArgs q16 = new Q16StringArgs();
		Q17Interest q17 = new Q17Interest();
		Q18ChildClass q18 = new Q18ChildClass();
		Q19ArrayListFunctions q19 = new Q19ArrayListFunctions();
		Q20ReadFile q20 = new Q20ReadFile();
		Scanner s = new Scanner(System.in);
		//printArray(array);
		//q1.bubbleSort(array);
		//printArray(array);
		//q2.fibonacci(25);
		//System.out.println(q3.reverseString("Apple"));
		//System.out.println(q4.factorial(5));
		//System.out.println(q5.mySubstring("Apple", 3));
		//System.out.println(q6.isEven(40));
		//System.out.println(q6.isEven(3));
		//System.out.println("Employee List before sort: ");
		//printArray(employeeList);
		//System.out.println("Employee List after sort: ");
		//Collections.sort(employeeList, new Q7CompareEmployees());
		//printArray(employeeList);
		//ArrayList<String> list = q8.savePalindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		//printArray(list);
		//printArray(q9.findPrimes());
		//System.out.println(q10.minValue(24, 35));
		//System.out.println(q11.addTheseNums());
		//q12.evenNums();
		//q13.printTriangle(4);
		//System.out.print("Choose an Option: \n  1. Square Root\n  2. Get Current Date\n  3. String Split\n>:");
		//int choice = s.nextInt();
		//q14.switchExample(choice);
		//System.out.println("1 + 2 = "+q15.addition(1, 2));
		//System.out.println("1 - 2 = "+q15.subtraction(1, 2));
		//System.out.println("1 * 2 = "+q15.multiplication(1, 2));
		//System.out.println("1 / 2 = "+q15.division(1, 2));
		//System.out.println(args[0]+" has "+q16.numChars(args[0])+" characters");
		//System.out.print("Enter the principal: ");
		//double principal = s.nextDouble();
		//System.out.print("Enter the interest rate: ");
		//double interestRate = s.nextDouble();
		//System.out.print("Enter the number of years: ");
		//int years = s.nextInt();
		//System.out.println("Interest is "+q17.simpleInterest(principal, interestRate, years));;
		//System.out.printf("Interest is $%.2f.%n", q17.simpleInterest(principal, interestRate, years));
		//System.out.println("Does Apple have any uppercase letters?: "+q18.checkUppercase("Apple"));
		//System.out.println("All lower case letters in Apple converted to upper case: "+q18.lowerToUpper("Apple"));
		//System.out.println("1834 + 10 = "+q18.addTen("1834"));
		//q19.arraylistFunctions();
		//q20.readFromFile();
		s.close();
	}
	
	public static void printArray(int[] array)
	{
		if(array.length == 0)
		{
			System.out.print("Empty Array");
		}
		for(int i = 0; i < array.length; i++)
		{
			if(i == array.length-1)
			{
				System.out.print(array[i] + "\n");
			}
			else
			{
				System.out.print(array[i]+", ");
			}
		}
	}
	
	public static void printArray(String[] array)
	{
		if(array.length == 0)
		{
			System.out.print("Empty Array");
		}
		for(int i = 0; i < array.length; i++)
		{
			if(i == array.length-1)
			{
				System.out.print(array[i] + "\n");
			}
			else
			{
				System.out.print(array[i]+", ");
			}
		}
	}
	
	public static void printArray(ArrayList<?> array)
	{
		if(array.isEmpty())
		{
			System.out.print("Empty ArrayList");
		}
		for(int i = 0; i < array.size(); i++)
		{
			if(i == array.size()-1)
			{
				System.out.print(array.get(i) + "\n");
			}
			else
			{
				System.out.print(array.get(i)+", ");
			}
		}
	}

}
