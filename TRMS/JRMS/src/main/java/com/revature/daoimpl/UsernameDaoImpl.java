package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.UsernameDao;
import com.revature.util.ConnFactory;

public class UsernameDaoImpl implements UsernameDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public boolean usernameExists(String un) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERNAME WHERE USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}

	@Override
	public boolean correctPassword(String un, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT PASSWORD FROM USERNAME WHERE USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(pw)) return true;
		}
		return false;
	}

	@Override
	public int getUID(String un) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT EMPLOYEEID FROM USERNAME WHERE USERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, un);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

}
