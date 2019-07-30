package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowersDaoImpl implements PowersDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createPowers(String powerName) throws SQLException {
		//prepared statement
		Connection conn=cf.getConnection();
		String sql="insert into powers values(powseq.nextval,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}

}
