package com.revature.bankingapppt1_2;

public class CustomerMenu {
	// print customer main menu
		public static void printCMM() {
			MO.clearConsole();
			System.out.println("CUSTOMER MAIN MENU");
			System.out.println("Please select an option:Ex// 1");
			System.out.println("1: Create Account");
			System.out.println("2: Select Account");
			System.out.println("3: Logout");
		}

		public static void run(String u) {
			String s;

			do {
				s = MO.in.nextLine().trim();
				switch (s) {
				case "1":
					AccountMenu.createAccount(u);
					printCMM();
					break;
				case "2":
					AccountMenu.selectAccount(u);
					printCMM();
					break;
				case "3":
					return;

				default:
					System.out.println("Sorry that wasn't a valid option. Please try again.");
					printCMM();
					break;
				}
			} while (!s.equals("3"));
		}

}
