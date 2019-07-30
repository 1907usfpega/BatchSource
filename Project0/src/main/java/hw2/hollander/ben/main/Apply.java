package hw2.hollander.ben.main;

import java.sql.SQLException;

import hw2.hollander.ben.daoimpl.AccountManagementDaoImpl;
import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.BadValueException;

public class Apply {
    public static void Application() throws AccountExists, BadValueException {
        System.out.println("Username");
        String usr = Driver.input.nextLine();
        usr = Driver.input.nextLine();
        System.out.println("Password");
        String pswd = Driver.input.nextLine();

        AccountManagementDaoImpl acct = new AccountManagementDaoImpl();
        try {
			acct.Create(usr, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
