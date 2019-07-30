package hw2.hollander.ben.main;

import java.util.Scanner;

import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.WrongCredentialsException;

 class Driver {
    public static Scanner input = new Scanner (System.in);
    public static void main(String[] args) throws WrongCredentialsException {
        try {
			LoginMenu.Menu();
		} catch (BadValueException e) {
			e.printStackTrace();
		}  
    }

}
