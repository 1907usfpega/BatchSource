package db.dao;

import java.sql.SQLException;
import java.util.List;

import db.beans.User;
import db.beans.UserAccount;



public interface UserDao {
	public abstract void registerUser( String username ,String password ) throws SQLException;
	public abstract void deleteUser(String username ) throws SQLException;
	public abstract UserAccount  Viewaccountbalance(String username) throws SQLException;
	
	
		
}
