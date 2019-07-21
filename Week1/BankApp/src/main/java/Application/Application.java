/**
 * If approved the information inside 
 * the  application will be used to create an account
 * or add to an account
 * and gives a name to a new customer along with the foreign 
 * key of an account_id to know which account he/she
 * is connected to
 */
package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MajorKey
 *
 */
public class Application {

	private static List<Application> open = new ArrayList<Application>();
	
	private Map<String,String> login = new HashMap<String,String>();
	private String name;
	private String account_id;
	
	public void startApplication() {
		
	}
	public void startJointApplication() {
		
	}
	/**
	 * @return the open
	 */
	public static List<Application> getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public static void setOpen(List<Application> open) {
		Application.open = open;
	}
	/**
	 * @return the login
	 */
	public Map<String, String> getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(Map<String, String> login) {
		this.login = login;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the account_id
	 */
	public String getAccount_id() {
		return account_id;
	}
	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
}
