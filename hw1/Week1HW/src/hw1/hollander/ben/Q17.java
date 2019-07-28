package hw1.hollander.ben;
import java.util.Scanner;
public class Q17 {
	public double interest() {
		Scanner input = new Scanner(System.in);
		/*
		 * Do not close Scanner(System.in)
		 * that can cause issues if you try
		 * to use a Scanner(System.in)
		 * somewhere else in your program
		 */
		System.out.println("Principal");
		double principal = input.nextDouble();
		System.out.println("Rate");
		double rate = input.nextDouble();
		System.out.println("How many years?");
		double time = input.nextDouble();
		double interest = principal*rate*time;
		System.out.println(interest);
		return interest;
	}
}
//Completed