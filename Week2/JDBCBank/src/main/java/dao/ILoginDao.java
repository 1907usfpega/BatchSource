/**
 * 
 */
package dao;

import java.sql.SQLException;

/**
 * @author MajorKey
 *
 */
public interface ILoginDao {

	void createlogin(String username, String password, String id) throws SQLException;
}
