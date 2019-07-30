package hw2.hollander.ben.main;

import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.BadValueException;

public class LoginMenu {
    public static void Menu() throws BadValueException {
        System.out.println("1: Register");
        System.out.println("2: Customer Login");
        System.out.println("Any other key to exit");
        Parse();
    }
    
    public static void Parse() throws BadValueException {
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
            default:
                System.out.println("Goodbye");
                System.exit(0);
        }
    }
}
