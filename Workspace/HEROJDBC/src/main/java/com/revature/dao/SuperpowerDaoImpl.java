package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class SuperpowerDaoImpl implements SuperpowerDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	
	
	public void createSuperpower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO SUPERPOWER VALUES(POWSEQ.NEXTVAL,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}

}
