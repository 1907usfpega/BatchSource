package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//Singleton Factory-create one object at a time @ one time
		//private static instance of self
	private static ConnFactory cf = new ConnFactory();
	//private constructor
	private ConnFactory() {
		super();
		
	}
	//synchronized getter method
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf=new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn= null;
		Properties prop=new Properties();
		try {
			prop.load(new FileReader("database.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
}
