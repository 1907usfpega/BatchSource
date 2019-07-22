package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.hw1.ArrayListFun;
import com.revature.hw1.BubbleSort;
import com.revature.hw1.ConcreteChild;
import com.revature.hw1.CountChars;
import com.revature.hw1.Employee;
import com.revature.hw1.Evens;
import com.revature.hw1.Fibonacci25;
import com.revature.hw1.Interest;
import com.revature.hw1.IsEven;
import com.revature.hw1.MathImplementation;
import com.revature.hw1.Minimum;
import com.revature.hw1.NFactorial;
import com.revature.hw1.Palindromes;
import com.revature.hw1.Primes;
import com.revature.hw1.PrintZeroesAndOnes;
import com.revature.hw1.ReadTextFile;
import com.revature.hw1.ReverseString;
import com.revature.hw1.SortEmployeesByAge;
import com.revature.hw1.SortEmployeesByDepartment;
import com.revature.hw1.SortEmployeesByName;
import com.revature.hw1.Substring;
import com.revature.hw1.SwitchCase;
import com.revature.hw1.VoodooAccess;

class UnitTests {

	@Test
	void bubbleTest() {
		assertEquals("Array before sorting: 10563237984\n" + "Array after sorting: 01233456789", BubbleSort.sort());
	}

	@Test
	void fibonacciTest() {
		assertEquals("Fibonacci Sequence: 0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,"
				+ "1597,2584,4181,6765,10946,17711,28657,46368", Fibonacci25.fib());

	}

	@Test
	void reverseStringTest() {
		String myString = "This is my String";
		String revString = "gnirtS ym si sihT";
		assertEquals(revString, ReverseString.rev(myString));
	}

	@Test
	void nFactorialTest() {
		int expected = 24;
		assertEquals(expected, NFactorial.factorialize(4));
	}

	@Test
	void substringTest() {
		String test = "Test";
		String expected = "Tes";
		assertEquals(expected, Substring.substr(test, 3));
	}

	@Test
	void isEvenTest1() {
		boolean expected = true;
		assertEquals(expected, IsEven.isEven(4));
	}

	@Test
	void isEvenTest2() {
		boolean expected = false;
		assertEquals(expected, IsEven.isEven(23));
	}

	@Test
	void sortEmployeeByNameTest() {
		Employee a = new Employee("Steven", "Gardening", 23);
		Employee b = new Employee("Greg", "Auto", 37);
		SortEmployeesByName sort = new SortEmployeesByName();
		int expected = 1;
		assertEquals(expected, sort.compare(a, b));
	}

	@Test
	void sortEmployeeByDeptTest() {
		Employee a = new Employee("Steven", "Gardening", 23);
		Employee b = new Employee("Greg", "Auto", 37);
		SortEmployeesByDepartment sort = new SortEmployeesByDepartment();
		int expected = -1;
		assertEquals(expected, sort.compare(a, b));
	}

	@Test
	void sortEmployeeByAgeTest() {
		Employee a = new Employee("Steven", "Gardening", 23);
		Employee b = new Employee("Greg", "Auto", 37);
		SortEmployeesByAge sort = new SortEmployeesByAge();
		int expected = 23 - 37;
		assertEquals(expected, sort.compare(a, b));
	}

	@Test
	void palindromesTest() {
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
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		assertEquals(expected, Palindromes.palindromes(al1));
	}

	@Test
	void primesTest() {
		String expected = "1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97";
		String actual = Primes.primesOneToOneHundred();
		assertEquals(expected, actual);
	}

	@Test
	void minimumTest() {
		int i = 4;
		int j = 8;
		int k = Minimum.minimum(i, j);
		assertEquals(i, k);
	}

	@Test
	void voodooTest() {
		String expected = "2 fields\nFloats: 12.7 114.72 exists in a different package!";
		assertEquals(expected, VoodooAccess.voodoo());
	}

	@Test
	void evensTest() {
		String expected = "2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,"
				+ "64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100";

		assertEquals(expected, Evens.evens());
	}

	@Test
	void zeroesAndOnesTest() {
		String expected = "0 \n1 0 \n1 0 1\n0 1 0 1";
		assertEquals(expected, PrintZeroesAndOnes.print());
	}

	@Test
	void switchCaseTest() {
		double expected = 4.0;
		assertEquals(expected, SwitchCase.switchCase(1, 16.0), 0);
	}


	@Test
	void mathTest() {
		int i = 7;
		int j = 4;
		MathImplementation mi = new MathImplementation();
		int expected = 11;
		assertEquals(expected, mi.addition(i, j));
	}

	@Test
	void numCharsTest() {
		String test = "This is a test";
		int expected = 14;
		assertEquals(expected, CountChars.count(test));
	}
	
	@Test
	void interestTest() {
		double principal = 4.0;
		double rate = 4.0;
		double time = 4.0;
		double expected = 64.0;
		assertEquals(expected, Interest.calculateInterest(principal, rate, time), 0);
	}
	
	@Test 
	void concreteChildTest() {
		String input = "this is a test";
		String expected = "THIS IS A TEST";
		ConcreteChild cc = new ConcreteChild();
		assertEquals(expected, cc.toUppercase(input));
	}
	
	@Test
	void arrayListFunTest() {
		String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n" + 
				"Evens added: 30\n" + 
				"Odds added: 25\n" + 
				"[4, 6, 8, 9, 10]";
		assertEquals(expected, ArrayListFun.funWithArrayList());
	}
	
	@Test
	void readFromFileTest() {
		String expected = "Name: Mickey Mouse\n" + 
				"Age: 35 years\n" + 
				"State: Arizona State\n" + 
				"\n" + 
				"Name: Hulk Hogan\n" + 
				"Age: 50 years\n" + 
				"State: Virginia State\n" + 
				"\n" + 
				"Name: Roger Rabbit\n" + 
				"Age: 22 years\n" + 
				"State: California State\n" + 
				"\n" + 
				"Name: Wonder Woman\n" + 
				"Age: 18 years\n" + 
				"State: Montana State\n\n";
	
		assertEquals(expected, ReadTextFile.read());
	}
}
