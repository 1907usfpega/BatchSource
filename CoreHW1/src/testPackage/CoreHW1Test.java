package testPackage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;

import q11.Q11;
import questions.Employee;
import questions.EmployeeComparatorAge;
import questions.EmployeeComparatorDepartment;
import questions.EmployeeComparatorName;
import questions.Q1;
import questions.Q10;
import questions.Q11package1;
import questions.Q12;
import questions.Q13;
import questions.Q14;
import questions.Q15;
import questions.Q16;
import questions.Q17;
import questions.Q18;
import questions.Q19;
import questions.Q2;
import questions.Q20;
import questions.Q3;
import questions.Q4;
import questions.Q5;
import questions.Q6;
import questions.Q8;
import questions.Q9;

class CoreHW1Test {

	@Test
	void test1() {
		int[] original = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] sorted = Q1.bubblesort(original);
		int[] expected = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(sorted, expected);
	}

	@Test
	void test2() {
		int[] f = Q2.fibonacci(4);
		int[] expected = { 0, 1, 1, 2 };
		assertArrayEquals(f, expected);
	}

	@Test
	void test3() {
		String original = "hello";
		String reverse = Q3.test(original);
		String expected = "olleh";
		assertEquals(reverse, expected);
	}

	@Test
	void test4() {
		int f = Q4.factorial(4);
		int expected = 4 * 3 * 2;
		assertEquals(f, expected);
	}

	@Test
	void test5() {
		String out = Q5.substring("hello", 3);
		String expected = "hel";
		assertEquals(out, expected);
	}

	@Test
	void test6() {
		int[] b = { 1, 2, 3, 4, 5 };
		boolean[] even = Q6.isEven(b);
		boolean[] expected = { false, true, false, true, false };
		assertArrayEquals(even, expected);
	}

	@Test
	void test7() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
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
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("Sort by name\r\n" + 
						"Employee [name=Hann, age=22, department=Training]\r\n" + 
						"Employee [name=Katie, age=25, department=Housing]\r\n" + 
						"Sort by dept.\r\n" + 
						"Employee [name=Katie, age=25, department=Housing]\r\n" + 
						"Employee [name=Hann, age=22, department=Training]\r\n" + 
						"Sort by age\r\n" + 
						"Employee [name=Hann, age=22, department=Training]\r\n" + 
						"Employee [name=Katie, age=25, department=Housing]");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);	}

	@Test
	void test8() {
		String[] s = { "madam", "adam" };

		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q8.q8(s);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("All the strings:");
				System.out.println("madam");
				System.out.println("adam");
				System.out.println("\nAll the palindromes:");
				System.out.println("madam");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test9() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q9.prime(100);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test10() {
		int min = Q10.min(11, 12);
		int expected = 11;
		assertEquals(min, expected);
	}

	@Test
	void test11() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q11package1.twoPackages();
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("7.0 8.5");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test12() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q12.q12(20);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("2 4 6 8 10 12 14 16 18 20 ");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test13() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q13.triangle(4);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("0 ");
				System.out.println("1 0 ");
				System.out.println("1 0 1 ");
				System.out.println("0 1 0 1 ");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test14() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				for (int i = 1; i < 4; i++) {
					Q14.switchCase(i);
				}
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("Finding the square root of 16:");
				System.out.println("4.0");
				System.out.println("Today's Date:");
				Date today = Calendar.getInstance().getTime();
				System.out.println(today);
				System.out.println("Splitting and storing a string:");
				System.out.println("I");
				System.out.println("am");
				System.out.println("learning");
				System.out.println("Core");
				System.out.println("Java");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test15() {
		Q15 q15 = new Q15();
		int a = 5;
		int b = 4;
		double add = q15.addition(a, b);
		double div = q15.division(a, b);
		Double[] results = { add, div };
		Double[] expected = { 9.0, 1.25 };
		assertArrayEquals(results, expected);
	}

	@Test
	void test16() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				String[] args = { "String" };
				Q16.main(args);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("Your string \"String\" is 6 characters long!");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test17() {
		double interest = Q17.interest(7,7,7);
		double expected = 7*7*7;
		assertEquals(expected,interest,0);
	}

	@Test
	void test18() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q18 q18 = new Q18();
				String str1 = "hello";
				String str2 = "Hi!";
				String str3 = "97";
				System.out.println("The string \"" + str1 + "\" " + (q18.hasUpperCase(str1) ? "has" : "does not have")
						+ " upper case characters.");
				System.out.println("The string \"" + str2 + "\" " + (q18.hasUpperCase(str2) ? "has" : "does not have")
						+ " upper case characters.");
				System.out.println("\"" + str1 + "\" to uppercase: \"" + q18.toUpperCase(str1) + "\"");
				System.out.print(str3 + " + 10 = ");
				q18.convertInt(str3);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("The string \"hello\" does not have upper case characters.\r\n"
						+ "The string \"Hi!\" has upper case characters.\r\n" + "\"hello\" to uppercase: \"HELLO\"\r\n"
						+ "97 + 10 = 107");
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		assertEquals(expected, result);
	}

	@Test
	void test19() {

		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q19.q19(10);
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{//start block
				/*
				 * System.out.println("Original Array:");
				 * System.out.println("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
				 * System.out.println("\nSum of evens: " + 30);
				 * System.out.println("\nSum of odds: " + 25);
				 * System.out.println("\nArray without primes:");
				 * System.out.println("[1, 4, 6, 8, 9, 10]"); // System.out.println();
				 */
				System.out.println("Original Array:\r\n" + 
						"[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\r\n" + 
						"\r\n" + 
						"Sum of evens: 30\r\n" + 
						"\r\n" + 
						"Sum of odds: 25\r\n" + 
						"\r\n" + 
						"Array without primes: \r\n" + 
						"[1, 4, 6, 8, 9, 10]");
			}//end block
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		//System.out.print(result);
		// System.out.println(expected+"\n"+result);
		// System.out.println(result+"\n"+expected);
		assertEquals(expected, result);
	}

	@Test
	void test20() {
		String result = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				Q20.readIn("test.txt");
				Q20.printOut();
			}
			capture.flush();
			result = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String expected = null;
		// PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			{
				System.out.println("Name: Mickey Mouse");
				System.out.println("Age: 35 years");
				System.out.println("State: Arizona State");
				System.out.println();
			}
			capture.flush();
			expected = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		// System.out.println(result+expected);
		assertEquals(expected, result);
	}
}// end CoreHW1Test
