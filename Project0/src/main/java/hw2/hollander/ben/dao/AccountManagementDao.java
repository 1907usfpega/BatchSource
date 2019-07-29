package hw2.hollander.ben.dao;

import java.sql.SQLException;

import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;

public interface AccountManagementDao {
	public abstract void Create(int hash, String usr) throws AccountExists, SQLException;
	public abstract void Delete(int acctid) throws AccountNotEmptyException, SQLException;
}
