package ProjectTest;

import java.util.Scanner;

public class TestInput {
		
		//Makes a scanner to read user's input (prompt will be in each question)
		static Scanner keyboard = new Scanner(System.in);
		
	//------------------------------------Int Check-------------------------------------------
		static int isInt() {
			
			//Saves the user's input as a String and creates a return variable and an error check variable
			String input;
			int userNum = 0, check;
			
			//Tests if user's input is an int
			//If it is an int, it will store the input
			//If it is not, it will ask the user to please input a valid int 
			do {
				input = keyboard.nextLine().replaceAll(" ", "");
			 try {
				   userNum = Integer.parseInt(input);  
				   check = 1;
				 }catch(NumberFormatException e) {
				   System.out.println("Input is not an int value. Please enter an integer: "); 
				   check = 0;
				 }
			}while(check != 1); //<--Keeps running with the check variable
			
			//Returns the int to the class that implements this interface method
			return userNum;
			
		}//end isInt()
		
		
	//------------------------------------Double Check-----------------------------------------
		static double isDouble() {
			
			//Saves the user's input as a String and creates a return variable and an error check variable	
			String input;
			double userNum = 0, check;
			
			//Tests if user's input is an double
			//If it is an double, it will store the input
			//If it is not, it will ask the user to please input a valid double
			do {
				input = keyboard.nextLine().replaceAll(" ", "");
			 try {
				   userNum = Double.parseDouble(input);  
				   check = 1;
				 }catch(NumberFormatException e) {
				   System.out.println("Input is not a double value. Please enter a double: "); 
				   check = 0;
				 }
			}while(check != 1); //<--Keeps running with the check variable
			
			//Returns the double to the class that implements this interface method
			return userNum;
			
		}//end isDouble()
		
		
//------------------------------------Long Check-----------------------------------------
		static long isLong() {
			
			//Saves the user's input as a String and creates a return variable and an error check variable	
			String input;
			long userNum = 0, check;
			
			//Tests if user's input is an long
			//If it is a long, it will store the input
			//If it is not, it will ask the user to please input a valid long
			do {
				input = keyboard.nextLine().replaceAll(" ", "");
			 try {
				   userNum = Long.parseLong(input);
				   check = 1;
				 }catch(NumberFormatException e) {
				   System.out.println("Input is not a long value. Please enter a long: "); 
				   check = 0;
				 }
			}while(check != 1); //<--Keeps running with the check variable
			
			//Returns the long to the class that implements this interface method
			return userNum;
			
		}//end isLong()
	//------------------------------------String Check-------------------------------------------
		static String isString() {
				
			//Saves the user's input as a String and returns it to the class that implements this interface method
			String input = keyboard.nextLine();
			return input;
			
		}//end isString()
		
	}//end UserInput interface

