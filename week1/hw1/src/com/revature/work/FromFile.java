package com.revature.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FromFile {

	private static final String INFILE= "Data.txt";
	private static ArrayList<String> hold;
	
	public static void read() {
		File file= new File(INFILE);
		hold=new ArrayList<String>();
		try {
			String in;
			Scanner sc = new Scanner (file);
			while(sc.hasNext()) {
				in=sc.nextLine();
				hold.add(in);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(String i:hold) {
			String[] meow= i.split(":");
			System.out.println("Name: "+meow[0]+" "+meow[1]);
			System.out.println("Age: "+meow[2]+" years");
			System.out.println("State: "+meow[3]+" State");
		}
		
	}

}
