package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question10Test {

	@Test
	void test() {
		int expected = 1;
		int actual = com.meschac.mafoula.Question10.q10(1, 2);
		assertEquals(expected, actual);
		
		actual = com.meschac.mafoula.Question10.q10(2,  1);
		assertEquals(expected, actual);

}}
