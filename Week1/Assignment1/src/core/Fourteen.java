package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class Fourteen {
	public void switchCase(int s) {
		switch(s) {
		case 1:
			int b=81;
			System.out.println("The square root of 81 is: "+Math.sqrt(b));
		break;
		case 2:
			LocalDate date = LocalDate.now();
	        System.out.println("Todays date is: "+DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date));
			break;
		case 3:
			String a ="I am learning Core Java";
			String[] c=a.split(" ");
			System.out.print("The contents of the array are: ");
			System.out.println(Arrays.toString(c));
			break;
		default:
			break;
		}
	}
}
