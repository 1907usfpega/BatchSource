package com.revature.questions;

import com.revature.driver.Driver;

public class Question11 {
	public static float driverFloat1;
	public static float driverFloat2;
	

	public static void doTask() {
		driverFloat1 = Driver.question11Float1;
		driverFloat2 = Driver.question11Float2;
		System.out.println( driverFloat1 + " + " + driverFloat2 + " = " + (driverFloat1 + driverFloat2));
	}
}
