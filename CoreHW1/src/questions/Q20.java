package questions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q20 {
	private static ArrayList<String> input;

	public static void readIn(String filename) {
		File file = new File(filename);
		input = new ArrayList<String>();
		try {
			String in;
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				in = scan.nextLine();
				input.add(in);
			}
		} catch (FileNotFoundException e) {
			System.out.println("That's not a valid file name.");
			e.printStackTrace();
		} // end catch
	}// end readIn

	public static void printOut() {
		String[] str;
		for(String x:input) {
			str = x.split(":");
			System.out.println("Name: "+str[0]+" "+str[1]);
			System.out.println("Age: "+str[2]+" years");
			System.out.println("State: "+str[3]+" State");
			System.out.println();
		}
	}
}// end Q20