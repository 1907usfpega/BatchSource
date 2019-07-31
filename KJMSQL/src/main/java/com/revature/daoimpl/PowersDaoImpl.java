package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDao;
import com.revature.util.ConnFactory;

public class PowersDaoImpl implements PowersDao{
	public static ConnFactory cf= ConnFactory.getInstance();
	@Override
	public void createPowers(String powerName) throws SQLException {
		Connection conn= cf.getConnection();
		String sql= "INSERT INTO SUPERPOWERS VALUES(POWSEQ.NEXTVAL,?)"; //IMPORTANT LINE 
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1,  powerName);
		ps.executeUpdate(); 
		
	}

}
