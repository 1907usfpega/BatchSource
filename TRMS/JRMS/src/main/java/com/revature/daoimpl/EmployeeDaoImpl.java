package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void registerEmployee(String fName, String lName, String email, String aStreet, String aCity, String aState,
			int zCode, String un, String pw) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call REGISTER(?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, fName);
		call.setString(2, lName);
		call.setString(3, email);
		call.setString(4, aStreet);
		call.setString(5, aCity);
		call.setString(6, aState);
		call.setInt(7, zCode);
		call.setString(8, un);
		call.setString(9, pw);
		call.execute();
	}

}
