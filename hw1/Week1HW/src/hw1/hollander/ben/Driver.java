package hw1.hollander.ben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		//call methods
		Q1BubbleSort q1 = new Q1BubbleSort();
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		q1.q1(arr);
		
		Q2Fibonacci q2 = new Q2Fibonacci();
		q2.q2(25); //Call Fibonacci method
		
		Q3ReverseString q3 = new Q3ReverseString();
		q3.q3("string");
		
		Q4Factorial q4 = new Q4Factorial();
		q4.q4(10);
		
		Q5Substring q5 = new Q5Substring();
		q5.q5("string", 2); //this returns doesn't print out
		
		Q6Even q6 = new Q6Even();
		q6.q6(55);
		
		//Q7
		List<Employee> empList = new ArrayList<Employee>();
		//Add employees
		empList.addAll(Arrays.asList(
				new Employee [] {
						new Employee ("Dora", "Deli", 60),
						new Employee ("Bob", "Bakery", 46),
						new Employee ("Gary", "Grocery", 57) 
				}));
		Collections.sort(empList);//sort by age defined in Employee class
		System.out.println(empList);
		//Sort by Name
		Collections.sort(empList,(arg0, arg1) ->{
			return arg0.getName().compareTo(arg1.getName());
		});
		System.out.println(empList);
		//Sort by dept
		Collections.sort(empList,(arg0, arg1) ->{
			return arg0.getDept().compareTo(arg1.getDept());
		});
		System.out.println(empList);
		
		
		Q8Palindrome q8 = new Q8Palindrome();
		q8.q8();
		
		Q9Primes q9 = new Q9Primes();
		q9.q9(100);
		
		Q10Ternary q10 = new Q10Ternary();
		q10.q10(1, 2);
		
		Q11 q11 = new Q11();
		q11.q11();
		
		Q12 q12 = new Q12();
		q12.q12();
		
		Q13 q13 = new Q13();
		q13.q13();
		
		
		Q14Switch q14 = new Q14Switch();
		for (int i=0; i<4; i++) {
			//should be default when i=0
			q14.q14(i);
		}
		
		
		Q15 q15 = new Q15();
		q15.add(1, 2);
		q15.subtract(6, 3);
		q15.multiply(3, 4);
		q15.divide(10, 5);
		
		
		Q16 q16 = new Q16();
		q16.q16(args); //hello passed in on my workspace
		
		Q17 q17 = new Q17();
		q17.interest();
		
		
		Q18 q18 = new Q18();
		q18.hasUppercase("hell0O");
		q18.toUppercase("hello");
		q18.parseInt("42");
		
		Q19 q19 = new Q19();
		q19.q19();
		
		Q20 q20 = new Q20();
		q20.q20();
	}

}