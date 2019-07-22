/**
 * 
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 5
 */
public class FindSubstring {

	public String subString(String str, int idx) {
		String string = "";
		for(int i = 0; i < idx; i ++)
			string = string + str.charAt(i);
		return string;
	}
}
