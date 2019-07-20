package com.revature.questions;

public class Question18 extends Superclass {

	@Override
	public boolean containsUppercase(String str) {
		if (str.equals(str.toLowerCase()))
			return false;
		return true;
	}

	@Override
	public String convertLowercase(String str) {
		//System.out.println(str.toUpperCase());
		return str.toUpperCase();
	}

	@Override
	public int toInt(String str) {
		System.out.println("String " + str+ " + 10 = "+Integer.parseInt(str));
		return Integer.parseInt(str)+10;
	}
	

}

abstract class Superclass {
	public abstract boolean containsUppercase(String str);

	public abstract String convertLowercase(String str);

	public abstract int toInt(String str);
}
