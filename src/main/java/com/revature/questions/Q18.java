package com.revature.questions;

import com.revature.utils.MyScanner;

/*Write a program having a concrete ;subclass that inherits three 
 * abstract methods from a superclass.  Provide the following three
 *  implementations in the subclass corresponding to the abstract
 *   methods in the superclass:
*/
public class Q18 extends Q18_Abstract{	

	//Check for uppercase characters in a string, and return ‘true’ 
	//or ‘false’ depending if any are found.
	@Override
	public boolean checkUppercase(String s) {
		//navigate through each character of the string
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLowerCase(s.charAt(i))) {
				//return false if it finds any upper case
				return false;
			}
		}
		return true;
	}
	
	public void checkUppercase_print(String s) {
		System.out.println(checkUppercase(s));
		
	}

	//Convert all of the lower case characters to uppercase 
	//in the input string, and return the result.
	@Override
	public String convertToUppercase(String s) {
		return s.toUpperCase();
	}
	public void convertToUppercase_print(String s) {
		System.out.println(convertToUppercase(s));
	}

	//Convert the input string to integer and add 10,
	//output the result to the console.
	@Override
	public int addTen() {
		System.out.print("Choose int number: ");
		return MyScanner.getInteger()+10;
	}
	
	public void addTen_print() {
		System.out.println("Added 10 = "+addTen());
	}

}

abstract class Q18_Abstract{
	public abstract boolean checkUppercase(String s);
	public abstract String convertToUppercase(String s);
	public abstract int addTen();	
}
