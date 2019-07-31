/**
 * 
 */
package question5;

/**
 * @author Deonta Kilpatrick
 *
 */
public class FindSubstring {

	//keeps concatenating the next character in the string till we make it to the index
	//if index is larger that the string length then throws exception 
	public String subString(String str, int idx) throws StringIndexOutOfBoundsException {
		String string = "";
		for(int i = 0; i < idx; i ++)
			string = string + str.charAt(i);
		return string;
	}
}
