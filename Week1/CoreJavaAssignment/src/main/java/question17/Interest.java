/**
 * 
 */
package question17;

import java.util.Scanner;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Interest {

	//prints the simple interest by multiplying the principle rate and time
	public void calculateInterest() {
		System.out.println("Hello. I am here to help you calculate the simple interest on anything you have.");
		
		Scanner keyboard = new Scanner(System.in);
		double principle, rate;
		int time;
		
		System.out.println("So let's start......");
		System.out.print("What is your principle? :");
		principle = keyboard.nextDouble();
		System.out.print("What is your rate(%)? :"); //rate is a percent value
		rate = keyboard.nextDouble() / 100; // therefore you need to divide it by 100
		System.out.print("For how many years? :");
		time = keyboard.nextInt();
		System.out.println("\tYour simple interest is " + (principle * rate * time));
		
	}
}
