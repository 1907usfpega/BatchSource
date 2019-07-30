package com.revature.dao;

import java.sql.SQLException;

public interface PowersDao {
	public abstract void createPower(String powerName) throws SQLException;
}
