/**
 * 
 */
package driver;

import java.sql.SQLException;
import java.util.Scanner;

import admin.Admin;
import user.User;


public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		//starts the bank app
		new Driver().start();
	}
	
	//choose which route to go admin/user
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Bank of Java1");
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
	
	//closing statement
	public void stop() {
		System.out.println("Well thank you for stopping by the Grand Simple Bank of Java. Have a nice day.");
	}

}