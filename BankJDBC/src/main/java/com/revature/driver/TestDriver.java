package com.revature.driver;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.daoimpl.BankingDaoImpl;

public class TestDriver {
	public static void main(String[] args) {

		BankingDaoImpl bdi = new BankingDaoImpl();
		try {
			
			
			
			
			System.out.println("Customers:");
			printList(bdi.getCustomerList());
			
			System.out.println();
			
			Iterator<Customer> itr = bdi.getCustomerList().iterator();
			while(itr.hasNext()) {
				Customer c = itr.next();
				System.out.println(c.getFirstName()+" "+c.getLastName()+"'s accounts: ");
				printList(bdi.getAccountListPersonal(c));
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}

		
		
	}// end main
	private static void printList(List list) {
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		} // end while
	}//end printList
	
	
}// end TestDriver
