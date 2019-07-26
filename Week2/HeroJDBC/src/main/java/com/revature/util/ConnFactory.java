package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnFactory {
//Singleton factory
	//private static instance of self
	private static ConnFactory cf= new ConnFactory();
	//private constructor
	private ConnFactory() {
		super();
	}
	//public static synchronized"getter" method
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf= new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn= null;
		Properties prop= new Properties();
		
		conn=DriverManager.getConnection(url, user, password);
	}
}
