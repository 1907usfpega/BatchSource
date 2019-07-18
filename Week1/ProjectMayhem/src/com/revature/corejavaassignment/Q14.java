package com.revature.corejavaassignment;
import java.lang.Math;
import java.time.Clock;

public class Q14 {

	public Q14() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q14 **********\n");
		System.out.print("case 1: square root of 4: ");
		switchTester(1, 4.0);
		System.out.print("case 1: square root of 9: ");
		switchTester(1, 9.0);
		System.out.print("case 1: square root of 144: ");
		switchTester(1, 144.0);
		System.out.print("case 2: Current time is: ");
		switchTester(2, 0);
		System.out.print("case 3: Special Message is: ");
		switchTester(3, 0);
		System.out.print("case 4: ");
		switchTester(4, 0);
		
		System.out.println("\n\n");
	}
	public void switchTester(int caseVar, double sqrtNum){
		switch(caseVar) {
		case 1:
			System.out.println(Math.sqrt(sqrtNum));
			break;
		case 2:
			Clock myClock = Clock.systemDefaultZone();
			System.out.println(myClock.instant());
			break;
		case 3:
			System.out.println("I am learning Core Java");
			break;
		default:
			System.out.println("Sorry, not a valid option.");
			break;
		}
	}

}
