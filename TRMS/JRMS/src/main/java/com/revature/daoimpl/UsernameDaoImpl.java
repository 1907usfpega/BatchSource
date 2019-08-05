package com.revature.daoimpl;

import java.sql.SQLException;

import com.revature.dao.UsernameDao;

public class UsernameDaoImpl implements UsernameDao {

	@Override
	public boolean usernameExists(String un) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean correctPassword(String un, String pw) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUID(String un) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
