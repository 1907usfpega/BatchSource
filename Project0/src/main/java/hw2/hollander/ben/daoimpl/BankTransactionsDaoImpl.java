package hw2.hollander.ben.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hw2.hollander.ben.dao.BankTransactionsDao;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.NSFException;
import hw2.hollander.ben.util.ConnFactory;

public class BankTransactionsDaoImpl implements BankTransactionsDao {
	public static ConnFactory cf= ConnFactory.getInstance();
	@Override
	public void Deposit(int acctID, double amt) throws BadValueException, SQLException {
		if (amt < 0) {
			try {
				throw new BadValueException();
			}
			catch(BadValueException e) {
				System.out.println("You can't deposit a negative amount");
			}
		}
		else {
			//implement
			Connection conn= cf.getConnection();
			String sql = "UPDATE accountsstate SET balance=balance+? WHERE acctid=?";//?=amt,  ?=acctID
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt);
			ps.setInt(2, acctID);
			ps.executeUpdate();
			
			try {
				ps.execute(sql);
			}
			catch(SQLException e) {
				//not all variables bound
				//e.printStackTrace();
				//deposit still completes
			}
			System.out.println("Deposit Complete");
		}
		
	}

	@Override
	public void Withdraw(int acctID, double amt) throws BadValueException, NSFException, SQLException {
		// TODO Auto-generated method stub
		if (amt < 0) {
			try {
				throw new BadValueException();
			}
			catch(BadValueException e) {
				System.out.println("You can't deposit a negative amount");
			}
		}
		else {
			//implement
			Connection conn= cf.getConnection();
			String sql = "UPDATE accountsstate SET balance=balance-? WHERE acctid=?";//?=amt,  ?=acctID
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt);
			ps.setInt(2, acctID);
			ps.executeUpdate();
			
			try {
				ps.execute(sql);
			}
			catch(SQLException e) {
				//check constraint NSF
				//e.printStackTrace();
				//deposit still completes
			}
			System.out.println("Withdrawal Complete");
		}
		
}
		

	@Override
	public void Balance(int acctID) throws SQLException {
		Connection conn= cf.getConnection();
		String sql= "SELECT balance FROM accountsstate WHERE acctid=" + acctID;
		Statement stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			System.out.println(rs.getDouble("Balance")); //there should only be 1 result
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Please see teller for assistance");
		}
		
	}

}
