package hw2.hollander.ben.main;

import java.sql.SQLException;

import hw2.hollander.ben.daoimpl.AccountManagementDaoImpl;
import hw2.hollander.ben.exceptions.AccountExists;

public class Apply {
    public static void Application() throws AccountExists {
        System.out.println("Username");
        String usr = Driver.input.nextLine();
        usr = Driver.input.nextLine();
        System.out.println("Password");
        String pswd = Driver.input.nextLine();
        int hash = (usr+pswd).hashCode();
        
        AccountManagementDaoImpl acct = new AccountManagementDaoImpl();
        try {
			acct.Create(hash, usr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
