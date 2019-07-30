package com.revature.beans;

/*
 * Handles Employee creation, getters. Superclass of Admin, though may end up consolidating both. Currently unsure.
 */

public class Employee {
	private int emplId;
	private String firstname;
	private String lastname;
	private String emailAddr;
	private String addr;
	private String cityName;
	private String stateName;
	private String uName;
	private String pw;
	private String type;
	
	public Employee()
	{
		
	}

	public Employee(int id, String first, String last, String email, String address, String city,
			String state, String username, String password, String emplType) {
		emplId = id;
		firstname = first;
		lastname = last;
		emailAddr = email;
		addr = address;
		cityName = city;
		stateName = state;
		uName = username;
		pw = password;
		type = emplType;
	}

	public int getEmplId() {
		return emplId;
	}
	
	public String getName()
	{
		return firstname + " " + lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public String getAddress() {
		return addr + "/n" + cityName + "/n" + stateName;
	}

	public String getuName() {
		return uName;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Employee [emplId=" + emplId + ", firstname=" + firstname + ", lastname=" + lastname + ", emailAddr="
				+ emailAddr + ", addr=" + addr + ", cityName=" + cityName + ", stateName=" + stateName + ", type="
				+ type + "]";
	}
	
	

}
