package com.revature.hw1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwitchCase {

	public static double switchCase(int input, double square) {
		double squareRoot = 0;
		
		switch (input) {
		case 1:
			squareRoot = Math.sqrt(square);
			break;
		case 2:
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date today = new Date();
			System.out.println(format.format(today));
			break;
		case 3:
			String str = "I am learning Core Java"; 
			String substr = "";
			String [] strArr = new String[5];
			int j = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != ' ') {
					substr = substr + str.charAt(i);
				} else {
					strArr[j++] = substr;
					substr = "";
				}
			}
			for(String word : strArr) {
				System.out.print(word + " ");
			}
//			System.out.println(strArr.toString());
			break;
		default:
			break;
		}

		return squareRoot;
		
	}

}
