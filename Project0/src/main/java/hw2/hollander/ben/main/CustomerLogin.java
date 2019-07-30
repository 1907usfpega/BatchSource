package hw2.hollander.ben.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.WrongCredentialsException;
import hw2.hollander.ben.util.ConnFactory;

public class CustomerLogin {
	public static ConnFactory cf= ConnFactory.getInstance();
    public static void CustomerLogin() throws BadValueException {
        String username = null;
        String pswd = null;
        System.out.println("Username:");
        //Used to consume newline from previous sysout
        username = Driver.input.nextLine();
        username = Driver.input.nextLine();
        System.out.println("Password:");
        pswd = Driver.input.nextLine();
        
        
        try {
            Verify(username, pswd);
        } catch (WrongCredentialsException e) {
            // TODO Auto-generated catch block
            System.out.println("Invalid Credentials");
            e.printStackTrace();
        }
          catch (SQLException e1) {
        	  e1.printStackTrace();
          }
    }
    
    public static void Verify(String usr, String pswd) throws WrongCredentialsException, SQLException, BadValueException {
    	int hash = (usr+pswd).hashCode();
    	int n=-1;//init to suppress IDE warnings
    	Connection conn = cf.getConnection();
        PreparedStatement ps;
		ps = conn.prepareStatement("SELECT COUNT(*) FROM login WHERE hashcode= ?");
        ps.setInt(1, hash);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
        	n = rs.getInt(1); //get first column returned
        	//hangs FIXME
        }
        
        if(n==0) {
        	throw new WrongCredentialsException();
        }
        else if(n>1) {
        	throw new SQLException();
        }
        else if(n==1) {
        	//implement
        	System.out.println("Access granted");
        	CustomerMenu.menu(hash);
        }
        else {
        	throw new SQLException();
        }
    }

}
