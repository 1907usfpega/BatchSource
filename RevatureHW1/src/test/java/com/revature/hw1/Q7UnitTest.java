package com.revature.hw1;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO: Figure out why setter test ain't working. That's weird.

class Q7UnitTest {

	Employee a;
	
	@Test
	@DisplayName("Constructor Test")
	void testConstructor() {
		a = new Employee("Bob Parr","Accounting", 45);
	}
	
	@Test
	@DisplayName("Getters & Setters Test")
	void testGetSet() {
		a.setName("Ash Williams");
		a.setDept("Housewares");
		a.setAge(40);
		
		if(a.getName().equals("Ash Williams") == false || a.getDept().equals("Housewares") == false || a.getAge() != 40)
		{
			fail("Something's wrong with your gets/sets. Might want to GET to SETting that right. :D");
		}
	}
	
	@Test
	@DisplayName("Comparator Test")
	void testCompare() {
		Employee b = new Employee("Jimmy Idiot","Sales", 20);
		//Compare still giving headaches. Results cannot be guaranteed valid here. :D
		if (a.compare(a, b) == 1)
		{
			fail("Yeah, that ain't gonna work.");
		}
	}



}
