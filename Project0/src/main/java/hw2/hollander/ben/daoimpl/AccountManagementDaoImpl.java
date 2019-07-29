package hw2.hollander.ben.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hw2.hollander.ben.dao.AccountManagementDao;
import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.util.ConnFactory;

public class AccountManagementDaoImpl implements AccountManagementDao {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	@Override
	public void Create(int hash, String usr) throws AccountExists, SQLException {
		// TODO Auto-generated method stub
		Connection conn= cf.getConnection();
		String sql= "{ call acct_creation(?, ?)";
		CallableStatement call= conn.prepareCall(sql);
		String n = String.valueOf(hash);
		call.setString(1, n);
		call.setString(2,  usr);
		try {
			call.execute();
			System.out.println("Account created"); //get acct number & sysout
		}
		catch(SQLException e) {
			System.out.println("This account already exists");
		}
	}

	@Override
	public void Delete(int acctid) throws AccountNotEmptyException, SQLException {
		// TODO Auto-generated method stub
		//get bal make sure bal is 0
		Connection conn= cf.getConnection();
		String sql= "{ call acct_delete(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, String.valueOf(acctid));
		try {
			call.execute();
			System.out.println("Account deleted");
		}
		catch(SQLException e) {
			try {
				throw new AccountNotEmptyException();
			}
			catch(AccountNotEmptyException e1) {
				System.out.println("Account not deleted, prbable becuase it's not empty");
			}
		}
		
	}

}
