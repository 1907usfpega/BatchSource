/**
 * 
 */
package com.revature.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author MajorKey
 *Question 20
 */
public class FileStream {

	
	public void readFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String [] arrOfStr = line.split(":");
			String name = arrOfStr[0] + " " + arrOfStr[1];
			System.out.println("Name: " + name);
			String age = arrOfStr[2];
			System.out.println("Age: " + age + " years");
			String state = arrOfStr[3];
			System.out.println("State: " + state + " State\n");
		}
	}
	
	public static void main(String [] args) {
		final String path = "res/Data.txt";
		File file = new File(path);
		FileStream stream = new FileStream();
		try {
			stream.readFile(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
