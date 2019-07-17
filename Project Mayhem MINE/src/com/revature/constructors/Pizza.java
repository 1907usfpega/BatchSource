package com.revature.constructors;

public class Pizza {

	private String size;
	private String crustType;
	private String topping1;
	private String topping2;
	private String topping3;
	
	public Pizza() {
		this("large","handtossed","pepperoni","veggie","cheese");
	}
	
	public Pizza(String size) {
		this(size, "Handtossed", "Cheese");
		}
	
	public Pizza(String size, String crustType);
	
	public Pizza(String size, String crustType, String topping1, String topping2, String topping3) {
		super();
		this.size = size;
		this.crustType = crustType;
		this.topping1 = topping1;
		this.topping2 = topping2;
		this.topping3 = topping3;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
