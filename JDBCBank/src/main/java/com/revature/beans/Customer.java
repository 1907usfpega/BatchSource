package com.revature.beans;

public class Customer {
	private int userId;
	private String firstname;
	private String lastname;
	private String emailAddr;
	private String addr;
	private String cityName;
	private String stateName;
	private String uName;
	private String pw;

	public Customer()
	{
		
	}

	public Customer(int customerId, String first, String last, String email, String address, String city,
			String state, String username, String password) {
		userId = customerId;
		firstname = first;
		lastname = last;
		emailAddr = email;
		addr = address;
		cityName = city;
		stateName = state;
		uName = username;
		pw = password;
	}
	
	

	public int getUserId() {
		return userId;
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

	public String getAddr() {
		return addr;
	}

	public String getCityName() {
		return cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public String getuName() {
		return uName;
	}

	public String getPw() {
		return pw;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
