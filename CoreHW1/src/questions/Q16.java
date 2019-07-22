package questions;
import java.util.Scanner;

public class Q16 {
	public static Scanner scan = new Scanner(System.in);
	
	public static void charCount() {
		System.out.println("Please input a string");
		String str = scan.nextLine();
		int count = str.length();
		System.out.println("Your string \""+str+"\" is "+count+" characters long!");
	}
	
	public static void main(String[] args) {
		String str = args[0];
		int count = str.length();
		System.out.println("Your string \""+str+"\" is "+count+" characters long!");
	}
}
