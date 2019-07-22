/**
 * using String.subString(beginIndex,endIndex)
 * check = string.length / 2
 * remain = string.length%2
 * numcheck = 0
 * loop through string concatenating
 * string = substring[0,1] + substring[1,lastindex] + substring[lastindex,lastindex + 1]
 * numcheck++
 * if remain == 0
 * then 
 * while numcheck <check
 * string = substring[beginInd, firstCharInd] +substring[secondCharInd, secondCharInd +1 ]
 *  + substring[firstCharInd + 1,secondCharInd] + substring[firstCharInd,firstCharInd + 1]
 *  + substring[secondCharInd + 1,endInd]
 *  numcheck++
 *  else if remain == 1 
 *  then add the middle char in the middle it wont have to be switched with anything
 *  
 *  
 *  not as memory efficient as using temp variable. will populate heap storage fast.
 *  will give a heap storage/string pool error if do on extremely long string
 */
package com.revature.core;

/**
 * @author MajorKey
 *Question 3
 */
public class StringReverse {

	public String reverseStr(String str) {
		if(str.length() <= 1) {
			return str;
		}
		
		return (reverseStr(str.substring(1)) + str.charAt(0));
	}
	
	/*public static void main(String [] args) {
		String a = "abc";
		a = reverseStr(a);
		printString(a);
		
	}*/
	/*public String reverseString(String str) {
		int len, check, remain;
		len = str.length();
		check = len / 2;
		remain = len % 2;
		if(remain == 0)
			str = reverse(str,check, len);
		else
			str = reverse(str, check, check, len);
			
		return str;
	}
	
	private String reverse(String str, int check, int len) {
		final int BEGIN_IND = 0;
		final int END_IND = len - 1;
		int numChecked, firstCharInd, secondCharInd;
		
		str = str.substring(END_IND, END_IND + 1) + 
				str.substring(BEGIN_IND + 1, END_IND) + str.substring(BEGIN_IND, BEGIN_IND + 1);
		
		numChecked = 1;
		firstCharInd = 1;
		secondCharInd = len - 2;
		
		while(numChecked < check) {
			str = str.substring(BEGIN_IND, firstCharInd) + str.substring(secondCharInd, secondCharInd + 1) +
					str.substring(firstCharInd + 1, secondCharInd) + str.substring(firstCharInd, firstCharInd + 1) +
					str.substring(secondCharInd + 1, END_IND + 1);
			
			numChecked++;
			firstCharInd++;
			secondCharInd--;
		}
		
		return str;
	}
	
	private String reverse(String str, int midCharInd, int check, int len) {
		final int BEGIN_IND = 0;
		final int END_IND = len - 1;
		int numChecked, firstCharInd, secondCharInd;
		
		str = str.substring(END_IND, END_IND + 1) + str.substring(BEGIN_IND + 1, midCharInd) + 
		str.substring(midCharInd, midCharInd + 1) + str.substring(midCharInd, END_IND) + 
		str.substring(BEGIN_IND, BEGIN_IND + 1);
		
		numChecked = 1;
		firstCharInd = 1;
		secondCharInd = len - 2;
		
		while(numChecked < check) {
			str = str.substring(BEGIN_IND, firstCharInd) + str.substring(secondCharInd, secondCharInd + 1) +
					str.substring(firstCharInd + 1, midCharInd) + str.substring(midCharInd, midCharInd + 1) +
					str.substring(midCharInd + 1, secondCharInd) + str.substring(firstCharInd, firstCharInd + 1) +
					str.substring(secondCharInd + 1, END_IND + 1);
			
			numChecked++;
			firstCharInd++;
			secondCharInd--;
		}
		
		return str;
	}
	*/
	public void printString(String str) {
		System.out.println(str);
	}

}
