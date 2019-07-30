package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao{
	public static ConnFactory cf= ConnFactory.getInstance();
	public Scanner scanit = new Scanner(System.in);
	
	public void createCustomer(int accountNumb, String fName,int balance,String lName,String username,String password)throws SQLException{
		Connection conn = cf.getConnection();
		String sql= "INSERT INTO KENBANKING (ACCOUNT_NUMBER,FNAME,BALANCE,LNAME,USERNAME,PASSWORD) VALUES(?,?,?,?,?,?)";
		CallableStatement call= conn.prepareCall(sql);
		call.setInt(1, accountNumb);
		call.setString(2, fName);
		call.setInt(3, balance);
		call.setString(4, lName);
		call.setString(5, username);
		call.setString(6,password);
		call.execute();
	} 

	public List<Customer> getCustomerList() throws SQLException {
		List<Customer> lcustt = new ArrayList<Customer>();
		Connection conn= cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM KENBANKING");
		Customer s= null;
		while(rs.next()) {
			s= new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
			System.out.println(s.toString());
			lcustt.add(s);
		}
		s=lcustt.get(lcustt.size()-1);
		System.out.println(s.toString());
		rs.close();
		rs=null;
		return lcustt;
	}
	
	public List<Customer> getCustomer(String usname) throws SQLException {		
		List<Customer> lcustt = new ArrayList<Customer>();
		Connection conn= cf.getConnection();		
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * FROM KENBANKING WHERE USERNAME ='"+usname+"'");
		Customer s= null;
		int balanc=0;
		while(rs.next()) {
			s= new Customer(rs.getInt(3),rs.getString(2),rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(6));
			balanc=rs.getInt(3);
			System.out.println(s.toString());
		}
		
		String tzz = null;
		do {
			System.out.println("");
		System.out.println("WITHDRAW    DEPOSIT    CANCEL");
		Scanner look = new Scanner(System.in);
		String choose = look.nextLine();
		
		switch(choose.toUpperCase()) {
		case "WITHDRAW":
			System.out.println("enter withdrawal amnt: ");
			int am = look.nextInt();
			if(am>balanc) {
				System.out.println("unsufficient funds...");
				break;
			}
			balanc = balanc - am;
			System.out.println("debug: balance is "+balanc);
			Statement astmt = conn.createStatement();
			ResultSet dpst = astmt.executeQuery(" UPDATE KENBANKING "
					+ "SET BALANCE='"+ balanc+"' "
					+ "WHERE USERNAME='"+usname+"'");
			break;
    	case "DEPOSIT":
    		System.out.println("enter deposit amnt: ");
    		int amS = look.nextInt();
    		balanc = balanc + amS;
    		System.out.println("debug: balance is "+balanc);
	   		Statement asAtmt = conn.createStatement();
			ResultSet dpAst = asAtmt.executeQuery(" UPDATE KENBANKING "
				+ "SET BALANCE='"+ balanc+"' "
				+ "WHERE USERNAME='"+usname+"'");
			break;
    	case "CANCEL":
    		System.out.println("    HAVE   A   GREAT   DAY !");
    		break;
		}
		System.out.println("continue?");
		look=new Scanner(System.in);
		tzz=look.nextLine();		
		}while(tzz.equals("YES"));
		rs.close();
		rs=null;	
		return lcustt;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//public void getCustomer(String username)throws SQLException{
//		Customer aCustomer = new Customer(username);
	//	Connection conn = cf.getConnection();
		//Statement stmt = conn.createStatement();
		//String rs = stmt.executeQuery( "SELECT * FROM KENBANKING WHERE USERNAME ='"+username+"'");
		//CallableStatement call= conn.prepareCall(rs);
		//call.getString(username);
		//call.getString(password);
		//call.execute();
		//Customer s = null;
		//s= new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
		//System.out.println(s.toString());
		
		
	
	
	

	@Override
	public void createCustomer(String customerName) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
