package hw2.hollander.ben.main;

import java.sql.SQLException;

import hw2.hollander.ben.daoimpl.AccountManagementDaoImpl;
import hw2.hollander.ben.daoimpl.AdminMethods;
import hw2.hollander.ben.daoimpl.BankTransactionsDaoImpl;
import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.WrongCredentialsException;

public class AdminMenu {
	public static void Menu() throws AccountExists, BadValueException, WrongCredentialsException {
		char choice;
		do {
			System.out.println("1: Create user"); //call register
			System.out.println("2: Read user"); //call view without check
			System.out.println("3: Update user");
			System.out.println("4: Delete user"); //account must be empty
			System.out.println("Any other key to exit");
			choice = Driver.input.next().charAt(0);
			
			BankTransactionsDaoImpl btdi = new BankTransactionsDaoImpl();
    		AccountManagementDaoImpl amdi = new AccountManagementDaoImpl();
			switch(choice) {
			case '1':
				Apply.Application();
				break;
			case '2':
				System.out.println("Which account?");
				int acctID = Driver.input.nextInt(); //TODO add in all columns from all tables
				try {
					btdi.Balance(acctID);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case '3':
				System.out.println("Current Username");
				String old = Driver.input.nextLine();
				old = Driver.input.nextLine();
				System.out.println("New Username");
				String neww = Driver.input.nextLine();
				System.out.println("Are you sure, the user will not be able to login with this username y/n");
				char choice1=Driver.input.next().charAt(0);
				if (choice1=='y' || choice=='Y') {
					AdminMethods.Update(old, neww);
				}
				break;
			case '4':
				System.out.println("Which account?");
				int acctID1 = Driver.input.nextInt();
				try {
					AdminMethods.Delete(acctID1);
				} catch (AccountNotEmptyException e) {

					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.exit(0);
			}
			
		}while(choice!='1' || choice!='2' || choice!='3' || choice!=4);
	}
}
