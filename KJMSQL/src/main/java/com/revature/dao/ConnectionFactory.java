package com.revature.dao;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
// a singleton factory 
	//private instance of itself
	private static ConnectionFactory cf= new ConnectionFactory(); 
	//private constructor now 
	private ConnectionFactory() {
		super();
	}
	//public static "sychronize "getter" method
	public static synchronized  ConnectionFactory getInstance() {//this is thread safe because its synchronized
		if (cf==null) {
			cf= new ConnectionFactory();
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
