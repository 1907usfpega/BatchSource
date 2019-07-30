package com.revature.bankingapppt1_2;

import java.sql.SQLException;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		

		
		/*Dbs.readAccountDBFile();
		Dbs.readUserDBFile();
		Dbs.setInitUserData();*/
		/*
		try {
			System.out.println(udi.getUserList());
			if(!udi.doesUserExist("levi"))
				udi.addNewUser("levi", "levi", "Admin");
			if(!udi.doesUserExist("eddie"))
				udi.addNewUser("eddie", "e", "Customer");
			System.out.println(udi.doesUserExist("levi"));
			System.out.println(udi.doesUserExist("leviw"));
			System.out.println(udi.doesUserExist("levi"));
			System.out.println(udi.getPassword("levi"));
			udi.changeUStatus("levi", "Approved");
			System.out.println(udi.getClearanceLevel("levi"));
			System.out.println(udi.getStatus("levi"));
			if(!adi.doesAcctExist(1))
				adi.addNewAcct(adi.getAcctList().size(), "Checking", "levi");
			adi.changeAStatus(1, "Approved");
			System.out.println(udi.getUserList());
			System.out.println(adi.getAcctList());
		}catch(SQLException se) {
			se.printStackTrace();
		}*/
		
		MO.printMainMenu(); 
		MO.mainMenu();
		MO.adi.removeCanc();	
		
		/*Dbs.deletAllDenied();
		Dbs.writeAccountFileDB(Dbs.accData);
		Dbs.writeUserFileDB(Dbs.userData);*/
	}


}
