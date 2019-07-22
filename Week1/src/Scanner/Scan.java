package Scanner;

import java.util.Scanner;

public class Scan {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("What is your name?");
		String name = input.nextLine();
		System.out.println(name);
		
		System.out.println("What is your favorite number " + name + "?");
		Double num = input.nextDouble();
		System.out.println(num);
		
		
	}//end main

}//end Scan class
