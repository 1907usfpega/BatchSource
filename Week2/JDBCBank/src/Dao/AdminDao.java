package Dao;

import java.sql.SQLException;

import methods.Admin;

public interface AdminDao {
	
	Admin getAdmin(int id) throws SQLException;
}