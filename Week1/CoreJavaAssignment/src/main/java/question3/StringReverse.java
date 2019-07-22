/**
 * 
 */
package question3;

/**
 * @author Deonta Kilpatrick
 *
 */
public class StringReverse {

	//didn't want to just print the string by printing charAt from end to beginning
	//i saved the string by recursively moving each character to the end of the substring
	//not advised for extremely large strings;will over populate string pool
	public String reverseStr(String str) {
		if(str.length() <= 1) {
			return str;
		}
		
		return (reverseStr(str.substring(1)) + str.charAt(0));
	}
}
