package com.revature.beansTester;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;

/*
 * Tester class for Customer object.
 * TODO: Implement some tests for post update of DB data.
 */

class CustomerTester {
	private Customer cust = null;
	
	//Guess Before Each works well for constructors/instantiation to test methods? OK.
	@BeforeEach
	void makeCustomer()
	{
		cust = new Customer(9999, "John", "Cena", "john.cena@hollywood.gov", "Invisible fortress", "Boston", "MA", "badman", "thuganomic$");
	}
	
	//Constructor. Probably should revise test method. Don't need all these args here. XD
	@Test
	@DisplayName ("Constructor Test")
	void testCustomer() {
		if (cust.getClass() != Customer.class)
		{
			fail("Constructor broke. We can't see you. :D");
		}

	}

	@Test
	@DisplayName ("User ID Check")
	void testGetUserId() {
		if (cust.getUserId() != 9999)
		{
			fail("That's the wrong number bozo.");
		}
	}

	//Since this test confirms getters for first, last, and full, will be only name tester implemented.
	@Test
	@DisplayName ("Name Checker")
	void testGetName() {
		if (cust.getName().equals("John Cena") == false)
		{
			fail("That's not John Cena...");
		}
	}

	@Test
	@DisplayName("Email Checker")
	void testGetEmailAddr() {
		if (cust.getEmailAddr().equals("john.cena@hollywood.gov") == false)
		{
			fail("That email ain't great bruh.");
		}
	}

	@Test
	@DisplayName("Address Checker")
	void testGetAddr() {
		if (cust.getAddr().equals("Invisible fortress") == false)
		{
			fail("I CAN'T SEE YOUR HOUSE FROM HERE.");
		}
	}

	@Test
	@DisplayName("City Checker")
	void testGetCityName() {
		if (cust.getCityName().equals("Boston") == false)
		{
			fail("HARVAHD YAHD!");
		}
	}

	@Test
	@DisplayName("State Checker")
	void testGetStateName() {
		if (cust.getStateName().equals("MA") == false)
		{
			fail("Bruh.");
		}
	}

	@Test
	@DisplayName ("Username Test")
	void testGetuName() {
		if (cust.getuName().equals("badman") == false)
		{
			fail("Not yet a badman.");
		}
	}

	@Test
	@DisplayName ("Password Checker")
	void testGetPw() {
		if (cust.getPw().equals("thuganomic$") == false)
		{
			fail("Bad password, bro.");
		}
	}

}
