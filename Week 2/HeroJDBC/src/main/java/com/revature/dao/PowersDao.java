package com.revature.dao;

import java.sql.SQLException;

public interface PowersDao {
	public abstract void createPowers(String powerNamer) throws SQLException;
}