package com.revature.driver;

public class Question18ConcreteSubclass extends Question18AbstractClass {

	public boolean anyUpper(String s) {
		char[] cars = s.toCharArray();
		for (char c : cars) {
			String hm = c + "";
			boolean notNum = true;
			try {
				Double d = Double.parseDouble(hm);
				if (d instanceof Double) {
					notNum = false;
				}
			} catch (NumberFormatException e) {
			}
			if (hm == hm.toUpperCase()) {
				if (notNum) {
					return true;
				}
			}
		}
		return false;
	}

	public String toUpper(String s) {
		return s.toUpperCase();
	}

	public int convertToIntPlus10(String s) {
		return Integer.parseInt(s) + 10;
	}
}
