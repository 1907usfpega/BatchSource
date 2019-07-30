package com.revature.hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	
	// Reads Data.txt and formats the output
	public static String read() {
		FileReader fr;
		String output = "";
		try {

			fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String str;
			String name1 = "";
			String name2 = "";
			String age = "";
			String state = "";
			int counter = 1;
			int delimeter = 0;

			// Reads to the end of the file
			while ((str = br.readLine()) != null) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == ':') {		// Data Delimeter ":"
						switch (counter % 4) {		// Uses a modulo on counter to determine which data value(s) to grab
						case 1:	// First Name
							name1 = Substring.substr(str, i);
							break;
						case 2: // Last Name
							for (int j = delimeter + 1; j < str.length(); j++) {
								if (str.charAt(j) == ':') {
									break;
								}
								name2 = name2 + str.charAt(j);
							}
							break;
						case 3: // Age and State
							int k = 0;
							for (int j = delimeter + 1; j < str.length(); j++) {
								if (str.charAt(j) == ':') {
									k = j;
									break;
								}
								age = age + str.charAt(j);
							}

							for (int j = k + 1; j < str.length(); j++) {
								state = state + str.charAt(j);
							}
							break;
						default:	// Should never Print
							System.out.println("You messed up the switch case");
							break;
						}
						delimeter = i;
						counter++;
					}
				}
				
				// Adding current data to output
				output = output + "Name: " + name1 + " " + name2 + "\n";
				output = output + "Age: " + age + " years\n";
				output = output + "State: " + state + " State\n\n";

				name1 = "";
				name2 = "";
				age = "";
				state = "";

				counter = 1;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

}
