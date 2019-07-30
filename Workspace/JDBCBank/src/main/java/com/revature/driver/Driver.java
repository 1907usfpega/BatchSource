package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bean.User;
import com.revature.daoimpl.UserDaoImpl;

public class Driver {
	public static ArrayList<User> allUsers = new ArrayList<User>();
	

	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl(); 
		try {
			allUsers = udi.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		//create user
		/*
		 * UserDaoImpl udi = new UserDaoImpl(); try { udi.createUser("Shecky Greene",
		 * "300879"); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		
		
		//delete user
		/*
		 * UserDaoImpl udi2 = new UserDaoImpl(); try { udi2.deleteUser(1); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		//view all users
		
		
		/*
		 * UserDaoImpl udi3 = new UserDaoImpl(); try {
		 * System.out.println(udi3.getUserList()); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		
		UserDaoImpl udi4 = new UserDaoImpl();
		try {
			udi4.updateUser(1, "Chilly Willy", "password");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		/*
		 * AccountDaoImpl adi = new AccountDaoImpl(); try { adi.createAccount(25); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		/*
		 * AccountDaoImpl adi2 = new AccountDaoImpl(); try { adi2.deleteAccount(2); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		/*
		 * AccountDaoImpl adi3 = new AccountDaoImpl(); try { adi3.updateBalance(4,
		 * 200.00); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		/*
		 * AccountDaoImpl adi4 = new AccountDaoImpl(); try {
		 * System.out.println(adi4.geAccountList()); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
