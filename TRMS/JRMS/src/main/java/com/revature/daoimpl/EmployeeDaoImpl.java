package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.RegistrationForm;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void registerEmployee(RegistrationForm rf) throws SQLException
	{
		Connection conn = cf.getConnection();
		String sql = "{ call REGISTER(?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, rf.getfName());
		call.setString(2, rf.getlName());
		call.setString(3, rf.getEmail());
		call.setString(4, rf.getaStreet());
		call.setString(5, rf.getaCity());
		call.setString(6, rf.getaState());
		call.setInt(7, rf.getzCode());
		call.setString(8, rf.getUn());
		call.setString(9, rf.getPw());
		call.execute();
	}

}
