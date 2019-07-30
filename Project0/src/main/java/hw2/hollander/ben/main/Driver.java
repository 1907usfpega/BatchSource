package hw2.hollander.ben.main;

import java.util.Scanner;

import hw2.hollander.ben.exceptions.BadValueException;

//commit after each transaction
public class Driver {
    public static Scanner input = new Scanner (System.in);
    public static void main(String[] args) {
        try {
			LoginMenu.Menu();
		} catch (BadValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }

}
