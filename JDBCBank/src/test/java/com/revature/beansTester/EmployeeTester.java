package com.revature.beansTester;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

/*
 * Tester for Employee. TBH this is gonna look a lot like CustomerTester.
 */

class EmployeeTester {
private Employee admin = null;	
private Employee empl = null;
	
	//Guess Before Each works well for constructors/instantiation to test methods? OK.
	@BeforeEach
	void makeCustomer()
	{
		admin = new Employee(7575, "The", "Brain", "thebrain@netscape.com", "1234 Secret Lab Dr.", "Los Angeles", "CA", "brain", "GlobalDomination", "admin");
		empl = new Employee(6666, "Pinky", "Mouse", "pinky@gmail.com", "1233 Secret Lab Dr.", "Los Angeles", "CA", "pinky", "nArfnArf", "employee");
	}

	@Test
	@DisplayName ("Constructor Test")
	void testEmployee() {
		if (admin.getClass() != Employee.class)
		{
			fail("Constructor broke. We can't see you. :D");
		}
	}

	@Test
	@DisplayName ("User ID Check")
	void testGetEmplId() {
		if (admin.getEmplId() != 7575 || empl.getEmplId() != 6666)
		{
			fail("That's the wrong number bozo.");
		}
	}

	@Test
	@DisplayName ("Name Checker")
	void testGetName() {
		if (admin.getName().equals("The Brain") == false || empl.getName().equals("Pinky Mouse") == false)
		{
			fail("Oof. Amnesia.");
		}
	}

	@Test
	@DisplayName("Email Checker")
	void testGetEmailAddr() {
		if (admin.getEmailAddr().equals("thebrain@netscape.com") == false)
		{
			fail("That email ain't it..");
		}
	}

	//Odd. Test method not cooperating on this one. XD
	@Test
	@DisplayName("Address Checker")
	void testGetAddress() {
		if (empl.getAddress().equals("1233 Secret Lab Dr.") == false)
		{
			fail("I CAN'T SEE YOUR HOUSE FROM HERE.");
		}
	}

	@Test
	@DisplayName ("Username Test")
	void testGetuName() {
		if (admin.getuName().equals("brain") == false)
		{
			fail("IQ < 200");
		}
	}

	@Test
	@DisplayName ("Employee Type Tester")
	void testGetType() {
		if (admin.getType().equals("admin") == false || empl.getType().equals("employee") == false)
		{
			fail("Abbott can't be Costello. C'mon man.");
		}
	}

}
