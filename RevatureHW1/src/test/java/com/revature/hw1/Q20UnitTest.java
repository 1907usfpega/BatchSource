package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Q20UnitTest {

	Q20 bleh = new Q20();
	Toon a = new Toon("Jerry","Mouse","75","Arizona");
	ArrayList<Toon> list = new ArrayList<Toon>();

	
	@Test
	void testReadData() {
		Scanner read;
		try {
			read = new Scanner(new File("Data.txt"));
			read.useDelimiter(":");
			while(read.hasNext())
			{
			Toon toon = new Toon();
			toon.setFirst(read.next());
			//System.out.println(toon.getFirst());
			toon.setLast(read.next());
			//System.out.println(toon.getLast());
			toon.setAge(read.next());
			toon.setState(read.nextLine());
			list.add(toon);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testPrintData() {
		list.add(a);
		bleh.printData(list);
	}

}
