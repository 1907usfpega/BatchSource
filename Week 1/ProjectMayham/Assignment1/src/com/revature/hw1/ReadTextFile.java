package com.revature.hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

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

			while ((str = br.readLine()) != null) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == ':') {
//						System.out.println("Entering Switch with following substring: " + Substring.substr(str, i));
						switch (counter % 4) {
						case 1:
							name1 = Substring.substr(str, i);
							break;
						case 2:
							for (int j = delimeter + 1; j < str.length(); j++) {
								if (str.charAt(j) == ':') {
									break;
								}
								name2 = name2 + str.charAt(j);
							}
							break;
						case 3:
							int k = 0;
							for (int j = delimeter + 1; j < str.length(); j++) {
								if (str.charAt(j) == ':') {
									k = j;
									break;
								}
								age = age + str.charAt(j);
							}
//							age = Substring.substr(str, i);

							for (int j = k + 1; j < str.length(); j++) {
								state = state + str.charAt(j);
							}
							break;
						default:
							System.out.println("You messed up the switch case");
							break;
						}
						delimeter = i;
						counter++;
					}
				}
				output = output + "Name: " + name1 + " " + name2 + "\n";
				output = output + "Age: " + age + " years\n";
				output = output + "State: " + state + " State\n\n";
//				System.out.println("Name: " + name1 + " " + name2);
//				System.out.println("Age: " + age + " years");
//				System.out.println("State: " + state + " State\n");

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
