package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void test1() {
		One a = new One();
		int[] b = new int[] { 5, 3, 9, 4 };
		String actual = a.bSort(b);
		String expected = "[3, 4, 5, 9]";
		assertEquals(actual, expected);
	}

	@Test
	void test2() {
		Eighteen a = new Eighteen();
		boolean actual = a.checkUppercase("hooooHoo");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	void test3() {
		Three a = new Three();
		String actual = a.reverseString("kellY");
		String expected = "Yllek";
		assertEquals(actual, expected);
	}

	@Test
	void test4() {
		Four a = new Four();
		int actual = a.factorial(5);
		int expected = 120;
		assertEquals(actual, expected);
	}

	@Test
	void test5() {
		Five a = new Five();
		String actual = a.subString("Getway2000", 6);
		String expected = "Getway";
		assertEquals(actual, expected);
	}

	@Test
	void test6() {
		Six a = new Six();
		boolean actual = a.even(11);
		;
		boolean expected = false;
		assertEquals(actual, expected);
	}

	

	@Test
	void test8() {
		Eight a = new Eight();
		boolean actual = a.isPalindrome("kayla");
		boolean expected = false;
		assertEquals(actual, expected);
	}

	@Test
	void test9() {
		Nine a = new Nine();
		boolean actual = a.prime(29);
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	void test10() {
		Ten a = new Ten();
		int actual = a.minV(10, 4);
		int expected = 4;
		assertEquals(actual, expected);
	}

	
	  @Test
	  
	  void test11() { 
		  Eleven b = new Eleven(); 
		  String actual =b.accessEleven2(2.0000999666F,6.888885555F); 
		  String expected =""+2.0000999666F+" "+6.888885555F ;
		  assertSame(actual, expected); 
		  }
	 
	@Test
	void test12() {
		Twelve a = new Twelve();
		String actual = a.printEven(10);
		String expected = "[2, 4, 6, 8, 10]";
		assertEquals(actual, expected);
	}

	@Test
	void test13() {
		Thirteen a = new Thirteen();
		String actual = a.printSteps();
		String expected = "0\r\n" + "10\r\n" + "101\r\n" + "0101";
		assertEquals(actual, expected);
	}

	@Test
	void test14() {
		Eighteen a = new Eighteen();
		boolean actual = a.checkUppercase("hooooHoo");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	void test15() {
		Fifteen a = new Fifteen();
		int actual = a.add(9, 10);
		int expected = 19;
		assertEquals(actual, expected);
	}

	/*
	 * @Test void test16() { Sixteen a = new Sixteen(); int actual = a.(9, 10); int
	 * expected = 19; assertEquals(actual, expected); }
	 */
	@Test
	void test17() {
		Seventeen a = new Seventeen();
		double actual = a.calInterest();
		double expected = 100;
		assertEquals(actual, expected);
	}

	@Test
	void test18() {
		Eighteen a = new Eighteen();
		boolean actual = a.checkUppercase("hooooHoo");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	void test19() {
		NineTeen a = new NineTeen();
		String actual = a.arrayStuff();
		String expected = "[1, 4, 6, 8, 9, 10]";
		assertEquals(actual, expected);
	}

}
