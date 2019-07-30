package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class FullDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createHeroPower(String hname, String pname) throws SQLException {
		//callable statement
		Connection conn=cf.getConnection();
		String sql="{ call insertheropower(?,?)";
		CallableStatement cs=conn.prepareCall(sql);
		cs.setString(1, pname);
		cs.setString(2, hname);
		cs.executeUpdate();
	}

}
