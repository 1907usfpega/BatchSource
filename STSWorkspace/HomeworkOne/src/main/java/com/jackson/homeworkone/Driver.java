package com.jackson.homeworkone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Driver 
{
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		Q16StringArgs q16 = new Q16StringArgs();
		int choice = 0;
		boolean quit = false;
		do
		{
			System.out.println("Enter what problem you would like to see executed(1-20, enter 21 to quit): ");
			choice = s.nextInt();
			switch(choice)
			{
				case 1:
					question1();
					break;
				case 2:
					question2();
					break;
				case 3:
					question3();
					break;
				case 4:
					question4();
					break;
				case 5:
					question5();
					break;
				case 6:
					question6();
					break;
				case 7:
					question7();
					break;
				case 8:
					question8();
					break;
				case 9:
					question9();
					break;
				case 10:
					question10();
					break;
				case 11:
					question11();
					break;
				case 12:
					question12();
					break;
				case 13:
					question13();
					break;
				case 14:
					question14();
					break;
				case 15:
					question15();
					break;
				case 16:
					System.out.println(args[0]+" has "+q16.numChars(args[0])+" characters");
					break;
				case 17:
					question17();
					break;
				case 18:
					question18();
					break;
				case 19:
					question19();
					break;
				case 20:
					question20();
					break;
				case 21:
					quit = true;
					break;
				default:
					System.out.println("That is not a valid input.");
					break;
			}
		}while(quit == false);
		s.close();
	}
	
	public static void question1()
	{
		Q1BubbleSort q1 = new Q1BubbleSort();
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		printArray(array);
		q1.bubbleSort(array);
		printArray(array);
	}
	
	public static void question2()
	{
		Q2Fibonacci q2 = new Q2Fibonacci();
		q2.fibonacci(25);
	}
	
	public static void question3()
	{
		Q3ReverseString q3 = new Q3ReverseString();
		System.out.println(q3.reverseString("Apple"));
	}
	
	public static void question4()
	{
		Q4Factorial q4 = new Q4Factorial();
		System.out.println(q4.factorial(5));
	}
	
	public static void question5()
	{
		Q5Substring q5 = new Q5Substring();
		System.out.println(q5.mySubstring("Apple", 3));
	}
	
	public static void question6()
	{
		Q6EvenNum q6 = new Q6EvenNum();
		System.out.println(q6.isEven(40));
		System.out.println(q6.isEven(3));
	}
	
	public static void question7()
	{
		Employee e1 = new Employee("John Doe", "Accounting", 23);
		Employee e2 = new Employee("Bill Murray", "Marketing", 45);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		System.out.println("Employee List before sorting: ");
		printArray(employeeList);
		System.out.println("\nEmployee List after sort by name: ");
		Collections.sort(employeeList, new Q7NameCompare());
		printArray(employeeList);
		System.out.println("\nEmployee List after sort by age: ");
		Collections.sort(employeeList, new Q7AgeCompare());
		printArray(employeeList);
		System.out.println("\nEmployee List after sort by department: ");
		Collections.sort(employeeList, new Q7DepartmentCompare());
		printArray(employeeList);
	}
	
	public static void question8()
	{
		Q8Palindromes q8 = new Q8Palindromes();
		ArrayList<String> list = q8.savePalindromes("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		printArray(list);
	}
	
	public static void question9()
	{
		Q9PrimeNums q9 = new Q9PrimeNums();
		printArray(q9.findPrimes());
	}
	
	public static void question10()
	{
		Q10Ternary q10 = new Q10Ternary();
		System.out.println(q10.minValue(24, 35));
	}
	
	public static void question11()
	{
		Q11AccessFloats q11 = new Q11AccessFloats();
		System.out.println(q11.addTheseNums());
	}
	
	public static void question12()
	{
		Q12EvenNums q12 = new Q12EvenNums();
		q12.evenNums();
		//System.out.println(Arrays.toString(q12.evenNums()));
	}
	
	public static void question13()
	{
		Q13ConsoleTriangle q13 = new Q13ConsoleTriangle();
		q13.printTriangle(4);
	}
	public static void question14()
	{
		Q14SwitchCase q14 = new Q14SwitchCase();
		Scanner s = new Scanner(System.in);
		System.out.print("Choose an Option: \n  1. Square Root\n  2. Get Current Date\n  3. String Split\n>:");
		int choice = s.nextInt();
		s.close();
		q14.switchExample(choice);
	}
	
	public static void question15()
	{
		Q15Calculator q15 = new Q15Calculator();
		System.out.println("1 + 2 = "+q15.addition(1, 2));
		System.out.println("1 - 2 = "+q15.subtraction(1, 2));
		System.out.println("1 * 2 = "+q15.multiplication(1, 2));
		System.out.println("1 / 2 = "+q15.division(1, 2));
	}
	
	public static void question16()
	{
		
	}
	
	public static void question17()
	{
		Q17Interest q17 = new Q17Interest();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the principal: ");
		double principal = s.nextDouble();
		System.out.print("Enter the interest rate: ");
		double interestRate = s.nextDouble();
		System.out.print("Enter the number of years: ");
		int years = s.nextInt();
		s.close();
		System.out.printf("Interest is $%.2f.%n", q17.simpleInterest(principal, interestRate, years));
		
	}
	
	public static void question18()
	{
		Q18ChildClass q18 = new Q18ChildClass();
		System.out.println("Does Apple have any uppercase letters?: "+q18.checkUppercase("Apple"));
		System.out.println("All lower case letters in Apple converted to upper case: "+q18.lowerToUpper("Apple"));
		System.out.println("1834 + 10 = "+q18.addTen("1834"));
	}
	
	public static void question19()
	{
		Q19ArrayListFunctions q19 = new Q19ArrayListFunctions();
		q19.arraylistFunctions();
	}
	
	public static void question20()
	{
		Q20ReadFile q20 = new Q20ReadFile();
		q20.readFromFile();
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
