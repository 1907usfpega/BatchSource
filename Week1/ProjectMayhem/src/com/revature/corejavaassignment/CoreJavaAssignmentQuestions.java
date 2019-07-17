package com.revature.corejavaassignment;

public class CoreJavaAssignmentQuestions {
	public static void main(String []args) {
		//////////Question 1//////////
		System.out.println("********** Q1 **********\n");
		/*int []i = {2, 4};
		System.out.println(i[0]+" "+i[1]);
		i[0] ^= i[1];
		i[1] ^= i[0];
		i[0] ^= i[1];
		System.out.println(i[0]+" "+i[1]);*/
		int []example1 = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Unsorted Array: ");
		for(int n = 0; n < 11; n++) {
			System.out.print(example1[n]+" ");
		}
		System.out.println();
		System.out.println("Sorted Array: ");
		bubbleSort(example1);
		for(int n = 0; n < 11; n++) {
			System.out.print(example1[n]+" ");
		}
		
		System.out.println("\n\n");
		
		//////////Question 2//////////
		System.out.println("********** Q2 **********\n");
		System.out.println("First 25 Finonacci Numbers: ");
		fibonacci(25);
		System.out.println("\n\n");
		
		//////////Question 3//////////
		System.out.println("********** Q3 **********\n");
		String testString = "THIS STRING SHOULD BE REVERSED. "
				+ ".desrever neeb sah gnirts siht";
		System.out.println("Forward String:\n"+ testString);
		testString = reverseString(testString);
		System.out.println("Reversed String:\n" + testString);
		System.out.println("\n\n");
		
		//////////Question 4//////////
		System.out.println("********** Q4 **********\n");
		System.out.println("Factorials of 0 through 20: ");
		for(int exampleInt = 0; exampleInt <= 20; exampleInt++) {
			System.out.println(exampleInt + "! = " + factorial(exampleInt));
		}
		System.out.println("\n\n");

		//////////Question 5//////////
		System.out.println("********** Q5 **********\n");
		String startString = "This part should remain.|This part should be removed.";
		System.out.println("Initial String:\n" + startString);
		String endString = subStringMaker(startString, 24);
		System.out.println("Sub-String:\n" + endString);
		System.out.println("\n\n");
		
		//////////Question 6//////////
		System.out.println("********** Q6 **********\n");
		
		System.out.println("\n\n");
		/*
		//////////Question 7//////////
		System.out.println("********** Q7 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 8//////////
		System.out.println("********** Q8 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 9//////////
		System.out.println("********** Q9 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 10//////////
		System.out.println("********** Q10 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 11//////////
		System.out.println("********** Q11 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 12//////////
		System.out.println("********** Q12 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 13//////////
		System.out.println("********** Q3 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 14//////////
		System.out.println("********** Q14 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 15//////////
		System.out.println("********** Q15 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 16//////////
		System.out.println("********** Q16 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 17//////////
		System.out.println("********** Q17 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 18//////////
		System.out.println("********** Q18 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 19//////////
		System.out.println("********** Q19 **********\n");
		
		System.out.println("\n\n");
		
		//////////Question 20//////////
		System.out.println("********** Q20 **********\n");
		
		System.out.println("\n\n");
		*/
		
		
	}
	public static void bubbleSort(int[] arr) {
		int len = arr.length - 1;
		for(int pass = len; pass >= 0; pass--) {
			for(int place = 0; place < pass; place++) {
				if(arr[place] > arr[place+1]) {
					arr[place] ^= arr[place+1];
					arr[place+1] ^= arr[place];
					arr[place] ^= arr[place+1];
				}
			}
		}
	}
	public static void fibonacci(int n) {
		int a = 0;
		int b = 1;
		switch(n) {
		case 0:
			break;
		case 1:
			System.out.print("a");
			break;
		default:
			System.out.print(a + " " + b + " ");
			for(int i = 1; i < n; i++) {
				b += a;
				a = (b - a);
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	public static String reverseString(String inString) {
		for(int i = 0; i < inString.length()/2; i++) {
			inString = (inString.substring(0,  i) +
						inString.substring(inString.length() - i - 1, inString.length() - i) +
						inString.substring(i + 1, inString.length() - i - 1) +
						inString.substring(i, i + 1) +
						inString.substring(inString.length() - i, inString.length()));
		}
		return inString;
	}
	public static long factorial(int intIn) {
		return intIn == 0 ? 1 : intIn * factorial(intIn - 1);
	}
	public static String subStringMaker(String inString, int length) {
		String outString = String.valueOf(inString.charAt(0));
		for(int i = 1; i < length; i++)
			outString += String.valueOf(inString.charAt(i));
		return outString;
	}
	public CoreJavaAssignmentQuestions() {
		
	}

}
