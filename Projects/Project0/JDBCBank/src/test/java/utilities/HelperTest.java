package utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelperTest {

	@Test
	public void test1() {
		Helper h =new Helper();
		boolean actual =h.isDouble("77");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		Helper h =new Helper();
		boolean actual =h.isDouble("711.22");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		Helper h =new Helper();
		boolean actual =h.isDouble("0.2");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		Helper h =new Helper();
		boolean actual =h.isDouble("hh");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		Helper h =new Helper();
		boolean actual =h.isDouble("11.7h");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		Helper h =new Helper();
		boolean actual =h.isDouble(".2");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {
		Helper h =new Helper();
		boolean actual =h.isInteger("77");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test8() {
		Helper h =new Helper();
		boolean actual =h.isInteger("1");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() {
		Helper h =new Helper();
		boolean actual =h.isInteger("10");
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test10() {
		Helper h =new Helper();
		boolean actual =h.isInteger("hh");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void tes11() {
		Helper h =new Helper();
		boolean actual =h.isInteger("11.7");
		boolean expected = false;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test12() {
		Helper h =new Helper();
		boolean actual =h.isInteger("1.2");
		boolean expected = false;
		assertEquals(expected, actual);
	}

}
