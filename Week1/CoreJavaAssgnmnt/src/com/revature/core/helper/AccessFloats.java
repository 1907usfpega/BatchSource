/**
 * 
 */
package com.revature.core.helper;

/**
 * @author MajorKey
 *Question 11
 */
public class AccessFloats {
	private float gpa;
	private float price;
	
	
	/**
	 * @param gpa
	 * @param price
	 */
	public AccessFloats(float gpa, float price) {
		super();
		this.gpa = gpa;
		this.price = price;
	}
	
	/**
	 * @param gpa
	 */
	public AccessFloats(float gpa) {
		super();
		this.gpa = gpa;
	}

	/**
	 * 
	 */
	public AccessFloats() {
		super();
	}

	/**
	 * @return the gpa
	 */
	public float getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
