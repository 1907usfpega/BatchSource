package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.jackson.homeworkone.Q20ReadFile;

class Q20Test 
{

	@Test
	void testReadFromFile() 
	{
		Q20ReadFile q20 = new Q20ReadFile();
		String expected = "Name: Mickey Mouse\n" + 
				"Age: 35\n" + 
				"State: Arizona State\n" + 
				"Name: Hulk Hogan\n" + 
				"Age: 50\n" + 
				"State: Virginia State\n" + 
				"Name: Roger Rabbit\n" + 
				"Age: 22\n" + 
				"State: California State\n" + 
				"Name: Wonder Woman\n" + 
				"Age: 18\n" + 
				"State: Montana State\n";
		assertEquals(expected, q20.readFromFile());
	}

}
