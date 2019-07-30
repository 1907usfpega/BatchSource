package com.revature.bankingapppt1_2;

import com.revature.menus.MenuOptions;



public class Driver {
	
	public static void main(String args[]) {
		
		MenuOptions.udi.initUser();
		MenuOptions.printMainMenu();
		MenuOptions.mainMenu();
		
		MenuOptions.removeDenied();
		MenuOptions.removeDeniedUsers();
		MenuOptions.removeDeniedAccounts();
		
	}


}
