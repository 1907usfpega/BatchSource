package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class UserDaoImpl {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	@Override
	public void createUsers(String userName) throws SqlException{
		Connection conn=cf.getConnection();
		 String sql="INSERT INTO POWERS VALUES(POWSED.NEXTVAL,?)";
		 PreparedStatement ps= conn.prepareStatement(sql);
		 ps.setString(1, userName);
		 ps.executeUpdate();
	}
	
	
	
}
