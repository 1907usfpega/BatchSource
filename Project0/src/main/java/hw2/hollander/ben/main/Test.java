package hw2.hollander.ben.main;

import java.sql.SQLException;

import hw2.hollander.ben.daoimpl.AccountManagementDaoImpl;
import hw2.hollander.ben.daoimpl.BankTransactionsDaoImpl;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.NSFException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankTransactionsDaoImpl b = new BankTransactionsDaoImpl();
		AccountManagementDaoImpl a = new AccountManagementDaoImpl();
		try {
			b.Withdraw(1015, 12);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NSFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
