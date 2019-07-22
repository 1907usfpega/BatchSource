package com.revature.homework1;

public class Assignment18A extends Assignment18  {

	@Override
	public String convertToUpperCase(String s) {
		s = s.toUpperCase();
		return s;
	}

	@Override
	public boolean testAllUpperCase(String str) {
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c >= 65 && c <= 90) {
				return true;
			}
		}
		//str.charAt(index)
		return false;
	}

	@Override
	public int returnAnInt(String s) {
		int i = Integer.parseInt(s);
		return i + 10;
	}

}



