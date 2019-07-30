package com.revature.dao;

import java.sql.SQLException;

//can use generics to avoid repeating code
//public interface Dao <T>{
public interface PowersDao {
	public abstract void createPowers(String powerName) throws SQLException;
}
