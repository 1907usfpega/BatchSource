package com.revature.work;

import java.util.Date;

public class Switch {
	
	public static void switchCase(int i) {
		switch(i){
		case 1:
			System.out.print("The Square root of 16 is: ");
			System.out.println(Math.sqrt(16));
			break;
		case 2:
			Date date=new Date();
			System.out.println("Todays Date is: ");
			System.out.println(date.toString());
			break;
		case 3:
			String s="I am learning Core Java";
			System.out.println("Split the string \""+s+"\" along spaces:");
			String[] n=new String[4];
			n=s.split(" ");
			for(String r: n) {
				System.out.println(r);
			}
			break;
		default:
			System.out.println("Default Case");
			
		
		}
	}

}
