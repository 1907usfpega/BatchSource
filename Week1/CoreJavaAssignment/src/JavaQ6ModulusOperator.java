package Assignment.Java;

import java.util.Scanner;

public class JavaQ6ModulusOperator {

	public static void main(String args[]) {
		int number;
		Scanner in = new Scanner(System.in);

		System.out.println("Input number to check");
		number = in.nextInt();
		if ((number & 1) == 0) {
			System.out.print(number + "\nis even");
		} else {
			System.out.print(number + "\nis odd");
		}
	}
}