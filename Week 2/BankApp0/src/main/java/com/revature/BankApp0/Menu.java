package com.revature.BankApp0;

public class Menu {

	public static void cls() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
	
	public static void mainMenu() {
		System.out.println("Please select an item from the following menu:\n"
				+ "1: View Existing Accounts\n"
				+ "2: Create an Account\n"
				+ "3: Delete an Account\n"
				+ "4. Deposit\n"
				+ "5. Withdraw\n"
				+ "6. Logout\n");
	}
	
	public static void createAccountMenu() {
		System.out.println("Account Creation\n"
				+ "Enter a nickname for your account.");
	}
	
	public static void deleteAccountMenu() {
		System.out.println("Account Deletion\n"
				+ "Enter the nickname for the account you wish to delete.\n");
	}
	
	public static void deposit1() {
		System.out.print("Enter the amount you would like to deposit: ");
	}
	
	public static void deposit2() {
		System.out.print("Enter the nickname of the account: ");
	}
	
	public static void deposit3(int depositAmount, String nickname) {
		System.out.println("You have added " + depositAmount + " to " + nickname + "\n");
	}
	
	public static void withdraw1() {
		System.out.print("Enter the amount you would like to withdraw: ");
	}
	
	public static void withdraw2() {
		System.out.print("Enter the nickname of the account: ");
	}
	
	public static void withdraw3(int withdrawAmount, String nickname) {
		System.out.println("You have removed " + withdrawAmount + " from " + nickname);
	}
	
	public static void logout(String username) {
		System.out.println("Goodbye  " + username);
	}

	public static void puar() {
		System.out.println("                                    ,$$.       ,$$.      \n" + 
				"                                   ,$'`$.     ,$'`$.     \n" + 
				"                                   $'  `$     $'  `$     \n" + 
				"                                  :$    $;   :$    $;    \n" + 
				"                                  $$    $$   $$    $$    \n" + 
				"                                  $$  _.$bqgpd$._  $$    \n" + 
				"                                  ;$gd$$^$$$$$^$$bg$:    \n" + 
				"                                .d$P^*'   \"*\"   `*^T$b.  \n" + 
				"                               d$$$    ,*\"   \"*.    $$$b \n" + 
				"                              d$$$b._    o   o    _.d$$$b\n" + 
				"                             *T$$$$$P             T$$$$$P*\n" + 
				"                               `^T$$    :\"---\";    $$P^' \n" + 
				"                                  `$._   `---'   _.$'    \n" + 
				"                                 .d$$P\"**-----**\"T$$b.   \n" + 
				"                                d$$P'             `T$$b  \n" + 
				"                               d$$P                 T$$b \n" + 
				"                              d$P'.'               `.`T$b\n" + 
				"                              `--:                   ;--'\n" + 
				"                                 |                   |   \n" + 
				"                                 :                   ;   \n" + 
				"                                  \\                 /    \n" + 
				"                                  .`-.           .-'.    \n" + 
				"                                 /   .\"*--+g+--*\".   \\   \n" + 
				"                                :   /     $$$     \\   ;  \n" + 
				"                                `--'      $$$      `--'  \n" + 
				"                                          $$$       \n" + 
				"                                          $$$            \n" + 
				"                                          :$$;           \n" + 
				"                                          :$$;           \n" + 
				"                                           :$$           \n" + 
				"                                           'T$bg+.____   \n" + 
				"                                             'T$$$$$  :  \n" + 
				"                                                 \"**--'");
	}
	
}
