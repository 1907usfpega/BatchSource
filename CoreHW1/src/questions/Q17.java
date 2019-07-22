package questions;
import java.util.Scanner;

public class Q17 {

	public static double interest(double principle, double rate, double time) {
		return principle*rate*time;
	}
	public static double interest() {
		// TODO Auto-generated method stub
		/*
		 * Q17. Write a program that calculates the simple interest on the principal,
		 * rate of interest and number of years provided by the user. Enter principal,
		 * rate and time through the console using the Scanner class. Interest =
		 * Principal* Rate* Time
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		double interest = 0;
		try {
			System.out.println("Enter principle");
			double principle = Double.parseDouble(scan.nextLine());
			System.out.println("Enter rate");
			double rate = Double.parseDouble(scan.nextLine());
			System.out.println("Enter time");
			double time = Double.parseDouble(scan.nextLine());
			interest(principle,rate,time);
		} catch (Exception e) {
			System.out.println("Congrats, you done broke it");
		} // end catch
		return interest;
	}//end interest
	
	

}
