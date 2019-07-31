package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO implements DAO<Administrator> {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public Administrator athenticate(String username, String password) throws SQLException {
		List<Administrator> admins = getAll();
		boolean authenticated = false;
		 Administrator admin = null;
		for(int i = 0; i < admins.size(); i++) {
			if(admins.get(i).getUsername().equals(username)) {
				if(admins.get(i).getPassword().equals(password)) {
					System.out.println("Authenticated!");
					admin = admins.get(i);
					authenticated = true;
					break;
				} 
			} 
		}
		if(authenticated == false) {
			System.out.println("Invalid Credentials!");
		}
		return admin;
	}	
	
	public void delete(int accountNumber) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELETE_USER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountNumber);
		call.execute();	
	}
	//DAO Interface Methods
	public List<Administrator> getAll() throws SQLException {
		List<Administrator> adminAccountList = new ArrayList<Administrator>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ADMINISTRATOR");
		Administrator a = null;
		while(rs.next()) {
			a = new Administrator(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
			adminAccountList.add(a);
		}
		return adminAccountList;
	}

	public void update(Administrator admin) {
		
		
	}
}
