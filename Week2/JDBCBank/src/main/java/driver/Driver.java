/**
 * 
 */
package driver;

import java.sql.SQLException;

import daoimpl.UserDaoImpl;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDaoImpl user = new UserDaoImpl();
		
		try {
			//user.createUser("Deonta", "Kilpatrick");
			System.out.println(user.getCurrentUser().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
