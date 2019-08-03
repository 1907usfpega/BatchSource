package com.revature.beans;

import java.sql.Date;

/*
 * Object class for Employee from the Tuition Reimbursement program. For use w/Data in SQL
 */

public class Employee {
	
	private int employeeID;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private int reportsTo;
	private String email;
	private String username;
	private String password;
	private int emplTypeID;
	private int addressID;
	private int availReimbID;
	
	public Employee()
	{
		
	}

	public Employee(int employeeID, String firstname, String lastname, Date birthdate, int reportsTo, String email,
			String username, String password, int emplTypeID, int addressID, int availReimbID) {
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.reportsTo = reportsTo;
		this.email = email;
		this.username = username;
		this.password = password;
		this.emplTypeID = emplTypeID;
		this.addressID = addressID;
		this.availReimbID = availReimbID;
	}
	
	
}
