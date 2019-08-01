/**
 * 
 */
package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.user.User;


public interface UserDao {

	void createUser(String firstname, String lastname) throws SQLException;
	User getCurrentUser() throws SQLException;
	User getUser(int id) throws SQLException;
	List<User> getAllUsers() throws SQLException;
	void updateUser(int id, String firstname, String lastname) throws SQLException;
	void deleteUser(int id)throws SQLException;
	
}
