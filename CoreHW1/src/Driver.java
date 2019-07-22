import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import questions.*;


public class Driver {
	public static void main(String[] args) {
		
		//Q1
		System.out.println("Q1: bubble sort {1,0,5,6,3,2,3,7,9,8,4}");
		int[] v = Q1.bubblesort(1,0,5,6,3,2,3,7,9,8,4);
		for(int x:v)
		{
			System.out.print(x+" ");
		}
		
		//Q2
		System.out.println("\n");
		System.out.println("Q2: first 25 Fibonacci numbers");
		int[] f = Q2.fibonacci(25);
		for(int x:f)
		{
			System.out.print(x+" ");
		}
		
		//Q3
		System.out.println("\n");
		System.out.println("Q3: Reverse a string w/out a temp variable");
		String s = "hello";
		System.out.println("Original string: "+s);
		System.out.print("Reversed string: ");
		Q3.reverseString(s);
		//TODO find a way to return the reversed string instead of just printing it out
		
		//Q4
		System.out.println("\n");
		System.out.println("Q4: compute factorial");
		//change this line in order to compute a different factorial
		int n = 6;
		System.out.println(n+"! = "+ Q4.factorial(n));

		//Q5
		System.out.println("\n");
		System.out.println("Q5: Substring");
		String str = "hello";
		int idx = 3;
		String out = Q5.substring(str, idx);
		System.out.println("The substring of \""+str+"\" from index 0 to index "+(idx-1)+" is \""+out+"\"");
		
		//Q6
		System.out.println("\n");
		System.out.println("Q6: even? (no modulus)");
		System.out.println("This can take a single integer or an array of integers due to overloading."
				+ " Both are domonstrated.");
		int a = 6;
		int[] b = {1,2,3,4,5};
		boolean[] beven = Q6.isEven(b);
		System.out.println("Passed in "+a+":");
		System.out.println(a+" is "+(Q6.isEven(a)?"even":"odd")+".");
		System.out.println("Passed in an array of "+b.length+" ints:");
		for(int i = 0; i<b.length; i++) {
			System.out.println(b[i]+" is "+(beven[i]?"even":"odd")+".");
		}

		//Q7
		System.out.println("\n");
		System.out.println("Q7: Sort Employees");
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee[] { new Employee("Katie","Housing",25),
				new Employee("Hann","Training",22)}
				));
		System.out.println("Sort by name");
		Collections.sort(employeeList, new EmployeeComparatorName());
		for (Employee e: employeeList) {
			System.out.println(""+e);
		} // end for
		System.out.println("Sort by dept.");
		Collections.sort(employeeList, new EmployeeComparatorDepartment());
		for (Employee e: employeeList) {
			System.out.println(""+e);
		} // end for
		System.out.println("Sort by age");
		Collections.sort(employeeList, new EmployeeComparatorAge());
		for (Employee e: employeeList) {
			System.out.println(""+e);
		} // end for
		

		//Q8
		System.out.println("\n");
		System.out.println("Q8: Strings and Palindromes");
		Q8.q8("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did");

		//Q9
		System.out.println("\n");
		System.out.println("Q9: Store ints 1-100; print all primes");
		Q9.prime(100);

		//Q10
		System.out.println("\n");
		System.out.println("Q10: Minimum via ternary operators");
		int i1 = 10;
		int i2 = 20;
		System.out.println("The minimum of "+i1+" and "+i2+" is "+Q10.min(i1,i2));

		//Q11
		System.out.println("\n");
		System.out.println("Q11: Access variables that exist in another package");
		Q11package1.twoPackages();

		//Q12
		System.out.println("\n");
		System.out.println("Q12: Store ints 1-100; print all evens");
		Q12.q12(100);

		//Q13
		System.out.println("\n");
		System.out.println("Q13: Triangle");
		Q13.triangle(4);
		System.out.println();

		//Q14
		System.out.println("\n");
		System.out.println("Q14: Switching");
		for(int i = 1; i<4; i++) {
			System.out.println("\nCase "+i);
			Q14.switchCase(i);
		}


		//Q15
		System.out.println("\n");
		System.out.println("Q15: Basic Math");
		Q15 q15 = new Q15();
		double d1 = 4;
		double d2 = 5;
		System.out.println(d1+"+"+d2+"="+q15.addition(d1,d2));
		System.out.println(d1+"/"+d2+"="+q15.division(d1, d2));


		//Q16
		System.out.println("\n");
		System.out.println("Q16: Number of characters for a string input");
		String [] strs = {"String"};
		Q16.main(strs);

		//Q17
		System.out.println("\n");
		System.out.println("Q17: ");
		Q17.interest();

		//Q18
		System.out.println("\n");
		System.out.println("Q18: method inheritance");
		Q18 q18 = new Q18();
		String str1 = "hello";
		String str2 = "Hi!";
		String str3 = "97";
		System.out.println("The string \""+str1+"\" "+(q18.hasUpperCase(str1)?"has":"does not have")
				+" upper case characters.");
		System.out.println("The string \""+str2+"\" "+(q18.hasUpperCase(str2)?"has":"does not have")
				+" upper case characters.");
		System.out.println("\""+str1+"\" to uppercase: \""+q18.toUpperCase(str1)+"\"");
		System.out.print(str3+" + 10 = ");
		q18.convertInt(str3);

		//Q19
		System.out.println("\n");
		System.out.println("Q19: Array manipulation");
		Q19.q19(10);

		//Q20
		System.out.println("\n");
		System.out.println("Q20: Read in file, print out in a certain format");
		Q20.readIn("Data.txt");
		Q20.printOut();
		
	}//end main
}
