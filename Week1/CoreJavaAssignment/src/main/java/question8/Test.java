/**
 * 
 */
package question8;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author Deonta Kilpatrick
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palindromes p = new Palindromes();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic","radar", "jimmy", "kayak", "john","refer", "billy", "did"));
		ArrayList<String> palindromes = p.getPalindromes(list);
		System.out.println(palindromes);

	}

}
