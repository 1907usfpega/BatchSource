package com.revature.dao;

import java.sql.SQLException;

public interface EmployeeDao {
	public abstract void registerEmployee(String fName, String lName, String email, String aStreet,
			String aCity, String aState, int zCode, String un, String pw) throws SQLException;
}
