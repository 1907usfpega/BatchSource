package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
// a singleton factory 
	//private instance of itself
	private static ConnFactory cf= new ConnFactory(); 
	//private constructor now 
	private ConnFactory() {
		super();
	}
	//public static "sychronize "getter" method
	public static synchronized  ConnFactory getInstance() {//this is thread safe because its synchronized
		if (cf==null) {
			cf= new ConnFactory();
		}
			return cf;
	}
	public Connection getConnection() {
		Connection conn= null; //ctrol shift o 
		Properties prop= new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			try {
				conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),prop.getProperty("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//do try and catch blocks move two lines down 
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  return conn;
	}
}
