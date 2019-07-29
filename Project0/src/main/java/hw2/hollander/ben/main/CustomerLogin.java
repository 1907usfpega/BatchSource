package hw2.hollander.ben.main;

import hw2.hollander.ben.exceptions.*;

public class CustomerLogin {
    public static void CustomerLogin() {
        String username = null;
        String pswd = null;
        System.out.println("Username:");
        //Used to consume newline from previous sysout
        username = Driver.input.nextLine();
        username = Driver.input.nextLine();
        System.out.println("Password:");
      //Used to consume newline from previous sysout
        pswd = Driver.input.nextLine();
        pswd = Driver.input.nextLine();
        
        
        try {
            Verify(username, pswd);
        } catch (WrongCredentialsException e) {
            // TODO Auto-generated catch block
            System.out.println("Invalid Credentials");
            e.printStackTrace();
        }
    }
    
    public static void Verify(String usr, String pswd) throws WrongCredentialsException {
        int hash = (usr+pswd).hashCode();
        //verify hash exists in customer table
        //if it does call CustomerMenu(hash);
        //else sysout see teller
    }

}
