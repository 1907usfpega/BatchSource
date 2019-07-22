package com.revature.subclass;

public class Concrete extends Cloudy{
	private String s;

	public Concrete(String s) {
		super();
		this.s = s;
	}

	public String getS() {
		return this.s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public boolean checkUpper() {
		String n=s.toLowerCase();
		if (!n.equals(s)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public String convertUpper() {
		String n=s.toUpperCase();
		return n;
	}

	@Override
	public int convertInt() {
		int i=0;
		for (int j=0;j<s.length();j++) {
		i+=(int)s.charAt(j);
		}
		i+=10;
		System.out.println(i);
		return i;
	}

	@Override
	public String toString() {
		return "Concrete [string=" + s + "]";
	}
	
	

}
