/**
 * 
 */
package dao;

import java.sql.SQLException;

import login.Login;

/**
 * @author MajorKey
 *
 */
public interface ILoginDao {

	public abstract void createLogin(String username, String password, int userid) throws SQLException;
	public abstract Login checkLogin(String username, String password) throws SQLException;
	public abstract int getLoginId(int userid) throws SQLException;
}
