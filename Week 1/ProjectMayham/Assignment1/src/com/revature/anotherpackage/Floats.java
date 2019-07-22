package com.revature.anotherpackage;

public class Floats {

	public float f1 = 12.7f;
	public float f2 = 114.72f;
	public Floats(float f1, float f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}
	public Floats() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Floats [f1=" + f1 + ", f2=" + f2 + "]";
	}



	public Floats(float f1) {
		super();
		this.f1 = f1;
	}



	public float getF1() {
		return f1;
	}
	public void setF1(float f1) {
		this.f1 = f1;
	}
	public float getF2() {
		return f2;
	}
	public void setF2(float f2) {
		this.f2 = f2;
	}
	
	
	
}
