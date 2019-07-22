package com.revature.questions;

import com.revature.driver.Driver;

public class Question11 {
	public static float driverFloat1;
	public static float driverFloat2;
	

	public static float[] doTask() {
		//access from DriverPackage, variables being public can just be accessed & return those again.
		driverFloat1 = Driver.question11Float1;
		driverFloat2 = Driver.question11Float2;
		System.out.println( driverFloat1 + " + " + driverFloat2 + " = " + (driverFloat1 + driverFloat2));
		return new float[] {driverFloat1, driverFloat2};
	}
}
