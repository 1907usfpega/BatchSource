/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import user.User;

/**
 * @author Deonta Kilpatrick
 *
 */
public interface IUserDao {

	void createUser(String firstname, String lastname) throws SQLException;
	User getCurrentUser() throws SQLException;
	User getUser(int id) throws SQLException;
	List<User> getAllUsers() throws SQLException;
	void updateUser(int id, String firstname, String lastname) throws SQLException;
	void deleteUser(int id)throws SQLException;
	
}
