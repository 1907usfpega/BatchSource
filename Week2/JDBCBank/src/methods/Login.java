package methods;

import java.sql.SQLException;
import java.util.Scanner;

import DaoImpl.DaoImplAdmin;
import DaoImpl.DaoImplLogin;
import DaoImpl.DaoImplUser;

public class Login {

	private int loginId;
	private int userId;
	private int adminId;
	private Scanner keyboard;
	
	public Login() {
		super();
	}
	
	public Login(int adminId, int userId) {
		super();
		this.userId = userId;
		this.adminId = adminId;
	}
	
	public Login(int loginId, int adminId, int userId) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.adminId = adminId;
	}
	
	public int getLoginId() {
		return loginId;
	}
	
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public static boolean checkUsername(String username) throws SQLException {
		DaoImplLogin log = new DaoImplLogin();
		return log.usernameAvailable(username);
	}
	
	public static void createLogin(String username, String password, int userid) throws SQLException {
		DaoImplLogin log = new DaoImplLogin();
		log.createLogin(username, password, userid);
	}
	
	public static Login getLogin(String username, String password) throws SQLException {
		DaoImplLogin login = new DaoImplLogin();
		return login.checkLogin(username, password);
	}
	
	public Admin adminLogin() throws SQLException {
		keyboard = new Scanner(System.in);
		
		boolean finished = false;
		
		do {
			System.out.println("Username: ");
			String username = keyboard.nextLine();
			System.out.println("Password: ");
			String password = keyboard.nextLine();
			
			DaoImplLogin login = new DaoImplLogin();
			Login log = login.checkLogin(username, password);
			
			if(log != null) {
				if(log.getAdminId() != 0 && log.getUserId() == 0) {
					DaoImplAdmin admin = new DaoImplAdmin();
					return admin.getAdmin(log.getAdminId());
				}
			}
				
			System.out.println("That username password combination did not match anything in out records for an Admin.");
			System.out.println("Do you want to try again?(yes/no)");
			
			String response = keyboard.nextLine();
			
			if (response.equalsIgnoreCase("yes")) {
				continue;
			}else {
				finished = true;
			}
		}while(!finished);
		return null;
	}
	
	public User userLogin() throws SQLException {
		keyboard = new Scanner(System.in);
		
		boolean finished = false;
		
		do {
			System.out.println("Username: ");
			String username = keyboard.nextLine();
			System.out.println("Password: ");
			String password = keyboard.nextLine();
			
			DaoImplLogin login = new DaoImplLogin();
			Login log = login.checkLogin(username, password);
			
			if(log != null) {
				if(log.getAdminId() == 0 && log.getUserId() != 0) {
					DaoImplUser user = new DaoImplUser();
					return user.getUser(log.getUserId());
				}
			}
				
			System.out.println("That username password combination did not match anything in out records for any users.");
			System.out.println("Do you want to try again?(yes/no)");
			
			String response = keyboard.nextLine();
			if (response.equalsIgnoreCase("yes")) {
				continue;
			}else {
				finished = true;
			}
		}while(!finished);
		return null;
	}
}