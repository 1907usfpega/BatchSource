package hw2.hollander.ben.main;

import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.WrongCredentialsException;

public class LoginMenu {
    public static void Menu() throws BadValueException, WrongCredentialsException {
        System.out.println("1: Register");
        System.out.println("2: Customer Login");
        System.out.println("Any other key to exit");
        Parse();
    }
    
    public static void Parse() throws BadValueException, WrongCredentialsException {
        //get next character
        char selection = Driver.input.next().charAt(0);
        //should i wrap the switch in a while in case of unsuccessful login, I probably should've instead of calling it everywhere else
        switch(selection) {
            case '1':
            try {
                Apply.Application();
            } catch (AccountExists e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                break;
            case '2':
                CustomerLogin.CustomerLogin();
                break;
            case '~':
            	System.out.println("Username");
            	String usr = Driver.input.nextLine();
            	usr = Driver.input.nextLine();
            	System.out.println("Password");
            	String pswd = Driver.input.nextLine();
            	if (usr.equals("Admin") && pswd.equals("****")) {
            		try {
						AdminMenu.Menu();
					} catch (AccountExists e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	else {
            		throw new WrongCredentialsException();
            	}
            	break;
            default:
                System.out.println("Goodbye");
                System.exit(0);
        }
    }
}
