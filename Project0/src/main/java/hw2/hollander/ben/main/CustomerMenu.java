package hw2.hollander.ben.main;

import java.sql.SQLException;

import hw2.hollander.ben.daoimpl.AccountManagementDaoImpl;
import hw2.hollander.ben.daoimpl.BankTransactionsDaoImpl;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.NSFException;

public class CustomerMenu {
    public static void menu(int hash) throws BadValueException, SQLException {
    	char choice;
    	do {
    		
    		System.out.println("1: Deposit");
    		System.out.println("2: Withdraw");
    		System.out.println("3: View Balance");
    		System.out.println("4: Delete Account");
    		System.out.println("ANY OTHER KEY TO EXIT");
    		choice = Driver.input.next().charAt(0);
    		BankTransactionsDaoImpl btdi = new BankTransactionsDaoImpl();
    		AccountManagementDaoImpl amdi = new AccountManagementDaoImpl();
    		switch(choice) {
    		case '1':
    			System.out.println("How much would you like to deposit?");
    			double amt = Driver.input.nextDouble();
    			System.out.println("To which account?");
    			int id = Driver.input.nextInt();
    			btdi.Deposit(id, amt);
    			break;
    		case '2':
    			System.out.println("How much would you like to withdraw?");
    			double amtW = Driver.input.nextDouble();
    			System.out.println("From which account?");
    			int idW = Driver.input.nextInt();
    			boolean go = amdi.AccountOwner(hash, idW);
    			if(go==true) {
    			try {
					btdi.Withdraw(idW, amtW);
				} catch (BadValueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NSFException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			}
    			else {
    				System.out.println("You don't have an account with that number");
    				}
    			break;
    		case '3':
    			System.out.println("Which account");
    			int idB = Driver.input.nextInt();
    			btdi.Balance(idB);
    			break;
    		case '4':
    			System.out.println("Which account");
    			int deleteID = Driver.input.nextInt();
    			try {
					amdi.Delete(deleteID, hash);
				} catch (AccountNotEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			break;
    		default:
    			System.out.println("Goodbye");
    			System.exit(0);
    		}
    	}while(choice!='1' || choice!='2' || choice!='3' || choice!='4');
    }
}
