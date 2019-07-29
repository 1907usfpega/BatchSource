package hw2.hollander.ben.dao;

import java.sql.SQLException;

import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.NSFException;

public interface BankTransactionsDao {
	public abstract void Deposit(int acctID, double n) throws BadValueException, SQLException;
	public abstract void Withdraw(int acctID, double n) throws BadValueException, NSFException, SQLException;
	public abstract void Balance(int acctID) throws SQLException;
}
