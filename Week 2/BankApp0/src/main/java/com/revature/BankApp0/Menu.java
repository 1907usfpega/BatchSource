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
		System.out.print("Enter the amount you would like to deposit: $");
	}
	
	public static void deposit2() {
		System.out.print("Enter the nickname of the account: ");
	}
	
	public static void deposit3(double depositAmount, String nickname) {
		System.out.println("You have added $" + depositAmount + " to " + nickname + "\n");
	}
	
	public static void withdraw1() {
		System.out.print("Enter the amount you would like to withdraw: $");
	}
	
	public static void withdraw2() {
		System.out.print("Enter the nickname of the account: ");
	}
	
	public static void withdraw3(double withdrawAmount, String nickname) {
		System.out.println("You have removed $" + withdrawAmount + " from " + nickname);
	}
	
	public static void logout(String username) {
		System.out.println("Goodbye  " + username);
	}
	
	public static void adminMenu() {
		System.out.println("Please select an item from the following menu:\n"
				+ "1. View User\n"
				+ "2. Create New User\n"
				+ "3. Update User Password\n"
				+ "4. Create New Account\n"
				+ "5. Close Account\n"
				+ "6. Withdraw for User\n"
				+ "7. Deposit for User\n"
				+ "8. Remove User\n"
				+ "9. Logout\n");
	}
	
	public static void viewUser() {
		System.out.println("Enter the Username\n");
	}
	
	public static void adminUserCreation1() {
		System.out.println("Enter Username\n");
	}
	
	public static void adminUserCreation2() {
		System.out.println("Enter Password\n");
	}
	
	public static void updatePassword1() {
		System.out.println("Enter Username");
	}
	
	public static void updatePassword2() {
		System.out.println("Enter New Password");
	}
	
	public static void withdrawForUser1() {
		System.out.println("Enter Username\n");
	}

	public static void withdrawForUser2() {
		System.out.println("Enter amount to withdraw\n");
	}
	
	public static void withdrawForUser3() {
		System.out.println("Enter account nickname\n");
	}
	
	public static void depositForUser1() {
		System.out.println("Enter Username\n");
	}
	
	public static void depositForUser2() {
		System.out.println("Enter amount to deposit\n");
	}
	
	public static void depositForUser3() {
		System.out.println("Enter account nickname\n");
	}
	
	public static void removeUser() {
		System.out.println("Enter the name of the user to be deleted.");
	}
	
	public static void adminAcctCreate1() {
		System.out.println("Enter the name of the user you are creating this account for.");
	}
	
	public static void adminAcctCreate2() {
		System.out.println("Enter the nickname for the account.");
	}
	
	public static void adminDelAcct1() {
		System.out.println("Enter the name of the user whose account you are closing.");
	}
	
	public static void adminDelAcct2() {
		System.out.println("Enter the nickname for the account.");
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
