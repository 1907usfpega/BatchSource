package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	private static final String url = "jdbc:oracle:thin:@hannsdatabase2.c2xik0pirjqx.us-west-1.rds.amazonaws.com:1521:ORCAL";
	private static final String user ="vgDemo";
	private static final String password = "p4ssw0rd";

	private ConnFactory() {
		super();
	}

	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}//end getConnection

}
