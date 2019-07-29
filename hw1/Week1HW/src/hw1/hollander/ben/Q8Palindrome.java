package hw1.hollander.ben;
import java.util.ArrayList;

public class Q8Palindrome {
	public static ArrayList<String> q8() {
		// Create a regular array with the values
		String [] origArr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"}; 
		ArrayList<String> original = new ArrayList();
		ArrayList<String> palindromes = new ArrayList();
		
		for (String x:origArr) {
			//Read elements into arraylist
			original.add(x);
		}
		for (String x: origArr) {
			String reversed = new StringBuffer(x).reverse().toString(); //reverse and convert back to string
			if (x.equals(reversed)) //check if palindrome
			// too lazy to use charAt to sort thru half the string and meet in the middle
			{
				palindromes.add(x); //add to palindromes arraylist
			}
		}
		
		System.out.println(palindromes.toString());
		return palindromes;
	}
}
//COMPLETED