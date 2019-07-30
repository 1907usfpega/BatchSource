package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowerDaoImpl implements PowersDao{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createPower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO superpower VALUES(powseq.nextval,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName); // fills in ? in sql with powerName
		ps.executeUpdate();
	}//end createPower
}//end PowerDaoImpl
