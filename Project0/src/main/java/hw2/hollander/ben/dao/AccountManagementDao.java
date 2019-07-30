package hw2.hollander.ben.dao;

import java.sql.SQLException;

import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.exceptions.BadValueException;

public interface AccountManagementDao {
	public abstract void Create(String usr, String pswd) throws AccountExists, SQLException, BadValueException;
	public abstract void Delete(int hash, int acctID) throws AccountNotEmptyException, SQLException;
}
