package questions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Q8 {
	
	private static ArrayList<String> string = new ArrayList<String>();
	private static ArrayList<String> pal = new ArrayList<String>();
	
	public static void q8(String ... a) {
		for(String x:a) {
			string.add(x);
			if(checkPalindrome(x)) {
				pal.add(x);
			}//end if
		}//end for
		
		System.out.println("All the strings:");
		for(String x:string) {
			System.out.println(x);
		}
		System.out.println("\nAll the palindromes:");
		for(String x:pal) {
			System.out.println(x);
		}
		
	}//end q8
	
	public static boolean checkPalindrome(String x){
		//System.out.println("Checking to see if \""+x+"\" is a palindrome.");
		boolean palindromic = true;
		for(int i = 0; i<(x.length())/2 && palindromic; i++) {
			//System.out.println(x.charAt(i)+" vs "+x.charAt(x.length()-1-i));
			if( x.charAt(i) != x.charAt(x.length()-1-i)) {
				//System.out.println(x.charAt(i)+" is not identical to "+x.charAt(x.length()-1-i));
				palindromic = false;
			}//end if
		}//end for
		//System.out.println();
		return palindromic;
	}//end checkPalindrome
	
	public static String test(String ... s) {
		String res = null;
		PrintStream originalOut = System.out;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream(100);
			PrintStream capture = new PrintStream(os);
			// From this point on, everything printed to System.out will get captured
			System.setOut(capture);
			q8(s);
			capture.flush();
			res = os.toString();
		} finally {
			System.setOut(originalOut);
		}
		return res;
		//System.out.println("Captured output: " + res);
	}//end test

}//end Q8
