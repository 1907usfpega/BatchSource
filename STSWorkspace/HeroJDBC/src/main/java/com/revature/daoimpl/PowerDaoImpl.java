package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowerDao;
import com.revature.util.ConnFactory;

public class PowerDaoImpl implements PowerDao
{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createPower(String powerName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO SUPERPOWER VALUES(PWRSEQ.NEXTVAL, ?)";
		//prepared statement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}
	
}
