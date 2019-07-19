package com.revature.JUnit;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question5;

class Question5Test {

	@Test
	void test() {
		Question5 q5 = new Question5();
		q5.run(4, "worlds").equals("worlds".substring(4));
	}

}
