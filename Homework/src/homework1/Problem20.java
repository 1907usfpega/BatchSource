package homework1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.IOException;  

public class Problem20 {

	static void writeAndRead() {
		
//------------------------------------Writes File-----------------------------------------
		//Creates a file name Data.txt and writes the designated values to it
		//Catches any exceptions that may occur
		try {
			FileWriter fw = new FileWriter("Data.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Mickey:Mouse:35:Arizona\n" + 
					"Hulk:Hogan:50:Virginia\n" + 
					"Roger:Rabbit:22:California\n" + 
					"Wonder:Woman:18:Montana\n");
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Q20.) An error occurred.");
			e.printStackTrace();
		}

		
//------------------------------------Reads File-----------------------------------------
		//Begins the console print statement
		System.out.println("Q20.) The file reads: \n");
		
		//Reads the Data.txt file and parses the information for display
		//Catches any exceptions that may occur
		try {
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			// Cycles through the file reading line by line
			while ((line = br.readLine()) != null) {
				String[] arr = new String[4];
				// Parses file at the :
				// Splits it into 4 parts
				arr = line.split(":");
				System.out.println("Name: " + arr[0] + " " + arr[1] + "\nAge: " + arr[2] + " years \nState: " + arr[3] + " State \n");
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}//endwriteAndRead() 

}//end Problem20 class
