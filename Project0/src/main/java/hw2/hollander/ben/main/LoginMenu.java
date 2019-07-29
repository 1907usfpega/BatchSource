package hw2.hollander.ben.main;

import hw2.hollander.ben.exceptions.AccountExists;

public class LoginMenu {
    public static void Menu() {
        System.out.println("1: Register");
        System.out.println("2: Customer Login");
        System.out.println("Any other key to exit");
        Parse();
    }
    
    public static void Parse() {
        //get next character
        char selection = Driver.input.next().charAt(0);
        //should i wrap the switch in a while in case of unsuccessful login
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
