/**
 * 
 */
package com.revature.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MajorKey
 *Question 14
 */
public class SwitchStatements {

	public void trySwitch(int java) {
		switch(java) {
		case 1: 
			int num = 144;
			System.out.println("The square root of " + num+
					" is " + Math.sqrt(num));
			break;
		case 2:
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			System.out.println("Today is " + formatter.format(date));
			break;
		case 3:
			String str = "I am learning Core Java";
			String [] arrOfStr = str.split(" ");
			for(String a: arrOfStr) {
				System.out.println(a);
			}
			break;
		default:
			System.out.println("You Suck.....");
		}
	}
	
	
	public static void main(String [] args) {
		SwitchStatements sw = new SwitchStatements();
		sw.trySwitch(1);
		sw.trySwitch(2);
		sw.trySwitch(3);
		sw.trySwitch(4);
	}
}
