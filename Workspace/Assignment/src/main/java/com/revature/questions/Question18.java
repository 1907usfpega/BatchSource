package com.revature.questions;

public class Question18 extends Superclass {
	//in Case the toLowerCase contains different chars than the original one, it is safe to assume they were not equal.
	@Override
	public boolean containsUppercase(String str) {
		if (str.equals(str.toLowerCase()))
			return false;
		return true;
	}
	
	//...
	@Override
	public String convertLowercase(String str) {
		//System.out.println(str.toUpperCase());
		return str.toUpperCase();
	}

	//returns a parsed int.
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
