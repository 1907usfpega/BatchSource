package core;

import java.util.Scanner;

public class Seventeen {
	Scanner sc= new Scanner(System.in);
	String principal;
	String rate;
	String time;
	
	public double calInterest() {
		System.out.println("Enter principal:");
		principal= sc.nextLine(); 
		System.out.println("Enter rate:");
		rate = sc.nextLine();
		System.out.println("Enter time:");
		time = sc.nextLine();
		double result =Double.parseDouble(time)*Double.parseDouble(principal)*Double.parseDouble(rate);
		System.out.println("Interest= "+principal+" x "+rate+" x "+time+" = $"+result);
		return result;
	}

}
