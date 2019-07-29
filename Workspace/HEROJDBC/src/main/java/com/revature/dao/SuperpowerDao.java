package com.revature.dao;

import java.sql.SQLException;

public interface SuperpowerDao {
	public abstract void createSuperpower(String powerName) throws SQLException;
}
