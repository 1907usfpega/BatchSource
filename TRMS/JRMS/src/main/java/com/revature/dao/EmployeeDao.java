package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.RegistrationForm;

public interface EmployeeDao {
	public abstract void registerEmployee(RegistrationForm rf) throws SQLException;
}
