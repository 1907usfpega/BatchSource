package com.revature.corejavaassignment;

import com.revature.corejavaassignmentQ11Package.Q11ExternalPackageClass;

public class Q11 {

	public Q11() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q11 **********\n");
		Q11ExternalPackageClass Q11Obj = new Q11ExternalPackageClass();
		Q11Test tester1 = new Q11Test((float)1.0, Q11Obj.getVal1());
		Q11Test tester2 = new Q11Test((float)2.0, Q11Obj.getVal2());
		System.out.println("Float 1 from imported class: " + Q11Obj.getVal1());
		System.out.println("Float 2 from imported class: " + Q11Obj.getVal2());
		System.out.println("Changing to \"3.0\" and \"4.0\"");
		Q11Obj.setVal1(3);
		Q11Test tester3 = new Q11Test((float)3.0, Q11Obj.getVal1());
		Q11Obj.setVal2(4);
		Q11Test tester4 = new Q11Test((float)4.0, Q11Obj.getVal2());
		System.out.println("Float 1 from imported class: " + Q11Obj.getVal1());
		System.out.println("Float 2 from imported class: " + Q11Obj.getVal2());
		System.out.println("\n\n");
		
		
	}

}
