package dao;

import java.sql.SQLException;

public interface UserDao {

	public abstract boolean checkUsername(String username) throws SQLException;
	
	public abstract boolean checkPassword(String username, String password) throws SQLException;
	
	public abstract void createUser(String username, String password, String userType) throws SQLException;
	
	public abstract int getID(String username) throws SQLException;
	
	public abstract String getType(String username) throws SQLException;
	
	public abstract void listUsers() throws SQLException;

}//end UserDao interface
