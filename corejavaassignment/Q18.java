package com.revature.corejavaassignment;

public class Q18 extends Q18Abstract{

	public Q18() {

		System.out.println("********** Q18 **********\n");
		// TODO Auto-generated constructor stub
	}
	public boolean uppercaseTest(String testStr) {
		if(testStr.equals(testStr.toLowerCase()))
			return false;
		return true;
	};
	public String uppercaseConvert(String testStr) {
		return testStr.toUpperCase();
	};
	public int addTen(String testStr) {
		Integer temp = Integer.parseInt(testStr) + 10;
		Q18Test tester = new Q18Test(temp, 136);
		return 0;
		
	};

}
