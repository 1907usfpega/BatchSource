package com.revature.faces;

//the implementation of the interface
public class InterImp implements InterFun{

	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	//makes sure you cant divide by 0
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
