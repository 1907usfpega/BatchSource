package com.revature.corejavaassignment;
import java.lang.Math;
import java.time.Clock;

public class Q14 {

	public Q14() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q14 **********\n");
		System.out.print("case 1: square root of 4: ");
		Q14Test tester1 = new Q14Test(2.0, switchTester(1, 4.0));
		System.out.print("case 1: square root of 9: ");
		Q14Test tester2 = new Q14Test(3.0, switchTester(1, 9.0));
		System.out.print("case 1: square root of 144: ");
		Q14Test tester3 = new Q14Test(12.0, switchTester(1, 144.0));
		System.out.print("case 2: Current time is: ");
		switchTester(2, 0);
		System.out.print("case 3: Special Message is: ");
		switchTester(3, 0);
		System.out.print("case 4: ");
		switchTester(4, 0);
		
		System.out.println("\n\n");
	}
	public double switchTester(int caseVar, double sqrtNum){
		switch(caseVar) {
		case 1:
			double tempD = Math.sqrt(sqrtNum);
			System.out.println(tempD);
			return tempD;
		case 2:
			Clock myClock = Clock.systemDefaultZone();
			System.out.println(myClock.instant());
			return 0.0;
		case 3:
			System.out.println("I am learning Core Java");
			return 0.0;
		default:
			System.out.println("Sorry, not a valid option.");
			return 0.0;
		}
	}

}
