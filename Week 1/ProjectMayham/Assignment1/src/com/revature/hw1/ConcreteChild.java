package com.revature.hw1;

public class ConcreteChild extends AbstractParent {

	@Override
	public boolean checkForUppercase(String str) {
		// TODO Auto-generated method stub
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) > 64 && str.charAt(i) < 91) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUppercase(String str) {
		// TODO Auto-generated method stub
		String output = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) > 96 && str.charAt(i) < 123) {
				output = output + (char)(str.charAt(i) - 32);
			} else {
				output = output + str.charAt(i);
			}
		}
		
		return output;
	}

	@Override
	public int toInt(String str) {
		// TODO Auto-generated method stub
		int output;
		try {
		output = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("Value entered was not a number");
			return -1;
		}
		return output; 
	}

	public static void main(String [] args) {
		ConcreteChild test = new ConcreteChild();
		
		String str = "This is my String";
		System.out.println(test.checkForUppercase(str));
		str = "this is my all lowercase string";
		System.out.println(test.checkForUppercase(str));
		System.out.println(test.toUppercase(str));
		System.out.println(test.toInt(str));
		System.out.println(test.toInt("3298"));
	}
	
}
