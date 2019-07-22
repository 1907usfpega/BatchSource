package com.revature.faces;

public class InterImp implements InterFun{

	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int division(int a, int b) {
		if (b!=0) {
			return a/b;
		}
		else {
			System.out.println("Divide by 0 error");
			return 0;
		}
	}
	

}
