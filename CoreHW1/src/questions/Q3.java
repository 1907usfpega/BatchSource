package questions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Q3 {

	public static void reverseString(String s) {
		for (int i = s.length() - 1; i > -1; i--) {
			System.out.print(s.charAt(i));
		}
	}// end reverseString

	public static String test(String s) {
		String res = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			reverseString(s);
			capture.flush();
			res = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		return res;
		//System.out.println("Captured output: " + res);
	}//end test

}// end Q3
