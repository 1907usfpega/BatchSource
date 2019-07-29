/**
 * 
 */
package daoimpl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ILoginDao;
import util.ConnFactory;

/**
 * @author MajorKey
 *
 */
public class LoginDaoImpl implements ILoginDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createlogin(String username, String password, String id) throws SQLException {
		Connection conn = cf.getConnection();

	}

}
