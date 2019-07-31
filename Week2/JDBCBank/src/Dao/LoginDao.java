package Dao;

import java.sql.SQLException;

import methods.Login;

public interface LoginDao {

	public abstract void createLogin(String username, String password, int userid) throws SQLException;
	public abstract Login checkLogin(String username, String password) throws SQLException;
	public abstract int getLoginId(int userid) throws SQLException;
}