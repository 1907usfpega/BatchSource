package com.revature.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.comp.Employee;
import com.revature.comp.EmployeeMain;
import com.revature.faces.InterImp;
import com.revature.subclass.Concrete;
import com.revature.work.Args;
import com.revature.work.ArrayListManip;
import com.revature.work.BubbleSort;
import com.revature.work.EvenWithoutMod;
import com.revature.work.Evens;
import com.revature.work.Factorial;
import com.revature.work.Fibbonacci;
import com.revature.work.Floats;
import com.revature.work.FromFile;
import com.revature.work.Interest;
import com.revature.work.Palindromes;
import com.revature.work.Primes;
import com.revature.work.Reverse;
import com.revature.work.SubString;
import com.revature.work.Ternary;
import com.revature.work.Triangle;

class Tests {

	@Test
	void q1() {
		int[] a = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] b = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		BubbleSort.dance(a);
		assertArrayEquals(b, a);
	}

	@Test
	void q2() {
		int a = Fibbonacci.fibb(5);
		int b = 5;
		assertEquals(b, a);
	}

	@Test
	void q3() {
		String a = "hello";
		String hold = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			Reverse.turnAround(a);
			ps.flush();
			hold = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		String b = "olleh";
		assertEquals(b, hold);
	}

	@Test
	void q4() {
		int a = Factorial.fact(5);
		int b = 120;
		assertEquals(b, a);
	}

	@Test
	void q5() {
		char[] a = SubString.shortString("supercalifragilisticexpialidocious", 18);
		String b = "supercalifragilist";
		assertArrayEquals(b.toCharArray(), a);
	}

	@Test
	void q6() {
		boolean a = EvenWithoutMod.ewm(5);
		assertEquals(false, a);
	}

	@Test
	void q7() {
		List<Employee> a = EmployeeMain.sorts();
		List<Employee> b = new ArrayList<Employee>();
		b.addAll(Arrays.asList(new Employee[] { new Employee("HR", "Hann", 48), new Employee("Staging", "Ren", 69), }));
		assertEquals(b.toString(), a.toString());
	}

	@Test
	void q8() {
		ArrayList<String> a = Palindromes.makePals();
		ArrayList<String> b = new ArrayList<String>();
		b.add("madam");
		b.add("civic");
		b.add("radar");
		b.add("kayak");
		b.add("refer");
		b.add("did");
		assertEquals(b, a);
	}

	@Test
	void q9() {
		ArrayList<Integer> a = Primes.printPrime();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			b.add(i);
		}
		assertEquals(b, a);
	}

	@Test
	void q10a() {
		int a = Ternary.max(1, -12);
		int b = 1;
		assertEquals(b, a);
	}

	void q10b() {
		int a = Ternary.min(4, 25);
		int b = 4;
		assertEquals(b, a);
	}

	@Test
	void q11() {
		Floats f = new Floats(69, 420);
		float a = f.getA();
		float b = (float) 69.0;
		assertEquals(b, a, (float) 0.0);

	}

	@Test
	void q12() {
		ArrayList<Integer> a = Evens.printEven();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			b.add(i);
		}
		assertEquals(b, a);

	}

	@Test
	void q13() {
		String hold=null;
		String b=null;
		PrintStream originalOut=System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			Triangle.tri();
			ps.flush();
			hold=os.toString();
		}
		finally {
			System.setOut(originalOut);
		}
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			{
				System.out.println("0");
				System.out.println("10");
				System.out.println("101");
				System.out.println("0101");
			}
			ps.flush();
			b=os.toString();
		}
		finally {
			System.setOut(originalOut);
		}
		assertEquals(b,hold);

	}

	@Test
	void q14a() {
		double a = Math.sqrt(16);
		double b = 4.0;
		assertEquals(b, a, 0.0);
	}

	void q14b() {
		String s = "I am learning Core Java";
		String[] a = new String[4];
		a = s.split(" ");
		String[] b = { "I", "am", "learning", "Core", "Java" };
		assertArrayEquals(b, a);
	}

	@Test
	void q15a() {
		InterImp d = new InterImp();
		int a = d.subtraction(4, 3);
		int b = 1;
		assertEquals(b, a);
	}

	void q15b() {
		InterImp d = new InterImp();
		int a = d.addition(1, 2);
		int b = 3;
		assertEquals(b, a);
	}

	void q15c() {
		InterImp d = new InterImp();
		float a = d.division(4, 2);
		float b = 2;
		assertEquals(b, a, 0.0);
	}

	void q15d() {
		InterImp d = new InterImp();
		int a = d.multiplication(3, 2);
		int b = 6;
		assertEquals(b, a);
	}

	@Test
	void q16() {
		int a = Args.attempt("Wassap");
		int b = 6;
		assertEquals(b, a);
	}

	@Test
	void q17() {
		float a = Interest.simpleInterest(10, (float) 10.0, 10);
		float b = 10 * 10 * 10;
		assertEquals(b, a, 0.0);
	}

	@Test
	void qa() {
		Concrete con = new Concrete("Safety");
		boolean a = con.checkUpper();
		boolean b = true;
		assertEquals(b, a);
	}

	@Test
	void q18b() {
		Concrete con = new Concrete("Safety");
		String a = con.convertUpper();
		String b = "SAFETY";
		assertEquals(b, a);
	}

	@Test
	void q18c() {
		Concrete con = new Concrete("Safety");
		int a = con.convertInt();
		int b = 630;
		assertEquals(b, a);
	}

	@Test
	void q19() {
		ArrayList<Integer> b = ArrayListManip.ALManip();
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(4);
		c.add(6);
		c.add(8);
		c.add(9);
		c.add(10);
		assertEquals(c, b);
	}

	@Test
	void q20() {
		String a=null;
		String b=null;
		PrintStream originalOut=System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			FromFile.read();
			ps.flush();
			a=os.toString();
		}
		finally {
			System.setOut(originalOut);
		}
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			{
				System.out.println("Name: Mickey Mouse");
				System.out.println("Age: 35 years");
				System.out.println("State: Arizona State");
				System.out.println("Name: Hulk Hogan");
				System.out.println("Age: 50 years");
				System.out.println("State: Virginia State");
				System.out.println("Name: Roger Rabbit");
				System.out.println("Age: 22 years");
				System.out.println("State: California State");
				System.out.println("Name: Wonder Woman");
				System.out.println("Age: 18 years");
				System.out.println("State: Montana State");
			}
			ps.flush();
			b=os.toString();
		}
		finally {
			System.setOut(originalOut);
		}
		assertEquals(b,a);

	}

}
