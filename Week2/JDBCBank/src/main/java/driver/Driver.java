/**
 * 
 */
package driver;

import java.sql.SQLException;
import java.util.Scanner;

import admin.Admin;
import daoimpl.LoginDaoImpl;
import user.User;

/**
 * @author Deonta Kilpatrick
 *
 */
public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		new Driver().start();
	}
	
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Grand Simple Bank of Java!");
		System.out.println("Are you a ");
		System.out.println("1. Bank Admin");
		System.out.println("2. User");
		String response = keyboard.nextLine();
		
		try {
			if(response.equals("1")) {
				new Admin().start();
			} else if(response.equals("2")) {
				new User().start();
			}
			
			keyboard.close();
			new Driver().stop();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void stop() {
		System.out.println("Well thank you for stopping by the Grand Simple Bank of Java. Have a nice day.");
	}

}
