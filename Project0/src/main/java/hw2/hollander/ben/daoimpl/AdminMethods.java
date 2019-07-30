package hw2.hollander.ben.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.util.ConnFactory;

public class AdminMethods {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	public static void Delete(int acctid) throws AccountNotEmptyException, SQLException {
		Connection conn= cf.getConnection();
		String sql= "{ call acct_delete(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, String.valueOf(acctid));
		call.execute();
		System.out.println("Account deleted");
	}
	
	public static void Update(String old, String newUsrname) {
		Connection conn= cf.getConnection();
		String sql = "UPDATE login SET usrname=? WHERE usrname=?"; //breaks hashcode integrity
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(1, old);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(2, newUsrname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
